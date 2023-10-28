package Practise;

public class RemoveDuplicatesFromASortedDoublyLinkedList {
//Doubly Linked List
    public static Node uniqueSortedList(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null){
            if (temp.data == temp.next.data)
                head = deleteNode(head, temp.next);
            else
                temp = temp.next;
        }
        return head;
    }

    private static Node deleteNode(Node head, Node node) {
        if (head == null || node == null)
            return null;

        if (head == node)
            return head.next;

        if (node.prev != null)
            node.prev.next = node.next;

        if (node.next != null)
            node.next.prev = node.prev;

        return head;
    }


    // SINGLY LINKED LIST
    public static Node uniqueSortedListForSingleLL(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null){
            if (temp.data == temp.next.data)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return head;
    }
}
