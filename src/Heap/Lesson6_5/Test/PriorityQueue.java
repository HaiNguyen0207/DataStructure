package Heap.Lesson6_5.Test;

public class PriorityQueue<E extends Comparable<E>> {
    private Node[] data;
    private int size;
    private int currentSize;

    public PriorityQueue(int size) {
        this.size = size;
        this.currentSize = 0;
        this.data = new Node[size];
    }

    //add
    public boolean add(E value, int priority) {
        if (!isFull()) {
            Node node = new Node(value, priority);
            data[currentSize] = node;
            siftUp(currentSize);
            currentSize++;
            return true;

        }
        return false;
    }

    //pop : xóa và trả về phần tử có mức ưu tiên cao nhất ở đầu queue.
    public Node<E> pop() {
        if (!isEmpty()) {
            Node node = data[0];
            data[0] = data[currentSize - 1];
            data[currentSize - 1] = null;
            currentSize--;
            siftDown(0);
            return node;
        }
        return null;
    }

    public void siftDown(int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < currentSize &&
                data[left].getPriority() > data[largest].getPriority()) {
            largest = left;
        }
        if (right < currentSize &&
                data[right].getPriority() > data[largest].getPriority()) {
            largest = right;
        }
        if (largest != index) {
            Node<E> tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            siftDown(largest);
        }
    }

    private boolean isEmpty() {
        return currentSize == 0 ? true : false;
    }

    private void siftUp(int currentSize) {
        var parent = (currentSize - 1) / 2;
        if (data[currentSize].getPriority() > data[parent].getPriority()) {
            var tmp = data[currentSize];
            data[currentSize] = data[parent];
            data[parent] = tmp;
            siftUp(parent);
        }
    }

    private boolean isFull() {
        return currentSize == size ? true : false;
    }

    //show element
    public void showElement() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(data[i].value + "(" + data[i].priority + ")" + " ");
        }
    }

    // peek() : lấy phần tử đầu nhưng không xóa
    public Node<E> peek() {
        if (!isEmpty()) {
            return data[0];
        } else {
            return null;
        }
    }
    // getsize

    public int getCurrentSize() {
        return currentSize;
    }

    public void setSize(int size) {
        this.size = size;
    }

    static class Node<E extends Comparable<E>> {
        private E value;
        private int priority;

        public Node() {
        }

        public Node(E value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", priority=" + priority +
                    '}';
        }
    }


}
