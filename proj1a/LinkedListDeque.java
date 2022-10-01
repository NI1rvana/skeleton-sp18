import java.awt.*;

public class LinkedListDeque<T> {
    private class Intnode {
        private T item;
        private Intnode next;
        private Intnode prev;
        public Intnode(T x) {
            item = x;
            next = null;
            prev = null;
        }
    }
    private Intnode head,tail;
    private int size;
    public LinkedListDeque() {
        this.head = new Intnode(null);
        this.tail = new Intnode(null);
        this.size = 0;
    }

    public void addFirst(T x) {
        if(this.isEmpty()) {
            Intnode p = new Intnode(x);
            head.next = p;
            tail.prev = p;
        }
        else {
            Intnode p = new Intnode(null);
            head.item = x;
            head.prev = p;
            p.next = head;
            head = p;
        }
        this.size += 1;
    }
    public void addLast(T x) {
        if(this.isEmpty()) {
            this.addFirst(x);
            return;
        }
        else {
            Intnode p = new Intnode(null);
            tail.item = x;
            tail.next = p;
            p.prev = tail;
            tail = p;
        }
        this.size += 1;
    }

    public T removeFirst() {
        T p = head.next.item;
        this.head = head.next;
        this.head.prev = null;
        this.size -= 1;
        return p;
    }
    public T removeLast() {
        T p = tail.prev.item;
        this.tail = tail.prev;
        this.tail.next = null;
        this.size -= 1;
        return p;
    }
    private T getRecursiveHelp(Intnode start, int index) {
        if (index == 0) {
            return head.item;
        } else {
            return getRecursiveHelp(head.next, index - 1);
        }
    }
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(head.next, index);
    }
    public T get(int x) {
        Intnode p = head;
        while (x > 0) {
            p = p.next;
            x -= 1;
        }
        return p.item;
    }
    public void printDeque() {
        Intnode p = this.head.next;
        while(p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public int size() {
        return this.size;
    }

}
