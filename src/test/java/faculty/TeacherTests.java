package faculty;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherTests {

    @Test
    public void TeacherClassTest(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        assertEquals("Sarah", teacher.getName());
        assertEquals("Jackson", teacher.getSurname());
        assertEquals("sarahjackson@gmail.com", teacher.getEmail());
    }

    @Test
    public void TeacherQualifySubjectTest(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        teacher.qualifySubject(Subject.Physics);
        teacher.qualifySubject(Subject.Maths);
        assertEquals(Arrays.asList(Subject.Physics, Subject.Maths), teacher.getQualifiedSubjects());
    }

    @Test
    public void TeacherQualifiedForSubjectTest(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        teacher.qualifySubject(Subject.Physics);
        teacher.qualifySubject(Subject.Maths);
        assertEquals(true, teacher.isQualified(Subject.Maths));
    }

    @Test
    public void TeacherUnqualifiedForSubjectTest(){
        Teacher teacher = new Teacher("Sarah", "Jackson", "sarahjackson@gmail.com");
        teacher.qualifySubject(Subject.Physics);
        teacher.qualifySubject(Subject.Maths);
        assertEquals(false, teacher.isQualified(Subject.English));
    }
}

