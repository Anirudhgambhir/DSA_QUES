package Practise;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        // Base Check for empty List or No Rotation.
        if (k == 0 || head == null)
            return head;

        // Checking Length of List
        ListNode tempNode = head;
        int length = 0;
        while (tempNode != null)
        {
            tempNode = tempNode.next;
            length++;
        }

        // Updating Value of K, Incase K is bigger than List.
        k = k % length;

        ListNode fast = head;
        int temp = k;
        while (temp > 0) {
            fast = fast.next;
            temp--;
        }

        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        ListNode tempHead = slow.next;
        slow.next = null;
        return tempHead;

    }
}
