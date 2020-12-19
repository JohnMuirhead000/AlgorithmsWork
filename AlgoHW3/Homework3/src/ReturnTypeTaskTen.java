public class ReturnTypeTaskTen {


    String document;
    double frequency;
    double TfIdf;

    public ReturnTypeTaskTen(String document, double frequency, double TfIdf){
        this.document = document;
        this.frequency = frequency;
        this.TfIdf = TfIdf;
    }

    public void printContents(){
        System.out.println("The doc is "+ document +  " the frequency is " + frequency + " the TfIdf is " + TfIdf);
    }
}
