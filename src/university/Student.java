package university;
import java.util.ArrayList;



    public class Student {
        public int id;
        public static ArrayList<Student> studentList = new ArrayList<>();
        public int personID;
        public final int entranceYear;
        public int majorID;
        public String studentID;

        public Student(int personID, int entranceYear, int majorID) {
            this.id = studentList.size() + 1;
            this.personID = personID;
            this.entranceYear = entranceYear;
            this.majorID = majorID;
            setStudentCode();
            studentList.add(this);
        }

        public static Student findByID(int id) {
            for (Student student : studentList) {
                if (student.id == id) {
                    return student;
                }
            }
            return null;
        }

        public void setStudentCode() {
            Major major = Major.findByID(this.majorID);

            if (major == null) {
                System.out.println("Major not found!");
                return;
            }

            this.studentID = String.format("%d%02d%02d", entranceYear, majorID, id);
        }
    }


