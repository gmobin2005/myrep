// Circular Double Linked List

import java.util.ArrayList;
import java.util.Objects;

public class CircularDoubleLinkedList {

    private Object data;
    private CircularDoubleLinkedList next;
    private CircularDoubleLinkedList prev;

    // constructor
    CircularDoubleLinkedList(Object data) {
        this.data = data;
        this.next = this;
        this.prev = this;
    }

    CircularDoubleLinkedList(){
        this.data = null;
        this.next = this;
        this.prev = this;
    }

    // methods
    public static CircularDoubleLinkedList insertAfter(CircularDoubleLinkedList node, Object data) {
        if (node == null) return new CircularDoubleLinkedList(data);
        if (!CircularDoubleLinkedList.validate(node)) return null;
        CircularDoubleLinkedList newNode = new CircularDoubleLinkedList(data);
        CircularDoubleLinkedList next = node.next;

        node.next = newNode;
        newNode.prev = node;

        newNode.next = next;
        next.prev = newNode;

        return newNode;
    }

    public static CircularDoubleLinkedList insertBefore(CircularDoubleLinkedList node, Object data) {
        if (node == null) return new CircularDoubleLinkedList(data);
        if (!CircularDoubleLinkedList.validate(node)) return null;
        CircularDoubleLinkedList newNode = new CircularDoubleLinkedList(data);
        CircularDoubleLinkedList prev = node.prev;

        node.prev = newNode;
        newNode.next = node;

        prev.next = newNode;
        newNode.prev = prev;
        return newNode;
    }

    public static int getCount(CircularDoubleLinkedList node) {
        if (node == null) return 0;
        if (!CircularDoubleLinkedList.validate(node)) return 0;
        int count = 1;
        CircularDoubleLinkedList p = node;
        while(p.next != node){
            p = p.next;
            count++;
        }
        return count;
    }

    public static CircularDoubleLinkedList findForward(CircularDoubleLinkedList node, Object data) {
        if (node == null) return null;
        if(!CircularDoubleLinkedList.validate(node)) return null;
        if(Objects.equals(node.data, data)) return node;
        CircularDoubleLinkedList p = node.next;
        while(p != node){
            if(Objects.equals(p.data, data)) return p;
            p = p.next;
        }
        return null;
    }

    public static CircularDoubleLinkedList findBackward(CircularDoubleLinkedList node, Object data) {
        if (node == null) return null;
        if (!CircularDoubleLinkedList.validate(node)) return null;
        if(Objects.equals(node.data, data)) return node;
        CircularDoubleLinkedList p = node.prev;
        while(p != node){
            if(Objects.equals(p.data, data)) return p;
            p = p.prev;
        }
        return null;
    }

    public static boolean contains(CircularDoubleLinkedList node, Object data) {
        if (node == null) return false;
        if (!CircularDoubleLinkedList.validate(node)) return false;
        if (Objects.equals(node.data, data)) return true;
        CircularDoubleLinkedList p = node.next;
        while(p != node){
            if(Objects.equals(p.data, data)) return true;
            p = p.next;
        }
        return false;
    }

    public static ArrayList<Object> toArrayList(CircularDoubleLinkedList node) {
        if(node == null) return new ArrayList<Object>();
        if(!CircularDoubleLinkedList.validate(node)) return new ArrayList<Object>();
        ArrayList<Object> list = new ArrayList<Object>();
        CircularDoubleLinkedList p = node;
        list.add(p.data);
        while(p.next != node){
            p = p.next;
            list.add(p.data);
        }
        return list;
    }

    public static boolean validate(CircularDoubleLinkedList node) {
        if (node == null) return false;
        if (node.next == null || node.prev == null) return false;
        if (node.next == node) return node.prev == node;
        if (node.prev == node) return node.next == node;
        CircularDoubleLinkedList p = node;
        while(p.next != node){
            if(p.next == null) return false;
            if(p.next.prev != p) return false;
            p = p.next;
        }
        return node.prev == p;
    }

    public static boolean isAlone(CircularDoubleLinkedList node) {
        if (node == null) return false;
        if (node.next == null || node.prev == null) return false;
        return (node.next == node && node.prev == node);
    }

    public static void printForward(CircularDoubleLinkedList node) {
        if (node == null){
            System.out.println("null");
            return;
        }
        if(!CircularDoubleLinkedList.validate(node)){
            System.out.println("Not a valid circular double linked list!");
            return;
        }
        if(CircularDoubleLinkedList.isAlone(node)){
            System.out.print(node.data);
            return;
        }
        CircularDoubleLinkedList p = node;
        while(p.next != node){
            System.out.print(p.data + " <-> ");
            p = p.next;
        }
        System.out.print(p.data);
    }

    // getters
    public Object getData() {
        return this.data;
    }

    public CircularDoubleLinkedList getNext() {
        return this.next;
    }

    public CircularDoubleLinkedList getPrev() {
        return this.prev;
    }

    // setters
    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(CircularDoubleLinkedList next) {
        this.next = next;
    }

    public void setPrev(CircularDoubleLinkedList prev) {
        this.prev = prev;
    }

}