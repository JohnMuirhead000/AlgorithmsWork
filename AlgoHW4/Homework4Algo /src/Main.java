import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Main {
    //Executing core operations
    public static void main(String[] args) {

        //Step 1, I will build a JSON graph.  I will use the path specfici to my machine.  This part
        //of the code should be changed to match.
        BuildJSONGraph JG = new BuildJSONGraph("algoData/algoData.json");
        //Now, I will build the SymbolGraph. I will use the JG i just built and the getter to return the hashMap.
        BuildSymbolGraph SG = new BuildSymbolGraph(JG.getJsonHM());



        //Now with these 2 objects constructed, I will find the neighbors using the static function GraphFunctions,
        ArrayList<String> Neighbors =  GraphFunctions.findNeighbors(JG.getJsonHM(), "giCentre");
        ArrayList<String> result  = GraphFunctions.filterNeighbors(JG.getJsonHM(), Neighbors, "North America");

        //Now I print the results.
        for (String node : result){
            System.out.println("giCentre neightbors in North America: ");
            System.out.println(node);
        }
        System.out.println();


        //The function (which's result is printed out) takes in 2 names (shortNames) and a Symbol Graph and
        //prints out the shortest path between them.  The intermediary values are the actual ID of the nodes,
        //as opposed to their names.
        System.out.println(GraphFunctions.BFS("Lane", "Rob", SG.getSymbolGraph()));



        System.out.println();
        System.out.println();
        ExploratoryAnalysis.countData(JG.getJsonHM());
        System.out.println();
        ExploratoryAnalysis.continentDistrib(JG.getJsonHM());
        System.out.println();
        ExploratoryAnalysis.influence(JG.getJsonHM());
        System.out.println();
        ExploratoryAnalysis.original(JG.getJsonHM());


    }
}
