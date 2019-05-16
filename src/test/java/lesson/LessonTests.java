package lesson;

import faculty.Subject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class LessonTests {

    @Mock
    Teacher teacher = Mockito.mock(Teacher.class);

    @Test
    public void CreateLessonTest() {

        Lesson mathLesson = new Lesson(teacher, "10:00", Subject.Maths);
    }
}
