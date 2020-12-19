import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuildBST {

    public static List<BST> buildBST(List<LinearProbingHashST<String, Term>> tables){

        List<BST> finalBST = new ArrayList<>();

        for (LinearProbingHashST table : tables){

            BST<String,Term> tempBST = new BST<>();

            for (Object word : table.getKeys()){
            }

            finalBST.add(tempBST);

        }
        return finalBST;
    }
}
