QUESTION: https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1

public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        Node temp1 = head1;
        Node temp2 = head2;
        Node list = new Node(-1);
        Node temp3 = list;
        while(temp1 != null && temp2 != null){
            if(temp1.data == temp2.data){
                temp3.next = new Node(temp1.data);
                temp3 = temp3.next;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else if(temp1.data < temp2.data){
                temp1 = temp1.next;
            }
            else if(temp1.data > temp2.data){
                temp2 = temp2.next;
            }
        }
        return list.next;
    }
