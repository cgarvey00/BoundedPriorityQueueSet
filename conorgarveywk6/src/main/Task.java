package main;
import java.time.LocalDate;
import java.util.Objects;

public class Task implements Comparable<Task> {

    private String owner;
    private String description;
    private LocalDate deadline;

    /**
     *
     * Constructs a new task with the specified owner, description, and deadline.
     *
     * @param owner       The Task owner.
     * @param description  The description of the Task.
     * @param deadline    The Task deadline, when its due
     * @throws IllegalArgumentException if the deadline is today or in the past.
     */
    public Task(String owner, String description, LocalDate deadline) {
        if (deadline.compareTo(LocalDate.now()) <= 0) {
            throw new IllegalArgumentException("Deadline cannot be in the past or today");
        }
        this.owner = owner;
        this.description = description;
        this.deadline = deadline;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        if (deadline.compareTo(LocalDate.now()) <= 0) {
            throw new IllegalArgumentException("Deadline cannot be in the past or today");
        }
        this.deadline = deadline;
    }

    /**
     *Computes the hash code of this task based on its owner, description, and
     * deadline.
     *
     * @return The hash code of this task.
     */
    @Override
    public int hashCode() {
        int hash = 8;
        hash = 90 * hash + Objects.hashCode(this.owner);
        hash = 90 * hash + Objects.hashCode(this.description);
        hash = 90 * hash + Objects.hashCode(this.deadline);
        return hash;
    }

    /**
     *
     * Determines whether this task is equal to another object based on their
     * owners, descriptions, and deadlines.
     *
     * @param obj The other object to compare with.
     * @return true if the Task Objects are equal otherwise false is returned.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.deadline, other.deadline)) {
            return false;
        }
        return true;
    }

    /**
     *
     * Compares the task with the deadline of another Task to organise the Tasks.
     *
     * @param t1 The other task to compare with.
     * @return An integer that the Task is equal to, minus 1 or plus one of which the deadline is
     * equal to.
     */
    @Override
    public int compareTo(Task t1) {
        int dline = 0;

        if (t1.getDeadline().compareTo(deadline) < 0) {
            dline = -1;
        } else if (t1.getDeadline().compareTo(deadline) > 0) {
            dline = 1;
        } else {
            return 0;
        }
        return dline;

    }

    /**
     *
     * Returns a string representation of this task, including its owner,
     * description, and deadline.
     *
     * @return An organised of the task.
     */
    @Override
    public String toString() {
        return "--Task Details--" + "\n" + "Owner: " + this.owner + "\n" + "Description: " + this.description + "\n"
                + "Deadline: " + (this.deadline.toString());
    }

}