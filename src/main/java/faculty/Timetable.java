package faculty;

import java.util.*;

public class Timetable {


    private SortedMap<String, Subject> timetable = new TreeMap<String, Subject>(new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    });

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

    //    RETURNS LESSON BASED ON TIME
    public Subject getLesson(String time){
        return timetable.get(time);
    }

    public int totalLessons(){
        return timetable.size();
    }
}
