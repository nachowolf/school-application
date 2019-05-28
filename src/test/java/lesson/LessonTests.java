package lesson;

import faculty.Student;
import faculty.Subject;
import faculty.Teacher;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LessonTests {


    @Test
    public void CreateLessonTest() {
        Teacher teacher = new Teacher("John", "Clark", "johnclark@gmail.com");
        teacher.qualifySubject(Subject.Maths);
        Lesson mathLesson = new Lesson(teacher, Subject.Maths, "10:00");
        assertEquals("10:00",mathLesson.getTime());
        assertEquals(Subject.Maths,mathLesson.getSubject());
    }

    @Test
    public void AddStudentTest(){
        Teacher teacher = new Teacher("John", "Clark", "johnclark@gmail.com");
        teacher.qualifySubject(Subject.Maths);
        Lesson mathLesson = new Lesson(teacher, Subject.Maths, "10:00");

        Student sarah = new Student("Sarah", "Langste", "sarahlangste@gmail.com");
        sarah.addSubject(Subject.Maths);
        sarah.addSubject(Subject.Physics);
        sarah.addSubject(Subject.English);

        Student dave = new Student("Dave", "Arma", "davearma@gmail.com");
        dave.addSubject(Subject.Maths);
        dave.addSubject(Subject.Art);
        dave.addSubject(Subject.Business);

       assertEquals(true, mathLesson.addStudent(sarah));
       assertEquals(true,  mathLesson.addStudent(dave));

        assertEquals(2, mathLesson.totalStudents());
    }

    @Test
    public void ShouldNotAddStudentIfAlreadyInLessonTest(){
        Teacher teacher = new Teacher("John", "Clark", "johnclark@gmail.com");
        teacher.qualifySubject(Subject.Maths);
        Lesson mathLesson = new Lesson(teacher, Subject.Maths, "10:00");

        Student sarah = new Student("Sarah", "Langste", "sarahlangste@gmail.com");
        sarah.addSubject(Subject.Maths);
        sarah.addSubject(Subject.Physics);
        sarah.addSubject(Subject.English);

        Student dave = new Student("Dave", "Arma", "davearma@gmail.com");
        dave.addSubject(Subject.Maths);
        dave.addSubject(Subject.Art);
        dave.addSubject(Subject.Business);

        assertEquals(true, mathLesson.addStudent(sarah));
        assertEquals(true,  mathLesson.addStudent(dave));

        assertEquals(false, mathLesson.addStudent(sarah));
        assertEquals(false,  mathLesson.addStudent(dave));

        assertEquals(2, mathLesson.totalStudents());
    }

    @Test
    public void ShouldNotAddStudentWithLessonsAtTheSameTimeTest(){
        Teacher mathTeacher = new Teacher("John", "Clark", "johnclark@gmail.com");
        mathTeacher.qualifySubject(Subject.Maths);
        Lesson mathLesson = new Lesson(mathTeacher, Subject.Maths, "10:00");

        Teacher engTeacher = new Teacher("Polly", "Dome", "pollydome@gmail.com");
        engTeacher.qualifySubject(Subject.English);
        Lesson englishLesson = new Lesson(engTeacher, Subject.English, "10:00");

        Student sarah = new Student("Sarah", "Langste", "sarahlangste@gmail.com");
        sarah.addSubject(Subject.Maths);
        sarah.addSubject(Subject.Physics);
        sarah.addSubject(Subject.English);

        assertEquals(true, mathLesson.addStudent(sarah));
        assertEquals(false, englishLesson.addStudent(sarah));

    }

    @Test
    public void CheckLessonStatus(){
        Teacher teacher = new Teacher("John", "Clark", "johnclark@gmail.com");
        teacher.qualifySubject(Subject.Maths);
        Lesson mathLesson = new Lesson(teacher, Subject.Maths, "10:00");

        Student sarah = new Student("Sarah", "Langste", "sarahlangste@gmail.com");
        sarah.addSubject(Subject.Maths);
        sarah.addSubject(Subject.Physics);
        sarah.addSubject(Subject.English);

        Student dave = new Student("Dave", "Arma", "davearma@gmail.com");
        dave.addSubject(Subject.Maths);
        dave.addSubject(Subject.Art);
        dave.addSubject(Subject.Business);

        Student pam = new Student("Pam", "Trueman", "pamtrueman@gmail.com");
        pam.addSubject(Subject.Maths);
        pam.addSubject(Subject.Art);
        pam.addSubject(Subject.Business);

        Student scott = new Student("Scott", "Walker", "scottwalker@gmail.com");
        scott.addSubject(Subject.Maths);
        scott.addSubject(Subject.Art);
        scott.addSubject(Subject.Business);

        Student susan = new Student("Susan", "Bones", "susanbones@gmail.com");
        susan.addSubject(Subject.Maths);
        susan.addSubject(Subject.Art);
        susan.addSubject(Subject.Business);

        assertEquals(true, mathLesson.addStudent(sarah));
        assertEquals(true,  mathLesson.addStudent(dave));
        assertEquals(true,  mathLesson.addStudent(pam));
        assertEquals(true,  mathLesson.addStudent(scott));
        assertEquals(true,  mathLesson.addStudent(susan));

        assertEquals(5, mathLesson.totalStudents());
        assertEquals("continued", mathLesson.lessonStatus());

    }

    @Test
    public void RemoveStudentFromLesson(){
        Teacher teacher = new Teacher("John", "Clark", "johnclark@gmail.com");
        teacher.qualifySubject(Subject.Maths);
        Lesson mathLesson = new Lesson(teacher, Subject.Maths, "10:00");

        Student sarah = new Student("Sarah", "Langste", "sarahlangste@gmail.com");
        sarah.addSubject(Subject.Maths);
        sarah.addSubject(Subject.Physics);
        sarah.addSubject(Subject.English);

        Student dave = new Student("Dave", "Arma", "davearma@gmail.com");
        dave.addSubject(Subject.Maths);
        dave.addSubject(Subject.Art);
        dave.addSubject(Subject.Business);

        Student pam = new Student("Pam", "Trueman", "pamtrueman@gmail.com");
        pam.addSubject(Subject.Maths);
        pam.addSubject(Subject.Art);
        pam.addSubject(Subject.Business);

        Student scott = new Student("Scott", "Walker", "scottwalker@gmail.com");
        scott.addSubject(Subject.Maths);
        scott.addSubject(Subject.Art);
        scott.addSubject(Subject.Business);

        Student susan = new Student("Susan", "Bones", "susanbones@gmail.com");
        susan.addSubject(Subject.Maths);
        susan.addSubject(Subject.Art);
        susan.addSubject(Subject.Business);

        assertEquals(true, mathLesson.addStudent(sarah));
        assertEquals(true,  mathLesson.addStudent(dave));
        assertEquals(true,  mathLesson.addStudent(pam));
        assertEquals(true,  mathLesson.addStudent(scott));
        assertEquals(true,  mathLesson.addStudent(susan));

        assertEquals(5, mathLesson.totalStudents());
        assertEquals("continued", mathLesson.lessonStatus());

        mathLesson.removeStudent(susan);

        assertEquals(4, mathLesson.totalStudents());
        assertEquals("cancelled", mathLesson.lessonStatus());

    }

    @Test
    public void returnListOfStudents(){
        Teacher teacher = new Teacher("John", "Clark", "johnclark@gmail.com");
        teacher.qualifySubject(Subject.Maths);
        Lesson mathLesson = new Lesson(teacher, Subject.Maths, "10:00");

        Student sarah = new Student("Sarah", "Langste", "sarahlangste@gmail.com");
        sarah.addSubject(Subject.Maths);
        sarah.addSubject(Subject.Physics);
        sarah.addSubject(Subject.English);

        Student dave = new Student("Dave", "Arma", "davearma@gmail.com");
        dave.addSubject(Subject.Maths);
        dave.addSubject(Subject.Art);
        dave.addSubject(Subject.Business);

        Student pam = new Student("Pam", "Trueman", "pamtrueman@gmail.com");
        pam.addSubject(Subject.Maths);
        pam.addSubject(Subject.Art);
        pam.addSubject(Subject.Business);

        Student scott = new Student("Scott", "Walker", "scottwalker@gmail.com");
        scott.addSubject(Subject.Maths);
        scott.addSubject(Subject.Art);
        scott.addSubject(Subject.Business);

        Student susan = new Student("Susan", "Bones", "susanbones@gmail.com");
        susan.addSubject(Subject.Maths);
        susan.addSubject(Subject.Art);
        susan.addSubject(Subject.Business);

        assertEquals(true, mathLesson.addStudent(sarah));
        assertEquals(true,  mathLesson.addStudent(dave));
        assertEquals(true,  mathLesson.addStudent(pam));
        assertEquals(true,  mathLesson.addStudent(scott));
        assertEquals(true,  mathLesson.addStudent(susan));

        assertEquals(5, mathLesson.totalStudents());
        assertEquals(Arrays.asList(sarah, dave, pam, scott, susan), mathLesson.getStudentList());
    }
}
