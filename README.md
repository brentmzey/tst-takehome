# TST Application Best Price and Promotion Calculator

## Overview

This repository contains a Scala-based application designed to calculate the best prices and promotion combinations for cabin groups. The application uses Maven as the build tool and is built with Scala version 2.12.12.

## Prerequisites

Before you can build and run the application, ensure you have the following installed:

- Java Development Kit (JDK) 11 (or equivalent)
- Apache Maven 3.6.0 or higher
- Scala 2.12.12

I recommend installing these with [SDKMan](https://sdkman.io/) and [NVM](https://github.com/nvm-sh/nvm)

```shell
sdk install java 11.0.24-tem
sdk install maven 3.9.8
sdk install scala 2.12.12
```

## Building the Application

To build the application, follow these steps:

1. **Clone the repository:**

   ```sh
   git clone git@github.com:brentmzey/tst-takehome.git
   cd tst-takehome
   ```
   
2. **direnv**

   I really advocate using [direnv](https://direnv.net/) to manage SDKMan and NVM installs with a `.envrc` in a project root. To get the most out of `direnv`, create and add the following to a `~/.direnvrc`
   file, either `~/.direnv` or `~/.config/direnv/direnvrc` i.e.:

   ```shell
   cat /dev/null > ./.direnvrc
   cat <<EOF >> ./.direnvrc
   use_sdk() {
     [[ -s "${SDKMAN_DIR}/bin/sdkman-init.sh" ]] && source "${SDKMAN_DIR}/bin/sdkman-init.sh"

     while (( "$#" >= 2 )); do
       local candidate=$1
       local candidate_version=$2
       SDK_OFFLINE_MODE=true sdk use $candidate $candidate_version

       shift 2
     done
   }

   use_nvm() {
     local node_version=$1

     nvm_sh=~/.nvm/nvm.sh
     if [[ -e $nvm_sh ]]; then
       source $nvm_sh
       nvm use $node_version
     fi
   }
   EOF
   # Place something like the following in your `.envrc`:

   cat <<EOF >> ./.envrc
   # maybe set some ENV vars too
   export PROJECT_JAVA_VERSION="11.0.24-tem"
   export PROJECT_MAVEN_VERSION="3.9.8"
   export PROJECT_SCALA_VERSION="2.12.12"
   export FOO="BAR"

   use sdk java 11.0.24-tem
   use sdk maven 3.9.8
   use sdk scala 2.12.12
   EOF
   ```

   To allow direnv, run this from the root where your `.envrc` file is:

   ```shell
   direnv allow .
   ```

3. **Build the application using Maven:**

   ```sh
   mvn -e clean install
   ```

   This command will clean any previous builds, compile the source code, and package the application into an Uber/Fat JAR file.

## Running Tests

To run the standalone tests, use the following Maven command:

```sh
mvn test
```

This command will execute all the tests defined in the project and provide a summary of the test results.

## Running the Application

The main entry point for the application is the `RateCalculator` class. To run the application, follow these steps:

1. **Navigate to the project directory:**

   ```sh
   cd tst-takehome
   ```

2. **Run the `RateCalculator` class:**

   ```sh
   mvn exec:java -Dexec.mainClass="io.brentzey.takehome.RateCalculator"
   ```
   
   Or, if you already compiled the full application, you can execute the Uber/Fat JAR file:

   ```shell
   java -jar target/tst-takehome-1.0.0-SNAPSHOT-fat.jar
   ```

   This command will execute the `RateCalculator` class, which will perform the calculations and log the results.

## Project Structure

- `src/main/scala`: Contains the main source code for the application.
- `src/test/scala`: Contains the test cases for the application.
- `pom.xml`: Maven configuration file that defines the project's dependencies and build configuration.
- Work is done off of the `development` branch. As you begin an issue this is the branch you should use as the base to branch from. You should create a relevant PR with your work pointed to merge into `development` for CI/CD purposes and automated test suite runs.
- The `main` branch is reserved for official deployment builds and 

## Dependencies

The project uses the following dependencies:

- `org.scala-lang:scala-library:2.12.12`
- `ch.qos.logback:logback-classic:1.4.14`
- `junit:junit:4.11`
- `org.scalatest:scalatest_2.12:3.2.19`

These dependencies are managed through Maven with project properties and are defined in the `pom.xml`.

## Conclusion

For more detailed information, refer to the source code and comments within the project.