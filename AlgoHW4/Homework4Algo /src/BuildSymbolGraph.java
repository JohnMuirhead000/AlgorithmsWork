import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class BuildSymbolGraph {

    private SymbolGraph symbolGraph;

    //Creates a symbol graph
    public BuildSymbolGraph(HashMap<String, JSONObject> jsonHM){
        try {
            FileWriter Writer = new FileWriter("data.txt");
            for(JSONObject entry : jsonHM.values()) {
                StringBuilder line = new StringBuilder(entry.get("shortName").toString() + " ");
                JSONArray neighbors = (JSONArray) entry.get("neighbors");
                Iterator<Long> iterator = neighbors.iterator();
                while (iterator.hasNext()) {
                    String string = iterator.next().toString();
                    if(line.indexOf(string) == -1) {
                        line.append(string).append(" ");
                    }
                }
                line.append("\n");
                Writer.write(line.toString());
            }
            Writer.close();
        } catch (IOException e) {
            System.out.println("error");
        }
        this.symbolGraph = new SymbolGraph("data.txt", " ");
    }



    //Returns the graph
    public SymbolGraph getSymbolGraph() {
        return symbolGraph;
    }


}
