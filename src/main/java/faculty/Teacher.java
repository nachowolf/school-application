package faculty;

import java.util.*;

public class Teacher extends Wallet implements Person {

    List<Subject> qualified = new ArrayList<Subject>();
    private SortedMap<String, Subject> timetable = new TreeMap<String, Subject>(new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return s2.compareTo(s1);
        }
    });;

    private String name;
    private String surname;
    private String email;

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

    //########## Token Methods ##########

    //    GET TOKEN BALANCE FROM WALLET
    public int getTokenBalance() {
        return getBalance();
    }

    //    WITHDRAW TOKENS FROM WALLET
    public void withdrawTokens(int amt) {
        withdraw(amt);
    }

    //    DEPOSIT TOKENS INTO WALLET
    public void depositTokens(int amt) {
        deposit(amt);
    }

//#################################

// ########## Teacher Subject Methods ##########

//    ADD A SUBJECT THAT TEACHER CAN TEACH
    public void qualifySubject(Subject subject){
        qualified.add(subject);
    }

//    RETURN A LIST OF ALL SUBJECTS THE TEACHER IS QUALIFIED FOR
    public List getQualifiedSubjects(){
        return qualified;
    }

//    CHECKS IF A TEACHER IS QUALIFIED FOR A CERTAIN SUBJECT
    public boolean isQualified(Subject subject){
        if(qualified.contains(subject)){
            return true;
        }
        else{
            return false;
        }
    }

// ###########################################

    //########## Lesson Methods ##########

    //    adds a lesson subject and time to teacher
    public void addLesson(String time, Subject subject){
        if(!timetable.containsKey(time)){
            timetable.put(time, subject);
        }
    }

    //    checks whether a teacher is available to teach a lesson
    public boolean checkLesson(String time){
        for(Map.Entry<String, Subject> lesson : timetable.entrySet()){
            String lessonTime = lesson.getKey();
            if(lessonTime.equals(time)){
                return true;
            }
        }
        return false;
    }

    //     removes a lesson from teacher timetable
    public void removeLesson(String time){
        timetable.remove(time);

    }

//    RETURNS ALL LESSONS THE TEACHER HAS TO TEACH
    public List allLessons(){
        List<String> periods = new ArrayList<>();
        for( Map.Entry period : timetable.entrySet()){
            periods.add(period.getKey() + " : " +period.getValue().toString());
        }
        return periods;
    }

    //####################################
}
