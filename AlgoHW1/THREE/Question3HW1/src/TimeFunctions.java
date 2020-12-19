
public class TimeFunctions {


    public static void linear(int n){
        double startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++);
        double endTime = System.currentTimeMillis();
        System.out.println("it took " + (endTime-startTime) + " in milleseconds");
    }


    public static void quadratic(int n){
        double startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++);
        double endTime = System.currentTimeMillis();
        System.out.println("it took " + (endTime-startTime) + " in milleseconds");
    }


    public static void cubic(int n){
        double startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++);
        double endTime = System.currentTimeMillis();
        System.out.println("it took " + (endTime-startTime) + " in milleseconds");
    }



}
