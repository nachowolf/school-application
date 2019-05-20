package faculty;


import java.text.Collator;
import java.util.*;

public class Student implements Person{

    private String name;
    private String surname;
    private String email;
    private List<Subject> subjects = new ArrayList<Subject>();
    private Map<String, Subject> timetable = new TreeMap<String, Subject>();

    public Student(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

//    Return the students name
    public String getName() {
        return this.name;
    }

//    return the students surname
    public String getSurname() {
        return this.surname;
    }

//    returns the students email address
    public String getEmail() {
        return this.email;
    }

//    adds registers a student for a subject
    public void addSubject(Subject subject){
        subjects.add(subject);
    }

//    returns the all subjects a student is registered for
    public List getSubjects(){
        return subjects;
    }

//    returns how many subjects a student has
    public int getTotalSubjects(){
        return subjects.size();
    }

//    removes a subject from a student
    public void removeSubject(Subject subject){
        subjects.remove(subject);
    }

//    prints students name when sysout object
    public String toString(){
        return this.name;
    }

//    returns a boolean if a student has that subject
    public boolean checkSubject(Subject subject){
        if(subjects.contains(subject)){
            return true;
        }
        else{
            return false;
        }
    }

//    adds a lesson subject and time to student
    public void addLesson(String time, Subject subject){
        for(Map.Entry<String, Subject> lesson : timetable.entrySet()){
            String lessonTime = lesson.getKey();
            Subject lessonSubject = lesson.getValue();
            if(lessonSubject != subject && lessonTime != time){
                timetable.put(time, subject);
            }
            else if(lessonTime != time){
                timetable.put(time, subject);
            }
        }
    }

//    checks whether a student is available to attend a lesson
    public boolean checkLesson(String time){
        for(Map.Entry<String, Subject> lesson : timetable.entrySet()){
            String lessonTime = lesson.getKey();
            if(lessonTime != time){
                return true;
            }
            }
        return false;
        }

//     removes a lesson from student timetable
    public void removeLesson(String time){
        timetable.remove(time);

    }

}
