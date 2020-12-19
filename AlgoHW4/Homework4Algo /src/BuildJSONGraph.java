import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


class BuildJSONGraph {

    private HashMap<String, JSONObject> jsonHM;


    public BuildJSONGraph(String filePath) {
        jsonHM = new HashMap<>();
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("nodes");
            for (JSONObject entry : (Iterable<JSONObject>) jsonArray) {
                if (!jsonHM.containsKey(entry.get("id").toString())) {
                    jsonHM.put(entry.get("id").toString(), entry);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //The getter
    public HashMap<String, JSONObject> getJsonHM() {
        return jsonHM;
    }
}



