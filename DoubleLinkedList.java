// double linked list
public class DoubleLinkedList {

    // fields
    private Object data;
    private DoubleLinkedList next;
    private DoubleLinkedList prev;

    // constructor
    DoubleLinkedList(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    DoubleLinkedList(){
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    // methods
    public static DoubleLinkedList findHead(DoubleLinkedList node){
        if(node == null) return null;
        DoubleLinkedList p = node;
        while(p.prev != null){
            p = p.prev;
        }
        return p;
    }

    public static DoubleLinkedList findTail(DoubleLinkedList node){
        if(node == null) return null;
        DoubleLinkedList p = node;
        while(p.next != null){
            p = p.next;
        }
        return p;
    }

    public static int getCount(DoubleLinkedList node){
        if(node == null) return 0;
        DoubleLinkedList p = DoubleLinkedList.findHead(node);
        int count = 0;
        while(p != null){
            count++;
            p = p.next;
        }
        return count;
    }

    public static boolean contains(DoubleLinkedList node, Object data){
        if(node == null) return false;
        DoubleLinkedList p = DoubleLinkedList.findHead(node);
        while(p != null){
            if(p.data.equals(data)) return true;
            p = p.next;
        }
        return false;
    }

    public static DoubleLinkedList findFirst(DoubleLinkedList node, Object data){
        if(node == null) return null;
        DoubleLinkedList p = DoubleLinkedList.findHead(node);
        while(p != null){
            if(p.data.equals(data)) return p;
            p = p.next;
        }
        return null;
    }

    public static DoubleLinkedList findLast(DoubleLinkedList node, Object data){
        if(node == null) return null;
        DoubleLinkedList p = DoubleLinkedList.findTail(node);
        while(p != null){
            if(p.data.equals(data)) return p;
            p = p.prev;
        }
        return null;
    }

    public static int findFirstIndex(DoubleLinkedList node, Object data){
        if(node == null) return -1;
        DoubleLinkedList p = DoubleLinkedList.findHead(node);
        int index = 0;
        while(p != null){
            if(p.data.equals(data)) return index;
            p = p.next;
            index++;
        }
        return -1;
    }

    public static int findLastIndex(DoubleLinkedList node, Object data){
        if(node == null) return -1;
        DoubleLinkedList p = DoubleLinkedList.findTail(node);
        int count = DoubleLinkedList.getCount(node);
        int index = count - 1;
        while(p != null && index >= 0){
            if(p.data.equals(data)) return index;
            p = p.prev;
            index--;
        }
        return -1;
    }

    public static int getIndex(DoubleLinkedList node){
        if(node == null) return -1;
        DoubleLinkedList p = DoubleLinkedList.findHead(node);
        int index = 0;
        while(p != null){
            if(p == node) return index;
            p = p.next;
            index++;
        }
        return -1;
    }

    public static DoubleLinkedList atIndex(DoubleLinkedList node, int index){
        if(node == null) return null;
        DoubleLinkedList p = DoubleLinkedList.findHead(node);
        if(index <= 0) return p;
        while(p != null && index > 0){
            p = p.next;
            index--;
        }
        return p;
    }

    public static DoubleLinkedList addLast(DoubleLinkedList node, Object data){
        if(node == null) return new DoubleLinkedList(data);
        DoubleLinkedList p = DoubleLinkedList.findTail(node);
        DoubleLinkedList newNode = new DoubleLinkedList(data);
        newNode.prev = p;
        p.next = newNode;
        return DoubleLinkedList.findHead(node);
    }

    public static DoubleLinkedList addFirst(DoubleLinkedList node, Object data){
        if(node == null) return new DoubleLinkedList(data);
        DoubleLinkedList p = DoubleLinkedList.findHead(node);
        DoubleLinkedList newNode = new DoubleLinkedList(data);
        newNode.next = p;
        p.prev = newNode;
        return newNode;
    }

    public static DoubleLinkedList insertAfter(DoubleLinkedList node, Object data){
        if(node == null) return new DoubleLinkedList(data);
        DoubleLinkedList newNode = new DoubleLinkedList(data);
        DoubleLinkedList next = node.next;
        node.next = newNode;
        newNode.prev = node;
        if(next == null) return DoubleLinkedList.findHead(node);
        newNode.next = next;
        next.prev = newNode;
        return DoubleLinkedList.findHead(node);
    }

    public static DoubleLinkedList insertBefore(DoubleLinkedList node, Object data){
        if(node == null) return new DoubleLinkedList(data);
        DoubleLinkedList prev = node.prev;
        DoubleLinkedList newNode = new DoubleLinkedList(data);
        node.prev = newNode;
        newNode.next = node;
        if(prev == null) return newNode;
        prev.next = newNode;
        newNode.prev = prev;
        return DoubleLinkedList.findHead(prev);
    }

    public static void print(DoubleLinkedList node){
        if(node == null){
            System.out.println("null");
            return;
        }
        DoubleLinkedList p = DoubleLinkedList.findHead(node);
        while(p != null) {
            System.out.print(p.data + " <-> ");
            p = p.next;
        }
        System.out.println("null");
    }

    public static int countData(DoubleLinkedList node, Object data){
        if(node == null) return 0;
        DoubleLinkedList p = DoubleLinkedList.findHead(node);
        int count = 0;
        while(p != null){
            if(p.data.equals(data)) count++;
            p = p.next;
        }
        return count;
    }

    // todo
    // add remove methods later

    // getters
    public Object getData(){
        return this.data;
    }

    public DoubleLinkedList getNext(){
        return this.next;
    }

    public DoubleLinkedList getPrev(){
        return this.prev;
    }

    // setters
    public void setData(Object data){
        this.data = data;
    }

    public void setNext(DoubleLinkedList next){
        this.next = next;
    }

    public void setPrev(DoubleLinkedList prev){
        this.prev = prev;
    }

}
