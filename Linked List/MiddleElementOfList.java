QUESTION: https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1/

int getMiddle(Node head)
    {
         // Your code here.
         Node slow = head;
         Node fast = head;
         while(fast != null && fast.next != null){
             
             fast= fast.next.next;
             slow = slow.next;
        }   
        return slow.data;
    }
