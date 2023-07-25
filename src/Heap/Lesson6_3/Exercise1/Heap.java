package Heap.Lesson6_3.Exercise1;

import java.lang.reflect.Array;

public class Heap<E extends Comparable<E>> {
    private E[] data;
    private int size;
    private int currentSize;

    public Heap(Class<E> dataType, int size) {
        data = (E[]) Array.newInstance(dataType, size);
        this.size = size;
        this.currentSize = 0;
    }

    //add
    public boolean add(E e) {
        if (currentSize < size) {
            currentSize++;
            data[currentSize - 1] = e;
            siftup(currentSize - 1);
            return true;
        }
        return false;
    }

    private void siftup(int index) {
        var parent = (index - 1) / 2;
        if (data[index].compareTo(data[parent]) > 0) {
            var tmp = data[index];
            data[index] = data[parent];
            data[parent] = tmp;
            siftup(parent);
        }
    }

    //show element
    public void showElement() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    //remove
    public boolean remove(E t) {
        var index = findNode(t);
        if (index != -1) {
            data[index] = data[currentSize - 1];
            data[currentSize] = null;
            currentSize--;
            siftDown(index);
            return  true;
        }
        return false;
    }

    private void siftDown(int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < currentSize && data[left].compareTo(data[largest]) > 0) {
            largest = left;
        }
        if (right < currentSize && data[right].compareTo(data[largest]) > 0) {
            largest = right;
        }
        if (index != largest) {
            var tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            siftDown(largest);
        }
    }

    public int findNode(E t) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].compareTo(t) == 0) {
                return i;
            }
        }
        return -1;
    }

    public E getMax() {
        return data[0];
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
