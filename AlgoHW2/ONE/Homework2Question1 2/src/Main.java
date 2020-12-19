import java.security.Key;

public class Main {

    public static void main (String args[]){


        //This main function is here to demonstrate the functionality of the MinPQ class.

        //The first step is to generate an array of random integers of an arbitrary length (I chose 25)
        //and to print it out.  I did this with 2 functions from my GenerateRandom class.
        System.out.println("Unsorted array of ints:");
        int[] testArray = GenerateRandom.genRandom(25);
        GenerateRandom.printInt(testArray);

        //Now I create a new MinPQ object with the size equal to the array of random ints I just made.
        MinPQ<Integer> test = new MinPQ<>(testArray.length);

        //Now I use a for loop.  This for loop inserts every single element from the random array into the
        //MinPQ object one by one.  When they are inserted, they should be sorted by nature of the insert function.
        for (int i = 0; i < testArray.length; i++){
            test.insert(testArray[i]);
        }

        //Now I create an array of Comparable objects called finalSol and set it to the
        //array (which is the heap) of the MinPQ object.  I did this with a getPq method I created in MinPQ.
        Comparable[] finalAnswer = test.getPq();
        System.out.println();

        //Finally, using a static method in the GenerateRandom class, I print out the elements of finalSol.
        //As you can see, the array is sorted by heaps.
        System.out.println("Sorted into heaps array of ints:");
        GenerateRandom.printComp(finalAnswer);

        //NOTE: I had 2 very similar functions for printing in GenerateRandom. The key difference is that one takes
        //in and prints an array of int and the other takes in and prints an array of Comparable objects.


        //I will now show the MinPQ ability to sort comparable objects.  I will sort Student objects.
        //The first step is to make some Students; I will make 8.

        Student jane = new Student(3.2, "Jane");
        Student bob = new Student(3.4, "bob");
        Student jill = new Student(2.7, "jill");
        Student joe = new Student(3.5, "joe");
        Student emily = new Student(4.0, "emily");
        Student frank = new Student(1.2, "frank");
        Student eliz = new Student(4.0, "eliz");
        Student brad = new Student(3.0, "brad");

        //Now I will create a MinPQ object with a size of 8, which will work with objects of type Student.

        MinPQ<Student> test2 = new MinPQ<Student>(8);

        //I now insert each student one by one.
        test2.insert(jane);
        test2.insert(bob);
        test2.insert(jill);
        test2.insert(joe);
        test2.insert(emily);
        test2.insert(frank);
        test2.insert(eliz);
        test2.insert(brad);

        //I will now create an array of Students equal to the array from the test2 object.  This array should have
        //the students organized in heaps.
        Comparable<Student>[] finalAnswer2 = test2.getPq();

        //Now I can just use the printComp static method to print out the elements of this array. 
        System.out.println();
        System.out.println("Sorted into heaps array of Students");
        System.out.println("Note that I print out the actual objects themselves:");
        GenerateRandom.printComp(finalAnswer2);


    }
}

