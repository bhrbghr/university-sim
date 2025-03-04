import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main{

    public static class Person {
        public int id;
        public String name;
        public String nationalID;
        public static ArrayList<Person> personList = new ArrayList<>();

        public Person(String nationalID, String name) {
            this.nationalID = nationalID;
            this.name = name;
            this.id = personList.size() + 1;
            personList.add(this);
        }

        public static Person findById(int id) {
            for (Person person : personList) {
                if (person.id == id) {
                    return person;
                }
            }
            return null;
        }

        public void displayInfo() {
            System.out.println("Person ID: " + id + ", Name: " + name + ", National ID: " + nationalID);
        }
    }

    public static class Major {
        public int id;
        public String name;
        public int capacity;
        public static ArrayList<Major> majorList = new ArrayList<>();

        public Major(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
            this.id = majorList.size() + 1;
            majorList.add(this);
        }

        public static Major findById(int id) {
            for (Major major : majorList) {
                if (major.id == id) {
                    return major;
                }
            }
            return null;
        }

        public void displayInfo() {
            System.out.println("Major ID: " + id + ", Name: " + name + ", Capacity: " + capacity);
        }
    }

    public static class Professor {
        public int id;
        public int personID;  // ارجاع به Person
        public int majorID;   // ارجاع به Major
        public static ArrayList<Professor> professorList = new ArrayList<>();

        public Professor(int personID, int majorID) {
            this.personID = personID;
            this.majorID = majorID;
            this.id = professorList.size() + 1;
            professorList.add(this);
        }

        public static Professor findById(int id) {
            for (Professor professor : professorList) {
                if (professor.id == id) {
                    return professor;
                }
            }
            return null;
        }

        public void displayInfo() {
            Person person = Person.findById(personID);
            Major major = Major.findById(majorID);
            if (person != null && major != null) {
                person.displayInfo();
                System.out.println("Professor Major: " + major.name);
            }
        }
    }

    public static class Student {
        public int id;
        public int personID;
        public int majorID;
        public static ArrayList<Student> studentList = new ArrayList<>();

        public Student(int personID, int majorID) {
            this.personID = personID;
            this.majorID = majorID;
            this.id = studentList.size() + 1;
            studentList.add(this);
        }

        public static Student findById(int id) {
            for (Student student : studentList) {
                if (student.id == id) {
                    return student;
                }
            }
            return null;
        }

        public void displayInfo() {
            Person person = Person.findById(personID);
            Major major = Major.findById(majorID);
            if (person != null && major != null) {
                person.displayInfo();
                System.out.println("Student Major: " + major.name);
            }
        }
    }

    public static class Course {
        public int id;
        public String title;
        public int units;
        public static ArrayList<Course> courseList = new ArrayList<>();

        public Course(String title, int units) {
            this.title = title;
            this.units = units;
            this.id = courseList.size() + 1;
            courseList.add(this);
        }

        public static Course findById(int id) {
            for (Course course : courseList) {
                if (course.id == id) {
                    return course;
                }
            }
            return null;
        }

        public void displayInfo() {
            System.out.println("Course ID: " + id + ", Title: " + title + ", Units: " + units);
        }
    }

    public static class Transcript {
        public int studentID;
        public HashMap<Integer, Double> grades = new HashMap<>();

        public Transcript(int studentID) {
            this.studentID = studentID;
        }

        public void setGrade(int courseID, double grade) {
            grades.put(courseID, grade);
        }

        public void printTranscript() {
            System.out.println("Transcript for Student ID: " + studentID);
            for (Integer courseID : grades.keySet()) {
                System.out.println("Course ID: " + courseID + " - Grade: " + grades.get(courseID));
            }
        }

        public double getGPA() {
            double totalGrades = 0;
            int courseCount = grades.size();
            for (Double grade : grades.values()) {
                totalGrades += grade;
            }
            return (courseCount > 0) ? totalGrades / courseCount : 0.0;
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person("123456789", "Ali");
        Person person2 = new Person("987654321", "Sara");

        Major major1 = new Major("Computer Science", 100);
        Major major2 = new Major("Math", 80);

        Professor professor1 = new Professor(person1.id, major1.id);
        Professor professor2 = new Professor(person2.id, major2.id);

        Student student1 = new Student(person1.id, major1.id);
        Student student2 = new Student(person2.id, major2.id);

        Course course1 = new Course("Introduction to Programming", 3);
        Course course2 = new Course("Circuit Analysis", 4);

        Transcript transcript1 = new Transcript(student1.id);
        transcript1.setGrade(course1.id, 85);
        transcript1.setGrade(course2.id, 90);

        professor1.displayInfo();
        professor2.displayInfo();

        student1.displayInfo();
        student2.displayInfo();

        course1.displayInfo();
        course2.displayInfo();

        transcript1.printTranscript();
        System.out.println("GPA: " + transcript1.getGPA());
    }
}
