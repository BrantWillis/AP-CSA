package LinearStructures;

import java.util.Iterator;

//import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
    private int size = 0;

    private Node<E> head, tail;

    public LinkedList() {}

    public LinkedList(E[] objects) {
        for(int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
    }

    public int indexOf(E e) {
        if(size == 0) return -1;

        int index = 0;
        Node<E> current = head;
        do {
            if(current.element == e) {
                return index;
            }
            current = current.next;
            index++;
        } while(current != null);
        
        return -1;
    }

    public int lastIndexOf(E e) {
        if(size == 0) return -1;

        int index = 0;
        int lastIndex = -1;
        Node<E> current = head;
        do {
            if(current.element == e) {
                lastIndex = index;
            }
            current = current.next;
            index++;
        } while(current != null);
        
        return lastIndex;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if(tail == null) { //list was empty
            tail = head; //only one list item so tail = head
        }
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if(tail == null) { //list was empty
            head = tail = newNode; //only one list item so tail = head
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public void add(E e) {
        add(size,e);
    }

    public void add(int index, E e) {
        if(index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else { //stick it in the middle
            Node<E> current = head;
            for(int i = 1; i < index; i++) {
                current = current.next; // advance pointers
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            current.next.next = temp;
            size++;
        }
    }

    public E getFirst() {
        if(size == 0) return null;
        return head.element;
    }

    public E getLast() {
        if(size == 0) return null;
        return tail.element;
    }

    public E get(int index) {
        checkIndex(index);
        if(index == 0) return getFirst();
        else if(index == size - 1) return getLast();
        else {
            Node<E> current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.element;
        }
    }

    public E set(int index, E e) {
        checkIndex(index);
        Node<E> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        Node<E> temp = current;
        current.element = e;
        return temp.element;
    }

    public E removeFirst() {
        if(size == 0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if(head == null) tail = null; // if size becomes 0
            return temp.element;
        }
    }

   public boolean contains(E e) {
        return (indexOf(e) != -1);
   }

    public E removeLast() {
        if(size == 0) return null;
        else if(size == 1) {
            Node<E> temp = head;
            clear();
            return temp.element;
        } else {
            Node<E> current = head;
            for(int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    public E remove(int index) {
        checkIndex(index);
        Node<E> current = head;
        Node<E> last = head;
        if(index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        }
        for(int i = 0; i < index; i++) {
            last = current;
            current = current.next;
        }
        last.next = current.next;
        size--;
        return current.element;
    }

    public void clear() {
        size = 0;
        head = tail = null;
    }

    //why is it static???
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for(int i = 0; i < size; i++) {
            result.append(get(i));
            if(i < size - 1) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;
        private int num = 0;

        @Override
        public boolean hasNext() {
            return (num < size);
        }

        @Override
        public E next() {
            if (hasNext()) {
                Node<E> last = current;
                current = current.next;
                num++;
                return last.element;
            } else {
                return null;
            }

        }

        @Override
        public void remove() {
            //LinkedList.this refers to "this" of the enclosing class
            LinkedList.this.remove(num);
        }
    }
}
