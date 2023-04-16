package Exceptions;

public class DuplicateElementException extends IllegalArgumentException {
    public DuplicateElementException() {
        super("The Task Already Exists in the Queue,try again.");
    }
}