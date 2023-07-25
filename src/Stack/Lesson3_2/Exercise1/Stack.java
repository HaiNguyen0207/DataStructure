package Stack.Lesson3_2.Exercise1;

import java.lang.reflect.Array;

public class Stack<T> {
    private int capacity;
    private int size;
    private T[] data;

    public Stack() {
        capacity = 10;
        size = 0;
        data = (T[]) Array.newInstance(Object.class, capacity);
    }

    public Stack(int capacity, T data) {
        this.capacity = capacity;
        this.data = (T[]) Array.newInstance(Object.class,this.capacity);
    }

    public Stack(int capacity) {
        size =0;
        this.capacity = capacity;
        this.data = (T[]) Array.newInstance(Object.class,this.capacity);
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


    //isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    //is full
    public boolean isFull() {
        return size == capacity;

    }

    //insert first
    public void push(T t) {
        if (!isFull()) {
            data[size++] = t;
        } else {
            System.out.println("Stack Full ! Unable add ");
        }
    }

    //remove first stack
    public void pop() {
        if (!isEmpty()) {
            data[size -1] = null;
            size--;
        } else {
            System.out.println("Stack is empty ! Unable remove ");
        }
    }

    //get element first stack
    public T peek() {
        if (!isEmpty()) {
           return data[size-1];
        } else {
            return null;
        }
    }

}
