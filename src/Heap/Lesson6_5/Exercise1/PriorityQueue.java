package Heap.Lesson6_5.Exercise1;

public class PriorityQueue<E extends Comparable<E>> {
    private Node[] data;
    private int size;
    private int currentSize;

    public PriorityQueue(int size) {
        this.size = size;
        this.data = new Node[size];
        this.currentSize = 0;
    }

    // add(e): thêm phần tử mới vào queue theo mức ưu tiên từ cao đến thấp.
    public boolean add(E e, int priority) {
        if (!isFull()) {
            Node node = new Node(e, priority);
            data[currentSize] = node;
            currentSize++;
            siftUp(currentSize-1); // sàng lên
            return true;
        }
        return false;
    }

    private void siftUp(int index) {
        var parent = (index - 1) / 2;
        if (data[index].priority > data[parent].priority) {
            var tmp = data[index];
            data[index] = data[parent];
            data[parent] = tmp;
            siftUp(parent);
        }
    }

    //isFull(): kiểm tra queue có đầy không(áp dụng với triển khai bằng mảng).
    public boolean isFull() {
        return currentSize == size;
    }

    //show element
    public void showElement() {
        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                System.out.print(data[i].value + "(" + data[i].priority + ") ");
            }
        }
    }

    //remove(): xóa và trả về phần tử có mức ưu tiên cao nhất ở đầu queue.
    public boolean remove() {
        if (!isEmpty()) {
            var node = data[0];
            data[0] = data[currentSize - 1];
            data[currentSize - 1] = null;
            currentSize--;
            siftDown(0);
            return true;
        }
        return false;
    }
    //size(): trả về số lượng phần tử hiện có trong queue.


    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    //search(e): tìm xem phần tử e có trong queue không.
    public boolean search(E e) {
        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                if (data[i].value.compareTo(e) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    //peek(): lấy phần tử đầu queue nhưng không xóa.
    public Node<E> peek() {
        return isEmpty() ? null : data[0];
    }

    //
    private void siftDown(int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < currentSize && data[left].getPriority() > data[largest].getPriority()) {
            largest = left;
        }
        if (right < currentSize && data[right].getPriority() > data[largest].getPriority()) {
            largest = right;
        }
        if (largest != index) {
            Node<E> tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            siftDown(largest);
        }
    }

    //isEmpty(): kiểm tra queue có rỗng hay không.
    public boolean isEmpty() {
        return currentSize == 0;
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
