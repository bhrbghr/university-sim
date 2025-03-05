package university;
import java.util.HashMap;

public class Transcript {

        public int studentID;
        public HashMap<Integer, Double> transcript = new HashMap<>();

        public Transcript(int studentID) {
            this.studentID = studentID;
        }

        public void setGrade(int presentedCourseID, double grade) {
            transcript.put(presentedCourseID, grade);
        }

        public void printTranscript() {
            System.out.println("Transcript for Student ID: " + studentID);

            for (Integer courseID : transcript.keySet()) {
                double grade = transcript.get(courseID);
                PresentedCourse course = PresentedCourse.findByID(courseID);
                System.out.println();
                System.out.println(course.courseID);
                Course courseDetails = Course.findByID(course.courseID);

                if (course != null && courseDetails != null) {
                    System.out.println("Course: " + courseDetails.title + " (Units: " + courseDetails.units + ") - Grade: " + grade);
                }
            }
        }

    public double getGPA() {
        double totalGrades = 0.0;
        int courseCount = 0;

        for (double grade : transcript.values()) {
            totalGrades += grade;
            courseCount++;
        }

        if (courseCount > 0) {
            return totalGrades / courseCount;
        } else {
            return 0.0;
        }
    }

}



