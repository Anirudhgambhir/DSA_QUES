package Practise;

public class FindLengthOfLoop {

    public static int lengthOfLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == slow){
            int count = 1;
            fast = fast.next;
            while (slow != fast) {
                fast = fast.next;
                count++;
            }
            return count;
        }

        return 0;
    }
}
