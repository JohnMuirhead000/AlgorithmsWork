
import java.util.List;
import java.util.Map;

//Somes Notes:

class Main {


    public static void main(String[] args) {

        //This code simply makes a map with Sting (name of file) and List<String>, all the different line of text
        //in that file.
        Map<String, List<String>> linesOfFiles = FileReader.fileReader("/Users/jackmuirhead/Desktop/data");

        //The 3 lines below represent steps 1-7
        //Here I create 2 things, a List of hash tables (one for each document) and another hash table
        //which contains all the words and the number of documents which that  word appears in.  I used
        //the static class GenHashTables (class I made and is in this project),
        //with the Map I made at the start as its argument, to make the list of hash tables.  These hash tables
        //have the word in question as the key, and a Term object as its value. The Term holds a number of things
        //including the word, the doc it came from, its frequency in that doc, and (soon to be updated) TF-IDF.
        //I used GenDocFreq with the list of tables as the argument to make the DocFreq (also a class I
        //made for this project).  Doc freq uses the word as its key and the values are how many of the documents
        //use that word at some point.
        List<LinearProbingHashST<String, Term>> tables;
        tables = GenHashTables.GenHT(linesOfFiles);
        LinearProbingHashST DocFreq = GenDocFreq.GenDF(tables);

        //This code represents step 8.  I run a function called UdTFIDF, which takes in a list of hash tables
        //(the 14 different documents) and the hash table DocFreq and, for each key value in each table of tables,
        //the funciton updates the Terms TF-IDF using the Term classes method to do so.  This function returns nothing,
        //but it alters the values (Specifically the Terms variable IfIdf) in each table of tables.
        UpdateTFIDF.UdTFIDF(tables, DocFreq);


        //TASK 2 - USING

        //Below is for Task 10a and part of 11.
        //The first thing I have is the static Search function.  My search function takes in a Key
        // (in the form of a String) but also a List of Hash Tables (the data from which it is searching).
        //to make this function work, I needed to make a new data type as its return type.  The insturctions
        //indicated that I should return the document, its frequency, and its IF-IDF score (for all documents with the
        //word in it).  I created a new data type called ReturnTypeTaskTen, and for each appearance I added a new
        //ReturnTypeTaskTen object to a list.  This list is then returned  So each function call with a specific
        //Key (a word) returns a List of objects, each object containing the doc it's from, its frequency in that doc,
        //and its TD-IDF score.  I will not try to demonstrate its functionality.  I will do this by trying a few words
        //and running the print function (built into ReturnTypeTaskTen) for each object in the list

        System.out.println("These lines below relate to task 10a");
        System.out.println();

        System.out.println("For the word 'the'");
        for (ReturnTypeTaskTen rt : SearchKey.SearchKey("the", tables)) {
            rt.printContents();
        }
        System.out.println();

        System.out.println("For the word 'boat'");
        for (ReturnTypeTaskTen rt : SearchKey.SearchKey("boat", tables)) {
            rt.printContents();
        }
        System.out.println();


        System.out.println("For the word 'Rum'");
        for (ReturnTypeTaskTen rt : SearchKey.SearchKey("Rum", tables)) {
            rt.printContents();
        }
        System.out.println();
        //Upon running this, you will see that 'the' appears in all 14 docs, 'boat' never appears, and 'Rum' appears
        //in 1 document.

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Now onto task 10b");
        System.out.println();

        //Below is the code for me to run and demonstrate task 10b (which includes step 11 of course).

        //Now I will run and print the names and TDIF of the top 10 terms from 3 randomly chosen docs
        //The top 10 takes in a LinearProbingHashST and returns a List of terms. To get a LinearProbingHashST
        // I just grab anny given index for tables. I run the function and print out somehting for each term in the
        // list which is outputed.

        //IMPORTANT NOTE!!! the last one will be the biggest, the first one will be the 10 biggest.  It is, nonetheless,
        //completely sorted.
        System.out.println("Testing for bustopher (the document)");
        for (Term aTerm : Top10.Top10(tables.get(0))) {
            System.out.println(aTerm.word);
            System.out.println("tf-idf: " + aTerm.TfIdf);
        }
        System.out.println();

        System.out.println("Testing for the-Rum (the document)");
        for (Term aTerm : Top10.Top10(tables.get(12))) {
            System.out.println(aTerm.word);
            System.out.println("tf-idf: " + aTerm.TfIdf);
        }
        System.out.println();

        System.out.println("Testing for gus (the document)");
        for (Term aTerm : Top10.Top10(tables.get(2))) {
            System.out.println(aTerm.word);
            System.out.println("tf-idf: " + aTerm.TfIdf);
        }
        System.out.println();
        System.out.println();
        System.out.println("Now time to show the final task:");
        System.out.println();

        //Below is the code for task 3

        //The first thing I will do is build a list of BSTs.  Each BST in the document
        //It will have the same values as the LinerProbingHashST in the list Tables.
        //My BuildBST.buildBST function creates a list of BSTs with the same values as the tables in tables.
        List<BST> BSTs = BuildBST.buildBST(tables);

        //The next step will be to grab  random words present in DocFreq. I will grab 1/10 as many words as
        //there are in the documents.
        int length = (int) (DocFreq.getN() * .1);
        String[] RandWords = new String[length];
        for (int i = 0; i < length; i++) {
            RandWords[i] = (String) DocFreq.getKeys()[(int)(Math.random() * (DocFreq.getKeys().length))];
        }

        //Finally, I will run a search, 10 times in which I search for the word in the tables using my search function.
        //I will use each of the 2 methods in SearchKey for this.  Is for a List of HashST.  The main difference
        //is that one runs the contain function which is built into the the LinearProbingHashST, the other uses the
        //contain built into the BST.  We will see which one runs faster.

        //Here, I run the test:
        //NOTE, This is the part where I use the Timer() class.
        System.out.println("Running the test with the LinearProbingHashSTs");
        RunTest.runTest(RandWords, tables);
        System.out.println();

        System.out.println("Running the test with the BSTs");
        RunTest.runTestBST(RandWords, BSTs);

    }
}





