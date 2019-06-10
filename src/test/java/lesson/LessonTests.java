package lesson;

import com.github.javafaker.Faker;
import faculty.Student;
import faculty.Subject;
import faculty.Teacher;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LessonTests {



    public static Teacher createTeacher(){
        Faker person = new Faker();
        String[] hold = person.funnyName().name().split(" ");
        String name = hold[0];
        String surname = hold[1];
        String email = name.toLowerCase() + surname.toLowerCase() + "@gmail.com";
        Teacher mockTeacher = new Teacher(name, surname, email);
        return mockTeacher;
    }

    public static Student createStudent(){
        Faker person = new Faker();
        String[] hold = person.funnyName().name().split(" ");
        String name = hold[0];
        String surname = hold[1];
        String email = name.toLowerCase() + surname.toLowerCase() + "@gmail.com";
        Student mock = new Student(name, surname, email);
        return mock;
    }



    @Test
    public void CreateLessonTest() {
        Teacher teacher = createTeacher();
        Teacher spyTeacher = Mockito.spy(teacher);

        spyTeacher.qualifySubject(Subject.Maths);
        Mockito.verify(spyTeacher).qualifySubject(Subject.Maths);

        Lesson mathLesson = new Lesson(teacher, Subject.Maths, "10:00");
        Lesson spyLesson = Mockito.spy(mathLesson);
        assertEquals("10:00", spyLesson.getTime());
        assertEquals(Subject.Maths, spyLesson.getSubject());
    }

    @Test
    public void AddStudentTest(){
        Teacher teacher = createTeacher();
        Teacher spyTeacher = Mockito.spy(teacher);

        spyTeacher.qualifySubject(Subject.Maths);
        Mockito.verify(spyTeacher).qualifySubject(Subject.Maths);

        Lesson mathLesson = new Lesson(teacher, Subject.Maths, "10:00");

        //### Student 1 ###
        Student student1 = createStudent();
        Student spyStudent1 = Mockito.spy(student1);

        spyStudent1.addSubject(Subject.Maths);
        Mockito.verify(spyStudent1).addSubject(Subject.Maths);

        spyStudent1.addSubject(Subject.Physics);
        Mockito.verify(spyStudent1).addSubject(Subject.Physics);

        spyStudent1.addSubject(Subject.English);
        Mockito.verify(spyStudent1).addSubject(Subject.English);

        //### Student 2 ###
        Student student2 = createStudent();
        Student spyStudent2 = Mockito.spy(student2);

        spyStudent2.addSubject(Subject.Maths);
        Mockito.verify(spyStudent2).addSubject(Subject.Maths);

        spyStudent2.addSubject(Subject.Art);
        Mockito.verify(spyStudent2).addSubject(Subject.Art);

        spyStudent2.addSubject(Subject.Business);
        Mockito.verify(spyStudent2).addSubject(Subject.Business);

       assertEquals(true, mathLesson.addStudent(spyStudent1));
       assertEquals(true,  mathLesson.addStudent(spyStudent2));

        assertEquals(2, mathLesson.totalStudents());
    }

    @Test
    public void ShouldNotAddStudentIfAlreadyInLessonTest(){
        Teacher teacher = createTeacher();
        Teacher spyTeacher = Mockito.spy(teacher);

        spyTeacher.qualifySubject(Subject.Maths);
        Mockito.verify(spyTeacher).qualifySubject(Subject.Maths
        );
        Lesson mathLesson = new Lesson(teacher, Subject.Maths, "10:00");

        //### Student 1 ###
        Student student1 = createStudent();
        Student spyStudent1 = Mockito.spy(student1);

        spyStudent1.addSubject(Subject.Maths);
        Mockito.verify(spyStudent1).addSubject(Subject.Maths);

        spyStudent1.addSubject(Subject.Physics);
        Mockito.verify(spyStudent1).addSubject(Subject.Physics);

        spyStudent1.addSubject(Subject.English);
        Mockito.verify(spyStudent1).addSubject(Subject.English);

        //### Student 2 ###
        Student student2 = createStudent();
        Student spyStudent2 = Mockito.spy(student2);

        spyStudent2.addSubject(Subject.Maths);
        Mockito.verify(spyStudent2).addSubject(Subject.Maths);

        spyStudent2.addSubject(Subject.Art);
        Mockito.verify(spyStudent2).addSubject(Subject.Art);

        spyStudent2.addSubject(Subject.Business);
        Mockito.verify(spyStudent2).addSubject(Subject.Business);

        assertEquals(true, mathLesson.addStudent(spyStudent1));
        assertEquals(true,  mathLesson.addStudent(spyStudent2));

        assertEquals(false, mathLesson.addStudent(spyStudent1));
        assertEquals(false,  mathLesson.addStudent(spyStudent2));

        assertEquals(2, mathLesson.totalStudents());
    }

    @Test
    public void ShouldNotAddStudentWithLessonsAtTheSameTimeTest(){
        Teacher teacherMath = createTeacher();
        Teacher spyTeacherMath = Mockito.spy(teacherMath);

        spyTeacherMath.qualifySubject(Subject.Maths);
        Mockito.verify(spyTeacherMath).qualifySubject(Subject.Maths);

        Lesson mathLesson = new Lesson(spyTeacherMath, Subject.Maths, "10:00");

        Teacher teacherEng = createTeacher();
        Teacher spyTeacherEng = Mockito.spy(teacherEng);

        spyTeacherEng.qualifySubject(Subject.English);
        Mockito.verify(spyTeacherEng).qualifySubject(Subject.English);
        Lesson englishLesson = new Lesson(spyTeacherEng, Subject.English, "10:00");

        Student student = createStudent();
        Student spyStudent = Mockito.spy(student);

        spyStudent.addSubject(Subject.Maths);
        Mockito.verify(spyStudent).addSubject(Subject.Maths);

        spyStudent.addSubject(Subject.Physics);
        Mockito.verify(spyStudent).addSubject(Subject.Physics);

        spyStudent.addSubject(Subject.English);
        Mockito.verify(spyStudent).addSubject(Subject.English);

        assertEquals(true, mathLesson.addStudent(spyStudent));
        assertEquals(false, englishLesson.addStudent(spyStudent));

    }

    @Test
    public void CheckLessonStatus(){
        Teacher teacher = createTeacher();
        Teacher spyTeacher = Mockito.spy(teacher);

        spyTeacher.qualifySubject(Subject.Maths);

        Lesson mathLesson = new Lesson(teacher, Subject.Maths, "10:00");

        Student student1 = createStudent();
        Student spyStudent1 = Mockito.spy(student1);

        spyStudent1.addSubject(Subject.Maths);
        Mockito.verify(spyStudent1).addSubject(Subject.Maths);

        spyStudent1.addSubject(Subject.Physics);
        Mockito.verify(spyStudent1).addSubject(Subject.Physics);

        spyStudent1.addSubject(Subject.English);
        Mockito.verify(spyStudent1).addSubject(Subject.English);

        Student student2 = createStudent();
        Student spyStudent2 = Mockito.spy(student2);

        spyStudent2.addSubject(Subject.Maths);
        Mockito.verify(spyStudent2).addSubject(Subject.Maths);

        spyStudent2.addSubject(Subject.Physics);
        Mockito.verify(spyStudent2).addSubject(Subject.Physics);

        spyStudent2.addSubject(Subject.English);
        Mockito.verify(spyStudent2).addSubject(Subject.English);

        Student student3 = createStudent();
        Student spyStudent3 = Mockito.spy(student3);

        spyStudent3.addSubject(Subject.Maths);
        Mockito.verify(spyStudent3).addSubject(Subject.Maths);

        spyStudent3.addSubject(Subject.Physics);
        Mockito.verify(spyStudent3).addSubject(Subject.Physics);

        spyStudent3.addSubject(Subject.English);
        Mockito.verify(spyStudent3).addSubject(Subject.English);

        Student student4 = createStudent();
        Student spyStudent4 = Mockito.spy(student4);

        spyStudent4.addSubject(Subject.Maths);
        Mockito.verify(spyStudent4).addSubject(Subject.Maths);

        spyStudent4.addSubject(Subject.Physics);
        Mockito.verify(spyStudent4).addSubject(Subject.Physics);

        spyStudent4.addSubject(Subject.English);
        Mockito.verify(spyStudent4).addSubject(Subject.English);

        Student student5 = createStudent();
        Student spyStudent5 = Mockito.spy(student5);

        spyStudent5.addSubject(Subject.Maths);
        Mockito.verify(spyStudent5).addSubject(Subject.Maths);

        spyStudent5.addSubject(Subject.Physics);
        Mockito.verify(spyStudent5).addSubject(Subject.Physics);

        spyStudent5.addSubject(Subject.English);
        Mockito.verify(spyStudent5).addSubject(Subject.English);

        assertEquals(true, mathLesson.addStudent(spyStudent1));
        assertEquals(true,  mathLesson.addStudent(spyStudent2));
        assertEquals(true,  mathLesson.addStudent(spyStudent3));
        assertEquals(true,  mathLesson.addStudent(spyStudent4));
        assertEquals(true,  mathLesson.addStudent(spyStudent5));

        assertEquals(5, mathLesson.totalStudents());
        assertEquals("Started", mathLesson.lessonStatus());

    }

    @Test
    public void RemoveStudentFromLesson(){
        Teacher teacher = createTeacher();
        Teacher spyTeacher = Mockito.spy(teacher);

        spyTeacher.qualifySubject(Subject.Maths);
        Lesson mathLesson = new Lesson(teacher, Subject.Maths, "10:00");

        Student student1 = createStudent();
        Student spyStudent1 = Mockito.spy(student1);

        spyStudent1.addSubject(Subject.Maths);
        Mockito.verify(spyStudent1).addSubject(Subject.Maths);

        spyStudent1.addSubject(Subject.Physics);
        Mockito.verify(spyStudent1).addSubject(Subject.Physics);

        spyStudent1.addSubject(Subject.English);
        Mockito.verify(spyStudent1).addSubject(Subject.English);

        Student student2 = createStudent();
        Student spyStudent2 = Mockito.spy(student2);

        spyStudent2.addSubject(Subject.Maths);
        Mockito.verify(spyStudent2).addSubject(Subject.Maths);

        spyStudent2.addSubject(Subject.Physics);
        Mockito.verify(spyStudent2).addSubject(Subject.Physics);

        spyStudent2.addSubject(Subject.English);
        Mockito.verify(spyStudent2).addSubject(Subject.English);

        Student student3 = createStudent();
        Student spyStudent3 = Mockito.spy(student3);

        spyStudent3.addSubject(Subject.Maths);
        Mockito.verify(spyStudent3).addSubject(Subject.Maths);

        spyStudent3.addSubject(Subject.Physics);
        Mockito.verify(spyStudent3).addSubject(Subject.Physics);

        spyStudent3.addSubject(Subject.English);
        Mockito.verify(spyStudent3).addSubject(Subject.English);

        Student student4 = createStudent();
        Student spyStudent4 = Mockito.spy(student4);

        spyStudent4.addSubject(Subject.Maths);
        Mockito.verify(spyStudent4).addSubject(Subject.Maths);

        spyStudent4.addSubject(Subject.Physics);
        Mockito.verify(spyStudent4).addSubject(Subject.Physics);

        spyStudent4.addSubject(Subject.English);
        Mockito.verify(spyStudent4).addSubject(Subject.English);

        Student student5 = createStudent();
        Student spyStudent5 = Mockito.spy(student5);

        spyStudent5.addSubject(Subject.Maths);
        Mockito.verify(spyStudent5).addSubject(Subject.Maths);

        spyStudent5.addSubject(Subject.Physics);
        Mockito.verify(spyStudent5).addSubject(Subject.Physics);

        spyStudent5.addSubject(Subject.English);
        Mockito.verify(spyStudent5).addSubject(Subject.English);

        assertEquals(true, mathLesson.addStudent(spyStudent1));
        assertEquals(true,  mathLesson.addStudent(spyStudent2));
        assertEquals(true,  mathLesson.addStudent(spyStudent3));
        assertEquals(true,  mathLesson.addStudent(spyStudent4));
        assertEquals(true,  mathLesson.addStudent(spyStudent5));


        assertEquals(5, mathLesson.totalStudents());
        assertEquals("Started", mathLesson.lessonStatus());

        mathLesson.removeStudent(spyStudent3);

        assertEquals(4, mathLesson.totalStudents());
        assertEquals("Cancelled", mathLesson.lessonStatus());

    }

    @Test
    public void returnListOfStudents(){
        Teacher teacher = createTeacher();
        Teacher spyTeacher = Mockito.spy(teacher);

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
