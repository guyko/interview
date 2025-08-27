# 🤝 Contributing to Algorithm Interview Prep

Thank you for your interest in contributing! This repository aims to be the most comprehensive collection of interview algorithm solutions for software engineers.

## 🎯 How You Can Contribute

### 🆕 Adding New Algorithm Solutions
- **Popular LeetCode problems** (especially top 100 interview questions)
- **Company-specific questions** from FAANG and other tech companies
- **Optimization improvements** to existing solutions
- **Alternative approaches** for existing problems

### 📚 Documentation Improvements
- **Better explanations** of algorithm approaches
- **More detailed complexity analysis**
- **Real interview experiences** and tips
- **Study guides** and learning paths

### 🧪 Testing and Quality
- **Additional test cases** including edge cases
- **Performance benchmarks**
- **Code review** and refactoring suggestions

## 📋 Contribution Guidelines

### Code Standards
- **Follow existing patterns** in the codebase
- **Use Kotlin** for new algorithm implementations
- **Include comprehensive JavaDoc** comments
- **Add time/space complexity** analysis in comments
- **Write meaningful test cases** with edge cases

### File Structure
```kotlin
/**
 * LeetCode #XXX: Problem Name
 * Problem description here...
 * 
 * Time Complexity: O(...)
 * Space Complexity: O(...)
 */
private fun algorithmName(params): ReturnType {
    // Implementation with clear comments
}
```

### Required Elements for New Solutions
1. **Problem reference** (LeetCode number if applicable)
2. **Clear problem description**
3. **Algorithm explanation** in comments
4. **Time and space complexity** analysis
5. **At least 3 test cases** including edge cases
6. **Multiple approaches** if significantly different

## 🚀 Getting Started

### 1. Fork and Clone
```bash
git clone https://github.com/your-username/interview.git
cd interview
```

### 2. Create Feature Branch
```bash
git checkout -b feature/add-leetcode-xxx-problem-name
```

### 3. Set Up Development Environment
```bash
# Ensure Java 11+ and Maven are installed
mvn compile
mvn test
```

### 4. Add Your Solution
- Create new test file: `TestYourAlgorithm.kt`
- Follow existing naming conventions
- Include problem in appropriate category

### 5. Test Your Implementation
```bash
# Compile your code
mvn test-compile

# Run your specific test
mvn test -Dtest=TestYourAlgorithm

# Run all tests to ensure nothing breaks
mvn test
```

### 6. Update Documentation
- Add your algorithm to `ALGORITHMS.md` index
- Update `README.md` if adding new category
- Update complexity analysis table if needed

### 7. Submit Pull Request
- Use descriptive commit messages
- Reference any related issues
- Include test results in PR description

## 🏷️ Labeling and Categories

### Problem Categories
- `array` - Array manipulation problems
- `string` - String processing algorithms
- `dynamic-programming` - DP solutions
- `tree` - Binary tree and tree algorithms
- `graph` - Graph algorithms
- `binary-search` - Search algorithms
- `backtracking` - Constraint satisfaction
- `math` - Mathematical algorithms
- `linked-list` - Linked list operations

### Difficulty Levels
- `easy` - Beginner-friendly problems
- `medium` - Intermediate complexity
- `hard` - Advanced algorithms

### Company Tags
- `faang` - Facebook, Amazon, Apple, Netflix, Google
- `microsoft` - Microsoft-specific questions
- `uber` - Uber interview questions
- `airbnb` - Airbnb coding challenges

## 📝 Algorithm Solution Template

```kotlin
package com.guyko

import junit.framework.TestCase

class TestYourAlgorithm : TestCase() {

    fun testAlgorithmName() {
        // Test case 1: Normal case
        assertEquals(expected1, algorithmName(input1))
        
        // Test case 2: Edge case
        assertEquals(expected2, algorithmName(input2))
        
        // Test case 3: Corner case
        assertEquals(expected3, algorithmName(input3))
    }

    /**
     * LeetCode #XXX: Problem Name
     * 
     * Problem Statement:
     * [Detailed problem description]
     * 
     * Example:
     * Input: [example input]
     * Output: [example output]
     * Explanation: [why this output]
     * 
     * Constraints:
     * - [constraint 1]
     * - [constraint 2]
     * 
     * Approach:
     * [Explain the algorithm approach]
     * 
     * Time Complexity: O(n) - [explanation]
     * Space Complexity: O(1) - [explanation]
     */
    private fun algorithmName(input: InputType): ReturnType {
        // Clear, readable implementation
        // with helpful comments explaining key steps
        
        return result
    }
}
```

## 🎖️ Recognition

Contributors will be:
- **Listed in README** acknowledgments
- **Tagged in releases** when their solutions are included
- **Featured** in documentation for significant contributions

### Top Contributor Benefits
- **Maintainer access** for regular contributors
- **Direct collaboration** on repository direction
- **Interview prep resources** and study materials

## 📞 Getting Help

### Questions?
- **Open an issue** with the `question` label
- **Join discussions** in existing issues
- **Review existing code** for patterns and examples

### Review Process
1. **Automated checks** run on all PRs
2. **Code review** by maintainers
3. **Test verification** ensures quality
4. **Documentation check** for completeness

## 🏆 What Makes a Great Contribution

### High-Impact Additions
- **Popular interview questions** (asked by multiple companies)
- **Multiple solution approaches** for the same problem
- **Optimization improvements** to existing code
- **Comprehensive test coverage**

### Quality Indicators
- **Clean, readable code** with good variable names
- **Thorough comments** explaining the approach
- **Edge case handling** and input validation
- **Performance considerations** noted

## 📈 Repository Goals

Our mission is to create:
- **The most comprehensive** algorithm interview repository
- **Production-quality code** that engineers actually use
- **Excellent documentation** for learning and reference
- **Active community** of contributors and learners

### Success Metrics
- **GitHub stars** and community engagement
- **Real interview success** stories from users
- **Code quality** and comprehensive coverage
- **Educational value** for computer science students

## 🎉 Thank You!

Every contribution, no matter how small, helps make this repository more valuable for software engineers preparing for technical interviews. Your effort helps others land their dream jobs!

**Happy coding!** 🚀