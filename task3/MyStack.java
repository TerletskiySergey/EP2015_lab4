package EPAM2015_lab4.task3;

import EPAM2015_lab4.task1.MyLinkedList;

import java.util.EmptyStackException;

public class MyStack {

    private MyLinkedList container;

    public MyStack() {

        this.container = new MyLinkedList();
    }

    public void push(Integer elem) {
        container.addLast(elem);
    }

    public Integer pop() {
        if (container.size() == 0) {
            throw new EmptyStackException();
        }
        return container.removeLast();
    }

    public String toString() {
        return container.toString();
    }
}
