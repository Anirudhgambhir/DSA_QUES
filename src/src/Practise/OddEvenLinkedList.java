package Practise;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = head.next;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = temp;
        return head;
    }
}
