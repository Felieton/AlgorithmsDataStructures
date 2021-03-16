public class EmptyStackException extends Exception {

    @Override
    public String getMessage() {
        return "the stack is empty";
    }
}
