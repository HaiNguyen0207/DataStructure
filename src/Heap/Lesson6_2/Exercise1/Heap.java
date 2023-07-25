package Heap.Lesson6_2.Exercise1;

import java.lang.reflect.Array;

public class Heap<E extends Comparable<E>> {
    private E[] data;
    private int max;
    private int currentSize;

    public Heap(Class<E> dataType, int max) {
        this.max = max;
        this.currentSize = 0;
        data = (E[]) Array.newInstance(dataType, max);
    }

    //show emlement
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
        }
        return false;
    }

    private void siftUp(int index) {
        var parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) > 0) {
            var tmp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = tmp;
            siftUp(parentIndex);
        }
    }

    public int getSize() {
        return currentSize;
    }

    public E getMaxHeap() {
        if (currentSize < 0) {
            return null;
        }
        return data[0];
    }

}
