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
    private Intnode head, tail;
    private int size;
    public LinkedListDeque() {
        this.head = new Intnode(null);
        this.tail = new Intnode(null);
        this.size = 0;
    }

    public void addFirst(T x) {
        if (this.isEmpty()) {
            Intnode p = new Intnode(x);
            p.next = tail;
            p.prev = head;
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
        if (this.isEmpty()) {
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
        if (this.isEmpty()) {
            return null;
        }
        T p = head.next.item;
        this.head = head.next;
        this.head.prev = null;
        head.item = null;
        this.size -= 1;
        return p;
    }
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T p = tail.prev.item;
        this.tail = tail.prev;
        this.tail.next = null;
        tail.item = null;
        this.size -= 1;
        return p;
    }
    private T getRecursiveHelp(Intnode start, int x) {
        if (x == 0) {
            return start.item;
        } else {
            return getRecursiveHelp(start.next, x - 1);
        }
    }
    public T getRecursive(int x) {
        if (x > size) {
            return null;
        }
        return getRecursiveHelp(head.next, x);
    }
    public T get(int x) {
        Intnode p = head.next;
        while (x > 0) {
            p = p.next;
            x -= 1;
        }
        return p.item;
    }
    public void printDeque() {
        Intnode p = this.head.next;
        while (p != tail) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
            return false;
    }
    public int size() {
        return this.size;
    }

//    public static void main(String[] args) {
//        LinkedListDeque L = new LinkedListDeque();
//        L.addLast(1);
//        L.addLast(2);
//        L.removeFirst();
//        System.out.println(L.getRecursive(0));
//    }
}
