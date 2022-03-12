QUESTION: https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1/

boolean isPalindrome(Node head) 
    {
        //Your code here
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow= slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow != null){
            if(slow.data != fast.data){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
        }
        
    Node reverse(Node head){
        Node curr = null;
        Node prev = null;
        Node next = head;
        while(next!=null){
            curr = next.next;
            next.next = prev;
            prev = next;
            next = curr;
        }
        return prev;
    }
