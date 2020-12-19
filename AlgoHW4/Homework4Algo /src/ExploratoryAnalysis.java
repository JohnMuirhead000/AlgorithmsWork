import org.json.simple.JSONObject;

import java.util.HashMap;

public class ExploratoryAnalysis {

    //The functions here are meant for generating data for an exploratory analysis

    public static void countData(HashMap<String, JSONObject> map) {
        System.out.println("The total number in the data set it: " + map.size());
    }


    public static void continentDistrib(HashMap<String, JSONObject> map){
        int NA = 0;
        int EU = 0;
        int SA = 0;
        int AS = 0;
        for (JSONObject obj : map.values()){
            if (obj.get("continent").equals("North America")){
                NA++;
            } else if (obj.get("continent").equals("South America")){
                SA++;
            } else if (obj.get("continent").equals("Europe")){
                EU++;
            } else if (obj.get("continent").equals("Asia")){
                AS++;
            }
        }
        System.out.println(AS + ": number from Asia");
        System.out.println(NA + ": number from North America");
        System.out.println(EU + ": number from Europe");
        System.out.println(SA + ": number from South America");
    }

    public static void influence(HashMap<String, JSONObject> map){

        int total = 0;

        for (JSONObject obj : map.values()){

            if (obj.get("influential").equals(true)){
                total++;}
        }
        System.out.println(total + ": are influential");
        System.out.println((map.size() - total) + ": are not influential");
        System.out.println( "thus...");
        System.out.println(100 * ((double) total / (double) map.size()) + "%: are influential");
        System.out.println((100 * ((double) (map.size()-total)) / (double) total) + "%: are not influential");
    }


    public static void original(HashMap<String, JSONObject> map){

        int total = 0;

        for (JSONObject obj : map.values()){

            if (obj.get("original").equals(true)){
                total++;}
        }
        System.out.println(total + ": are original");
        System.out.println((map.size() - total) + ": are not original");
        System.out.println( "thus...");
        System.out.println(100 * ((double) total / (double) map.size()) + "%: are original");
        System.out.println((100 * ((double) (map.size()-total)) / (double) total) + "%: are not original");
    }




}
