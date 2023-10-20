package Practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    //Todo: Add a more efficient approach, for the below solution.
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null){
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
}
