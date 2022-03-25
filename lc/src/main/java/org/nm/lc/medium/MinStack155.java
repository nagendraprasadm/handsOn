package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class MinStack155
{
    private List<Integer> st = new ArrayList<>();
    private List<Integer> mt = new ArrayList<>();
    int size = 0;

    public MinStack155() {

    }

    public void push(int val) {
        st.add(val);
        size++;
        if(size == 1){
            mt.add(size - 1);
        }else {
            int curMin = st.get(mt.get(size - 2));
            if(curMin > val){
                mt.add(size - 1);
            }else{
                mt.add(mt.get(size - 2));
            }
        }
    }

    public void pop() {
        st.remove(size - 1);
        mt.remove(size - 1);
        size--;
    }

    public int top() {
        return st.get(size - 1);
    }

    public int getMin() {
        return st.get(mt.get(size-1));
    }
}
