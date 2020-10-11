/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node prev;
        Node next;
    }

    public Deque() {
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void addFirst(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;

        if (last == null) last = first;
        else oldfirst.prev = first;

        N++;
    }

    public void addLast(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.prev = oldlast;

        if (first == null) first = last;
        else oldlast.next = last;

        N++;
    }

    public Item removeFirst() {
        Item item = first.item;
        if (N > 1) {
            first = first.next;
            first.prev = null;
        }
        else {
            last = null;
            first = null;
        }
        N--;
        return item;
    }

    public Item removeLast() {
        Item item = last.item;
        if (N > 1) {
            last = last.prev;
            last.next = null;
        }
        else {
            first = null;
            last = null;
        }
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new OrderIterator();
    }

    private class OrderIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (current == null) throw new NoSuchElementException("No more items");
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException("No such method supported");
        }
    }

    public static void main(String[] args) {
        Deque<String> dq = new Deque<String>();
        dq.addFirst("first");

        Iterator<String> it = dq.iterator();
        //
        // System.out.print("1");
        // System.out.print(it.hasNext());
        // System.out.print(it.next());
        // System.out.print(it.hasNext());

        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }
}

// import java.util.Iterator;
// import java.util.NoSuchElementException;
//
// public class Deque<Item> implements Iterable<Item> {
//
//     private int numOfElem = 0;
//     private Node first, last;
//
//     // construct an empty deque
//     public Deque() {
//     }
//
//     // Node structure in deque
//     private class Node {
//         Node prev;
//         Node next;
//         Item val;
//     }
//
//     private void initFirstLastPtr(Item item) {
//         // initial first node
//         first = new Node();
//         first.next = null;
//         first.prev = null;
//         first.val = item;
//
//         // point last to same node
//         last = first;
//
//         // increment number of element
//         numOfElem++;
//     }
//
//
//     // is the deque empty?
//     public boolean isEmpty() {
//         return (numOfElem == 0);
//     }
//
//     // return the number of items on the deque
//     public int size() {
//         return numOfElem;
//     }
//
//     // add the item to the front
//     public void addFirst(Item item) {
//         if (item == null) {
//             throw new IllegalArgumentException();
//         }
//
//         if (isEmpty()) {
//             initFirstLastPtr(item);
//         }
//         else {
//             Node oldFirst = first;
//             first = new Node();
//             first.val = item;
//             first.next = oldFirst;
//             first.prev = null;
//             oldFirst.prev = first;
//
//             numOfElem++;
//         }
//     }
//
//     // add the item to the end
//     public void addLast(Item item) {
//         if (item == null) {
//             throw new IllegalArgumentException();
//         }
//
//         if (isEmpty()) {
//             initFirstLastPtr(item);
//         }
//         else {
//             Node oldLast = last;
//             last = new Node();
//             last.val = item;
//             last.next = null;
//             last.prev = oldLast;
//             oldLast.next = last;
//
//             numOfElem++;
//         }
//     }
//
//     // remove and return the item from the front
//     public Item removeFirst() {
//         if (isEmpty()) {
//             throw new NoSuchElementException();
//         }
//         Item item = first.val;
//
//         if (first == last) {
//             first = null;
//             last = null;
//         }
//         else {
//             first = first.next;
//             first.prev = null;
//         }
//
//         numOfElem--;
//         return item;
//     }
//
//     // remove and return the item from the end
//     public Item removeLast() {
//         if (isEmpty()) {
//             throw new NoSuchElementException();
//         }
//         Item item = last.val;
//
//         if (first == last) {
//             first = null;
//             last = null;
//         }
//         else {
//             last = last.prev;
//             last.next = null;
//         }
//
//         numOfElem--;
//         return item;
//     }
//
//     // return an iterator over items in order from front to end
//     @Override
//     public Iterator<Item> iterator() {
//         return new DequeIterator();
//     }
//
//     private class DequeIterator implements Iterator<Item> {
//         Node iterPtr = first;
//
//         @Override
//         public boolean hasNext() {
//             return (iterPtr != null);
//         }
//
//         @Override
//         public Item next() {
//             if (iterPtr == null) {
//                 throw new NoSuchElementException();
//             }
//             Item item = iterPtr.val;
//             iterPtr = iterPtr.next;
//             return item;
//         }
//
//         @Override
//         public void remove() {
//             throw new UnsupportedOperationException();
//         }
//
//     }
//
//     public static void main(String[] args) {
//     }
// }
