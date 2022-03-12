QUESTION: https://leetcode.com/problems/remove-linked-list-elements/

public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        while(head.val == val && head.next !=null){
                head = head.next;    
        }
        if(head.next == null && head.val == val ){
                return null;
        }
        ListNode temp = head;
        while(temp!= null  && temp.next!=null){
            
            if(temp.next.val == val){
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
            
        }
        return head;
    }
