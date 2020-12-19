import java.util.List;


public class GenDocFreq {

    public static LinearProbingHashST<String, Integer> GenDF(List<LinearProbingHashST<String, Term>> tables){

        LinearProbingHashST<String, Integer> DocFreq = new LinearProbingHashST<>();

        for (LinearProbingHashST table : tables) {

            for (Object word : table.getKeys()) {

                if (!(DocFreq.contain((String) word))) {
                    DocFreq.put((String) word, 1);
                } else {
                    DocFreq.put((String) word, (DocFreq.get((String) word)) + 1);
                }
            }
        }
        return DocFreq;
    }

}
