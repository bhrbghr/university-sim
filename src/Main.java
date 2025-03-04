import base.Person;
import university.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Creating Persons
        Person alex = new Person("Alex", "1051");
        Person john = new Person("John", "1052");
        Person lisa = new Person("Lisa", "1053");
        Person kiran = new Person("Kiran", "1054");
        Person elena = new Person("Elena", "1055");

        // Creating Majors
        Major majorPhysics = new Major("Physics", 30);
        Major majorEngineering = new Major("Engineering", 30);

        // Creating Students
        Student alexStudent = new Student(1, 405, 1);
        Student johnStudent = new Student(2, 405, 1);
        Student lisaStudent = new Student(3, 404, 2);

        // Displaying Students
        System.out.println("Students:");
        for (Student s : Student.studentList) {
            System.out.println(Person.findByID(s.personID).name + "  " + s.studentID);
        }

        // Creating Professors
        Professor martinProf = new Professor(6, 1);
        Professor simonProf = new Professor(7, 2);

        // Displaying Professors
        System.out.println("\nProfessors:");
        for (Professor p : Professor.professorList) {
            System.out.println(Person.findByID(p.personID).name + "  " + p.id);
        }

        // Creating Courses
        Course physics1 = new Course("Physics I", 4);
        Course chemistry = new Course("Chemistry", 4);
        Course engineeringBasics = new Course("Engineering Basics", 3);

        // Creating Presented Courses
        PresentedCourse physics1Present = new PresentedCourse(4, 1, 12);
        PresentedCourse chemistryPresent = new PresentedCourse(5, 1, 12);
        PresentedCourse engineeringBasicsPresent = new PresentedCourse(6, 2, 12);

        // Adding Students to Courses
        physics1Present.addStudent(1);
        physics1Present.addStudent(2);
        chemistryPresent.addStudent(1);
        chemistryPresent.addStudent(2);
        chemistryPresent.addStudent(3);
        engineeringBasicsPresent.addStudent(3);

        // Creating Transcripts and Adding Grades
        Transcript alexTranscript = new Transcript(1);
        Transcript johnTranscript = new Transcript(2);
        Transcript lisaTranscript = new Transcript(3);

        alexTranscript.setGrade(4, 18.0);
        alexTranscript.setGrade(5, 16.0);
        johnTranscript.setGrade(4, 14.25);
        johnTranscript.setGrade(5, 15.50);
        lisaTranscript.setGrade(5, 19.0);
        lisaTranscript.setGrade(6, 17.0);

        // Displaying Transcripts
        System.out.println("\nTranscripts:");
        alexTranscript.printTranscript();
        johnTranscript.printTranscript();
        lisaTranscript.printTranscript();

        // Displaying GPAs
        System.out.println("\nGPA Results:");
        System.out.printf("Alex's GPA: %.2f\n", alexTranscript.getGPA());
        System.out.printf("John's GPA: %.2f\n", johnTranscript.getGPA());
        System.out.printf("Lisa's GPA: %.2f\n", lisaTranscript.getGPA());
    }
}
