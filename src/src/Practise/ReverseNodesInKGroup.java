package Practise;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        return reverseKNode(head, k, count);
    }

    private ListNode reverseKNode(ListNode head, int k, int length) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
            length--;
        }

        if (curr != null && length >= k) {
            head.next = reverseKNode(next, k, length);
        } else
            head.next = next;

        return prev;
    }
}