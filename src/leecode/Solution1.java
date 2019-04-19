package leecode;


public class Solution1 {

    /**
     *      给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     *      如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     *      您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     *      示例：
     *
     *      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     *      输出：7 -> 0 -> 8
     *      原因：342 + 465 = 807
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode l1head = l1;
        ListNode l2head = l2;


        int modNum = (l1head.val + l2head.val) % 10;
        int addNum = (l1head.val + l2head.val) / 10;


        if (l1head.next != null) {
            l1head.next.val += addNum;
        } else if (l2head.next != null) {
            l2head.next.val += addNum;
        } else if (l1head.next == null && l2head.next == null && addNum != 0) {
            l1head.next = new ListNode(addNum);

        }

        ListNode listNode = new ListNode(modNum);
        ListNode headNode = listNode;


        ListNode ll1 = l1head.next;
        ListNode ll2 = l2head.next;

        while (ll1 != null && ll2 != null) {

            int modNum_c = (ll1.val + ll2.val) % 10;
            int addNum_c = (ll1.val + ll2.val) / 10;
            if (ll1.next != null) {
                ll1.next.val += addNum_c;

            } else if (ll2.next != null) {
                ll2.next.val += addNum_c;

            } else if (ll1.next == null && ll2.next == null && addNum_c > 0) {

                ListNode tempNode = new ListNode(addNum_c);
                ll1.next = tempNode;
            }

            ll1 = ll1.next;
            ll2 = ll2.next;

            ListNode tempNode = new ListNode(modNum_c);
            listNode.next = tempNode;
            listNode = tempNode;


        }

        if (ll1 == null && ll2 != null) {

            while (ll2 != null) {
                int modNum_c = ll2.val % 10;
                int addNum_c = ll2.val / 10;
                if (ll2.next != null) {
                    ll2.next.val += addNum_c;

                } else if (addNum_c != 0) {
                    ll2.next = new ListNode(addNum_c);
                }
                ll2.val = modNum_c;


                listNode.next = ll2;
                listNode = ll2;
                ll2 = ll2.next;
            }

        }

        if (ll2 == null && ll1 != null) {

            while (ll1 != null) {

                int modNum_c = ll1.val % 10;
                int addNum_c = ll1.val / 10;
                if (ll1.next != null) {
                    ll1.next.val += addNum_c;

                } else if (addNum_c != 0) {
                    ll1.next = new ListNode(addNum_c);
                }
                ll1.val = modNum_c;

                listNode.next = ll1;
                listNode = ll1;
                ll1 = ll1.next;
            }

        }

        return headNode;

    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode a = new ListNode(8);
        ListNode b = new ListNode(9);
        l1.next = a;
        a.next = b;


        ListNode l2 = new ListNode(5);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(9);
        l2.next = c;
        c.next = d;


        ListNode headNode = addTwoNumbers(l1, l2);

        while (headNode != null) {
            System.out.println(headNode.val);
            headNode = headNode.next;
        }


    }
}