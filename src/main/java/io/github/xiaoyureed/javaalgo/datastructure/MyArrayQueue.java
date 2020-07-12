package io.github.xiaoyureed.javaalgo.datastructure;

/**
 * @author : xiaoyureed
 * 2020/7/12
 */
public class MyArrayQueue {
}

class ArrayQueue<E> {

    private Object items[];

    private int front;
    private int rear;

    private int count;

    ArrayQueue(int capcity) {
        this.items = new Object[capcity];
        this.front = 0;
        // this.rear = -1;
        this.rear = items.length - 1;
        this.count = 0;
    }

    public void display() {
        if (front < rear) {
            for (int i=front; i<= rear; i++) {

            }
        }
    }

    public void push(E item) {
        if (count == items.length) {
            System.out.println(">>> full");
            return;
        }
        rear = ++rear % items.length;
        items[rear] = item;
        count++;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (count == 0) {
            System.out.println(">>> empty");
            return null;
        }
        count--;
        front = front % items.length;
        return (E) items[front++];
    }

    public int count() {
        return this.count;
    }

}
