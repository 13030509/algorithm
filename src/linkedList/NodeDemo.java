package linkedList;

/**
 * 链表的反转
 * 链表中环的检测
 * 两个有序的链表合并
 * 删除链表倒数第 n 个结点
 * 求链表的中间结点
 */
public class NodeDemo {


    //求链表的中间结点
    public static Node getMidNode(Node node){

        if(node == null || node.next == null){
            return node;
        }

        Node slow = node;
        Node fast = node;

        while (fast.next !=null && fast.next.next != null){

            slow = slow.next;
            fast = fast.next.next;

        }
        return new Node(slow.val);

    }




    //删除链表倒数第 n 个结点

    public static Node deleteNodeByIndex(Node node,int n){



        if(node == null){
            return null;
        }

        int length = 0;

        Node head = node;

        while (node != null){
            length++;
            node = node.next;
        }

        int start = 0;
        int index = length-n;

        if(index<0){
            return null;
        }

        Node resNodeHead = new Node(0);
        Node cur = resNodeHead;
        resNodeHead.next = head;




        while ( resNodeHead.next != null ){

            if (index == start){
                resNodeHead.next = resNodeHead.next.next;

                return cur.next;

            }else {
                resNodeHead = resNodeHead.next;
                start ++;
            }
        }

        return null;
    }


    //两个有序的链表合并
    public static Node mergeSortedListNode(Node l1, Node l2) {

        Node head = new Node(0);
        Node cur = head;

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        while (l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;

        }

        if(l1 != null ){

            while (l1 != null){
                head.next = l1;
                l1 = l1.next;
            }

        }

        if(l2 != null ){

            while (l2 != null){
                head.next = l2;
                l2 = l2.next;
            }

        }


        return cur.next;
    }

    //链表中环的检测
    public static boolean hasRoundInNode(Node node) {

        if (node == null || node.next == null) {
            return false;
        }

        //快慢指针的方式检测

        Node slowNode = node;
        Node fastNode = node.next;
        while (slowNode != null && fastNode.next != null) {

            if (slowNode == fastNode) {
                return true;
            } else {
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
            }

        }

        return false;

    }


    //链表的反转
    public static Node reverseList(Node node) {

        if (node == null) {
            return node;
        }
        Node head = new Node(0);

        while (node != null) {

            Node cur = new Node(node.val);
            //将当前节点放入新链表头
            cur.next = head.next;
            head.next = cur;

            node = node.next;
        }

        return head.next;

    }

    //链表打印
    public static void printNodeList(Node node) {

        Node cur = node;

        while (cur != null) {

            System.out.print(cur.val + "  ");

            cur = cur.next;

        }
        System.out.println();

    }

    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(6);
        Node n3 = new Node(9);
        Node n4 = new Node(12);
        Node n5 = new Node(13);
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;


        Node n1_c = new Node(2);
        Node n2_c = new Node(4);
        Node n3_c = new Node(5);
        Node n4_c = new Node(8);
        Node n5_c = new Node(13);

        n5_c.next = null;
        n4_c.next = n5_c;
        n3_c.next = n4_c;
        n2_c.next = n3_c;
        n1_c.next = n2_c;

        printNodeList(getMidNode(n1));

        //printNodeList(mergeSortedListNode(n1,n1_c));

        // printNodeList(n1);
        //printNodeList(reverseList(n1));


        //System.out.println(hasRoundInNode(n1));


    }
}
