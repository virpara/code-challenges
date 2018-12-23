package book.ita.lec4;

import java.util.Arrays;

public class Heap {
    private Integer[] heap = null;

    // number of elements in the heap
    private int size = 0;
    public int counter = 0;

    /**
     * Specifies heap types
     */
    public static enum Type {
        MAX, MIN
    }

    /**
     * Builds empty heap with default capacity of 100
     */
    public Heap() {
        this(100);
    }

    /**
     * Builds empty heap of the specified size
     * @param size heap size
     */
    public Heap(int size) {
        this(new Integer[0], size);
    }

    /**
     * Builds heap from the given array and of default size 100 if given array length is
     * less than 100, otherwise double the size of given array
     * @param array array of elements
     */
    public Heap(Integer[] array) {
        this(array, 100 > array.length ? 100 : array.length * 2);
    }

    /**
     * Builds heap of the specified size and adds the given array to heap.
     * @param array initial array of random size containing values
     * @param heapSize heap size
     */
    public Heap(Integer[] array, int heapSize) {
        heap = new Integer[heapSize];

        System.arraycopy(array, 0, heap, 0, array.length);
        this.size = array.length;

        System.out.println(Arrays.asList(array));
        if (this.size > 1) {
//            buildMaxHeap(1);
            buildMaxHeapBetter();
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Heap h = new Heap(arr);
        h.print();
        System.out.println("iterations: " + h.counter);
    }

    public void print() {
//        System.out.println(Arrays.asList(heap));
        for(int i = 1; i < this.size; i++) {
            System.out.print(heap[i] + " -> ");
            if(left(i) < size) System.out.print(heap[left(i)] + ", ");
            if(right(i) < size) System.out.print(heap[right(i)]);
            System.out.println();
        }
    }

    // convert random input array to max heap
    // we can take top-down or down-up approach
    /**
     * Build max heap of the user given array. Fix the heap property,
     * if it is violated by any element.
     * @param parentIdx
     */
    public void buildMaxHeap(int parentIdx) {
        counter++;
        int leftIdx = left(parentIdx);
        int rightIdx = right(parentIdx);

        // Important Note: calling this before swapping elements allow us to start fixing the heap
        //      from bottom, when the recursion stack unwinds.
        //      if we call this at the end, it doesn't fix the heap when it is in sorted order
        //      because the greatest elements are at the very bottom of the tree.

        // call recursively if left or right child index are in range of heap size
        // cannot skip any part because we cannot be sure if either part already satisfies heap property
        if (leftIdx < size) buildMaxHeap(leftIdx);
        if (rightIdx < size) buildMaxHeap(rightIdx);

        int parent = heap[parentIdx];
        int left = leftIdx < size ? heap[leftIdx] : 0;
        int right = rightIdx < size ? heap[rightIdx] : 0;

        if (parent > Math.max(left, right)) {
            // parent satisfies max heap property. looks good for the parent element
        } else {
            // swap parent with the child having greatest value
            if (left > right) {
                swap(leftIdx, parentIdx);
            }
            else {
                swap(rightIdx, parentIdx);
            }

            // heap is modified so make sure the level after parentIdx is again built for heap property
            buildMaxHeap(parentIdx);
        }
    }

    public void buildMaxHeapBetter() {
        for(int i = size / 2; i > 0; i--) {
            maxHeapify(i);
        }
    }

    /**
     * Restore the heap property at specified indext. Assumes left and
     * right children satisfies heap property
     * @param idx element index
     */
    public void maxHeapify(int idx) {
        counter++;

        int l = left(idx);
        int r = right(idx);

        int largest = idx;
        if (l < size && heap[idx] < heap[l]) largest = l;
        if (r < size && heap[largest] < heap[r]) largest = r;

        if (largest != idx) {
            swap(idx, largest);
            maxHeapify(largest);
        }

    }

    /**
     * Swaps the elements of heap at given indexes
     * @param x heap element index
     * @param y heap element index
     */
    private void swap(int x, int y) {
        int tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }

    /**
     * Returns index of the left child
     * @param idx element index
     * @return index of the left child
     */
    public static int left(int idx) {
        return idx * 2;
    }

    /**
     * Returns index of the right child
     * @param idx element index
     * @return index of the right child
     */
    public static int right(int idx) {
        return idx * 2 + 1;
    }

    /**
     * Returns parent index of the element at the given index
     * @param idx element index
     * @return parent index
     */
    public static int parent(int idx) {
        return idx / 2;
    }

    public void insertMax(int value) {

    }

    public int extractMax() {
        int value = 0;

        return value;
    }

    public void insertMin(int value) {

    }

    public int extractMin() {
        int value = 0;

        return value;
    }

    public void heapsort() {

    }

}
