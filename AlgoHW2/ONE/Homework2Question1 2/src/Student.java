public class Student implements Comparable<Student>{

    public Student(double GPA, String name){ this.GPA = GPA; this.name = name;}

    private double GPA;
    private String name;

    public int compareTo(Student o) {
        if (o.GPA > this.GPA) return -1;
        if (o.GPA < this.GPA) return +1;
        return 0;
    }

    public String getName(){return name;}

}