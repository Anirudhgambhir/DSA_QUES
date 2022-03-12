QUESTION: https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1

void deleteNode(Node del)
    {
         // Your code here
         del.data = del.next.data;
         del.next = del.next.next;
    }
