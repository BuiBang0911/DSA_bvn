package week6;

import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }

}

class Sortbyroll implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student o1, Student o2) {
        if (o1.getCgpa() > o2.getCgpa()) {
            //System.out.println(o1.getCgpa() + " " + o2.getCgpa());
            return -1;
        } else if (o1.getCgpa() < o2.getCgpa()) {
            return 1;
        }
        if (o1.getFname().compareTo(o2.getFname()) > 0) {
            return 1;
        } else if (o1.getFname().compareTo(o2.getFname()) < 0) {
            return -1;
        }
        if (o1.getId() > o2.getId()) return -1;
        return 1;
    }
}
//Complete the code
public class JavaSort {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            //sortStudent(studentList);
            //Collections.sort(studentList, new Sortbyroll());
            /*for (int i=0; i < studentList.size(); i++) {
                System.out.println(studentList.get(i).getFname());
            }*/
            testCases--;
        }
        Collections.sort(studentList, new Sortbyroll());
        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }

    private static void sortStudent(List<Student> list) {
        int l = list.size();

    }
}



