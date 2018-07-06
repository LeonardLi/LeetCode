package com.xiaode.ADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by liyangde on Jul, 2018
 */
public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int curSize;
    private T[] elements;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public T get(int index) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        return elements[index];
    }

    public int size() {
        return curSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T set(int index, T newVal) {
        T old = get(index);
        elements[index] =  newVal;
        return old;
    }

    public boolean add(T newVal) {
        add(size(), newVal);
        return true;
    }

    public void add(int index, T newVal) {
        if (elements.length == size())
            setCapacity(size()*2 + 1);
        for (int i = curSize; i > index; i--)
            elements[i] = elements[i - 1];

        elements[index] = newVal;

        curSize++;
    }


    public T remove(int index) {
        return null;
    }

    public void setCapacity(int newCapacity){
        if (newCapacity < curSize) return;

        T[] olds = elements;

        elements = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            elements[i] = olds[i];
        }
    }

    private void doClear() {
        this.curSize = 0;
        setCapacity(DEFAULT_CAPACITY);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int current = 0;
        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
