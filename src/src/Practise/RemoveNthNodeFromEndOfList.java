package Practise;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        if (count == n)
            return head.next;
        count -= (n + 1);
        temp = head;
        while (count > 0){
            temp = temp.next;
            count--;
        }
        temp.next = temp.next.next;
        return head;
    }

    public ListNode removeNthFromEndEfficient(ListNode head, int n) {
        ListNode temp = head;
        ListNode main = head;

        while (n > 0){
            temp = temp.next;
            n--;
        }

        if (temp == null)
            return head.next;

        while (temp.next != null){
            temp = temp.next;
            main = main.next;
        }

        main.next = main.next.next;

        return head;
    }
}
