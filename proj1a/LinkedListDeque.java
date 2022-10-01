import java.awt.*;

public class LinkedListDeque<Node> {
    private class Intnode {
        public Node item;
        public Intnode next;
        public Intnode(Node x, Intnode n) {
            item = x;
            next = n;
        }
    }
    public Intnode head,tail;
    public int size;
    public LinkedListDeque() {
        this.head = new Intnode(null ,null);
        this.tail = head;
        this.size = 0;
    }

    public void addFirst(Node x) {
        if(this.isEmpty())
        {
            head.next = new Intnode(x,head.next);
            tail = head.next;
        }
        else
            this.head.next = new Intnode(x, head.next);
        this.size += 1;
    }
    public void addLast(Node x) {
        if(this.isEmpty()) {
            head.next = new Intnode(x,head.next);
            tail = head.next;
        }
        else {
            this.tail.next = new Intnode(x, null);
            this.tail = this.tail.next;
        }
        this.size += 1;
    }

    public void removeFirst() {
        this.head = head.next;
        this.size -= 1;
    }
    private Node getRecursiveHelp(Intnode start, int index) {
        if (index == 0) {
            return head.item;
        } else {
            return getRecursiveHelp(head.next, index - 1);
        }
    }
    public Node getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(head.next, index);
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
        if (head == tail) return true;
        else return false;
    }
    public int size() {
        return this.size;
    }
}
