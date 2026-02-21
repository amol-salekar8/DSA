# Singly Linked List

![](./image/SinglyLinkedList.svg)

- Linked List consists of a series of structure called nodes
- Each node is record
- 1<sup>st</sup> part of record stores data
- 2<sup>nd</sup> part of record store pointer to next node.
- Each node contains 2 fields data and next filed
- Each node allocated n the heap with call to new().

**[Single List Node](../utility/SingleListNode.java)**

### Basic operation
1) Traversing the list
2) Inserting an item in the list
3) Deleting an item in the list

### 1) Traversing the list
**Operation**
1) Follow the pointers
2) Display the contents of nodes as they traversed
3) Stop when the next pointers point to null

```java
import com.dsa.linkedList.singly.SingleListNode;

// Count program

public int length(SingleListNode headNode) {
  int count = 0;
  SingleListNode currentNode = headNode;
  while (currentNode != null) {
    count++;
    currentNode = currentNode.next;
  }
  return count;
}

/**
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
```

### 2) Insertion
**Types of insertion**
1) At the beginning (Before the head)
2) End of List (After the current tail)
3) Random location (Middle of the list)

**1) At the beginning :**
- Only one pointer needs to modify

**Operation**
- Update the new node -> current head

![Singly_insertion_At_Beginning_1](./image/Singly_insertion_At_Beginning_1.svg)
-  Update the head pointer to point to new node

![Singly_insertion_At_Beginning_2](./image/Singly_insertion_At_Beginning_2.svg)

**2) At the End :**
- Modify two next pointer
  - tail node next pointer
  - new node next pointer
  
**Operation**
- New node -> null

![Singly_insertion_At_End_1](./image/Singly_insertion_At_End_1.svg)

- Tail node -> New node

![Singly_insertion_At_End_2](./image/Singly_insertion_At_End_2.svg)

**3) At the Middle :**
- Modify two next pointer
- E.G. If we want to add an element at position 3 then we need to stop at position 2

![Singly_insertion_At_Middle_1](./image/Singly_insertion_At_Middle_1.svg)
![Singly_insertion_At_Middle_2](./image/Singly_insertion_At_Middle_2.svg)

### 3) Deletion
**Types of deletion**
1) Deleting First node (Head node)
2) Deleting last node (Tail node)
3) Deleting Intermediate (Middle) Node

**1) Deleting First node**
1) Create a temporary node which will point to same node as that lead.

![Singly_Deletion_At_Beginning_1.svg](./image/Singly_Deletion_At_Beginning_1.svg)
2) Now move the head pointer to next node and dispose the temporary node
   
![Singly_Deletion_At_Beginning_2.svg](./image/Singly_Deletion_At_Beginning_2.svg)

**2) Deleting last node (Tail node)**
- Tricker than removing first node, because the algorithm should find a node which is previous to tail
**Step 1 :**
- Traverse the list and maintain previous node address also
- When we reach end of the list we have two nodes
  - previous of tail node
  - tail node

![Singly_Deletion_At_End_1](./image/Singly_Deletion_At_End_1.svg)

**Step 2 :**
- Update previous node next pointer to Null

![Singly_Deletion_At_End_2](./image/Singly_Deletion_At_End_2.svg)

**Step 3 :**
- Dispose of the tail node

![Singly_Deletion_At_End_3](./image/Singly_Deletion_At_End_3.svg)

**2) Deleting Intermediate node (Middle node)**
- Always located between two node

**Step 1 :** 
- Maintain location of previous node while traversing to list
- Once we find the node to be deleted change previous node -> next -> next

![Singly_Deletion_At_Intermidiate_1.svg](./image/Singly_Deletion_At_Intermidiate_1.svg)
![Singly_Deletion_At_Intermidiate_2.svg](./image/Singly_Deletion_At_Intermidiate_2.svg)

## Deletion of whole Single Linked List
- This work storing the current node in temporary variable and freezing the current node.
- After freezing the current node go to the next with temporary variable and repeat this process for all nodes.


## [Singly List implementation](../singly/SingleLinkedImplemtation.java)



