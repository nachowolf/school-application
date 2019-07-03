package faculty;

import cafeteria.MenuItem;

public interface Person {


//    Get name, surname and email
    String getName();
    String getSurname();
    String getEmail();
    Role getRole();
    double getTokenBalance();
    boolean withdrawTokens(double amt);
    boolean depositTokens(double amt);
    int totalLessons();
    Subject getLesson(String time);
//    boolean buyFromCafeteria(MenuItem item);

}
