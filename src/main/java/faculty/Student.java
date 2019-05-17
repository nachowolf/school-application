package faculty;


import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class Student implements Person{

    private String name;
    private String surname;
    private String email;
    private List<Subject> subjects = new ArrayList<Subject>();

    public Student(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEmail() {
        return this.email;
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public List getSubjects(){
        return subjects;
    }

    public int getTotalSubjects(){
        return subjects.size();
    }

    public void removeSubject(Subject subject){
        subjects.remove(subject);
    }
    public String toString(){
        return this.name;
    }

    public boolean checkSubject(Subject subject){
        if(subjects.contains(subject)){
            return true;
        }
        else{
            return false;
        }
    }

}
