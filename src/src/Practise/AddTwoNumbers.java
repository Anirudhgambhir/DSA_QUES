package Practise;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode();
        ListNode head = ans;
        while (l1 != null || l2 != null) {
            int add = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + carry;
            if (add > 9) {
                add = add % 10;
                carry = 1;
            } else
                carry = 0;

            ListNode temp = new ListNode(add, null);
            ans.next = temp;
            ans = temp;

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }

        if (carry > 0) {
            ans.next = new ListNode(carry, null);
        }

        return head.next;
    }
}
