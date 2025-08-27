# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Maven-based Java/Kotlin interview preparation project containing algorithmic coding challenges and data structure implementations. The codebase uses a hybrid Java/Kotlin setup with Maven for build management.

## Build and Development Commands

### Build and Compilation
```bash
mvn compile                 # Compile main sources
mvn test-compile           # Compile test sources
mvn package                # Build JAR package
mvn clean                  # Clean build artifacts
```

### Testing
```bash
mvn test                   # Run all tests
mvn test -Dtest=TestKakuro # Run specific test class
```

### Development
```bash
mvn exec:java -Dexec.mainClass="com.guyko.App"  # Run main application
```

## Architecture and Code Structure

### Language Setup
- **Primary Language**: Mixed Java/Kotlin codebase
- **Java**: Main application code (`src/main/java/com/guyko/`) - Java 11
- **Kotlin**: Test implementations (`src/test/java/com/guyko/`)
- **Kotlin Version**: 2.0.21 with standard library

### Project Structure
```
src/
├── main/java/com/guyko/
│   └── App.java              # Simple main application entry point
└── test/java/com/guyko/
    ├── TestKakuro.kt         # Kakuro puzzle solver (combinatorial problem)
    ├── TestLinked.kt         # Linked list operations and reversal algorithms
    ├── TestRegex1.kt         # Regular expression challenges
    ├── TestSubSum.kt         # Subset sum algorithms
    ├── TestSubstrings.kt     # String processing algorithms
    ├── TestTree.kt           # Tree data structure implementations
    └── TestYearWithMaxPeople.kt # Date/time algorithm challenges
```

### Testing Framework
- **Framework**: JUnit 4.13.2 with Kotlin test extensions
- **Mocking**: Mockito 1.10.19 for test doubles
- **Pattern**: Each test file contains both test cases and algorithm implementations
- **Logging**: kotlin-logging 1.12.5 for structured logging in tests

### Maven Configuration Notes
- Kotlin and Java compilation phases are carefully orchestrated
- Kotlin sources are in Java source directories (Maven convention override)
- Supports both Kotlin and Java compilation in the same build
- Includes source and javadoc JAR generation for distribution
- GPG signing configured but skipped by default (`skipSign=true`)

### Development Patterns
- Algorithm implementations are typically private methods within test classes
- Test classes extend JUnit's `TestCase` for assertion methods
- Data structures often use Kotlin data classes for clean syntax
- Recursive algorithms are common (linked list reversal, tree traversal, etc.)