# TST Application Best Price and Promotion Calculator

## Overview

This repository contains a Scala-based application designed to calculate the best prices and promotion combinations for cabin groups. The application uses Maven as the build tool and is built with Scala version 2.12.12.

## Prerequisites

Before you can build and run the application, ensure you have the following installed:

- Java Development Kit (JDK) 11 (or equivalent)
- Apache Maven 3.6.0 or higher
- Scala 2.12.12

## Building the Application

To build the application, follow these steps:

1. **Clone the repository:**

   ```sh
   git clone git@github.com:brentmzey/tst-takehome.git
   cd tst-takehome
   ```

2. **Build the application using Maven:**

   ```sh
   mvn -e clean install
   ```

   This command will clean any previous builds, compile the source code, and package the application into a JAR file.

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

## Dependencies

The project uses the following dependencies:

- `org.scala-lang:scala-library:2.12.12`
- `ch.qos.logback:logback-classic:1.4.14`
- `junit:junit:4.11`
- `org.scalatest:scalatest_2.12:3.2.19`

These dependencies are managed through Maven with project properties and are defined in the `pom.xml`.

## Conclusion

For more detailed information, refer to the source code and comments within the project.