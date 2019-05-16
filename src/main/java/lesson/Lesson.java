package lesson;

import faculty.Student;
import faculty.Subject;
import faculty.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Lesson implements Classroom {

    private Teacher teacher;
    private String time;
    private Subject subject;
    List<Student> students = new ArrayList<Student>();


    public Lesson(Teacher teacher, String time, Subject subject){
        if(teacher.isQualified(subject)){
            this.teacher = teacher;
            this.time = time;
            this.subject = subject;
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

    public List getStudentList() {
        return students;
    }

    public int totalstudents(){
        return students.size();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }
}
