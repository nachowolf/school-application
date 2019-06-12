package faculty;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentTests {

    public static Student createStudent(){
        Faker person = new Faker();
        String[] hold = person.funnyName().name().split(" ");
        String name = hold[0];
        String surname = hold[1];
        String email = name.toLowerCase() + surname.toLowerCase() + "@gmail.com";
        Student mockStudent = new Student(name, surname, email);
        return mockStudent;
    }


//##########| CONSTRUCTOR TESTS |##########

    @Test
    @Order(1)
    public void StudentClassTest() {
        Student student1 = new Student("John", "Doe", "johndoe@gmail.com");
        Student spyStudent1 = Mockito.spy(student1);
        assertEquals("John", spyStudent1.getName());
        assertEquals("Doe", spyStudent1.getSurname());
        assertEquals("johndoe@gmail.com", spyStudent1.getEmail());



        Faker fakeStudent = new Faker();
        String[] hold = fakeStudent.funnyName().name().split(" ");
        String name = hold[0];
        String surname = hold[1];
        String email = name.toLowerCase() + surname.toLowerCase() + "@gmail.com";

        Student student2 = new Student(name, surname, email);
        Student spyStudent2 = Mockito.spy(student2);

        assertEquals(name, spyStudent2.getName());

        assertEquals(surname, spyStudent2.getSurname());

        assertEquals(email, spyStudent2.getEmail());
    }

//#########################################


//   ##########| STUDENT SUBJECT TESTS |##########

    @Test
    @Order(2)
    public void StudentAddSubjectsTest(){
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        Student spyStudent = Mockito.spy(student);

        spyStudent.addSubject(Subject.English);
        Mockito.verify(spyStudent).addSubject(Subject.English);

        spyStudent.addSubject(Subject.Maths);
        Mockito.verify(spyStudent).addSubject(Subject.Maths);

        assertEquals(Arrays.asList(Subject.English, Subject.Maths), spyStudent.getSubjects());
    }

    @Test
    @Order(3)
    public void StudentReturnCountOfAllSubjectsTest(){
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        Student spyStudent = Mockito.spy(student);

        spyStudent.addSubject(Subject.English);
        Mockito.verify(spyStudent).addSubject(Subject.English);

        spyStudent.addSubject(Subject.Maths);
        Mockito.verify(spyStudent).addSubject(Subject.Maths);

        spyStudent.addSubject(Subject.Biology);
        Mockito.verify(spyStudent).addSubject(Subject.Biology);

        spyStudent.addSubject(Subject.Art);
        Mockito.verify(spyStudent).addSubject(Subject.Art);

        assertEquals(4, spyStudent.getTotalSubjects());
    }

    @Test
    @Order(4)
    public void StudentRemoveSubjectTest() {
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        Student spyStudent = Mockito.spy(student);

        spyStudent.addSubject(Subject.English);
        Mockito.verify(spyStudent).addSubject(Subject.English);

        spyStudent.addSubject(Subject.Maths);
        Mockito.verify(spyStudent).addSubject(Subject.Maths);

        spyStudent.addSubject(Subject.Biology);
        Mockito.verify(spyStudent).addSubject(Subject.Biology);

        spyStudent.addSubject(Subject.Art);
        Mockito.verify(spyStudent).addSubject(Subject.Art);

        assertEquals(4, spyStudent.getTotalSubjects());

        spyStudent.removeSubject(Subject.Art);
        Mockito.verify(spyStudent).removeSubject(Subject.Art);

        assertEquals(3, spyStudent.getTotalSubjects());
    }

    @Test
    @Order(5)
    public void StudentCheckIfHasSubjectTest(){
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        Student spyStudent = Mockito.spy(student);

        spyStudent.addSubject(Subject.English);
        Mockito.verify(spyStudent).addSubject(Subject.English);

        spyStudent.addSubject(Subject.Maths);
        Mockito.verify(spyStudent).addSubject(Subject.Maths);

        spyStudent.addSubject(Subject.Biology);
        Mockito.verify(spyStudent).addSubject(Subject.Biology);

        spyStudent.addSubject(Subject.Art);
        Mockito.verify(spyStudent).addSubject(Subject.Art);
        assertEquals(true, spyStudent.checkSubject(Subject.Biology));
        assertEquals(true, spyStudent.checkSubject(Subject.Maths));
        assertEquals(false, spyStudent.checkSubject(Subject.Chemistry));
    }

    //   ############################################



//    ##########| STUDENT WALLET TESTS | ##########

    @Test
    @Order(6)
    public void StudentWalletTokensTest() {
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        Student spyStudent = Mockito.spy(student);

        spyStudent.depositTokens(3);
        Mockito.verify(spyStudent).depositTokens(3);
        assertEquals(3, spyStudent.getTokenBalance());

        spyStudent.depositTokens(5);
        Mockito.verify(spyStudent).depositTokens(5);
        assertEquals(8, spyStudent.getTokenBalance());

        spyStudent.withdrawTokens(7);
        Mockito.verify(spyStudent).withdrawTokens(7);
        assertEquals(1, spyStudent.getTokenBalance());

    }
    //    #############################################



    //    ##########| STUDENT NOTES TEST |##########
    @Test
    @Order(7)
    public void StudentAddNotesTest() {
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        Student spyStudent = Mockito.spy(student);

        spyStudent.addNote(Subject.English, NoteSource.Attended);
        Mockito.verify(spyStudent).addNote(Subject.English, NoteSource.Attended);

        assertEquals(1, spyStudent.totalNotes());
    }

    @Test
    @Order(8)
    public void StudentRemoveNote() {
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        Student spyStudent = Mockito.spy(student);

        spyStudent.addNote(Subject.English, NoteSource.Attended);
        Mockito.verify(spyStudent).addNote(Subject.English, NoteSource.Attended);

        spyStudent.addNote(Subject.Art, NoteSource.Attended);
        Mockito.verify(spyStudent).addNote(Subject.Art, NoteSource.Attended);

        assertEquals(2, spyStudent.totalNotes());

        spyStudent.removeNote(Subject.English, NoteSource.Attended);
        Mockito.verify(spyStudent).addNote(Subject.English, NoteSource.Attended);

        assertEquals(1, spyStudent.totalNotes());
    }

    @Test
    @Order(8)
    public void StudentCountAllNotesFromAttendingClass() {
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        Student spyStudent = Mockito.spy(student);

        spyStudent.addNote(Subject.English, NoteSource.Attended);
        Mockito.verify(spyStudent).addNote(Subject.English, NoteSource.Attended);

        spyStudent.addNote(Subject.Art, NoteSource.Attended);
        Mockito.verify(spyStudent).addNote(Subject.Art, NoteSource.Attended);

        spyStudent.addNote(Subject.Business, NoteSource.Bought);
        Mockito.verify(spyStudent).addNote(Subject.Business, NoteSource.Bought);

        assertEquals(3, spyStudent.totalNotes());
        assertEquals(2, spyStudent.totalNotes(NoteSource.Attended));
    }

    @Test
    @Order(9)
    public void StudentCountAllNotesBought() {
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        Student spyStudent = Mockito.spy(student);

        spyStudent.addNote(Subject.English, NoteSource.Attended);
        Mockito.verify(spyStudent).addNote(Subject.English, NoteSource.Attended);

        spyStudent.addNote(Subject.Art, NoteSource.Attended);
        Mockito.verify(spyStudent).addNote(Subject.Art, NoteSource.Attended);

        spyStudent.addNote(Subject.Business, NoteSource.Bought);
        Mockito.verify(spyStudent).addNote(Subject.Business, NoteSource.Bought);

        spyStudent.addNote(Subject.Chemistry, NoteSource.Bought);
        Mockito.verify(spyStudent).addNote(Subject.Chemistry, NoteSource.Bought);

        spyStudent.addNote(Subject.Geography, NoteSource.Bought);
        Mockito.verify(spyStudent).addNote(Subject.Geography, NoteSource.Bought);

        assertEquals(5, spyStudent.totalNotes());
        assertEquals(3, spyStudent.totalNotes(NoteSource.Bought));
    }

    @Test
    @Order(10)
    public void StudentCountAllNotesBoughtAndForASubject() {
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        Student spyStudent = Mockito.spy(student);

        spyStudent.addNote(Subject.English, NoteSource.Attended);
        Mockito.verify(spyStudent).addNote(Subject.English, NoteSource.Attended);

        spyStudent.addNote(Subject.Art, NoteSource.Attended);
        Mockito.verify(spyStudent).addNote(Subject.Art, NoteSource.Attended);

        spyStudent.addNote(Subject.Business, NoteSource.Bought);
        Mockito.verify(spyStudent).addNote(Subject.Business, NoteSource.Bought);

        assertEquals(3, spyStudent.totalNotes());
        assertEquals(1, spyStudent.totalNotes(Subject.English, NoteSource.Attended));
    }

    @Test
    @Order(11)
    public void buyNotesIfRegisteredForSubjectTest(){
        Student vendor = createStudent();
        vendor.addNote(Subject.English, NoteSource.Attended);


        Student student = createStudent();
        Student spyStudent = Mockito.spy(student);

        spyStudent.depositTokens(3);
        Mockito.verify(spyStudent).depositTokens(3);

        spyStudent.addSubject(Subject.English);
        Mockito.verify(spyStudent).addSubject(Subject.English);

        spyStudent.buyNotes(vendor, Subject.English);
        Mockito.verify(spyStudent).buyNotes(vendor, Subject.English);
    }


//    ##########################################


    //    ##########| STUDENT TIMETABLE TESTS |##########
    @Test
    @Order(12)
    public void addLessonTest(){
    Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
    Student spyStudent = Mockito.spy(student);

    spyStudent.addLesson("10:11", Subject.English);
    Mockito.verify(spyStudent).addLesson("10:11", Subject.English);

    assertEquals(1, spyStudent.totalLessons());
}

    @Test
    @Order(13)
    public void removeLessonTest(){
        Student student = new Student("Jack", "Silverto", "jacksilverto@hotmail.com");
        Student spyStudent = Mockito.spy(student);

        spyStudent.addLesson("10:11", Subject.English);
        Mockito.verify(spyStudent).addLesson("10:11", Subject.English);

        spyStudent.addLesson("12:00", Subject.English);
        Mockito.verify(spyStudent).addLesson("12:00", Subject.English);

        spyStudent.addLesson("11:00", Subject.Maths);
        Mockito.verify(spyStudent).addLesson("11:00", Subject.Maths);

        assertEquals(3, spyStudent.totalLessons());
    }

//    ###############################################

}
