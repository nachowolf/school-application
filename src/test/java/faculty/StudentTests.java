package faculty;

import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTests {

    @Test
   public void StudentClassTest(){
        Student student = new Student("John", "Doe", "johndoe@gmail.com");
        assertEquals("John", student.getName());
        assertEquals("Doe", student.getSurname());
        assertEquals("johndoe@gmail.com", student.getEmail());
    }

    @Test
    public void StudentAddSubjectsTest(){
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        student.addSubject(Subject.English);
        student.addSubject(Subject.Maths);
        assertEquals(Arrays.asList(Subject.English, Subject.Maths), student.getSubjects());
    }

    @Test
    public void StudentReturnCountOfAllSubjectsTest(){
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        student.addSubject(Subject.English);
        student.addSubject(Subject.Maths);
        student.addSubject(Subject.Art);
        student.addSubject(Subject.Biology);
        assertEquals(4, student.getTotalSubjects());
    }

    @Test
    public void StudentRemoveSubjectTest() {
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        student.addSubject(Subject.English);
        student.addSubject(Subject.Maths);
        student.addSubject(Subject.Art);
        student.addSubject(Subject.Biology);
        assertEquals(4, student.getTotalSubjects());
        student.removeSubject(Subject.Art);
        assertEquals(3, student.getTotalSubjects());
    }

}
