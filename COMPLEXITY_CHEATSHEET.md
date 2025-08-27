# ⏱️ Algorithm Complexity Cheat Sheet

## 📊 Big O Complexity Chart

### Time Complexity Rankings (Best to Worst)

| Big O | Name | Example | Description |
|-------|------|---------|-------------|
| **O(1)** | Constant | Array access, Hash table lookup | Executes in same time regardless of input size |
| **O(log n)** | Logarithmic | Binary search, Tree operations | Time increases logarithmically with input |
| **O(n)** | Linear | Linear search, Single loop | Time increases linearly with input |
| **O(n log n)** | Linearithmic | Merge sort, Quick sort | Efficient sorting algorithms |
| **O(n²)** | Quadratic | Bubble sort, Nested loops | Time increases quadratically |
| **O(n³)** | Cubic | Triple nested loops | Three-dimensional problems |
| **O(2ⁿ)** | Exponential | Recursive Fibonacci, Subsets | Time doubles with each input increase |
| **O(n!)** | Factorial | Traveling salesman (brute force) | Extremely slow for large inputs |

## 📈 Visual Performance Comparison

```
Operations for different input sizes:

n=10        n=100       n=1000      n=10000
O(1):       1           1           1           1
O(log n):   3           7           10          13
O(n):       10          100         1000        10000
O(n log n): 33          664         9966        132877
O(n²):      100         10000       1000000     100000000
O(2ⁿ):      1024        2^100       2^1000      2^10000
```

## 🎯 This Repository's Algorithm Complexities

### Arrays and Hash Tables
| Algorithm | Time | Space | File |
|-----------|------|-------|------|
| Two Sum | O(n) | O(n) | `TestTwoSum.kt` |
| Maximum Subarray | O(n) | O(1) | `TestSubSum.kt` |
| Merge Intervals | O(n log n) | O(n) | `TestMergeIntervals.kt` |
| Insert Interval | O(n) | O(n) | `TestMergeIntervals.kt` |

### String Processing
| Algorithm | Time | Space | File |
|-----------|------|-------|------|
| Valid Parentheses | O(n) | O(n) | `TestValidParentheses.kt` |
| Palindrome Number | O(log n) | O(1) | `TestPalindrome.kt` |
| Longest Palindrome | O(n²) | O(1) | `TestPalindrome.kt` |
| Regex Matching | O(m×n) | O(m×n) | `TestRegex1.kt` |
| String Rotation | O(n) | O(n) | `TestSubstrings.kt` |

### Search Algorithms
| Algorithm | Time | Space | File |
|-----------|------|-------|------|
| Binary Search | O(log n) | O(1) | `TestBinarySearch.kt` |
| Search Rotated Array | O(log n) | O(1) | `TestBinarySearch.kt` |
| Find Min Rotated | O(log n) | O(1) | `TestBinarySearch.kt` |

### Dynamic Programming
| Algorithm | Time | Space | File |
|-----------|------|-------|------|
| Climbing Stairs | O(n) | O(1) | `TestClimbingStairs.kt` |
| Coin Change | O(amount × coins) | O(amount) | `TestClimbingStairs.kt` |
| Longest Increasing Subsequence | O(n²) | O(n) | `TestClimbingStairs.kt` |

### Tree Algorithms
| Algorithm | Time | Space | File |
|-----------|------|-------|------|
| Tree Traversal | O(n) | O(h) | `TestTree.kt` |
| Tree Construction | O(n) | O(h) | `TestTree.kt` |
| Tree Serialization | O(n) | O(n) | `TestTree.kt` |

### Linked Lists
| Algorithm | Time | Space | File |
|-----------|------|-------|------|
| Reverse Linked List | O(n) | O(1) | `TestLinked.kt` |
| Reverse K Groups | O(n) | O(1) | `TestLinked.kt` |

### Mathematical
| Algorithm | Time | Space | File |
|-----------|------|-------|------|
| Kakuro Solver | O(9^n) | O(n) | `TestKakuro.kt` |
| Year Max People | O(n log n) | O(n) | `TestYearWithMaxPeople.kt` |

## 🧠 Memory Complexity Guide

### Space Complexity Categories

| Space | Description | Examples |
|-------|-------------|----------|
| **O(1)** | Constant extra space | In-place algorithms, variables |
| **O(log n)** | Logarithmic space | Recursive calls on balanced trees |
| **O(n)** | Linear space | Creating arrays, hash tables |
| **O(n²)** | Quadratic space | 2D arrays, memoization tables |

### Stack Space in Recursion
- **Balanced Binary Tree**: O(log n) stack depth
- **Skewed Tree**: O(n) stack depth  
- **Divide & Conquer**: Usually O(log n)
- **Backtracking**: O(depth of solution)

## 🎯 Interview Optimization Tips

### Time Optimization Strategies

1. **Hash Tables** → Convert O(n²) nested loops to O(n)
2. **Binary Search** → Convert O(n) linear search to O(log n)
3. **Dynamic Programming** → Convert O(2ⁿ) recursion to O(n²) or O(n)
4. **Two Pointers** → Convert O(n²) to O(n) for sorted arrays
5. **Sorting** → Enable O(n log n) solutions for many problems

### Space Optimization Strategies

1. **In-place algorithms** → Reduce O(n) space to O(1)
2. **Sliding window** → Process streams without storing all data
3. **Bottom-up DP** → Replace recursive O(n) stack with iterative O(1)
4. **Rolling arrays** → Reduce 2D DP space from O(n²) to O(n)

## 📚 Common Complexity Patterns

### Input Size Guidelines

| Input Size | Maximum Complexity | Algorithms |
|------------|-------------------|------------|
| n ≤ 10 | O(n!) | Brute force, permutations |
| n ≤ 20 | O(2ⁿ) | Backtracking, subsets |
| n ≤ 500 | O(n³) | Dynamic programming |
| n ≤ 5000 | O(n²) | Nested loops, bubble sort |
| n ≤ 10⁶ | O(n log n) | Merge sort, binary search |
| n ≤ 10⁸ | O(n) | Linear algorithms |
| n > 10⁸ | O(log n) or O(1) | Binary search, math formulas |

### Data Structure Operations

| Data Structure | Access | Search | Insertion | Deletion |
|----------------|--------|--------|-----------|----------|
| **Array** | O(1) | O(n) | O(n) | O(n) |
| **Hash Table** | O(1) | O(1) | O(1) | O(1) |
| **Binary Search Tree** | O(log n) | O(log n) | O(log n) | O(log n) |
| **Heap** | O(1) | O(n) | O(log n) | O(log n) |
| **Stack** | O(1) | O(n) | O(1) | O(1) |
| **Queue** | O(1) | O(n) | O(1) | O(1) |

## 🔍 Algorithm Selection Guide

### For Searching Problems
- **Sorted Array** → Binary Search O(log n)
- **Unsorted Array** → Linear Search O(n) or Hash Table O(1)
- **Range Queries** → Segment Tree O(log n)

### For Sorting Problems
- **Small Arrays (n < 50)** → Insertion Sort O(n²)
- **General Purpose** → Merge Sort O(n log n)
- **Memory Constrained** → Heap Sort O(n log n)
- **Nearly Sorted** → Tim Sort O(n)

### For Dynamic Programming
- **Optimal Substructure** → Bottom-up DP
- **Overlapping Subproblems** → Memoization
- **Space Critical** → Rolling array optimization

### For String Problems
- **Pattern Matching** → KMP O(n+m)
- **Multiple Patterns** → Aho-Corasick
- **Edit Distance** → DP O(n×m)

## ⚡ Quick Reference

### Most Common Interview Complexities
- **O(1)** - Hash table lookups, array access
- **O(log n)** - Binary search, balanced tree operations
- **O(n)** - Single pass algorithms, BFS/DFS
- **O(n log n)** - Efficient sorting, divide and conquer
- **O(n²)** - Nested loops, basic dynamic programming

### Red Flags (Usually Too Slow)
- **O(n³)** - Avoid unless n < 500
- **O(2ⁿ)** - Only for small inputs (n < 25)
- **O(n!)** - Brute force, very small inputs only

### Golden Rules
1. **Prefer O(n log n) over O(n²)** when possible
2. **Use hash tables** to eliminate nested loops
3. **Consider sorting** to enable two-pointer techniques
4. **Think DP** for optimization problems
5. **Binary search** for sorted data or search spaces

Remember: **Premature optimization is the root of all evil**, but understanding complexity helps you choose the right algorithm from the start!