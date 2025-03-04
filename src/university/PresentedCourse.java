package university;
import java.util.ArrayList;
public class PresentedCourse {

        public int id;
        public int courseID;
        public int professorID;
        public int capacity;
        public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
        public ArrayList<Integer> studentIds = new ArrayList<>();


        public PresentedCourse(int courseID, int professorID, int maxCapacity) {
            this.id = presentedCourseList.size() + 1;
            this.courseID = courseID;
            this.professorID = professorID;
            this.capacity = maxCapacity;
            presentedCourseList.add(this);
        }

        public static PresentedCourse findByID(int id) {
            for (PresentedCourse presentedCourse : presentedCourseList) {
                if (presentedCourse.id == id) {
                    return presentedCourse;
                }
            }
            return null;
        }


        public void addStudent(int studentID) {
            if (studentIds.size() < capacity) {
                studentIds.add(studentID);
            } else {
                System.out.println("Course is full. Student cannot be added.");
            }
        }


        public void printStudents() {
            System.out.println("Students in Presented Course ID " + id + ":");
            for (int studentID : studentIds) {
                System.out.println("Student ID: " + studentID);
            }
        }
}


