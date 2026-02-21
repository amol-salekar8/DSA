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
import com.dsa.linkedList.utility.SingleListNode;
// Count program
public int length(SingleListNode headNode){
    int count =0;
    SingleListNode currentNode = headNode;
    while (currentNode != null){
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