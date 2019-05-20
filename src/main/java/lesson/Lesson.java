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
    private boolean status = false;


    public Lesson(Teacher teacher,Subject subject, String time){
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

    public boolean addStudent(Student student){
        if(student.getTotalSubjects() >= 3 && student.checkSubject(this.subject) && !student.checkLesson(this.time) && !students.contains(student)){
            students.add(student);
            student.addLesson(this.time, this.subject);
            if(students.size() >= 5){
                this.status = true;
            }
            else{
                this.status = false;
            }
            return true;
        }
        else {
            return false;
        }
    }

    public List getStudentList() {
        return students;
    }

    public int totalStudents(){
        return students.size();
    }

    public void removeStudent(Student student){
        students.remove(student);
        student.removeLesson(time);
        if(students.size() >= 5){
            this.status = true;
        }
        else{
            this.status = false;
        }
    }

    public String lessonStatus(){
        if(status){
            return "continued";
        }
        else{
            return "cancelled";
        }
    }
}
