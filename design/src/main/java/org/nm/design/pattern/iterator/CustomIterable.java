package org.nm.design.pattern.iterator;

import java.util.List;

public interface CustomIterable<T> extends Iterable
{
    public List<T> getItems();
}
