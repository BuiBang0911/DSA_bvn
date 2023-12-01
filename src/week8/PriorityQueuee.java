package week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getId() {
        return id;
    }
}

class Priorities {
    private static final String SERVED = "SERVED";

    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> priority = getPriorityQueue(events);

        for (String s : events) {
            String[] t = s.split(" ");
            String event = t[0];
            if (event.equals(SERVED)) {
                priority.poll();
                continue;
            }

            String name = t[1];
            double cgpa = Double.parseDouble(t[2]);
            int id = Integer.parseInt(t[3]);

            Student student = new Student(id, name, cgpa);
            priority.add(student);
        }

        List<Student> students = new ArrayList<>();
        while (!priority.isEmpty()) {
            students.add(priority.poll());
        }
        return students;
    }

    private static PriorityQueue<Student> getPriorityQueue(List<String> events) {
        int size = events.size();
        Comparator<Student> pqComparator = new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                return s1.getCgpa() != s2.getCgpa() ? Double.compare(s2.getCgpa(), s1.getCgpa())
                        : !s1.getName().equals(s2.getName()) ? s1.getName().compareTo(s2.getName())
                        : Integer.compare(s1.getId(), s2.getId());
            }
        };

        return new PriorityQueue<>(size, pqComparator);
    }
}


public class PriorityQueuee {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
