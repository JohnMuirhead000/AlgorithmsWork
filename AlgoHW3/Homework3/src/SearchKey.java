import java.util.ArrayList;
import java.util.List;

public class SearchKey {



    public static List<ReturnTypeTaskTen> SearchKey(String Key, List<LinearProbingHashST<String,Term>> tables){

        List<ReturnTypeTaskTen> result = new ArrayList<>();

        for (LinearProbingHashST<String,Term> table : tables) {
            if (table.contain(Key)) {

                result.add(new ReturnTypeTaskTen(table.get(Key).document, table.get(Key).frequency, table.get(Key).TfIdf));
            }
        }
        return result;
    }


    public static List<BST> SearchKeyBST(String Key, List<BST> BSTs){

        List<BST> result = new ArrayList<>();

        for (BST table : BSTs) {
            if (table.contain(Key)) {
                result.add(table);
            }
        }
        return result;
    }

}
