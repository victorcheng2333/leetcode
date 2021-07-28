package LinkedList;

public class SecondNode {
    public static void main(String[] args) {
        var list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        printList(list);
        var result = new SecondNode().interChange(list);
        System.out.println("");
        printList(result);

        System.out.println("");
        ListNode list2 = null;
        printList(new SecondNode().interChange(list2));
        System.out.println("");

        var list3 = new ListNode(1);
        printList(new SecondNode().interChange(list3));
    }

    static void printList(ListNode root) {
        while(root != null) {
            System.out.print(root.val + "->");
            root = root.next;
        }

    }

    ListNode interChange(ListNode root) {
        if (root == null || root.next == null) return root;
        var dummy = new ListNode(-1);
        dummy.next = root;
        var cur = dummy;
        while(cur != null && cur.next != null && cur.next.next != null ) {
            var first = cur.next;
            var second = cur.next.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = first;
        }
        return dummy.next;
    }
}