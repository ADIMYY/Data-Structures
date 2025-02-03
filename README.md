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
----
# 2 - Linked List Data Structure

This repository provides an implementation of the **Linked List** data structure in [Python/C/Java/etc.]. A linked list is a linear data structure where each element (called a node) contains data and a reference (or pointer) to the next node in the sequence. Unlike arrays, linked lists are not stored in contiguous memory locations, which allows for dynamic memory allocation and efficient insertions/deletions.

## Table of Contents
1. [What is a Linked List?](#what-is-a-linked-list)
2. [Types of Linked Lists](#types-of-linked-lists)
3. [Operations on Linked Lists](#operations-on-linked-lists)
4. [Code Implementation](#code-implementation)

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
---
# 3 - Stack Data Structure

A **Stack** is a linear data structure that follows the **LIFO (Last In, First Out)** principle. This means that the last element added to the stack will be the first one to be removed.

---

## Key Operations

1. **Push**: Add an element to the top of the stack.
2. **Pop**: Remove and return the top element of the stack.
3. **Peek/Top**: Retrieve the top element without removing it.
4. **IsEmpty**: Check if the stack is empty.
5. **Size**: Get the number of elements in the stack.

---

## Real-World Examples

- **Undo Functionality**: In text editors, the undo feature uses a stack to keep track of changes.
- **Browser History**: Backtracking through browser history is managed by a stack.
- **Expression Evaluation**: Parsing and evaluating mathematical expressions.

---

## Visualization

Imagine a stack of plates:

- When you add a plate, it is placed on top of the stack.
- When you remove a plate, it is taken from the top.

```
Top ->  [ Plate 3 ]
         [ Plate 2 ]
         [ Plate 1 ]
Bottom ->
```

---

## Implementation

### [Java Example](https://github.com/ADIMYY/Data-Structures/blob/main/Stack/Stack.java)
---

## Advantages

1. Simple to implement.
2. Efficient for managing data with **LIFO** order.

## Disadvantages

1. Limited access to only the top element.
2. Fixed size if implemented with arrays (unless dynamically resized).

---

## Applications

- **Expression evaluation** (e.g., postfix, prefix expressions).
- **Function call management** in programming languages.
- [**Balanced parenthesis checking**](https://github.com/ADIMYY/Data-Structures/blob/main/Stack/Expression.java) in compilers.

---
# 4 - Queue Data Structure

## What is a Queue?
A **Queue** is a linear data structure that follows the **First In, First Out (FIFO)** principle. This means that the first element added to the queue is the first one to be removed.

### Key Characteristics:
- **FIFO (First In, First Out):** The first element added is the first to be removed.
- **Enqueue:** Adding an element to the rear (end) of the queue.
- **Dequeue:** Removing an element from the front of the queue.
- **Front (Head):** The first element in the queue.
- **Rear (Tail):** The last element in the queue.

## Types of Queues
1. **Simple Queue** - Basic queue with FIFO ordering.
2. **Circular Queue** - The last position is connected back to the first to make a circular structure.
3. **Double-ended Queue (Deque)** - Elements can be added or removed from both ends.
4. **Priority Queue** - Elements are dequeued based on priority rather than order.

## Queue [Implementation](https://github.com/ADIMYY/Data-Structures/tree/main/Queue) Using Java

## Applications of Queues
- **CPU Scheduling** (Round-robin scheduling)
- **Print Spoolers** (Managing print jobs)
- **Handling Requests in Web Servers**
- **Breadth-First Search (BFS) in Graphs**
- **Managing Calls in Customer Support Systems**

## Complexity Analysis
| Operation  | Time Complexity |
|------------|----------------|
| Enqueue    | O(1)           |
| Dequeue    | O(1)           |
| Front/Rear | O(1)           |
| is_empty   | O(1)           |

## Conclusion
Queues are a fundamental data structure with various real-world applications. Understanding how they work and implementing them efficiently is crucial in data structures and algorithms.
---
