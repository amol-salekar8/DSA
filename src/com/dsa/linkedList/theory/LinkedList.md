# LinkedList

**Problems of Array**
1) static structure
2) cannot extend or reduced
3) Expensive to maintain new insertion and deletion

To overcome above problem we  go to Linked List

**Q.How it made**
1) Data
2) Reference to next node

- Entry point of linked list is called head
- Last node is referece to null

![StructureOfLinkedList](./image/StructureOfLinkedList.svg)

**Note :** If the list is empty then head node is null

## Feature
- Successive elements are connected by pointer.
- The last elements points to null.
- Can grow or shrink in size during execution of program.
- Can be made just as long as required ( until system memory exhausted).
- Does not want memory space (but take some extra memory space for pointers).

## Abstract Data Structure
1) Main Operation
    - Insert 
    - Delete
2) Auxiliary operation
    - Delete list
    - Count
    - Find n<sup>th</sup> node

## Advantage
1) Expand in constant time

## Disadvantage
1) Acces time to individual elements take O(n) time complexity.
2) It is hard to manipulate, if we delete any node in between then we need to change pointer

## Comparision
| Parameter                         | Linked List       | Array | Dynamic Array |
|-----------------------------------|-------------------|---------|-------------|
| Indexing                          | O(n)              | O (1) | O (1) |
| Insertion and deletion at begning | O(1)              | O (n) if array is full | O(n) |
| Insertion at end                  | O(n)              | O(1) if not full | O(1) not full |
| Deletion at end                   | O(n)              | O(1) | O(n) |
| Insertion at middle               | O(n)              | O(n) | O(n) |
| Deletion at middle                | O(n)              | O(n) | O(n) |
| Wasted space                      | O(n) for pointers | O(n) | O(n) |


### Types
1) [Singly Linked List](SinglyLinkedList.md)
2) [Doubly Linked List](DoublyLinkedList.md)
3) [Circular Linked List](CircularLinkedList.md)