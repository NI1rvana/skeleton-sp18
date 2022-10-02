/** Array based list.
 *  @author Josh Hug
 */

public class ArrayDeque<T> {
    /** Creates an empty list. */
    private T[] item;
    private int length,size,head,tail;

    public ArrayDeque() {
        T[] q = (T[]) new Object[8];
        this.item = q;
        length = 8;
        head = tail = 4;
        size = 0;
    }
    public boolean isEmpty() {
        if(size == 0)
            return true;
        else return false;
    }

    private void resize() {
        int p = head;
        int n = item.length;
        int r = n - p; // number of elements to the right of p
        int newCapacity = n << 1;
        T[] a = (T[]) new Object[newCapacity];
        System.arraycopy(item, p, a, 0, r);
        System.arraycopy(item, 0, a, r, p);
        this.item = a;
        length = newCapacity;
        head = 0;
        tail = n;
    }
        /** Inserts X into the back of the list. */

    public void addFirst(T e) {
        item[head = (head - 1) & (item.length - 1)] = e;
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
        if(size == length - 1)
            resize();
        size += 1;
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
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
            if(i == length) {
                i = 0;
            }
            System.out.println(item[i] + " ");

        }
    }



}
