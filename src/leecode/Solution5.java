package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution5 {

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode tempNode = new ListNode(1);
        ListNode headNode = tempNode;

        List<ListNode> headlist = new ArrayList<ListNode>();

        for (int i = 0; i < lists.length; i++) {

            if (null != lists[i]) {
                headlist.add(lists[i]);
            }

        }
        int length = headlist.size();

        while (length > 0) {

            int leastIndex = 0;
            ListNode minNode = null;
            for (int i = 0; i < headlist.size(); i++) {
                if(headlist.get(i)!=null){
                     minNode = headlist.get(i);
                    break;
                }

            }
            if(minNode==null){
               return headNode.next;
            }


            for (int i = 0; i < headlist.size(); i++) {

                if (headlist.get(i) != null && minNode.val > headlist.get(i).val) {

                    minNode = new ListNode(headlist.get(i).val);
                    leastIndex = i;

                }
            }

            tempNode.next = minNode;
            tempNode = tempNode.next;

            if (headlist.get(leastIndex) != null && null != headlist.get(leastIndex).next) {
                headlist.set(leastIndex, headlist.get(leastIndex).next);

            } else {
                headlist.remove(leastIndex);
                length--;
            }


        }


        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        l1.next = a;
        a.next = b;


        ListNode l2 = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        l2.next = c;
        c.next = d;

        ListNode l3 = new ListNode(2);
        ListNode e = new ListNode(6);
        l2.next = e;

        ListNode[] listNode =new ListNode[]{l1,l2,l3};


        ListNode headNode = mergeKLists(listNode);

        while (headNode != null) {
            System.out.println(headNode.val);
            headNode = headNode.next;
        }
    

    }


}
