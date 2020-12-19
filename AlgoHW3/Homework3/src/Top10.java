import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TermComparator implements Comparator<Term> {

    @Override
    public int compare(Term first, Term second) {
        return Double.compare(first.TfIdf, second.TfIdf);
    }

}
public class Top10 {

    public static List<Term> Top10(LinearProbingHashST table){

        List<Term> terms = new ArrayList<>();

        //Creates a list of all of the terms:
            for (Object key : table.getKeys()){
                Term aTerm = (Term) table.get((String) key);
                terms.add(aTerm);
            }

        TermComparator tc = new TermComparator();
        Collections.sort(terms, tc);
        List<Term> top10 = new ArrayList<Term>(terms.subList(terms.size() -10, terms.size()));


        return top10;
    }


}
