public interface PriorityQueue<E extends Comparable<E>> {
    void add(E item);
    E remove();
    E getFirst();
    boolean isEmpty();
    int size();
    void clear();
}
