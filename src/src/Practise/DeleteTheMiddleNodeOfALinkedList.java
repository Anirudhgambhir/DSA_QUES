package Practise;

public class DeleteTheMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        if (fast != null && fast.next != null)
            fast = fast.next.next;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
