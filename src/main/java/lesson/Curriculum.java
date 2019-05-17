package lesson;

import faculty.Subject;
import faculty.Teacher;

public interface Curriculum {

    Teacher getTeacher();
    String getTime();
    Subject getSubject();
}
