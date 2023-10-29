package Practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(list);
        temp = head;
        for (Integer integer : list) {
            temp.val = integer;
            temp = temp.next;
        }
        return head;
    }

    // MergeSort based Solution for Sorting Linked List

    public ListNode sortListEfficient(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast, slow;
        fast = head;
        slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        prev.next = null;

        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);

        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode temp = new ListNode(-1);
        ListNode counter = temp;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
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
