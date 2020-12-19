import java.util.Scanner;
import java.util.Stack;


public class Evaluate
{
    public static void main(String[] args)
    {

        String[] eq1 = new String[]{"(", "2", "+", "3", ")"};
        String[] eq2 = new String[]{"(", "(", "2", "/", "4", ")", "+", "10", ")"};
        String[] eq3 = new String[]{"(", "3", "/", "3", ")"};
        //Below is the case that does not work:
        //String[] eq4 = new String[]{"(", "(", "-5", ")", "^", ")"};
        String[] eq5 = new String[]{"(", "3", "^", "4", ")"};
        String[] eq6 = new String[]{"(", "log", "5",  ")"};

        StackCalculator.calculate(eq1);
        StackCalculator.calculate(eq2);
        StackCalculator.calculate(eq3);
        //StackCalculator.calculate(eq4);
        StackCalculator.calculate(eq5);
        StackCalculator.calculate(eq6);
    }

}