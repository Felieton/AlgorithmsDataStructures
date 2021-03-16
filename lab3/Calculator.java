import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Stack;
import static java.io.StreamTokenizer.TT_EOF;
import static java.io.StreamTokenizer.TT_NUMBER;
import static java.io.StreamTokenizer.TT_WORD;

public class Calculator {

    private boolean isOperator(int type) {
        char[] operators = {'+', '-', '*', '/', '^'};
        for (int i = 0; i < 5; i++)
            if (type == operators[i])
                return true;

        return false;
    }

    private Double calculate(Double x, Double y, int operator) throws IllegalArgumentException {
        if (operator=='+')
            return x+y;

        if (operator=='-')
            return x-y;

        if (operator=='*')
            return x*y;

        if (operator=='/') {
            if (y==0)
                throw new IllegalArgumentException();
            else
            return x / y;
        }
        if (operator=='^')
            return Math.pow(x,y);

        return null;
    }

    public double compute(String sequence) throws IllegalArgumentException {
        if (sequence == null || sequence.length() < 3)
            throw new IllegalArgumentException();

        Stack<Object> stack = new Stack<>();
        double result;
        StreamTokenizer streamTok = new StreamTokenizer(new StringReader(sequence));
        streamTok.ordinaryChar('/');

        try {
            while (streamTok.nextToken() != TT_EOF) {
                if (streamTok.ttype == TT_NUMBER)
                    stack.push(streamTok.nval);

                else if (isOperator(streamTok.ttype)) {
                    Double x, y;
                    y = (Double) stack.pop();
                    x = (Double) stack.pop();
                    stack.push(calculate(x, y, streamTok.ttype));

                } else if (streamTok.ttype == TT_WORD) {
                    Double x, y;
                    y = (Double) stack.pop();
                    x = (Double) stack.pop();
                    if (streamTok.sval.equals("log"))
                        stack.push(Math.log(y) / Math.log(x));
                    else if (streamTok.sval.equals("root"))
                        stack.push(Math.pow(Math.E, Math.log(y) / x));
                    else
                        throw new IllegalArgumentException();
                }
            }
            result = (Double) stack.pop();

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
