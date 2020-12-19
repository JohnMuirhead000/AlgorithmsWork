import java.util.List;
import java.util.Map;

public class Term {

    public String word;
    public String document;
    public double frequency;
    public double TfIdf;

    public Term(String word, String document){
        this.word = word;
        this.document = document;
        this.frequency = 1.0;
        this.TfIdf = 0.0;
    }

    public Term(String word, String document, int frequency){
        this.word = word;
        this.document = document;
        this.frequency = frequency;
        this.TfIdf = 0.0;
    }


    public void updateFreq(){
        this.frequency = frequency + 1.0;
    }

    public void UpdateTfIdf(double NumberOfWords, double NumberOfDocs, double NumberOfAppearences){
        //System.out.println((TF(NumberOfWords) * IDF(NumberOfDocs, NumberOfAppearences)));
       this.TfIdf = (TF(NumberOfWords) * IDF(NumberOfDocs, NumberOfAppearences));
    }


    private double TF(double NumberOfWords){
         return  (this.frequency / NumberOfWords) ;
    }
    private double IDF(double NumberOfDocs, double NumberOfAppearences){
        return  Math.log((NumberOfDocs /  NumberOfAppearences) + 1);
    }




    public String getDoc(){
        return document;
    }


    public double GetFreq() {
        return frequency;
    }

}
