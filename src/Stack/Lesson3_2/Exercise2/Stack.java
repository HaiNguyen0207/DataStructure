package Stack.Lesson3_2.Exercise2;

import java.lang.reflect.Array;

public class Stack<T> {
    private int capacity;
    private int size;
    private T[] data;

    public Stack() {
        capacity = 100;
        size = 0;
        data = (T[]) Array.newInstance(Object.class, capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    //check is empty ?
    public boolean isEmpty() {
        return size == 0;
    }

    //check stack full ?
    public boolean isFull() {
        return size == capacity;
    }

    // push
    public void push(T t) {
        if (!isFull()) {
            data[size] = t;
            size++;
        } else {
            System.out.printf("Stack full ! Enable push ");
        }
    }

    // pop
    public void pop() {
        if (!isEmpty()) {
            data[size-1] = null;
            size--;
        } else {
            System.out.printf("Stack is empty ! Enable pop");
        }
    }

    // peek
    public T peek() {
        if (!isEmpty()) {
            return data[size-1];
        } else {
            return null;
        }
    }

}
