package lesson;

import faculty.NoteSource;
import faculty.Student;
import faculty.Subject;
import faculty.Teacher;


import java.util.ArrayList;
import java.util.List;

import static lesson.LessonStatus.*;

public class Lesson implements Curriculum {

    private Teacher teacher;
    private String time;
    private Subject subject;
    List<Student> students = new ArrayList<Student>();
    private LessonStatus status = Pending;


    //############# Constructor #############
    public Lesson(Teacher teacher,Subject subject, String time){
        if(teacher.isQualified(subject)){
            this.teacher = teacher;
            this.time = time;
            this.subject = subject;
        }
        else{
            status = Cancelled;
        }

    }
    //#######################################

//    ########## LESSON IDENTITY METHODS ##########

    public Teacher getTeacher() {
        return this.teacher;
    }

    public String getTime() {
        return this.time;
    }

    public Subject getSubject() {
        return this.subject;
    }

//    ##############################################


//    ########## STUDENT LESSON REGISTRY METHODS ##########

//    ADD STUDENT TO LESSON
    public boolean addStudent(Student student){
        if(student.getTotalSubjects() >= 3 && student.checkSubject(this.subject) && !student.checkLesson(this.time) && !students.contains(student)){
            students.add(student);
            student.addLesson(this.time, this.subject);
            student.deposit(3);
            student.receiveNotes(this.subject, NoteSource.Attended);
            if(students.size() >= 5){
                this.status = Started;
                teacher.depositTokens(5);
            }
            else{
                this.status = Cancelled;
            }
            return true;
        }
        else {
            return false;
        }
    }

//    RETURN LIST OF ALL STUDENTS IN LESSON
    public List getStudentList() {
        return students;
    }

//    RETURN TOTAL AMOUNT OF STUDENTS IN LESSON
    public int totalStudents(){
        return students.size();
    }

//    REMOVE STUDENT FROM LESSON
    public void removeStudent(Student student){
        students.remove(student);
        student.removeLesson(time);
        student.withdraw(3);
        student.removeNotes(this.subject, NoteSource.Attended);
        if(students.size() <= 5) {
            this.status = Cancelled;
            teacher.withdrawTokens(5);
        }
    }

//    #####################################################

//    ########## LESSON METHODS ##########

//    RETURN THE STATUS OF LESSON
    public String lessonStatus(){
        return this.status.toString();
    }

//    ####################################
}
