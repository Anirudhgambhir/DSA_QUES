package Practise;

public class FlattenALinkedList {
    public static Node flattenLinkedList(Node head) {
        Node newList = new Node(-1);
        Node temp = newList;
        Node tempHead = head;
        while (tempHead != null) {
            Node childHead = tempHead;
            while (childHead != null) {
                temp.child = new Node(childHead.data);
                temp = temp.child;
                childHead = childHead.child;
            }
            tempHead = tempHead.next;
        }
        return sortList(newList.child);
    }
    private static Node sortList(Node head) {
        if (head == null || head.child == null) {
            return head;
        }
        Node fast, slow;
        fast = head;
        slow = head;
        Node prev = null;

        while (fast != null && fast.child != null) {
            prev = slow;
            fast = fast.child.child;
            slow = slow.child;
        }

        prev.child = null;

        Node node1 = sortList(head);
        Node node2 = sortList(slow);

        return merge(node1, node2);
    }

    private static Node merge(Node node1, Node node2) {
        Node temp = new Node(-1);
        Node counter = temp;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                counter.child = node1;
                node1 = node1.child;
            } else {
                counter.child = node2;
                node2 = node2.child;
            }
            counter = counter.child;
        }

        if (node1 != null) {
            counter.child = node1;
        }

        if (node2 != null) {
            counter.child = node2;
        }
        return temp.child;
    }
}
