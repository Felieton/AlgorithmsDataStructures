public class FullStackException extends Exception {

    @Override
    public String getMessage() {
        return "the stack is full";
    }
}
