package faculty;


import cafeteria.MenuItem;

import java.util.*;

public class Student implements Person {

    private List<Subject> subjects = new ArrayList<Subject>();
    private Map<Subject, NoteSource> notes = new HashMap();

    private String name;
    private String surname;
    private String email;
    private Role role = Role.Student;
    private Wallet wallet = new Wallet();
    private Timetable timetable = new Timetable();


//############# Constructor #############

    public Student(String name, String surname, String email) {
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

    @Override
    public Role getRole() {
        return this.role;
    }

//####################################


//########## Token Methods ##########

    //    GET TOKEN BALANCE FROM WALLET
    public double getTokenBalance() {
        return wallet.getBalance();
    }

    //    WITHDRAW TOKENS FROM WALLET
    public boolean withdrawTokens(double amt) {
        return wallet.withdraw(amt);
    }

    //    DEPOSIT TOKENS INTO WALLET
    public boolean depositTokens(double amt) {
        return wallet.deposit(amt);
    }

//    BUY FROM RESTUARANT
//    public boolean buyFromCafeteria(MenuItem item){
//        return wallet.withdraw(item.getPrice());
//    }

//#################################


//########## Subject Methods ##########

    //    adds registers a student for a subject
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    //    returns the all subjects a student is registered for
    public List getSubjects() {
        return subjects;
    }

    //    returns how many subjects a student has
    public int getTotalSubjects() {
        return subjects.size();
    }

    //    removes a subject from a student
    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    //    returns a boolean if a student has that subject
    public boolean checkSubject(Subject subject) {
        if (subjects.contains(subject)) {
            return true;
        } else {
            return false;
        }
    }
    //###################################


    //########## Lesson Methods ##########

    //    adds a lesson subject and time to student
    public void addLesson(String time, Subject subject) {
        timetable.addLesson(time, subject);
    }

    //    checks whether a student is available to attend a lesson
    public boolean checkLesson(String time) {
        return timetable.checkLesson(time);
    }

    //     removes a lesson from student timetable
    public void removeLesson(String time) {
        timetable.removeLesson(time);

    }


    //    RETURNS ALL LESSONS STUDENT HAS
    public List allLessons() {
        return timetable.allLessons();
    }

    //    RETURNS TOTAL NUMBER OF LESSONS
    @Override
    public int totalLessons() {
        return timetable.totalLessons();
    }
// CHECK WHAT LESSON IS AT TIME;
    @Override
    public Subject getLesson(String time) {
        return timetable.getLesson(time);
    }

//####################################

//    ########## Note Methods ##########

    //     ADD NOTES
    public void addNote(Subject subject, NoteSource source) {
        notes.put(subject, source);
    }

    //    RETURNS HOW MUCH NOTES THE STUDENT HAS
    public int totalNotes() {
        return notes.size();
    }

    //    RETURNS HOW MUCH NOTES THERE ARE FOR A SPECIFIC SUBJECT
    public int totalNotes(Subject subject) {
        int counter = 0;
        for (Subject subjectKey : notes.keySet()) {
            if (subject.equals(subjectKey)) {
                counter++;
            }
        }
        return counter;
    }

    //    RETURNS HOW MANY NOTES HAVE BEEN BOUGHT OR RECEIVED DURING LESSON
    public int totalNotes(NoteSource source) {
        int counter = 0;
        for (NoteSource sourceValue : notes.values()) {
            if (source.equals(sourceValue)) {
                counter++;
            }
        }
        return counter;

    }

    //    RETURNS HOW MANY NOTES THERE ARE FOR A SUBJECT AND IT'S SOURCE
    public int totalNotes(Subject subject, NoteSource source) {
        int counter = 0;

        Iterator note = notes.entrySet().iterator();
        while (note.hasNext()) {
            Map.Entry pairInfo = (Map.Entry) note.next();
            if (pairInfo.getKey().equals(subject) && pairInfo.getValue().equals(source)) {
                counter++;
            }
        }
        return counter;
    }

    //    RETURNS HOW MANY NOTES THERE ARE FOR A SUBJECT AND IT'S SOURCE
    public int totalNotes(NoteSource source, Subject subject) {
        int counter = 0;

        Iterator note = notes.entrySet().iterator();
        while (note.hasNext()) {
            Map.Entry pairInfo = (Map.Entry) note.next();
            if (pairInfo.getKey().equals(subject) && pairInfo.getValue().equals(source)) {
                counter++;
            }
        }
        return counter;
    }

    public boolean hasNotes(Subject subject) {
        return notes.containsKey(subject);
    }


    //    REMOVES NOTES FROM STUDENT
    public void removeNote(Subject subject, NoteSource source) {
        notes.remove(subject, source);
    }

//    ###################################

    //    ##########| EXCHANGE NOTES METHODS |##########
//    Buy notes from another student
    public void buyNotes(Student vendor, Subject subject) {

        int chargeAmt;

        if (subjects.contains(subject)) {
            chargeAmt = 3;
        } else {
            chargeAmt = 5;
        }

        if (vendor.hasNotes(subject)) {

            if (wallet.getBalance() >= chargeAmt) {
                wallet.withdraw(chargeAmt);
                notes.put(subject, NoteSource.Bought);
                vendor.depositTokens(chargeAmt);
            }
        }
    }
//    ##############################################
}
