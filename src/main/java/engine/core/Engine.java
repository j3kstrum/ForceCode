package engine.core;

import common.BaseLogger;
import common.data.GameMap;
import engine.access.extern.EngineToGUI;
import engine.access.extern.EngineToScripting;
import engine.data.EngineData;
import org.mapeditor.core.Map;
import org.mapeditor.io.TMXMapReader;

import java.net.URL;

/**
 * The main class for the main.java.engine.
 * This class will be initialized and will be responsible for game timing, acting as a game pipeline, etc.
 *
 * Created by jacob.ekstrum on 9/11/17.
 */
public class Engine {

    // Hard shutdown boolean. Causes main loop to terminate with no chance for recovery.
    private boolean _shutdown = false;

    // The Engine's Database.
    private final EngineData DATA;

    // The amount of time for each game tick.
    private static final long TICK_TIME = 250;
    private boolean _inCoreGame = false;

    private static final BaseLogger ENGINE_LOGGER = new BaseLogger("Engine");

    /**
     * Initializes the Engine and performs the main ticking loop.
     */
    public Engine() {
        DATA = new EngineData();
        new Thread(
                () -> this.start()
        ).start();
    }

    /**
     * Loads the Tiled static Map from disk.
     * @return The initial GameMap, initialized to hold the static Tiled Map.
     */
    private GameMap loadGameMap() {
        URL url = getUrlFromResources("resave-test.tmx");
        TMXMapReader tmr = new TMXMapReader();
        GameMap mp = null;
        try {
            Map map = tmr.readMap(url.getPath());
            mp = new GameMap(map);
        } catch (Exception e) {
            ENGINE_LOGGER.fatal("Could not load game map.");
            // TODO: Don't just kill the program here. Download the game map that we know works from
            // GitHub if we can get a connection, and then use that map instead.
            ENGINE_LOGGER.fatal(e.getMessage());
            System.exit(1);
        }
        return mp;
    }

    /**
     * BORROWED FROM Tiled MapEditor test code. Loads a filename from the project's resources.
     * @param filename The relative path to be loaded for resources.
     * @return The URL representing the full filepath to the desired resource.
     */
    private URL getUrlFromResources(String filename) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        return classLoader.getResource(filename);
    }

    private void start() {
        this.DATA.setMap(loadGameMap());

        ENGINE_LOGGER.info("Engine initialized. Beginning tick loop...");
        long lastTick = System.currentTimeMillis();
        while (!_shutdown) {
            lastTick = this.performWait(lastTick);
            this.tick();
        }
        if (!this.cleanup()) {
            ENGINE_LOGGER.critical("Engine cleanup failed.");
            System.exit(1);
        }
        System.exit(0);
    }

    /**
     * Wrapper for shutdown(boolean now) that uses default argument now=false.
     * @return The value returned by shutting down with now as false.
     */
    public boolean shutdown() {
        return this.shutdown(false);
    }

    /**
     * Safe shutdown handler for the engine that can be called from external functions.
     * @param now Whether to immediately terminate the program at the end of the tick or to wait.
     * @return true if successful, false if shutdown failed.
     */
    public boolean shutdown(boolean now) {
        if (now) {
            this._shutdown = true;
        } else {
            ENGINE_LOGGER.warning("Currently can not shutdown engine with delay. " +
                    "Terminating immediately following current tick.");
            this._shutdown = true;
        }
        return true;
    }

    /**
     * Ensures that the proper amount of time since the last tick has elapsed.
     * If not, sleeps until this condition is met.
     * @param lastTick The system time polled at the last tick.
     * @return The system time at the end of the method, which is the start of the next tick.
     */
    private long performWait(long lastTick) {
        long delta = System.currentTimeMillis() - lastTick;
        if (delta > Engine.TICK_TIME) {
            ENGINE_LOGGER.critical("System too slow for tick. Elapsed delta: " + String.valueOf(delta) + ".");
        } else {
            try {
                Thread.sleep(Engine.TICK_TIME - delta);
            } catch (InterruptedException ie) {
                ENGINE_LOGGER.critical("Tick sleep interrupted!");
            }
        }
        return System.currentTimeMillis();
    }

    /**
     * Performs all of the necessary game logic for one tick, or turn, if currently in-game.
     */
    private void tick() {

        if (_inCoreGame) {
            this.DATA.setMap(
                    EngineToScripting.nextTurn(
                            this.DATA.getMap()
                    )
            );
            EngineToGUI.update();
        }

//        if (System.currentTimeMillis() % 100 == 64) {
//            ENGINE_LOGGER.info("Wow! How awesome! The engine ticked and ended in just the right 2-digit number!");
//            ENGINE_LOGGER.fatal("Shutting down due to awesomeness.");
//            this.shutdown();
//        }
    }

    /**
     * Performs code cleanup.
     * @return true if successful, false otherwise.
     */
    private boolean cleanup(){
        // TODO: Populate
        ENGINE_LOGGER.warning("Currently have no engine cleanup code.");
        return true;
    }

    /**
     * Starts the game from the engine's perspective.
     * NOTE: This is a *hard* game start; that is, the battle is occurring here.
     */
    public void startGame() {
        this._inCoreGame = true;
    }

    /**
     * Stops the core battle from the engine's perspective.
     */
    public void stopGame() {
        this._inCoreGame = false;
    }

}
