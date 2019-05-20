package faculty;

import faculty.Subject;

import java.util.Map;
import java.util.TreeMap;

public class Wallet {

    private int token = 0;
    private Map<Subject, NoteSource> notes = new TreeMap<Subject, NoteSource>();

    public void earnToken(Subject subject){
        notes.put(subject, NoteSource.Attended);
        this.token += 3;
    }

    public void buyNotes(Subject subject){

    }
}
