/** Array based list.
 *  @author Josh Hug
 */

public class ArrayDeque<T> {
    /** Creates an empty list. */
    private T[] item;
    private int length,size,head,tail;

    public ArrayDeque() {
        T[] item = (T[]) new Object[8];
        length = 8;
        head = tail = 4;
        size = 0;
    }
    public boolean isEmpty() {
        if(head == tail)
            return true;
        else return false;
    }

    public void resize() {
        T[] a = (T[]) new Object[2*length];
        if(head >= tail)
            System.arraycopy(item,head,a,0,tail - head);
        else {
            System.arraycopy(item,head,a,0,tail - 1 - head);
            System.arraycopy(item,tail,a,tail - head,head - tail);
        }
        item = a;
    }
    /** Inserts X into the back of the list. */
    public void addFirst(T x) {
        item[head] = x;
        head = (head - 1) & (length - 1);
        if(head == tail)
            resize();
    }
    public void addLast(T x) {
        item[tail] = x;
        tail = (tail + 1) & (length - 1);
        if(head == tail)
            resize();
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
        T x = item[head];
        head = (head + 1) & (length - 1);
        return x;
    }
    public T removeLast() {
        T x = item[tail];
        tail = (tail - 1) & (length - 1);
        return x;
    }

    public void printDeque() {
        int p = head;
        for (int i = head; ; i++) {
            if(i == length + 1) {
                i = 0;
            }
            System.out.print(item[i]);
            if(i == tail) {
                break;
            }
        }
    }
}
