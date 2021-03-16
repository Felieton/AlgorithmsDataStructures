public class Test {
    private LimitedQueue<Duck> queue =new LimitedQueue<>(100);
    private SinkingStack<Duck> stack=new SinkingStack<>(100);
    private Calculator calc=new Calculator();

    private void calcTest(){
        String [] sequences={"40 50 +", "3 5 -", "50 7 *", "5 6 /", "9 0.5 ^", "2 -8 log", "3 -64 root"};

        for (String s: sequences)
            System.out.println(s+" = "+calc.compute(s));

        System.out.println();
    }

    private void queueTest() {
        for(int i = 0; !queue.isFull(); i++) {
            try {
                queue.enqueue(new Duck(i));
            } catch (IQueue.FullQueueException e) {
                System.out.println("queue is empty, can't add " + i + " lbs weighing duck");
            }
        }
        try {
            queue.enqueue(new Duck(1024));
        } catch (IQueue.FullQueueException e) {
            System.out.println("queue is empty, can't add " + 1024 + " lbs weighing duck");
        }
        try {
            System.out.println("first in queue: " + queue.dequeue().toString());
        } catch (IQueue.EmptyQueueException e) {
            System.out.println("queue is empty");
        }
        try {
            System.out.println("first in queue " + queue.dequeue().toString());
        } catch (IQueue.EmptyQueueException e) {
            System.out.println("queue is empty");
        }
        System.out.println();
    }

    private void stackTest() {
        for(int i = 1; !stack.isFull(); i++) {
            stack.push(new Duck(i));
        }
        try {
            System.out.println("first on stack: " + stack.top().toString());
        } catch (IStack.EmptyStackException e) {
            System.out.println("empty stack");
        }
        System.out.println("adding elem to full stack");
        stack.push(new Duck(1213));
        try {
            System.out.println("first on stack: " + stack.top().toString());
        } catch (IStack.EmptyStackException e) {
            System.out.println("empty stack");
        }
        while(!stack.isEmpty()) {
            Duck duck;
            try {
                duck = stack.pop();
                System.out.println("last on stack: " + duck.toString());
            } catch (IStack.EmptyStackException e) {
                System.out.println("empty stack");
            }
        }
    }

    public static void main(String[] args){
        Test test = new Test();
        test.calcTest();
        test.queueTest();
        test.stackTest();
    }
}
