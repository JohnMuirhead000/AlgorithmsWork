import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenHashTables {

    public static List<LinearProbingHashST<String,Term>>  GenHT ( Map<String, List<String>> linesOfFiles){

        List<LinearProbingHashST<String,Term>> tables = new ArrayList<>();

        linesOfFiles.forEach((String fileName, List<String> lines) -> {
            LinearProbingHashST<String, Term> tt = new LinearProbingHashST<>();
            for (String line : lines) {
                String[] words = line.split(" ");
                for (String aWord : words) {
                    if (tt.get(aWord) == null) {
                        tt.put(aWord, new Term(aWord, fileName));
                    } else {
                        tt.get(aWord).updateFreq();
                    }
                }
            }
            tables.add(tt);
        });

        return tables;
    }

}
