public class Main {
    public static void main(String args[]){

        //To show off the functionality of my Heap sort I have the code below.
        //I start by creating an array of Integers of size 100.  I then printed out these random int
        //with the method printComp.
        //I then ran the sort algorithm and printed again

        Integer[] test = GenerateRandom.genRandom(100);
        System.out.println("Below is the random array of integers");
        GenerateRandom.printComp(test);
        System.out.println();
        System.out.println("Below is the sorted array of integers, sorted with the Heapsort");
        Heapsort.sort(test);
        GenerateRandom.printComp(test);

        System.out.println();
        System.out.println();
        System.out.println();


        //The code below is to prove the funcitonality of the SelectionSort alorithm.
        Integer[] test2 = GenerateRandom.genRandom(100);
        System.out.println("Below is the random array of integers");
        GenerateRandom.printComp(test2);
        System.out.println();
        System.out.println("Below is the sorted array of integers, sorted with the SelectionSort");
        SelectionSort.sort(test2);
        GenerateRandom.printComp(test2);

        System.out.println();
        System.out.println();
        System.out.println();

        //I will now use the timer class to compare the speed of the SelectionSort and the HeapSort.
        //The way I run these tests is as follows:
        //First I create an array of random integers of the desired length. After that, I start a timer, run the algo
        //and then stop the timer.  I print the difference between the times with an appropriate message.

        Integer[] test3A = GenerateRandom.genRandom(10000);
        Integer[] test3B = test3A;

        double startTime = System.currentTimeMillis();
        Heapsort.sort(test3A);
        double endTime = System.currentTimeMillis();
        System.out.println("The Heapsort sorted the 10,000 length array in this many milliseconds: " + (endTime - startTime));
        double startTime2 = System.currentTimeMillis();
        SelectionSort.sort(test3B);
        double endTime2 = System.currentTimeMillis();
        System.out.println("The Selection sorted the 10,000 length array in this many milliseconds: " + (endTime2 - startTime2));

        System.out.println();
        System.out.println();

        Integer[] test4A = GenerateRandom.genRandom(100000);
        Integer[] test4B = test4A;

        double startTime3 = System.currentTimeMillis();
        Heapsort.sort(test3A);
        double endTime3 = System.currentTimeMillis();
        System.out.println("The Heapsort sorted the 100,000 length array in this many milliseconds: " + (endTime3 - startTime3));
        double startTime4 = System.currentTimeMillis();
        SelectionSort.sort(test4B);
        double endTime4 = System.currentTimeMillis();
        System.out.println("The Selection sorted the 100,000 length array in this many milliseconds: " + (endTime4 - startTime4));

    }
}
