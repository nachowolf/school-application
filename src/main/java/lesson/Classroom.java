package lesson;

import faculty.Subject;
import faculty.Teacher;

public interface Classroom {

    Teacher getTeacher();
    String getTime();
    Subject getSubject();
}
