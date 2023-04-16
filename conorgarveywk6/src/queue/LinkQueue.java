package queue;
import Exceptions.DuplicateElementException;
import main.Task;

import java.util.NoSuchElementException;

public class LinkQueue {

    protected int numElements;

    protected Node first;

    protected Node last;

    public LinkQueue() {
        first = null;
        last = null;
    }

    /**
     *
     * A node class used to store elements in the queue.
     *
     * The data stored in the node of Object Task.
     */
    protected static class Node {
        protected Task data;
        protected Node next;

        /**
         * Constructs a new node with the given data.
         *
         * @param data the Task to be stored in the node.
         */
        public Node(Task data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     *
     * This returns the number of Tasks in the queue.
     *
     * @return the number of Tasks in the queue.
     */
    public int size() {
        return numElements;
    }

    /**
     *
     * Checks whether the queue is empty.
     *
     * @return true,if the queue is empty, otherwise false is returned.
     */
    public boolean isEmpty() {
        return numElements == 0;
    }

    /**
     *
     * Returns the first element in the queue without removing it.
     *
     * @return the first element in the queue.
     * @throws NoSuchElementException, if the queue is empty.
     */
    public Task peek() {
        Node current = first;
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty no Task is present");
        }
        return current.data;
    }

    /**
     *
     * Returns the element at the specified position in the queue.Used to check
     * if a Task exists in the BoundedPriorityQueueSet
     *
     * @param pos the position of the element to be returned.
     * @return the element at the specified position.
     * @throws IndexOutOfBoundsException, checks if the position supplied is out of range.
     */
    public Task get(int pos) {
        if (isEmpty() || pos >= numElements || pos < 0) {
            throw new IndexOutOfBoundsException("Position is out of bounds");
        } else {
            Node current = first;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    /**
     * Inserts the specified Task into the queue.
     *
     * @param data the Task to be inserted.
     * @return true if the element was successfully inserted, otherwise
     *         false is returned.
     * @throws DuplicateElementException,if the element already exists in the queue.
     */
    public boolean add(Task data) throws DuplicateElementException {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        numElements++;
        return true;
    }

    /**
     *
     * Removes and returns the first Task in the queue.
     *
     * @return the first Task in the queue.
     * @throws NoSuchElementException, thrown if the queue is empty.
     */
    public Task remove() {
        Task temp = null;
        if (isEmpty()) {
            throw new NoSuchElementException("Task does not exist,the Queue is Empty");
        } else {
            temp = first.data;
            first = first.next;
        }
        numElements--;
        return temp;
    }
}