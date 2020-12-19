import java.util.List;

public class UpdateTFIDF {

    //For the function to work, user must have a specific word, document, and list of documents
    public static void UdTFIDF(List<LinearProbingHashST<String,Term>> tables, LinearProbingHashST<String, Integer> docFreq){

        //The function works by looping through all the keys (the words) in docFreq (a parameter in which I passed DocFreq as the argument)
            for (LinearProbingHashST table : tables) {
                for (Object aWord: table.getKeys()){
                    Term tempTerm = (Term) table.get(aWord);
                    tempTerm.UpdateTfIdf(table.getN(),tables.size(), (double) docFreq.get((String) aWord));
                    table.put(aWord,tempTerm);
                }
            }
    }









}
