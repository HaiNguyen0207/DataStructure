package Heap.Lesson6_4.Exercise1;

import java.lang.reflect.Array;

public class Heap<E extends Comparable<E>> {
    private E[] data;
    private int size;
    private int currentSize;

    public Heap(Class<E> typeData, int size) {
        this.size = size;
        this.data = (E[]) Array.newInstance(typeData, size);
        this.currentSize = 0;
    }

    //add
    public boolean add(E e) {
        if (currentSize < size) {
            currentSize++;
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

    //show element
    public void showElement() {
        for (int i = 0; i < currentSize; i++) {
            System.out.println(data[i]);
        }
    }

    //remove
    public boolean remove(E e) {
        var index = findNode(e);
        if (index != -1) {
            data[index] = data[currentSize - 1];
            data[currentSize - 1] = null;
            currentSize--;
            siftDown(index);
        }
        return false;
    }

    private void siftDown(int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left< currentSize && data[left].compareTo(data[largest]) > 0) {
            largest = left;
        }
        if (right < currentSize &&data[right].compareTo(data[largest]) > 0) {
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

    //update
    public boolean update(E oldNode, E newNode) {
        var index = findNode(oldNode);
        if (index != -1) {
            data[index] = newNode;
            var parentIndex = (index - 1) / 2;
            if (data[index].compareTo(data[parentIndex]) > 0) {
                siftUp(index);
            } else {
                siftDown(index);
            }
        }
        return false;
    }

    public E showNodeDetail(E e) {
        return data[findNode(e)];
    }

    public E getMax() {
        return data[0];
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }
}
