import java.util.Vector;

/**
 * Implementación de una Cola de Prioridad basada en un Min-Heap usando un Vector.
 * El elemento con el valor "menor" siempre estará en la raíz.
 * * @param <E> El tipo de elementos almacenados.
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data;

    public VectorHeap() {
        data = new Vector<E>();
    }

    /**
     * Constructor que inicializa el Heap a partir de un Vector existente.
     * @param v El vector con datos iniciales.
     */
    public VectorHeap(Vector<E> v) {
        int i;
        data = new Vector<E>(v.size());
        for (i = 0; i < v.size(); i++) {
            add(v.get(i));
        }
    }

    /**
     * Calcula el índice del padre de un nodo.
     * @param i Índice del nodo hijo.
     * @return Índice del padre.
     */
    protected static int parent(int i) {
        return (i-1) / 2;
    }

    /**
     * Calcula el índice del hijo izquierdo de un nodo.
     * @param i Índice del nodo padre.
     * @return Índice del hijo izquierdo.
     */
    protected static int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Calcula el índice del hijo derecho de un nodo.
     * @param i Índice del nodo padre.
     * @return Índice del hijo derecho.
     */
    protected static int right(int i) {
        return (2 * i + 1) + 1;
    }

    /**
     * Mueve un nodo recién insertado hacia arriba en el árbol hasta que
     * se restaure la propiedad del Min-Heap.
     * @param leaf El índice del nodo a mover.
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     * Agrega un nuevo elemento a la cola de prioridad.
     * @param value El elemento a insertar.
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1); 
    }

    /**
     * Mueve un nodo hacia abajo en el árbol, intercambiándolo con su hijo menor,
     * hasta que se restaure la propiedad del Min-Heap.
     * @param root El índice del nodo a mover.
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Retira y devuelve el elemento con la mayor prioridad.
     * @return El elemento con mayor prioridad, o null si está vacía.
     */
    @Override
    public E remove() {
        if (isEmpty()) return null;
        
        E minVal = getFirst(); 
        data.set(0, data.get(data.size() - 1)); 
        data.setSize(data.size() - 1); 
        if (data.size() > 1) {
            pushDownRoot(0); 
        }
        return minVal;
    }

    /**
     * Devuelve el elemento con la mayor prioridad sin retirarlo.
     * @return El elemento en la raíz.
     */
    @Override
    public E getFirst() {
        if (isEmpty()) return null;
        return data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.size() == 0;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }
}

