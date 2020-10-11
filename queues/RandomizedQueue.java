/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    public RandomizedQueue() {
        a = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N] = item;
        N++;
    }

    public Item dequeue() {
        int i = StdRandom.uniform(0, N);
        Item item = a[i];
        a[i] = a[N - 1];
        a[N - 1] = null;
        N--;

        if (N > 0 && N <= a.length / 4) resize(a.length / 2);
        return item;
    }

    public Item sample() {
        int i = StdRandom.uniform(0, N);
        return a[i];
    }

    public Iterator<Item> iterator() {
        return new OrderRandom();
    }

    private class OrderRandom implements Iterator<Item> {
        private int i;
        private final int[] randomorder = StdRandom.permutation(N);

        public boolean hasNext() {
            return i < N;
        }

        public Item next() {
            if (i == N) throw new NoSuchElementException("Item depleted");
            Item item = a[randomorder[i++]];
            return item;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException("Method remove cannot be invoke");
        }
    }

    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public static void main(String[] args) {
    }
}
//
// import edu.princeton.cs.algs4.StdRandom;
//
// import java.util.Iterator;
// import java.util.NoSuchElementException;
//
// public class RandomizedQueue<Item> implements Iterable<Item> {
//
//     private int numOfElem;
//     private Item[] valArr;
//
//     // construct an empty randomized queue
//     public RandomizedQueue() {
//         numOfElem = 0;
//         valArr = (Item[]) new Object[2];
//     }
//
//     // is the randomized queue empty?
//     public boolean isEmpty() {
//         return (numOfElem == 0);
//     }
//
//     // return the number of items on the randomized queue
//     public int size() {
//         return numOfElem;
//     }
//
//     // add the item
//     public void enqueue(Item item) {
//         if (item == null)
//             throw new IllegalArgumentException();
//
//         if (numOfElem == valArr.length)
//             resize(2 * valArr.length);
//
//         valArr[numOfElem++] = item;
//     }
//
//     // remove and return a random item
//     public Item dequeue() {
//         if (isEmpty())
//             throw new NoSuchElementException();
//
//         int rand = getIndexOfRandomElem();
//         Item item = valArr[rand];
//
//         // move last element to current empty position
//         numOfElem--;
//         valArr[rand] = valArr[numOfElem];
//         valArr[numOfElem] = null;
//
//         if (numOfElem > 0 && numOfElem == valArr.length / 4)
//             resize(valArr.length / 2);
//
//         return item;
//     }
//
//     // return a random item (but do not remove it)
//     public Item sample() {
//         if (isEmpty())
//             throw new NoSuchElementException();
//         int rand = getIndexOfRandomElem();
//         Item item = valArr[rand];
//         return item;
//     }
//
//     private void resize(int capacity) {
//         Item[] itemCopy = (Item[]) new Object[capacity];
//         int j = 0;
//         for (int i = 0; i < numOfElem; i++) {
//             itemCopy[i] = valArr[i];
//         }
//         valArr = itemCopy;
//     }
//
//     private int getIndexOfRandomElem() {
//         int rand = StdRandom.uniform(numOfElem);
//         while (valArr[rand] == null) {
//             rand = StdRandom.uniform(numOfElem);
//         }
//         return rand;
//     }
//
//     // return an independent iterator over items in random order
//     @Override
//     public Iterator<Item> iterator() {
//         Iterator<Item> iterator = new RandomQueueIterator<>();
//         return iterator;
//     }
//
//     private class RandomQueueIterator<Item> implements Iterator<Item> {
//         private int[] shuffledIndexArray;
//         private int currentIndex;
//
//         public RandomQueueIterator() {
//             shuffledIndexArray = new int[numOfElem];
//             for (int i = 0; i < numOfElem; i++) {
//                 shuffledIndexArray[i] = i;
//             }
//             StdRandom.shuffle(shuffledIndexArray);
//             currentIndex = 0;
//         }
//
//         @Override
//         public boolean hasNext() {
//             return currentIndex < numOfElem;
//         }
//
//         @Override
//         public Item next() {
//             if (!hasNext())
//                 throw new NoSuchElementException();
//
//             int index = shuffledIndexArray[currentIndex++];
//             Item item = (Item) valArr[index];
//             return item;
//         }
//
//         @Override
//         public void remove() {
//             throw new UnsupportedOperationException();
//         }
//     }
//
//     public static void main(String[] args) {
//     }
// }
