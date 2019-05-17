package lesson;

import faculty.Student;
import faculty.Subject;
import faculty.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Lesson implements Curriculum {

    private Teacher teacher;
    private String time;
    private Subject subject;
    List<Student> students = new ArrayList<Student>();


    public Lesson(String time, Subject subject){
            this.time = time;
            this.subject = subject;
    }

    public boolean setTeacher(Teacher teacher){
        if(teacher.isQualified(this.subject)){
            this.teacher = teacher;
            return true;
        }
        else{
            return false;
        }
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public String getTime() {
        return this.time;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public boolean addStudent(Student student){
        if(student.getTotalSubjects() >= 3 && student.checkSubject(this.subject)){
            students.add(student);
            return true;
        }
        else {
            return false;
        }
    }

    public List getStudentList() {
        return students;
    }

    public int totalstudents(){
        return students.size();
    }


    public void removeStudent(Student student){
        students.remove(student);
    }
}
