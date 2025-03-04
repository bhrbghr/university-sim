package base;
import java.util.ArrayList;

public class Person {
        public int id;
        public String name;
        public String nationalID;
        public static ArrayList<Person> personList = new ArrayList<>();

        public Person(String nationalID, String name) {
            this.id = personList.size() + 1;
            this.name = name;
            this.nationalID = nationalID;
            personList.add(this);
        }

        public static Person findByID(int id) {
            for (Person p : personList) {
                if (p.id == id) {
                    return p;
                }
            }
            return null;
        }
    }


