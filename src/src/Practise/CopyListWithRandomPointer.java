package Practise;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    // Uses Extra Space
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> nodeHashMap = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            nodeHashMap.put(temp, node);
            temp = temp.next;
        }

        Node t = head;
        while (t != null) {
            Node node = nodeHashMap.get(t);
            node.next = t.next != null ? nodeHashMap.get(t.next) : null;
            node.random = t.random != null ? nodeHashMap.get(t.random) : null;
            t = t.next;
        }

        return nodeHashMap.get(head);
    }

    // Removing Extra HashMap
    public Node copyRandomListEfficient(Node head) {
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }

        Node itr = head;
        while (itr != null) {
            if (itr.random != null)
                itr.next.random = itr.random.next;
            itr = itr.next.next;
        }

        Node empty = new Node(-1);
        temp = empty;
        itr = head;
        Node fast;

        while (itr != null) {
            fast = itr.next.next;
            temp.next = itr.next;
            itr.next = fast;
            temp = temp.next;
            itr = fast;
        }

        return empty.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

