package dsaa.lab02;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class OneWayLinkedList<E> implements IList<E> {

    private class Element {
        public Element(E e) {
            this.object = e;
        }

        E object;
        Element next = null;
    }

    Element sentinel;
    private int size;

    private class InnerIterator implements Iterator<E> {
        Element current;

        public InnerIterator() {
            current = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            E value = current.object;
            current = current.next;
            return value;
        }

    }

    public OneWayLinkedList() {
        this.sentinel = new Element(null);
    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        Element newNode = new Element(e);//creating a new empty block
        Element current = sentinel;

        while (current.next != null)
            current = current.next;//pointing current at the end of the list

        current.next = newNode;//placing the new element at the end
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) throws NoSuchElementException {
        if (index < 0 || index >= size)
            throw new NoSuchElementException("Index out of bounds");
        else {
            Element newNode = new Element(element);//creating a new empty block
            Element current = sentinel;

            for (int i = 0; i < index; i++) {
                current = current.next;//pointing current at the index-1
            }
            newNode.next = current.next;
            current.next = newNode;//placing the new element at the index
            size++;
        }

    }

    @Override
    public void clear() {
        sentinel.next = null; //clearing the first element causes loss of the reference to the next element, thus disconnecting the list from the sentinel
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        Element current = sentinel.next;
        while (current != null) {
            if (current.object.equals(element))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public E get(int index) throws NoSuchElementException {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Index out of bounds");
        } else {
            Element current = sentinel.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.object;
        }
    }

    @Override
    public E set(int index, E element) throws NoSuchElementException {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Index out of bounds");
        } else {
            Element current = sentinel.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            E oldValue = current.object;
            current.object = element;
            return oldValue;
        }
    }

    @Override
    public int indexOf(E element) {
        Element current = sentinel.next;
        int index = 0;
        while (current != null) {
            if (current.object.equals(element))
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) throws NoSuchElementException {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Index out of bounds");
        } else {
            Element current = sentinel.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Element removed = current.next;
            current.next = removed.next;
            size--;
            return removed.object;
        }
    }

    @Override
    public boolean remove(E e) {
        Element current = sentinel.next;
        while (current != null) {
            if (current.object.equals(e)) {
                current.next = current.next.next; //we cant just make current.next = null,
                // because we would lose the reference to the rest of the list, instead we disconnect this element
                // by guiding the reference to the next element
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

}

