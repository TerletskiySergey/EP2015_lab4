package EPAM2015_lab4.task1;

import java.util.NoSuchElementException;

public class MyLinkedList {

    private static class Element {
        private Element next;
        private Element prev;
        private Integer val;

        public Element() {
        }

        public Element(Integer e) {
            this.val = e;
        }

        public boolean hasNext() {
            return next != null;
        }

        public Element next() {
            return next;
        }

        public void remove() {
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
        }

        public Integer get() {
            return val;
        }

        public void set(Integer val) {
            this.val = val;
        }
    }

    private Element head;
    private int size;

    public void add(Integer e) {
        if (size == 0) {
            addFirst(e);
            return;
        }
        Element newElem = new Element(e);
        Element last = element(size - 1);
        last.next = newElem;
        newElem.prev = last;
        size++;
    }

    public void add(int index, Integer value) {
        checkPositionIndex(index);
        if (index == size) {
            addLast(value);
            return;
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        Element curElem = element(index);
        Element newElem = new Element(value);
        curElem.prev.next = newElem;
        newElem.prev = curElem.prev;
        newElem.next = curElem;
        curElem.prev = newElem;
        size++;
    }

    public void addFirst(Integer e) {
        Element newElem = new Element(e);
        if (head == null) {
            head = newElem;
        } else {
            head.prev = newElem;
            newElem.next = head;
            head = newElem;
        }
        size++;
    }

    public void addLast(Integer e) {
        add(e);
    }

    public Integer get(int index) {
        checkElementIndex(index);
        Element curElem = element(index);
        return curElem.get();
    }

    public Integer getFirst() {
        checkIfEmpty();
        return head.get();
    }

    public Integer getLast() {
        checkIfEmpty();
        Element last = element(size - 1);
        return last.get();
    }

    public Integer remove(int index) {
        checkElementIndex(index);
        if (index == 0) {
            return removeFirst();
        }
        Element curElement = element(index);
        curElement.remove();
        size--;
        return curElement.get();
    }

    public Integer removeFirst() {
        checkIfEmpty();
        Integer toReturn = head.get();
        if (size == 1) {
            head = null;
        } else {
            head = head.next();
            head.prev.remove();
        }
        size--;
        return toReturn;
    }

    public Integer removeLast() {
        checkIfEmpty();
        if (size == 1) {
            return removeFirst();
        }
        Element last = element(--size);
        last.remove();
        return last.get();
    }

    public void set(int index, Integer value) {
        checkElementIndex(index);
        Element curElement = element(index);
        curElement.set(value);
    }

    public int size() {
        return size;
    }

    public int indexOf(Integer value) {
        int index = 0;
        Element curElem = head;
        while (curElem != null) {
            if (curElem.get().equals(value)) {
                return index;
            }
            curElem = curElem.next();
            index++;
        }
        return -1;
    }

    private Element element(int index) {
        Element curElem = head;
        while (index-- != 0) {
            curElem = curElem.next();
        }
        return curElem;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void checkIfEmpty() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[]");
        Element curElem = head;
        while (curElem != null) {
            sb.insert(sb.length() - 1, curElem.get());
            if (curElem.hasNext()) {
                sb.insert(sb.length() - 1, ", ");
            }
            curElem = curElem.next();
        }
        return sb.toString();
    }
}
