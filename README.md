# 🧠 Algorithm Interview Prep

A comprehensive collection of algorithmic coding solutions for technical interviews, implemented in **Kotlin** and **Java**. This repository contains solutions to popular LeetCode problems and common interview questions, with detailed explanations and optimal implementations.

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/guyko/interview)
[![Java Version](https://img.shields.io/badge/Java-11-orange)](https://openjdk.java.net/projects/jdk/11/)
[![Kotlin Version](https://img.shields.io/badge/Kotlin-2.0.21-blue)](https://kotlinlang.org/)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## 🚀 Quick Start

### Prerequisites
- Java 11 or higher
- Maven 3.6+

### Building and Running Tests
```bash
# Clone the repository
git clone https://github.com/guyko/interview.git
cd interview

# Compile the project
mvn compile

# Run all tests
mvn test

# Build JAR package
mvn package
```

## 📚 Problem Categories

### 🔍 Array & Two Pointers
- **[Two Sum](src/test/java/com/guyko/TestTwoSum.kt)** - Find two numbers that add up to target
- **[Maximum Subarray](src/test/java/com/guyko/TestSubSum.kt)** - Kadane's algorithm for maximum sum subarray

### 🔤 String Processing  
- **[Valid Parentheses](src/test/java/com/guyko/TestValidParentheses.kt)** - Check for balanced brackets
- **[Palindrome Number](src/test/java/com/guyko/TestPalindrome.kt)** - Number and string palindrome detection
- **[Longest Palindromic Substring](src/test/java/com/guyko/TestPalindrome.kt)** - Find longest palindrome in string
- **[Regular Expression Matching](src/test/java/com/guyko/TestRegex1.kt)** - Pattern matching with `.` and `*`
- **[String Rotation & Substrings](src/test/java/com/guyko/TestSubstrings.kt)** - String manipulation algorithms

### 🔍 Binary Search
- **[Binary Search](src/test/java/com/guyko/TestBinarySearch.kt)** - Classic binary search implementation
- **[Search in Rotated Sorted Array](src/test/java/com/guyko/TestBinarySearch.kt)** - Modified binary search
- **[Find Minimum in Rotated Array](src/test/java/com/guyko/TestBinarySearch.kt)** - Minimum element detection

### 📊 Dynamic Programming
- **[Climbing Stairs](src/test/java/com/guyko/TestClimbingStairs.kt)** - Fibonacci-based DP problem
- **[Coin Change](src/test/java/com/guyko/TestClimbingStairs.kt)** - Minimum coins for amount
- **[Longest Increasing Subsequence](src/test/java/com/guyko/TestClimbingStairs.kt)** - Classic LIS problem

### 🌲 Trees & Data Structures
- **[Binary Tree Operations](src/test/java/com/guyko/TestTree.kt)** - Tree traversal and manipulation
- **[Linked List Reversal](src/test/java/com/guyko/TestLinked.kt)** - Reverse linked list algorithms

### ⏰ Intervals & Scheduling
- **[Merge Intervals](src/test/java/com/guyko/TestMergeIntervals.kt)** - Merge overlapping intervals
- **[Insert Interval](src/test/java/com/guyko/TestMergeIntervals.kt)** - Insert and merge new interval
- **[Year with Maximum People](src/test/java/com/guyko/TestYearWithMaxPeople.kt)** - Timeline optimization

### 🧮 Mathematical Problems
- **[Kakuro Solver](src/test/java/com/guyko/TestKakuro.kt)** - Combinatorial number puzzle

## 🏗️ Architecture

### Project Structure
```
src/
├── main/java/com/guyko/
│   └── App.java              # Simple main application
└── test/java/com/guyko/
    ├── TestTwoSum.kt         # Array problems (Two Sum)
    ├── TestValidParentheses.kt # Stack-based problems
    ├── TestPalindrome.kt     # String palindrome problems
    ├── TestBinarySearch.kt   # Binary search variants
    ├── TestClimbingStairs.kt # Dynamic programming
    ├── TestMergeIntervals.kt # Interval problems
    ├── TestSubSum.kt         # Maximum subarray (Kadane's)
    ├── TestRegex1.kt         # Pattern matching
    ├── TestSubstrings.kt     # String manipulation
    ├── TestTree.kt           # Binary tree operations
    ├── TestLinked.kt         # Linked list algorithms
    ├── TestKakuro.kt         # Combinatorial puzzles
    └── TestYearWithMaxPeople.kt # Timeline algorithms
```

### Technology Stack
- **Language**: Kotlin 2.0.21 with Java 11
- **Build Tool**: Maven 3.x
- **Testing**: JUnit 4.13.2
- **Development**: IntelliJ IDEA / VS Code

## 📖 Solution Approach

Each problem includes:

1. **📝 Problem Description** - Clear explanation of the problem
2. **💡 Algorithm Explanation** - Step-by-step approach
3. **⚡ Time & Space Complexity** - Big O analysis
4. **🧪 Test Cases** - Comprehensive test coverage
5. **💻 Clean Implementation** - Production-ready code

### Example Solution Structure
```kotlin
/**
 * LeetCode #1: Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
private fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }
    
    throw IllegalArgumentException("No two sum solution")
}
```

## 🎯 Key Features

- ✅ **Production Quality Code** - Clean, readable, and well-documented
- ✅ **Comprehensive Testing** - Full test coverage with edge cases
- ✅ **Optimal Solutions** - Time and space efficient algorithms
- ✅ **Latest Kotlin** - Modern language features and best practices
- ✅ **Security Focused** - No vulnerable dependencies
- ✅ **CI Ready** - Maven build system with security scanning

## 🔧 Development

### Running Specific Tests
```bash
# Run a specific test class
mvn test -Dtest=TestTwoSum

# Run tests with pattern matching
mvn test -Dtest="*BinarySearch*"

# Run all tests in a package
mvn test -Dtest="com.guyko.*"
```

### Code Quality
```bash
# Compile with full warnings
mvn compile -Xlint:all

# Generate documentation
mvn javadoc:javadoc

# Create source and javadoc JARs
mvn package
```

## 📊 Complexity Analysis

| Problem Category | Time Complexity | Space Complexity | Difficulty |
|-----------------|----------------|------------------|------------|
| Two Sum | O(n) | O(n) | Easy |
| Valid Parentheses | O(n) | O(n) | Easy |
| Binary Search | O(log n) | O(1) | Easy |
| Maximum Subarray | O(n) | O(1) | Medium |
| Merge Intervals | O(n log n) | O(n) | Medium |
| Longest Palindrome | O(n²) | O(1) | Medium |
| Regular Expression | O(mn) | O(mn) | Hard |

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-algorithm`)
3. Add your solution with comprehensive tests
4. Ensure all tests pass (`mvn test`)
5. Submit a pull request

### Contribution Guidelines
- Follow existing code style and patterns
- Include detailed problem description and complexity analysis
- Add comprehensive test cases
- Document your approach with comments

## 📄 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## 🔗 Resources

- [LeetCode](https://leetcode.com/) - Original problem source
- [Kotlin Documentation](https://kotlinlang.org/docs/) - Language reference
- [Big O Cheat Sheet](https://www.bigocheatsheet.com/) - Algorithm complexity reference

---

**Happy Coding!** 🚀 If you find this repository helpful, please consider giving it a ⭐!