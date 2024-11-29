package com.itm.patrones.table.iterator;

import java.util.List;

public class Iterable<T> implements Iterator<T> {
    private final List<T> iterator;
    private int index;

    public Iterable(final List<T> iterator) {
        this.iterator = iterator;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < iterator.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            return iterator.get(index++);
        }
        return null;
    }
}
