public class GenerateRandom {

    public static int[] genRandom(int size){
        int[] sol = new int[size];
        for (int i = 0; i < size; i++){
            sol[i] = (int) (Math.random() * 100);
        }
        return sol;
    }

    //Function used to print an array of ints
    public static void printInt(int[] print){
        for (int i = 0; i < print.length; i++){
            System.out.print(" "+ print[i]);
        }
    }

    //Functions used to print an array of comparables
    public static void printComp(Comparable[] print){
        for (int i = 0; i < print.length; i++){
            System.out.print(" "+ print[i]);
        }
    }

}
