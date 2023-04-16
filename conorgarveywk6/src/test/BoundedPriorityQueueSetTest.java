package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import queue.BoundedPriorityQueueSet;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import Exceptions.DuplicateElementException;
import main.Task;
import org.junit.jupiter.api.Test;

public class BoundedPriorityQueueSetTest {

    public BoundedPriorityQueueSetTest() {
    }

    /**
     * Test of size method, of class BoundedPriorityQueueSet where the Queue is
     * empty.
     */
    @Test
    public void size_EmptyQueueTest() {
        System.out.println("size, being tested when the queue is empty");
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        int expected = 0;
        int actual = tasks.size();
        assertEquals(expected, actual);
    }

    /**
     * This tests the size method, of class BoundedPriorityQueueSet, where there is
     * one Task present
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void size_QueueContainsOneElementTest() throws DuplicateElementException {
        System.out.println("size,being tested where there is a Task present");

        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2024, 3, 15));
        tasks.add(t1);
        int expected = 1;
        int actual = tasks.size();
        assertEquals(expected, actual);

    }

    /**
     * isEmpty method being tested of class BoundedPriorityQueue, where the Queue is
     * empty
     */
    @Test
    public void isEmpty_QueueIsEmptyTest() {
        System.out.println("isEmpty,being tested on an empty queue");
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        boolean expected = true;
        boolean actual = tasks.isEmpty();
        assertEquals(expected, actual);
    }

    /**
     * This tests the isEmpty method, of class BoundedPriorityQueueSet, where there
     * is one Task present
     *
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void isEmpty_OneElementInQueueTest() throws DuplicateElementException {
        System.out.println("isEmpty, being tested where a Queue has a Task present ");
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2024, 12, 4));
        tasks.add(t1);
        boolean expected = false;
        boolean actual = tasks.isEmpty();
        assertEquals(expected, actual);
    }

    /**
     * This tests the isFull method, of class BoundedPriorityQueueSet, where the
     * Queue is not full
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void isFull_QueueNotFullTest() throws DuplicateElementException {
        System.out.println("isFull, being tested where the Queue is not full");
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet(4);
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2023, 5, 22));
        tasks.add(t1);
        boolean expected = false;
        boolean actual = tasks.isFull();
        assertEquals(expected, actual);
    }

    /**
     * This tests the isFull method, of class BoundedPriorityQueueSet, where the
     * Queue is full
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void isFull_WhereQueueSetIsFullTest() throws DuplicateElementException {
        System.out.println("isFull, being tested with the queue set being full");
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        int month = 1;
        for (int i = 0; i < 10; i++) {
            tasks.add(new Task("Owner", "My Task", LocalDate.of(2024, month, 12)));
            month++;
        }
        boolean expected = true;
        boolean actual = tasks.isFull();
        assertEquals(expected, actual);
    }

    /**
     * This tests the peek method, of class BoundedPriorityQueueSet, where the Queue
     * to be occupied
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void peek_WhereTaskPresentTest() throws DuplicateElementException {
        System.out.println("peek, being tested with a Task already present in the Queue");
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        Task expected = new Task("Owner5", "My Fifth Task", LocalDate.of(2024, 3, 12));
        tasks.add(expected);
        Task actual = tasks.peek();
        assertEquals(expected, actual);
        int resultSize = 1;
        assertEquals(resultSize, tasks.size());
        actual = tasks.peek();
        assertEquals(expected, actual);
    }

    /**
     * Test of peek method, of class BoundedPriorityQueueSet, with an empty queue
     * Present.
     */
    @Test
    public void peek_TestWhereQueueIsEmpty() {
        System.out.println("peek, being tested with an empty queues");
        BoundedPriorityQueueSet instance = new BoundedPriorityQueueSet();
        assertThrows(NoSuchElementException.class, () -> {
            instance.peek();
        });
    }

    /**
     * This tests the add method, of class BoundedPriorityQueueSet, where the Task
     * is first added to the Queue
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void add_FirstElementTest() throws DuplicateElementException {
        System.out.println("add, Adding the First Element to the Queue");
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        assertEquals(0, tasks.size());
        boolean expected = true;
        boolean actual = tasks.add(t1);
        assertEquals(expected, actual);
        Task result = tasks.remove();
        assertEquals(t1, result);
    }

    /**
     * This tests the add method, of class BoundedPriorityQueueSet, where the Task
     * is added to the start of the Queue
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void add_StartOfQueueTest() throws DuplicateElementException {
        System.out.println("add, where a Task object is added to the start of the Queue");
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        Task t2 = new Task("Owner2", "My Second Task", LocalDate.of(2023, 5, 15));
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        tasks.add(t1);
        boolean expected = true;
        boolean actual = tasks.add(t2);
        assertEquals(expected, actual);
        Task result = tasks.remove();
        assertEquals(t2, result);
    }

    /**
     * This tests the add method, of class BoundedPriorityQueueSet, where the Task
     * is added to the end of the Queue
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void add_EndOfQueueWhereDayAfterTest() throws DuplicateElementException {
        System.out.println("add, where a Task is Added to the End of the Queue");
        Task t1 = new Task("Owner1", "First Task", LocalDate.of(2025, 3, 15));
        Task t2 = new Task("Task2", "Second Task", LocalDate.of(2025, 3, 16));
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        tasks.add(t1);
        boolean expected = true;
        boolean actual = tasks.add(t2);
        assertEquals(expected, actual);
        Task resultTask = tasks.remove();
        assertEquals(t1, resultTask);
    }

    /**
     * This tests the add method, of class BoundedPriorityQueueSet, checking whether
     * the Tasks are equal or not
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void add_WhereTwoTasksAreEqualTest() throws DuplicateElementException {
        System.out.println("add, Testing to add a Task where two tasks are equal");
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        Task t2 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();

        tasks.add(t1);

        Throwable thrown = assertThrows(DuplicateElementException.class, () -> {
            tasks.add(t2);
        });
        assertEquals("The Task Already Exists in the Queue,try again.", thrown.getMessage());
    }

    /**
     * This tests the remove method, of class BoundedPriorityQueueSet, adding the
     * Task to middle of queue.
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void add_InMiddleOfQueueTest() throws DuplicateElementException {
        System.out.println("add, adding to a Task to a Queue in the Middle");
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        Task t2 = new Task("Owner2", "My Second Task", LocalDate.of(2025, 3, 16));
        Task t3 = new Task("Owner3", "My Third Task", LocalDate.of(2025, 3, 17));
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        tasks.add(t1);
        tasks.add(t3);
        boolean expected = true;
        boolean actual = tasks.add(t2);
        assertEquals(expected, actual);
        tasks.remove();
        Task resultTask = tasks.remove();
        assertEquals(t2, resultTask);
    }

    /**
     * Test of add method, of class BoundedPriorityQueueSet, where the queue is
     * already full.
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void add_WhereQueueIsFullTest() throws IllegalStateException, DuplicateElementException {
        System.out.println("add, to a full Queue with a default queue");
        Task task = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        int day = 1;
        for (int i = 0; i < 10; i++) {
            tasks.add(new Task("Owner1", "My First Task", LocalDate.of(2025, 1, day)));
            day++;
        }
        assertThrows(IllegalStateException.class, () -> {
            tasks.add(task);
        });

    }

    /**
     * Test of add method, of class BoundedPriorityQueueSet, where the queue is
     * already full with a predefined maxCapacity
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void add_FullQueueWithAFullQueueTest() throws IllegalStateException, DuplicateElementException {
        System.out.println(
                "add being tested where a QueueSet is defined with a maximum capacity, where the IllegalStateException is thrown");
        Task t1 = new Task("Owner1", "My First Task", LocalDate.of(2025, 3, 15));
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet(8);
        int day = 1;
        for (int i = 0; i < 8; i++) {
            tasks.add(new Task("Owner1", "My First Task", LocalDate.of(2025, 1, day)));
            day++;
        }
        assertThrows(IllegalStateException.class, () -> {
            tasks.add(t1);
        });
    }

    /**
     * This tests the remove method, of class BoundedPriorityQueueSet, where the
     * queue is empty.
     *
     * @throws DuplicateElementException, to ensure there is unique Tasks present
     */
    @Test
    public void remove_WithTasksPresentTest() throws DuplicateElementException {
        System.out.println("remove,being tested on a Queue full of Tasks");
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        Task t1 = new Task("Task1", "Test1", LocalDate.of(2025, 3, 11));
        Task t2 = new Task("Task2", "Test2", LocalDate.of(2025, 3, 15));
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(new Task("Task3", "Test3", LocalDate.of(2025, 3, 17)));
        tasks.add(new Task("Task4", "Test4", LocalDate.of(2025, 3, 18)));

        Task expected = t1;
        Task actual = tasks.remove();
        assertEquals(expected, actual);

        int resultSize = 3;
        assertEquals(resultSize, tasks.size());
        expected = t2;
        actual = tasks.remove();
        assertEquals(expected, actual);
    }

    /**
     * This tests the remove method, of class BoundedPriorityQueueSet, where the
     * queue is empty.
     */
    @Test
    public void remove_TestWithNoTasks() {
        System.out.println("remove, testing the remove method on an empty queue");
        BoundedPriorityQueueSet tasks = new BoundedPriorityQueueSet();
        assertThrows(NoSuchElementException.class, () -> {
            tasks.remove();
        });
    }

}