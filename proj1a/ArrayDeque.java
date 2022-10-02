/** Array based list.
 *  @author Josh Hug
 */

public class ArrayDeque<T> {
    /** Creates an empty list. */
    private T[] item;
    private int length,size,head,tail;

    public ArrayDeque() {
        item = (T[]) new Object[8];
        length = 8;
        head = 3;
        tail = 4;
        size = 0;
    }
    public boolean isEmpty() {
        if(size == 0)
            return true;
        else return false;
    }

    private void resize() {
        int p = (head + 1) & (length - 1);
        int r = length - p; // number of elements to the right of p
        int newCapacity = length << 1;
        T[] a = (T[]) new Object[newCapacity];
        System.arraycopy(item, p, a, 0, r);
        System.arraycopy(item, 0, a, r, p);
        this.item = a;
        length = newCapacity;
        head = (0 - 1) & (length - 1);
        tail = (size + 1) & (length - 1);
    }
        /** Inserts X into the back of the list. */

    public void addFirst(T e) {
        item[head] = e;
        head = (head - 1) & (length - 1);
        size += 1;
        if (head == tail)
            resize();
    }
//    public void addFirst(T x) {
//        item[head] = x;
//        head = (head - 1) & (length - 1);
//        if(size == length - 1)
//            resize();
//        size += 1;
//    }
    public void addLast(T x) {
        item[tail] = x;
        tail = (tail + 1) & (length - 1);
        size += 1;
        if(head == tail)
            resize();
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int x) {
        if(x > size)
            return  null;
        int p = (head + 1) % length;
        int i = p;
        while (x > 0) {
            i += 1;
            x -= 1;
            if(i == length) {
                i = 0;
            }
        }
        return item[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return this.size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeFirst() {
        head = (head + 1) & (length - 1);
        T x = item[head];
        size -= 1;
        return x;
    }
    public T removeLast() {
        tail = (tail - 1) & (length - 1);
        T x = item[tail];
        size -= 1;
        return x;
    }

    public void printDeque() {
        int p = (head + 1) % length;

        for (int i = p;i != (tail - 1) ; i++) {
            i %= length;
            System.out.print(item[i] + " ");
        }
    }
    public static void main(String[] args) {
        ArrayDeque L = new ArrayDeque();
        for (int i = 0; i < 100; i++) {
            L.addFirst(i);
        }

        System.out.println(L.removeFirst());
        L.printDeque();
    //    System.out.println(L.get(1));
    }
}
