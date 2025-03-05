package university;
import base.Person;

import java.util.ArrayList;
public class Professor {

        public int id;
        public static ArrayList<Professor> professorList = new ArrayList<>();
        public int personID;
        public int majorID;
        private static int idCounter = 1;


        public Professor(int personID, int majorID) {
            this.id = professorList.size() + 1;
            this.personID = personID;
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
        public String toString(){
            return "Professor {ID =" + id +
                    ", Major ID =" + majorID + "}";
        }
    }


