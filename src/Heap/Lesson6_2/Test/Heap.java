package Heap.Lesson6_2.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Heap<E extends Comparable<E>> {
    private E[] data;
    private int max;
    private int currentSize;

    public Heap(Class<E> dataType, int max) {
        this.data = (E[]) Array.newInstance(dataType, max);
        this.max = max;
        this.currentSize = 0;
    }

    //show element
    public void showElement() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(data[i] + " ");
        }
    }

    //add
    public boolean add(E e) {
        currentSize++;
        if (currentSize < max) {
            data[currentSize - 1] = e;
            siftUp(currentSize - 1);
            return true;
        } else {
            return false;
        }
    }

    private void siftUp(int index) {
        var parenIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parenIndex]) > 0) {
            E tmp = data[index];
            data[index] = data[parenIndex];
            data[parenIndex] = tmp;
            siftUp(parenIndex);
        }

    }

}
