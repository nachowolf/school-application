package lesson;

import faculty.Person;
import faculty.Student;
import faculty.Subject;
import faculty.Teacher;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class LessonTests {


    @Test
    public void CreateLessonTest() {
        Lesson mathLesson = new Lesson("10:00", Subject.Maths);
        assertEquals("10:00",mathLesson.getTime());
        assertEquals(Subject.Maths,mathLesson.getSubject());
    }

    @Test
    public void AddTeacherTest(){
        Teacher teacher = new Teacher("John", "Clark", "johnclark@gmail.com");
        teacher.qualifySubject(Subject.Maths);

        Lesson mathLesson = new Lesson("10:00", Subject.Maths);
        mathLesson.setTeacher(teacher);
        assertEquals("John",mathLesson.getTeacher().getName());
    }

    @Test
    public void AddStudentTest(){
        Teacher teacher = new Teacher("John", "Clark", "johnclark@gmail.com");
        teacher.qualifySubject(Subject.Maths);

        Lesson mathLesson = new Lesson("10:00", Subject.Maths);
        mathLesson.setTeacher(teacher);

        Student sarah = new Student("Sarah", "Langste", "sarahlangste@gmail.com");
        sarah.addSubject(Subject.Maths);
        sarah.addSubject(Subject.Physics);
        sarah.addSubject(Subject.English);

        Student dave = new Student("Dave", "Arma", "davearma@gmail.com");
        dave.addSubject(Subject.Maths);
        dave.addSubject(Subject.Art);
        dave.addSubject(Subject.Business);

        mathLesson.addStudent(sarah);
        mathLesson.addStudent(dave);
    }
}
