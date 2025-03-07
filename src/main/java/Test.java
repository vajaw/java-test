public class Test {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node = soluation(node1, 2);

        ListNode curr = node;
        while (curr.next != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

    public static ListNode soluation(ListNode head, int n) {

        if (head == null) {
            return head;
        }


        ListNode left = head;
        ListNode right = head;
        // ListNode curr = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = right;
        return head;
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}


