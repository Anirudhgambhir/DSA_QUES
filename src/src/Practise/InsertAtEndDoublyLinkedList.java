package Practise;

class Node {
    public int data;
    public Node next;
    public Node prev;

    Node()
    {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
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
