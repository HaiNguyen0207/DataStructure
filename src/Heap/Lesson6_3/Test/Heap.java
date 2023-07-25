package Heap.Lesson6_3.Test;

import java.lang.reflect.Array;

public class Heap<T extends Comparable<T>> {
    private T[] data;
    private int size;
    private int currentSize;

    public Heap(Class<T> dataType, int size) {
        this.size = size;
        data = (T[]) Array.newInstance(dataType, size);
        this.currentSize = 0;
    }

    //add
    public boolean add(T t) {
        currentSize++;
        if (currentSize < size) {
            data[currentSize - 1] = t;
            siftUp(currentSize - 1);
            return true;
        } else {
            return false;
        }
    }

    private void siftUp(int index) {
        var parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) > 0) {
            var tmp = data[parentIndex];
            data[parentIndex] = data[index];
            data[index] = tmp;
            siftUp(parentIndex);
        }
    }

    //show element
    public void showElement() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(data[i] + " ");
        }
    }

    //remove
    public void remove(T t) {
        var index = findNode(t);
        if (index != -1) {
            data[index] = data[currentSize - 1];
            data[currentSize] = null;
            currentSize--;
            siftDown(index);
        }
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
        if (largest != index) {
            var tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            siftDown(largest);
        }
    }

    private int findNode(T t) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].compareTo(t) == 0) {
                return i;
            }
        }
        return -1;
    }

}
