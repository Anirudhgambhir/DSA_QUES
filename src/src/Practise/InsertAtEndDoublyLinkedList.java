package Practise;

public class InsertAtEndDoublyLinkedList {
    public static Node insertAtTail(Node list, int K) {
        if (list == null)
            return new Node(K);

        Node node = list;
        Node newNode = new Node(K);

        while (node.next != null)
            node = node.next;

        node.next = newNode;
        newNode.prev = node;
        return list;
    }
}
