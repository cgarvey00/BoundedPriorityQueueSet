package queue;
import Exceptions.DuplicateElementException;
import main.Task;
public class BoundedPriorityQueueSet extends LinkQueue {

    /**
     *
     * The maximum capacity of the queue
     */
    private final int maxCapacity;

    /**
     *
     * Constructs a new BoundedPriorityQueueSet object with a default maximum
     * capacity of 10.
     */
    public BoundedPriorityQueueSet() {
        super();
        maxCapacity = 10;
    }

    /**
     *
     * Constructs a new BoundedPriorityQueueSet object with a specified maximum
     * capacity.
     *
     * @param maxCapacity The maximum capacity of the queue. Must be a positive
     *                    integer.
     * @throws IllegalArgumentException, is thrown if the maxCapacity is less than or equal to
     *                                  zero.
     */
    public BoundedPriorityQueueSet(int maxCapacity) throws IllegalArgumentException {
        super();
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("The MaxCapacity must be a positive integer.");
        } else {
            this.maxCapacity = maxCapacity;
        }
    }

    /**
     *
     * Returns the number of Tasks in the queue.
     *
     * @return The number of Tasks present in the queue.
     */
    public int size() {
        return super.size();
    }

    /**
     *
     * Determines whether the queue is empty or not.
     *
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     *
     * Determines whether the queue is full or not. if the numElements is equal to maxCapacity or
     * not
     *
     * @return True if the queue is full, false otherwise.
     */
    public boolean isFull() {
        return numElements == maxCapacity;
    }

    /**
     *
     * Adds a new task to the BoundedPriorityQueueSet.
     *
     * @param task, the Tasks to add to the BoundedPriorityQueueSet. Either in the first,middle or end of the
     * Queue
     *
     * @return true, if the task was added otherwise false is returned.
     *
     * @throws DuplicateElementException, checks to see If the task is already in the queue.
     *
     * @throws IllegalStateException, checks to see if the queue is full and the task cannot be
     *                                   added.
     */
    @Override
    public boolean add(Task task) throws DuplicateElementException, IllegalStateException {
        if (isFull()) {
            throw new IllegalStateException("Queue is full, Max Capacity has been reached");
        }
        for (int i = 0; i < numElements; i++) {
            Task existingTask = get(i);
            if (existingTask.equals(task)) {
                throw new DuplicateElementException();
            }
        }
        Node newNode = new Node(task);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else if (first.data.compareTo(task) < 0) {
            newNode.next = first;
            first = newNode;
        } else if (last.data.compareTo(task) > 0) {
            last.next = newNode;
            last = newNode;
        } else {
            Node current = first;
            Node previous = null;
            while (current.data.compareTo(task) > 0) {
                previous = current;
                current = current.next;
            }
            previous.next = newNode;
            newNode.next = current;

        }
        numElements++;
        return true;
    }

    /**
     *
     * Retrieves, but does not remove, the first Task of the BoundedPriorityQueueSet
     *
     * @return The task at the front of the queue
     * @throws: NoSuchElementException returned if the queue is empty.
     */
    public Task peek() {
        return super.peek();
    }

    /**
     *
     * This removes and returns the first Task in the BoundedPriorityQueueSet
     *
     * @return The Task that was removed from the queue.
     * @throws:NoSuchElementException returned if the queue is empty.
     */
    public Task remove() {
        return super.remove();
    }
}