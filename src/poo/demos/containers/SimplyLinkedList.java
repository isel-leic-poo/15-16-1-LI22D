package poo.demos.containers;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * TODO
 */
public class SimplyLinkedList<T> extends AbstractList<T> {

    private static class Node<T> {
        public T item;
        public Node<T> next;

        public Node(T item) {
            this(item, null);
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /** The first element in the SimplyLinkedList_this, or {@literal null} if the SimplyLinkedList_this is empty. */
    private Node<T> head;
    /** The last element in the SimplyLinkedList_this, or {@literal null} if the SimplyLinkedList_this is empty. */
    private Node tail;

    /**
     * Adds the given element to the end of the list.
     * @param item The element to be added.
     * @return The index where the item was stored.
     * @throws IllegalArgumentException if the received item is null.
     */
    @Override
    public int add(T item) {
        if(item == null)
            throw new IllegalArgumentException();

        final Node<T> newNode = new Node<>(item);
        tail = isEmpty() ? (head = newNode) : (tail.next = newNode);
        return size++;
    }

    /**
     * Removes the given element from the list, if it exists.
     * @param item The element to be removed.
     * @return A boolean value indicating whether the element was removed or not.
     */
    @Override
    public boolean remove(T item) {
        // TODO
        return false;
    }

    /**
     * Gets the element at the specified index.
     * @param index the index of the element to get
     * @return The element or {@literal null} if none exists.
     * @throws IllegalArgumentException if the received index is invalid.
     */
    @Override
    public T get(int index) {
        if(index >= size() || index < 0)
            throw new IllegalArgumentException();

        Node<T> current = head;
        while (index-- != 0)
            current = current.next;
        return current.item;
    }

    /**
     * Gets an iterator to the current list.
     * @return The newly instantiated iterator.
     */
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            public Node<T> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if(!hasNext())
                    throw new NoSuchElementException();
                final T result = current.item;
                current = current.next;
                return result;
            }
        };
    }
}
