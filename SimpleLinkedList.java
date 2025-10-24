import java.util.ArrayList;

// simple linked list
public class SimpleLinkedList {
    // fields
    private Object data;
    private SimpleLinkedList next;

    // constructor
    SimpleLinkedList(){
        this.data = null;
        this.next = null;
    }

    SimpleLinkedList(Object data){
        this.data = data;
        this.next = null;
    }

    // methods
    public static int getSize(SimpleLinkedList root){
        if(root == null) return 0;
        SimpleLinkedList p = root;
        int count = 1;
        while(p.next != null){
            p = p.next;
            count++;
        }
        return count;
    }

    public static SimpleLinkedList addLast(SimpleLinkedList root, Object obj){
        if(root == null)
            return new SimpleLinkedList(obj);
        SimpleLinkedList p = root;
        while (p.next != null){
            p = p.next;
        }
        SimpleLinkedList node = new SimpleLinkedList(obj);
        p.next = node;
        return root;
    }

    public static SimpleLinkedList addFirst(SimpleLinkedList root, Object obj){
        if(root == null)
            return new SimpleLinkedList(obj);
        SimpleLinkedList p = root;
        SimpleLinkedList node = new SimpleLinkedList(obj);
        node.next = p;
        return node;
    }

    public static SimpleLinkedList insertAfter(SimpleLinkedList prenode, Object data){
        if(prenode == null){
            SimpleLinkedList node = new SimpleLinkedList(data);
            return node;
        }
        SimpleLinkedList newnode = new SimpleLinkedList(data);
        if(prenode.next == null){
            prenode.next = newnode;
            return prenode;
        }
        SimpleLinkedList nextnode = prenode.next;
        prenode.next = newnode;
        newnode.next = nextnode;
        return prenode;
    }

    public static SimpleLinkedList remove(SimpleLinkedList root, Object data){
        if(root == null)
            return null;
        if(root.data.equals(data)){
            root = null;
            return null;
        }
        SimpleLinkedList p = root;
        while(p.next != null){
            if(p.next.data.equals(data)){
                p.next = p.next.next;
                return root;
            }
            p = p.next;
        }
        return root;
    }

    public static SimpleLinkedList removeAll(SimpleLinkedList root, Object data){
        if(root == null)
            return null;
        if(root.data == data){
            root = null;
            return null;
        }
        SimpleLinkedList p = root;
        while(p.next != null){
            if(p.next.data.equals(data)){
                p.next = p.next.next;
                if(p.next == null)
                    break;
            }
            p = p.next;
        }
        return root;
    }

    public static ArrayList<Object> getList(SimpleLinkedList root){
        if(root == null) return null;
        ArrayList<Object> list = new ArrayList<Object>();
        SimpleLinkedList p = root;
        while(p != null){
            list.add(p.getData());
            p = p.next;
        }
        return list;
    }

    public static int getIndex(SimpleLinkedList root, Object data){
        if(root == null) return -1;
        SimpleLinkedList p = root;
        int index = 0;
        while (p != null){
            if(p.data.equals(data)){
                return index;
            }
            p = p.next;
            index++;
        }
        return -1;
    }

    public static void printList(SimpleLinkedList root){
        if(root == null){
            System.out.println("null");
            return;
        }
        SimpleLinkedList p = root;
        while (p != null){
            System.out.print(p.getData() + "-> ");
            p = p.next;
        }
        System.out.println("null");
    }

    // getters
    public Object getData(){
        return this.data;
    }

    public SimpleLinkedList getNext() {
        return this.next;
    }

    // setters
    public void setData(Object data){
        this.data = data;
    }

    public void setNext(SimpleLinkedList next){
        this.next = next;
    }
}
