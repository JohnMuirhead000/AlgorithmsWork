import java.util.List;

public class RunTest {
    public static void runTest(String[] RandWords, List<LinearProbingHashST<String, Term>> tables){

        double totalTime = 0;
        //it runs 10 times.
        for (int i = 0; i < 10; i++) {
            for (int J = 0; J < RandWords.length; J++) {
                double Stime = System.nanoTime();
                //This is my stopwatch
                SearchKey.SearchKey(RandWords[J], tables);
                double Endtime = System.nanoTime();
                //TIMER
                totalTime = totalTime + (Endtime - Stime);
            }
        }
        System.out.println("Combined, the 10 runs took " + totalTime + " nanoseconds");
    }

    public static void runTestBST(String[] RandWords, List<BST> BSTs){

        double totalTime = 0;
        //it runs 10 times.
        for (int i = 0; i < 10; i++) {
            for (int J = 0; J < RandWords.length; J++) {
                double Stime = System.nanoTime();
                //TIMER
                SearchKey.SearchKeyBST(RandWords[J], BSTs);
                double Endtime = System.nanoTime();
                //TIMER
                totalTime = totalTime + (Endtime - Stime);
            }
        }
        System.out.println("Combined, the 10 runs took " + totalTime + " nanoseconds");
    }
}