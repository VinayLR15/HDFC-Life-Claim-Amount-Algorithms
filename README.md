# HDFC Life Claim Amount Algorithms

A Java console application that implements different array and algorithm problems using HDFC Life claim amount data.

## Technologies

* Java 21+
* Plain Java
* IntelliJ IDEA
* Git & GitHub

## Algorithms Implemented

1. Array Insert and Delete using Shifting
2. Pair Sum using Brute Force
3. Pair Sum using Two Pointer
4. Palindrome using Two Pointer
5. Partition using Two Pointer
6. Sliding Window - Maximum Sum of Size K
7. Sliding Window - Longest Substring Without Repeating Characters
8. Recursive Binary Search
9. Custom Exception Handling

## Seed Data

```text
25000, 18000, 42000, 15000, 31000, 9000
```

The claim amounts are stored using a raw `int[]` with a `size` field.

## Project Structure

```text
hdfc-life-claim-algorithms/
│
├── src/
│   └── com/
│       └── hdfclife/
│           ├── Main.java
│           │
│           ├── algo/
│           │   ├── PairSumSolver.java
│           │   ├── PalindromeChecker.java
│           │   ├── PartitionSolver.java
│           │   ├── SlidingWindowSolver.java
│           │   ├── UniqueSubstringSolver.java
│           │   └── BinarySearcher.java
│           │
│           ├── exception/
│           │   ├── AlgorithmException.java
│           │   ├── InvalidIndexException.java
│           │   ├── StoreFullException.java
│           │   ├── PairNotFoundException.java
│           │   └── InvalidWindowException.java
│           │
│           └── store/
│               └── ClaimAmountStore.java
│
├── README.md
└── .gitignore
```

## Expected Output

```text
Seed Array:
25000, 18000, 42000, 15000, 31000, 9000

After Insert:
25000, 18000, 22000, 42000, 15000, 31000, 9000

Elements Shifted:
4

After Delete:
25000, 18000, 42000, 15000, 31000, 9000

Brute Force Pair:
15000 + 42000

Two Pointer Pair:
15000 + 42000

Palindrome 12321:
true

Palindrome 18500:
false

Partition:
9000, 18000, 15000, 42000, 31000, 25000

Maximum Window Sum:
88000

Longest Unique Substring Length:
8

Binary Search 15000:
found

Binary Search 999:
not found

Invalid Index:
Invalid index: 99

Pair Not Found:
No pair found for target: 1
```

## Complexity

| Algorithm                  |       Time | Extra Space |
| -------------------------- | ---------: | ----------: |
| Array Insert               |       O(n) |        O(1) |
| Array Delete               |       O(n) |        O(1) |
| Brute Force Pair Sum       |      O(n²) |        O(1) |
| Two Pointer Pair Sum       | O(n log n) |        O(n) |
| Palindrome                 |       O(d) |        O(d) |
| Partition                  |       O(n) |        O(1) |
| Sliding Window Maximum Sum |       O(n) |        O(1) |
| Longest Unique Substring   |       O(n) |        O(n) |
| Recursive Binary Search    |   O(log n) |    O(log n) |

Where `n` is the number of claim amounts and `d` is the number of digits.

## Why Two Pointer Pair Sum?

For 1,000,000 daily claim amounts, the two-pointer approach is better than brute force.

Brute force takes O(n²) time because it checks every possible pair.

The two-pointer approach sorts the data in O(n log n) time and then searches using two pointers.

Therefore, it is much more efficient and scalable for a large dataset.

## Run the Project

### IntelliJ IDEA

Open `Main.java` and select:

```text
Right Click → Run 'Main.main()'
```

### Terminal

Compile:

```bash
javac -d out $(find src -name "*.java")
```

Run:

```bash
java -cp out com.hdfclife.Main
```

## Notes

* Plain Java only
* No Spring
* No Java Streams
* No `ArrayList` for claim amounts
* Uses a raw `int[]` with a `size` field
* Insert and delete use in-place shifting
* Pair sum uses both brute-force and two-pointer approaches
* Partition works on a copy of the seed array
* Custom exceptions are used for invalid operations

## Author

**Vinay L R**

**HDFC Life (Backend Developer)**
