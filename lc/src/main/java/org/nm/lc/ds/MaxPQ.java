package org.nm.lc.ds;

public class MaxPQ
{
    private int[] arr = null;
    private int size = 0;

    public MaxPQ (int n)
    {
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
    }

    public void insert (int val)
    {
        if (size == arr.length) {
            throw new RuntimeException("Exceeded size");
        }
        arr[++size] = val;
        swim(size);
    }

    public int extractMax ()
    {
        if (size == 0) {
            throw new RuntimeException("PQ is Empty");
        }
        int val = arr[1];
        int last = arr[size];
        arr[1] = last;
        size--;
        sink(1);
        return val;
    }

    private void sink (int i)
    {
        int l = i * 2;
        if (l <= size) {
            l = less(l, l + 1) ? l + 1 : l;
            if(less(i, l)){
                exch(l, i);
                sink(l);
            }else{
                return;
            }
        }
    }

    private void swim (int i)
    {
        while (i > 1) {
            int pix = i / 2;
            if (less(pix, i)) {
                exch(pix, i);
            }
            else {
                break;
            }
            i = pix;
        }
    }

    private void exch (int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean less (int i, int j)
    {
        return arr[i] < arr[j];
    }
}
