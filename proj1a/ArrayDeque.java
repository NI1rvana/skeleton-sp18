/** Array based list.
 *  @author Josh Hug
 */

public class ArrayDeque<T> {
    /** Creates an empty list. */
    T[] item;
    int itSize = 0;
    public ArrayDeque() {
        T[] item = (T[]) new Object[100];
    }
    public void resizing(int cap) {
        T[] a = (T[]) new Object[cap];
        System.arraycopy(item,0,a,0,itSize);
        item = a;
    }
    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if(itSize == item.length)
            this.resizing(itSize * 2);
        item[itSize] = x;
        this.itSize += 1;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return item[itSize-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return item[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return this.itSize;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T returnNum = item[itSize-1];
        itSize -= 1;
        item[itSize] = null;
        if(itSize * 4 < item.length)
            resizing(item.length/2);
        return returnNum;
    }
}
