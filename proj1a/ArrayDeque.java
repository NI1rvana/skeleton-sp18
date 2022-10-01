/** Array based list.
 *  @author Josh Hug
 */

public class ArrayDeque {
    /** Creates an empty list. */
    int[] item;
    int itSize = 0;
    public ArrayDeque() {
         item = new int[100];
    }
    public void resizing(int cap) {
        int[] a = new int[cap];
        System.arraycopy(item,0,a,0,itSize);
        item = a;
    }
    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if(itSize == item.length)
            this.resizing(itSize * 2);
        item[itSize] = x;
        this.itSize += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return item[itSize-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return item[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return this.itSize;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int returnNum = item[itSize-1];
        itSize -= 1;
        item[itSize] = 0;
        if(itSize * 4 < item.length)
            resizing(item.length/2);
        return returnNum;
    }
} 