
import java.util.Stack;

public class StackCalculator {

    public static void calculate(String[] a)
    {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        for (int i = 0; i < a.length; i++)
        {
            {
                if (a[i].equals("(")) ;
                else if (a[i].equals("+")) ops.push(a[i]);
                else if (a[i].equals("-")) ops.push(a[i]);
                else if (a[i].equals("*")) ops.push(a[i]);
                else if (a[i].equals("/")) ops.push(a[i]);
                else if (a[i].equals("sqrt")) ops.push(a[i]);
                else if (a[i].equals("^")) ops.push(a[i]);
                else if (a[i].equals("log")) ops.push(a[i]);
                else if (a[i].equals(")"))
                {
                    String op = ops.pop();
                    double v = vals.pop();
                    if (op.equals("+")) v = vals.pop() + v;
                    else if (op.equals("-")) v = vals.pop() - v;
                    else if (op.equals("*")) v = vals.pop() *  v;
                    else if (op.equals("/")) v = vals.pop() / v;
                    else if (op.equals("^")) v = Math.pow(v, vals.pop());
                    else if (op.equals("log")) v = Math.log(v);
                    vals.push(v);
                } else vals.push(Double.parseDouble(a[i]));
            }
        }
            System.out.println(vals.pop());
    }
}

