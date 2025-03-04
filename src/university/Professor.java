package university;
import java.util.ArrayList;
public class Professor {

        public int id;
        public static ArrayList<Professor> professorList = new ArrayList<>();
        public int personID;
        public int majorID;


        public Professor(int personID, int majorID) {
            this.id = professorList.size() + 1;
            this.majorID = majorID;
            professorList.add(this);
        }

        public static Professor findByID(int id) {
            for (Professor professor : professorList) {
                if (professor.id == id) {
                    return professor;
                }
            }
            return null;
        }
    }


