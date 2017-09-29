# CodeCarnage
An intuitive and simple arena battle game involving strategy.

Current Build Status:

| **Branch** | **Build Status** | **Code Test Coverage** |
|------------|------------------|------------------------|
| **Ekstrum** | [![Build Status](https://travis-ci.org/j3kstrum/CodeCarnage.svg?branch=ekstrum)](https://travis-ci.org/j3kstrum/CodeCarnage) | [![Coverage Status](https://coveralls.io/repos/github/j3kstrum/CodeCarnage/badge.svg?branch=ekstrum)](https://coveralls.io/github/j3kstrum/CodeCarnage?branch=ekstrum) |
| **Develop** | [![Build Status](https://travis-ci.org/j3kstrum/CodeCarnage.svg?branch=develop)](https://travis-ci.org/j3kstrum/CodeCarnage) | [![Coverage Status](https://coveralls.io/repos/github/j3kstrum/CodeCarnage/badge.svg?branch=develop)](https://coveralls.io/github/j3kstrum/CodeCarnage?branch=develop) |
| **Master** | [![Build Status](https://travis-ci.org/j3kstrum/CodeCarnage.svg?branch=master)](https://travis-ci.org/j3kstrum/CodeCarnage) | [![Coverage Status](https://coveralls.io/repos/github/j3kstrum/CodeCarnage/badge.svg?branch=master)](https://coveralls.io/github/j3kstrum/CodeCarnage?branch=master) |

## How To Play

### Prerequisites

You will need **git** (to clone our repository) and **Java Runtime Environment (JRE) v1.8 (or greater)** (to run the game).

#### How to Install git

Please see https://git-scm.com/downloads for more information.

#### How to Install The Java Runtime Environment

You likely already have the *Java Runtime Environment* installed on your machine and will not need to download this package.

However, should you have difficulties running *CodeCarnage*, please see https://java.com/en/download/ .

### Windows

1. Clone our git repository (if you are unsure how to clone a git repository, please see https://help.github.com/articles/cloning-a-repository/ .)
2. Navigate to the folder where you cloned the git repository (this path will end with *CodeCarnage*).
3. Double-click the ***RUN-WINDOWS.bat*** file
4. Play!

### Linux

1. Clone our git repository (if you are unsure how to clone a git repository, please see https://help.github.com/articles/cloning-a-repository/ .)
2. Navigate to the folder where you cloned the git repository. Please do this using a terminal window.
3. Run the ***RUN-LINUX.sh*** file. You can do this by simply executing *./RUN-LINUX.sh* in the terminal window you have opened.
4. Play!

### Mac and Other Devices

Mac and Other Devices are not directly supported by CodeCarnage.

If you cannot access a Linux Device, we recommend using a Virtual Environment with Fedora, as this is a tested environment.
To do this, see http://www.wikihow.com/Install-Fedora-17-in-Virtualbox (while the article is slightly outdated, the procedure is extremely similar).

You could also try to follow the **Linux** instructions at your own risk.

## About

### Who?
Sean Brais, Jacob Ekstrum, Nick Martin, and David Olsen.

### What?
CodeCarnage is an arena battle game where each side indirectly controls a robot. The robot is manipulated through a custom script that the user creates through a drag-and-drop interface, allowing infinite customization.

### Is there more?

Please see our GitHub Wiki for more information about the core developers and the intended goals.

Contributions are always welcome!

## Contributors

### Build Information

Please use Gradle for best dependency support.  https://gradle.org/install/
Additionally, it is recommended to use IntelliJ IDEA as your development environment.

When building locally, simply run the command 

'gradle idea'

 from the root project directory to build all dependencies.

### CodeCarnage Gradle commands

gradle clean

-- Clean the files generated by *gradle build*

gradle cleanIdea

-- Clean the files generated by *gradle idea*

gradle idea

-- Build the project files required to run CodeCarnage in Run and Debug mode in IntelliJ IDEA.

gradle build

-- Build the project files required to run CodeCarnage by Java.

gradle buildJar

-- Build the result project executable JAR file.

## LEGAL

Please see The License (LICENSE) for licensing information.

Please see the sources file (SOURCES) for information pertaining to sources used.
