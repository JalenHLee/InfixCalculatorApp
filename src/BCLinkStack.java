class BCLinkStack<E> {
    private class Node<T> {
        private T value;
        private Node<T> next;

        Node(T v, Node<T> n) {
            value = v;
            next = n;
        }
    }

    private int size;
    private Node<E> top;

    public BCLinkStack() {
        size = 0;
        top = null;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public E pop() {
        if (size == 0) {
            System.out.println("Cannot pop when Stack is empty.");
            return null;
        }
        E ret = top.value;
        top = top.next;
        size--;
        return ret;
    }

    public void push(E x) {
        Node<E> newTop = new Node<>(x, top);
        top = newTop;
        size++;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return top.value;
    }

}