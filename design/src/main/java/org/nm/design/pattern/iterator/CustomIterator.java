package org.nm.design.pattern.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CustomIterator<E, T extends  CustomIterable> implements Iterator
{
    private int currentIndex = 0;

    private List<E> elements = new LinkedList<>();

    public CustomIterator(T itemsHolder) {
        if(itemsHolder != null){
            this.elements = itemsHolder.getItems();
        }
    }
    @Override
    public boolean hasNext ()
    {
        return currentIndex != elements.size();
    }

    @Override
    public E next ()
    {
        return elements.get(currentIndex++);
    }

    @Override
    public void remove ()
    {
        throw new UnsupportedOperationException("Not Supported");
    }
}
