QUESTION: https://practice.geeksforgeeks.org/problems/circular-linked-list/1#

boolean isCircular(Node head)
    {
	// Your code here
	    if(head == null){
	        return true;
	    }
	    Node temp = head;
	    while(temp != null){
	        if(temp.next == head){
	            return true;
	        }
	        temp = temp.next;
	    }
	    return false;
    }
