package Practise;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode updatedHead = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return updatedHead;
    }
}
