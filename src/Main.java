import base.Person;
import university.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Person alex = new Person("1051", "Alex");
        Person john = new Person("1052", "John");
        Person lisa = new Person("1053", "Lisa");
        Person kiran = new Person("1054", "Kiran");
        Person elena = new Person("1055", "Elena");


        Major majorPhysics = new Major("Physics", 30);
        Major majorEngineering = new Major("Engineering", 30);


        Student alexStudent = new Student(1, 405, 1);
        Student johnStudent = new Student(2, 405, 1);
        Student lisaStudent = new Student(3, 404, 2);


        System.out.println("Students:");
        for (Student s : Student.studentList) {
            System.out.println(Person.findByID(s.personID).name + "  " + s.studentID);
        }


        Professor martinProf = new Professor(6, 1);
        Professor simonProf = new Professor(7, 2);


        System.out.println("\nProfessors:");
        for (Professor p : Professor.professorList) {
            System.out.println(Professor.findByID(p.id) + "  ");
        }


        Course physics1 = new Course("Physics I", 4);
        Course chemistry = new Course("Chemistry", 4);
        Course engineeringBasics = new Course("Engineering Basics", 3);


        PresentedCourse physics1Present = new PresentedCourse(1, martinProf.id, 12);
        PresentedCourse chemistryPresent = new PresentedCourse(2, martinProf.id, 12);
        PresentedCourse engineeringBasicsPresent = new PresentedCourse(3, simonProf.id, 12);


        physics1Present.addStudent(alexStudent.id);
        physics1Present.addStudent(johnStudent.id);

        chemistryPresent.addStudent(alexStudent.id);
        chemistryPresent.addStudent(johnStudent.id);
        chemistryPresent.addStudent(lisaStudent.id);

        engineeringBasicsPresent.addStudent(alexStudent.id);


        Transcript alexTranscript = new Transcript(alexStudent.id);
        Transcript johnTranscript = new Transcript(johnStudent.id);
        Transcript lisaTranscript = new Transcript(lisaStudent.id);

        alexTranscript.setGrade(1, 18.0);
        alexTranscript.setGrade(2, 16.0);
        alexTranscript.setGrade(3, 16.0);

        johnTranscript.setGrade(1, 14.25);
        johnTranscript.setGrade(2, 15.50);

        lisaTranscript.setGrade(2, 19.0);
        lisaTranscript.setGrade(3, 17.0);


        System.out.println("\nTranscripts:");
        alexTranscript.printTranscript();
        johnTranscript.printTranscript();
        lisaTranscript.printTranscript();


        System.out.println("\nGPA Results:");
        System.out.printf("Alex's GPA: %.2f\n", alexTranscript.getGPA());
        System.out.printf("John's GPA: %.2f\n", johnTranscript.getGPA());
        System.out.printf("Lisa's GPA: %.2f\n", lisaTranscript.getGPA());
    }
}
