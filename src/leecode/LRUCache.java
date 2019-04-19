package leecode;


/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 /* 缓存容量
 */

/**
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
public class LRUCache {

    class ListNode {
        int val;
        int key;
        ListNode next;

        ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    private int capacity;
    private int modCount;


    //哨兵 简化代码
    private ListNode sentry = new ListNode(0, 0);


    public LRUCache(int capacity) {

        this.capacity = capacity;

    }

    public int get(int key) {

        if (modCount == 0) {
            return -1;
        }

        int index = 0;
        ListNode headNode = sentry;
        while (headNode.next != null && index < capacity) {

            index++;
            if (headNode.next.key == key) {

                int val = headNode.next.val;

                //删除当前节点
                ListNode temp = new ListNode(headNode.next.key, headNode.next.val);
                headNode.next = headNode.next.next;
                //将节点插入链表头
                temp.next = sentry.next;
                sentry.next = temp;

                return val;


            } else {
                headNode = headNode.next;
            }
        }

        return -1;


    }

    public void put(int key, int value) {

        modCount++;
        ListNode newNode = new ListNode(key, value);

        ListNode headNode = sentry;
        int index = 0 ;
        while (headNode.next!= null && index < capacity ){
            index++;
            if(headNode.next.key == key){
                headNode.next.val = value;

                //删除当前节点
                ListNode temp = new ListNode(headNode.next.key, headNode.next.val);
                headNode.next = headNode.next.next;

                //将节点插入链表头
                temp.next = sentry.next;
                sentry.next = temp;
                return;
            }else{
                headNode = headNode.next;
            }
        }

        newNode.next = sentry.next;
        sentry.next = newNode;

    }

}
