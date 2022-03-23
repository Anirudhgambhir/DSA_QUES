QUESTION: https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/

public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int len = 1;
        while(curr.next!= null){
            len++;
            curr= curr.next;
        }
        return reverseK(head,k,len);
    }
    public ListNode reverseK(ListNode head, int k, int l) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while(curr != null && count<k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
            l--;
        }
        
        if(curr!= null && l >= k){
            head.next = reverseK(next, k, l);
        }else{
            head.next = next;
        }
        
        return prev;
    }
