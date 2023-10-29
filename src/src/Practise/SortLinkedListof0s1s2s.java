package Practise;

public class SortLinkedListof0s1s2s {
    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node fast, slow;
        fast = head;
        slow = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        prev.next = null;

        Node node1 = sortList(head);
        Node node2 = sortList(slow);

        return merge(node1, node2);
    }

    private Node merge(Node node1, Node node2) {
        Node temp = new Node(-1);
        Node counter = temp;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                counter.next = node1;
                node1 = node1.next;
            } else {
                counter.next = node2;
                node2 = node2.next;
            }
            counter = counter.next;
        }

        if (node1 != null) {
            counter.next = node1;
        }

        if (node2 != null) {
            counter.next = node2;
        }
        return temp.next;
    }
}
