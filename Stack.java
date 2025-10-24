
public class Stack {
    // fixed size stack
    private final int size;
    private final Object[] stack;
    private int count;

    // constructor
    Stack(int size){
        if(size <= 0) this.size = 0;
        else this.size = size;
        this.stack = new Object[this.size];
        this.count = 0;
    }

    Stack(){
        this.size = 1024;
        this.stack = new Object[this.size];
        this.count = 0;
    }

    // methods
    public boolean push(Object obj){
        if(count == this.size) return false;
        this.stack[count++] = obj;
        return true;
    }

    public Object pop(){
        if(count == 0) return null;
        Object item = this.stack[--count];
        this.stack[count] = null;
        return item;
    }

    public Object getTop(){
        if(count == 0) return null;
        return this.stack[count - 1];
    }

    public Object getBottom(){
        if(count == 0) return null;
        return this.stack[0];
    }

    public boolean contains(Object obj){
        if(count == 0 || obj == null) return false;
        for (int i = 0;i < count;i++){
            if(this.stack[i].equals(obj)) return true;
        }
        return false;
    }

    public int search(Object obj){
        if(count == 0 || obj == null) return -1;
        for (int i = 0;i < count;i++){
            if(this.stack[i].equals(obj)) return i;
        }
        return -1;
    }

    public void reverse(){
        if(count == 0) return;
        for (int i = 0,j = count -1;i < j;i++,j--){
            Object temp = this.stack[i];
            this.stack[i] = this.stack[j];
            this.stack[j] = temp;
        }
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == this.size;
    }

    public void print(){
        for (int i = 0;i < count;i++){
            System.out.print(this.stack[i] + " ");
        }
    }

    public void clear(){
        for (int i = 0;i < count;i++)
            this.stack[i] = null;
        this.count = 0;
    }

    // getters
    public int getSize(){
        return this.size;
    }

    public int getCount(){
        return count;
    }

}
