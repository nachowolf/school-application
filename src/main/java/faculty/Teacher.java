package faculty;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements Person {

    private String name;
    private String surname;
    private String email;
    List<Subject> qualified = new ArrayList<Subject>();

    public Teacher(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    public void qualifySubject(Subject subject){
        qualified.add(subject);
    }

    public List getQualifiedSubjects(){
        return qualified;
    }

    public String toString(){
        return this.name;
    }

    public boolean isQualified(Subject subject){
        if(qualified.contains(subject)){
            return true;
        }
        else{
            return false;
        }
    }
}
