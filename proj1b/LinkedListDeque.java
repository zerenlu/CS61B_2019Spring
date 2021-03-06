public class LinkedListDeque<T> implements Deque<T> {
    private Node sentinel;
    private int size;
    /* Create Node class to define a Node*/
    private class Node {
        private T item;
        private Node pre, next;
        private Node(T i, Node prv, Node nex) {
            item = i;
            pre = prv;
            next = nex;
        }
    }
    /* Create an empty linked list deque*/
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    /* initial with one element*/
    public LinkedListDeque(T x) {
        sentinel = new Node(null, null, null);

        sentinel.next = new Node(x, sentinel, sentinel);
        sentinel.pre = sentinel.next;
        size = 1;
    }

    /* add First element*/
    @Override
    public void addFirst(T item) {
        Node node = new Node(item, sentinel, sentinel.next);
        sentinel.next.pre = node;
        sentinel.next = node;
        size += 1;
    }
    /*Add element to last position*/
    @Override
    public void addLast(T item) {
        Node node = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.next = node;
        sentinel.pre = node;
        size += 1;
    }

    /*Return the number of elements in the list*/
    @Override
    public int size() {
        return size;
    }

    /*print all the elements*/
    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (p.item != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(" ");
    }

    /*remove first element*/
    @Override
    public T removeFirst() {
        if (size != 0) {
            T v = sentinel.next.item;
            sentinel.next.next.pre = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return v;
        } else {
            return null;
        }

    }

    /*remove last element*/
    @Override
    public T removeLast() {
        if (size != 0) {
            T v = sentinel.pre.item;
            sentinel.pre.pre.next = sentinel;
            sentinel.pre = sentinel.pre.pre;
            size -= 1;
            return v;
        } else {
            return null;
        }
    }
    /*return the element at given index*/
    @Override
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        } else {
            int counter = 0;
            Node p = sentinel.next;
            while (counter != index) {
                p = p.next;
                counter += 1;
            }
            return p.item;
        }
    }
    /*copy the entire list object one by one.
    * source @https://www.youtube.com/watch?v=JNroRiEG7U4
    *
    * */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size; i++) {
            addLast((T) other.get(i));
        }

    }
    /*return the item based on index*/
    public T getRecursive(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        } else {
            return getRecursiveHelper(sentinel.next, index);
        }
    }

    /*help function to get item based on index*/
    private T getRecursiveHelper(Node n, int i) {
        if (i == 0) {
            return n.item;
        } else {
            return getRecursiveHelper(n.next, i - 1);
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> test = new LinkedListDeque<>(10);
        test.addFirst(20);
        test.addLast(30);
//        test.printDeque();
//        test.removeFirst();
        test.removeLast();
        System.out.print(test.getRecursive(1));
    }
}
