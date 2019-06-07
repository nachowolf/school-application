package faculty;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Wallet implements Person {

    List<Subject> qualified = new ArrayList<Subject>();

    private String name;
    private String surname;
    private String email;
    private Wallet wallet = new Wallet();
    private Timetable timetable = new Timetable();


//############# Constructor #############

    public Teacher(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

//#####################################


//########## Identity Methods ##########

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

//####################################

    // ########## Teacher Subject Methods ##########

    //    ADD A SUBJECT THAT TEACHER CAN TEACH
    public void qualifySubject(Subject subject) {
        qualified.add(subject);
    }

    //    RETURN A LIST OF ALL SUBJECTS THE TEACHER IS QUALIFIED FOR
    public List getQualifiedSubjects() {
        return qualified;
    }

    //    CHECKS IF A TEACHER IS QUALIFIED FOR A CERTAIN SUBJECT
    public boolean isQualified(Subject subject) {
        if (qualified.contains(subject)) {
            return true;
        } else {
            return false;
        }
    }

// ###########################################

    //########## Token Methods ##########

    //    GET TOKEN BALANCE FROM WALLET
    public int getTokenBalance() {
        return wallet.getBalance();
    }

    //    WITHDRAW TOKENS FROM WALLET
    public void withdrawTokens(int amt) {
        wallet.withdraw(amt);
    }

    //    DEPOSIT TOKENS INTO WALLET
    public void depositTokens(int amt) {
        wallet.deposit(amt);
    }

//#################################


    //########## Lesson Methods ##########

    //    adds a lesson subject and time to teacher
    public void addLesson(String time, Subject subject){
        if (isQualified(subject)) {
            timetable.addLesson(time, subject);
        }
    }

    //    checks whether a teacher is available to teach a lesson
    public boolean checkLesson(String time){
        return timetable.checkLesson(time);
    }

    //     removes a lesson from teacher timetable
    public void removeLesson(String time){
        timetable.removeLesson(time);

    }

//    RETURNS ALL LESSONS THE TEACHER HAS TO TEACH
    public List allLessons(){

        return timetable.allLessons();
    }

    //    RETURNS LESSON BASED ON TIME
    public Subject getLesson(String time) {
        return timetable.getLesson(time);
    }

    //####################################
}
