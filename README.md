# Data-Structures

# 1 - Array Data Structure

## Overview
An **array** is a fundamental data structure in computer science that stores a collection of elements. Each element in an array is identified by an index or a key. Arrays are widely used due to their simplicity and efficiency in accessing elements.

## Key Characteristics
- **Fixed Size**: The size of an array is determined at the time of creation and cannot be changed dynamically.
- **Homogeneous Elements**: All elements in an array are of the same data type.
- **Random Access**: Elements can be accessed directly using their index, making array access time O(1).
- **Contiguous Memory**: Elements are stored in contiguous memory locations, which allows for efficient memory access.

## Basic Operations
1. **Access**: Retrieve an element by its index.
2. **Insertion**: Add an element at a specific index (may require shifting elements).
3. **Deletion**: Remove an element from a specific index (may require shifting elements).
4. **Search**: Find the index of a specific element.
5. **Update**: Modify the value of an element at a specific index.

## Example [Code](https://github.com/ADIMYY/Data-Structures/blob/main/Array/Array.java) (Java)

# 2 - Linked List Data Structure

This repository provides an implementation of the **Linked List** data structure in [Python/C/Java/etc.]. A linked list is a linear data structure where each element (called a node) contains data and a reference (or pointer) to the next node in the sequence. Unlike arrays, linked lists are not stored in contiguous memory locations, which allows for dynamic memory allocation and efficient insertions/deletions.

## Table of Contents
1. [What is a Linked List?](#what-is-a-linked-list)
2. [Types of Linked Lists](#types-of-linked-lists)
3. [Operations on Linked Lists](#operations-on-linked-lists)
4. [Code Implementation](#code-implementation)
5. [Usage](#usage)
6. [Contributing](#contributing)
7. [License](#license)

---

## What is a Linked List?

A **Linked List** is a linear data structure consisting of nodes, where each node contains:
- **Data**: The value stored in the node.
- **Next**: A reference (or pointer) to the next node in the sequence.

The first node is called the **head**, and the last node points to `null` (or `None`), indicating the end of the list.

### Advantages of Linked Lists:
- Dynamic size: Nodes can be added or removed as needed.
- Efficient insertions and deletions: No need to shift elements like in arrays.

### Disadvantages of Linked Lists:
- Random access is not allowed. You must traverse the list from the head to access a specific node.
- Extra memory is required for storing the pointers.

---

## Types of Linked Lists

1. **Singly Linked List**: Each node points only to the next node.
2. **Doubly Linked List**: Each node points to both the next and the previous node.
3. **Circular Linked List**: The last node points back to the first node, forming a loop.

---

## Operations on Linked Lists

Common operations on linked lists include:
1. **Insertion**:
   - Insert at the beginning.
   - Insert at the end.
   - Insert at a specific position.
2. **Deletion**:
   - Delete from the beginning.
   - Delete from the end.
   - Delete a specific node.
3. **Traversal**: Access each node in the list.
4. **Search**: Find a node with a specific value.
5. **Reverse**: Reverse the order of nodes in the list.

---

## [Code](https://github.com/ADIMYY/Data-Structures/blob/main/LinkedList/LinkedList.java) Implementation

Below is an example implementation of a **Singly Linked List** in Java.
