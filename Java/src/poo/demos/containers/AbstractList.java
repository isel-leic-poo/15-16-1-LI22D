package poo.demos.containers;

import java.util.Iterator;

/**
 * Created by palbp on 07/11/16.
 */
public abstract class AbstractList<T> implements Iterable<T> {

    /** The container's size. */
    protected int size;

    /**
     * Adds the given element to the end of the list.
     * @param item The element to be added.
     * @return The index where the item was stored.
     * @throws IllegalArgumentException if the received item is null.
     */
    public abstract int add(T item);

    /**
     * Removes the given element from the list, if it exists.
     * @param item The element to be removed.
     * @return A boolean value indicating whether the element was removed or not.
     */
    public abstract boolean remove(T item);

    /**
     * Gets the element at the specified index.
     * @param index the index of the element to get
     * @return The element or {@literal null} if none exists.
     * @throws IllegalArgumentException if the received index is invalid.
     */
    public abstract T get(int index);

    /**
     * Gets the number of elements in the list.
     * @return The number of contained elements.
     */
    public int size() {
        return size;
    }

    /**
     * Indicates whether the list is empty or not.
     * @return A boolean value indicating whether the list is empty or not.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Gets an iterator to the current list.
     * @return The newly instantiated iterator.
     */
    public abstract Iterator<T> iterator();
}
