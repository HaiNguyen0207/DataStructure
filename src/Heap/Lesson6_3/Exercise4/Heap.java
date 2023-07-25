package Heap.Lesson6_3.Exercise4;

import java.lang.reflect.Array;
import Heap.Lesson6_3.Exercise4.Student;
public class Heap<E extends Comparable<E>> {
    private E[] data;
    private int size;
    private int currentSize;

    public Heap(Class<E> dataType, int size) {
        this.currentSize = 0;
        this.size = size;
        this.data = (E[]) Array.newInstance(dataType, size);
    }

    //add
    public boolean add(E e) {
        if (currentSize < size) {
            currentSize++;
            data[currentSize - 1] = e;
            siftUp(currentSize-1);
            return true;
        }
        return false;
    }

    private void siftUp(int index) {
        var parent = (index - 1) / 2;
        if (data[index].compareTo(data[parent]) > 0) {
            var tmp = data[index];
            data[index] = data[parent];
            data[parent] = tmp;
            siftUp(parent);
        }
    }

    // remove
    public boolean remove(E e) {
        var index = findNode(e);
        if (index != -1) {
            data[index] = data[currentSize - 1];
            data[currentSize - 1] = null;
            siftDown(index);
            currentSize--;
            return true;
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
        if (largest != index) {
            var tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            siftDown(largest);
        }
    }

    public int findNode(E e) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].compareTo(e) == 0) {
                return i;
            }
        }
        return -1;
    }

    //show element
    public void showElement() {
        for (int i = 0; i < currentSize; i++) {
            System.out.println(data[i]);
        }
    }

    public void showDetail(int i) {
        System.out.println(data[i]);
    }

    public E getNodeMax() {
        return data[0];
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
