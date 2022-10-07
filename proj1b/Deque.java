public interface Deque<T> {

    public void addFirst(T x);
    public void addLast(T x);
    public T removeFirst();
    public T removeLast();
    public T getRecursive(int x);
    public T get(int x);
    public void printDeque();
    public boolean isEmpty();
    public int size();

}
