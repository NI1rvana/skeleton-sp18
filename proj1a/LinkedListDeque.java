import java.awt.*;

public class LinkedListDeque<Node> {
    private class Intnode {
        public Node item;
        public Intnode next;
        public Intnode prev;
        public Intnode(Node x) {
            item = x;
            next = null;
            prev = null;
        }
    }
    public Intnode head,tail;
    public int size;
    public LinkedListDeque() {
        this.head = new Intnode(null);
        this.tail = new Intnode(null);
        this.size = 0;
    }

    public void addFirst(Node x) {
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
    public void addLast(Node x) {
        if(this.isEmpty()) {
            this.addFirst(x);
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

    public Node removeFirst() {
        Node p = head.next.item;
        this.head = head.next;
        this.head.prev = null;
        this.size -= 1;
        return p;
    }
    public Node removeLast() {
        Node p = tail.prev.item;
        this.tail = tail.prev;
        this.tail.next = null;
        this.size -= 1;
        return p;
    }
    public Node get(int x) {
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
        if (head == tail) {
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
