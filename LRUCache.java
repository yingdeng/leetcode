// Build double linked list
    class Node {
        Node pre, next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

public class LRUCache {
    public HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    public Node head;
    public Node tail;
    public int capacity;
    public int len;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        len = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node newest = map.get(key);
            removeNode(newest);
            setHead(newest);
            return newest.value;
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        // If the node is exist, remove the head and set it as head
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            oldNode.value = value;
            removeNode(oldNode);
            setHead(oldNode);
        }
        else {
            Node newNode = new Node(key, value);
            if (len < capacity) {
                setHead(newNode);
                map.put(key, newNode);
                len++;
            }
            else {
                map.remove(tail.key);
                tail = tail.pre;
                if (tail != null) {
                    tail.next = null;
                }
                setHead(newNode);
                map.put(key, newNode);
            }
        }
    }

    // Delete Head node from doubly linked list
    public void removeNode(Node node) {
        Node cur = node;
        Node pre = cur.pre;
        Node next = cur.next;
        
        if (pre != null) {
            pre.next = next;
        }
        else {
            head = next;
        }
        
        if (next != null) {
            next.pre = pre;
        }
        else {
            tail = pre;
        }
    }
    
    // Set the node as head in the doubly linked list
    public void setHead(Node node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }
        head = node; // be caution here, not node = head; is head = node
        if (tail == null) {
            tail = node;
        }
    }
}