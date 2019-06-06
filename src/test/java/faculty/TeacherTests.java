package faculty;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeacherTests {

    //##########| CONSTRUCTOR TESTS |##########
    @Test
    @Order(1)
    public void TeacherClassTest(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        assertEquals("Sarah", teacher.getName());
        assertEquals("Jackson", teacher.getSurname());
        assertEquals("sarahjackson@gmail.com", teacher.getEmail());

            Faker fakeTeacher = new Faker();
            String[] hold = fakeTeacher.funnyName().name().split(" ");
            String name = hold[0];
            String surname = hold[1];
            String email = name.toLowerCase() + surname.toLowerCase() + "@gmail.com";

            Teacher student2 = new Teacher(name, surname,email);
            assertEquals(name ,student2.getName());
            assertEquals(surname ,student2.getSurname());
            assertEquals(email ,student2.getEmail());

    }

        //#########################################


//    ##########| TEACHER QUALIFICATION TESTS |#########
    @Test
    @Order(2)
    public void TeacherQualifySubjectTest(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        teacher.qualifySubject(Subject.Physics);
        teacher.qualifySubject(Subject.Maths);
        assertEquals(Arrays.asList(Subject.Physics, Subject.Maths), teacher.getQualifiedSubjects());
    }

    @Test
    @Order(3)
    public void TeacherQualifiedForSubjectTest(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        teacher.qualifySubject(Subject.Physics);
        teacher.qualifySubject(Subject.Maths);
        assertEquals(true, teacher.isQualified(Subject.Maths));
    }

    @Test
    @Order(4)
    public void TeacherUnqualifiedForSubjectTest(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        teacher.qualifySubject(Subject.Physics);
        teacher.qualifySubject(Subject.Maths);
        assertEquals(false, teacher.isQualified(Subject.English));
    }
    //    ###############################################

//    ##########| TEACHER LESSON TESTS |##########
    @Test
    @Order(5)
    public void AddLessonToTeacher(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        teacher.qualifySubject(Subject.Maths);
        teacher.addLesson("10:30", Subject.Maths);
        assertEquals(true, teacher.checkLesson("10:30"));
    }

    @Test
    @Order(6)
    public void AddLessonToTeacherNotQualifiedToTeachLesson(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        teacher.addLesson("10:30", Subject.Maths);
        assertEquals(false, teacher.checkLesson("10:30"));
    }

    @Test
    @Order(7)
    public void RemoveLessonFromTeacherUsingTime(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        teacher.qualifySubject(Subject.Maths);
        teacher.addLesson("10:30", Subject.Maths);
        assertEquals(true, teacher.checkLesson("10:30"));
        teacher.removeLesson("10:30");
    }

    @Test
    @Order(8)
    public void AllTeacherLessonsTest(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        teacher.qualifySubject(Subject.Maths);
        teacher.addLesson("10:30", Subject.Maths);
        teacher.addLesson("11:30", Subject.Maths);
        teacher.addLesson("9:30", Subject.Maths);
        assertEquals(true, teacher.checkLesson("9:30"));
        assertEquals(Arrays.asList("9:30 : Maths", "10:30 : Maths", "11:30 : Maths"), teacher.allLessons());
    }


    //    ############################################
}

