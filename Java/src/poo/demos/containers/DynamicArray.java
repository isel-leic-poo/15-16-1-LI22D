package poo.demos.containers;

import java.util.Iterator;

/**
 * TODO:
 */
public class DynamicArray<T> extends AbstractList<T> {

    /**
     * Adds the given element to the end of the SimplyLinkedList_this.
     * @param item The element to be added.
     * @return The index where the item was stored.
     * @throws IllegalArgumentException if the received item is null.
     */
    public int add(T item) {
        if(item == null)
            throw new IllegalArgumentException();
        // TODO:
        return 0;
    }


    /**
     * Removes the given element from the list, if it exists.
     * @param item The element to be removed.
     * @return A boolean value indicating whether the element was removed or not.
     */
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
    public T get(int index) {
        if(index >= size() || index < 0)
            throw new IllegalArgumentException();

        // TODO:

        return null;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO:
        return null;
    }
}
