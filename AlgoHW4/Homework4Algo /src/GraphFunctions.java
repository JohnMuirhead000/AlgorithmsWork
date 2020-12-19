import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import edu.princeton.cs.algs4.Graph;
import java.util.Iterator;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class GraphFunctions {


    //This function is how I will do the first part of task 2.1.  It takes in a hash map, a category, the specifc from that category,
    //and a string representation.  It outputs, then
    public static ArrayList<String> findNeighbors(HashMap<String, JSONObject> map, String node) {

        ArrayList<String> result = new ArrayList<String>();
        for (JSONObject obj : map.values()) {
            if (obj.get("shortName").equals(node)) {
                JSONArray neighbors = (JSONArray) obj.get("neighbors");
                for (Long entry : (Iterable<Long>) neighbors) {
                    String id = entry.toString();
                    result.add(map.get(id).get("shortName").toString());
                }
            }
        }
        return result;
    }


    //The point and purpose of this function is to take in a Hash map (representation the JSON graph), a list of places
    // (representing the shortName version of a JSONObject), and a place (representing the place we want to pull from).
    public static ArrayList<String> filterNeighbors(HashMap<String, JSONObject> map, ArrayList<String> options, String place) {

        ArrayList<String> result = new ArrayList<String>();

        for (String s : options) {

            for (JSONObject obj : map.values()) {

                if (obj.get("shortName").equals(s)) {

                    if (obj.get("continent").equals(place)) {

                        result.add(obj.get("shortName").toString());

                    }
                }
            }
        }
        return result;
    }


    public static ArrayList<String> BFS(String start, String end, SymbolGraph symbolGraph) {
        ArrayList<String> path = new ArrayList<>();
        int starti = symbolGraph.index(start);
        BFS bfs = new BFS(symbolGraph.G(), starti);


        if (!symbolGraph.contains(start)) {
            return path;
        }

        if (symbolGraph.contains(end)) {
            int endi = symbolGraph.index(end);
            if (bfs.hasPathTo(endi)) {
                for (int i : bfs.pathTo(endi)) {
                    path.add(symbolGraph.name(i));
                }
            }
        }
        return path;
    }
}




