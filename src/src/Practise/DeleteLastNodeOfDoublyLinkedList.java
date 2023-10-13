package Practise;

public class DeleteLastNodeOfDoublyLinkedList {
    public static Node deleteLastNode(Node head) {
        if (head.next == null)
            return null;
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.prev.next = null;
        temp.prev = null;

        return head;
    }
}
