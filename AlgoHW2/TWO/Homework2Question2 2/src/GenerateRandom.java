public class GenerateRandom {

    public static Integer[] genRandom(int size){

        Integer[] sol = new Integer[size];

        for (int i = 0; i < size; i++){
            sol[i] = (int) (Math.random() * 100);
        }
        return sol;
    }

    //Functions used to print an array of compatibles
    public static void printComp(Comparable[] print){
        for (int i = 0; i < print.length; i++){
            System.out.print(" "+ print[i]);
        }

    }
}