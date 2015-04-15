package EPAM2015_lab4.task2;

        import EPAM2015_lab4.task1.MyLinkedList;

public class MyQueue {

    private MyLinkedList container;

    public MyQueue() {
        this.container = new MyLinkedList();
    }

    public void offer(Integer elem) {
        if (elem == null) {
            throw new NullPointerException();
        }
        container.addLast(elem);
    }

    public Integer peek() {
        if (container.size() == 0) {
            return null;
        }
        return container.getFirst();
    }

    public Integer poll() {
        if (container.size() == 0) {
            return null;
        }
        return container.removeFirst();
    }

    public String toString() {
        return container.toString();
    }
}
