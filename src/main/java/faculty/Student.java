package faculty;


import java.util.*;

public class Student extends Wallet implements Person {

    private List<Subject> subjects = new ArrayList<Subject>();
    private Map<String, Subject> timetable = new TreeMap<String, Subject>();
    private Map<Subject, NoteSource> notes = new HashMap();

    private String name;
    private String surname;
    private String email;


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


//########## Subject Methods ##########

//    adds registers a student for a subject
    public void addSubject(Subject subject){
        subjects.add(subject);
    }

//    returns the all subjects a student is registered for
    public List getSubjects(){
        return subjects;
    }

//    returns how many subjects a student has
    public int getTotalSubjects(){
        return subjects.size();
    }

//    removes a subject from a student
    public void removeSubject(Subject subject){
        subjects.remove(subject);
    }

//    returns a boolean if a student has that subject
    public boolean checkSubject(Subject subject){
        if(subjects.contains(subject)){
            return true;
        }
        else{
            return false;
        }
    }
    //###################################


    //########## Lesson Methods ##########

//    adds a lesson subject and time to student
    public void addLesson(String time, Subject subject){
        if(!timetable.containsKey(time)){
            timetable.put(time, subject);
        }
    }

//    checks whether a student is available to attend a lesson
    public boolean checkLesson(String time){
        for(Map.Entry<String, Subject> lesson : timetable.entrySet()){
            String lessonTime = lesson.getKey();
            if(lessonTime.equals(time)){
                return true;
            }
            }
        return false;
        }

//     removes a lesson from student timetable
    public void removeLesson(String time){
        timetable.remove(time);

    }

    //     removes a lesson from student timetable
    public void removeLesson(Subject subject){
        timetable.remove(subject);

    }

//    RETURNS ALL LESSONS STUDENT HAS
    public Map allLessons(){
        return timetable;
    }

//    RETURNS TOTAL NUMBER OF LESSONS
    public int totalLessons(){
        return timetable.size();
    }

//####################################

//    ########## Note Methods ##########

//     ADD NOTES
public void addNote(Subject subject, NoteSource source) {
        notes.put(subject, source);
    }

//    RETURNS HOW MUCH NOTES THE STUDENT HAS
    public int totalNotes(){
        return notes.size();
    }

    //    RETURNS HOW MUCH NOTES THERE ARE FOR A SPECIFIC SUBJECT
    public int totalNotes(Subject subject) {
        int counter = 0;
        for(Subject subjectKey: notes.keySet()){
            if(subject.equals(subjectKey)){
                counter++;
            }
        }
        return counter;
    }

//    RETURNS HOW MANY NOTES HAVE BEEN BOUGHT OR RECEIVED DURING LESSON
public int totalNotes(NoteSource source) {
        int counter = 0;
        for(NoteSource sourceValue: notes.values()){
            if(source.equals(sourceValue)){
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


    //    REMOVES NOTES FROM STUDENT
public void removeNote(Subject subject, NoteSource source) {
        notes.remove(subject, source);
    }

//    ###################################
}
