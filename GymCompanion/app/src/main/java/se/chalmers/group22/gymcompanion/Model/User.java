package se.chalmers.group22.gymcompanion.Model;

import lombok.AccessLevel;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.io.Serializable;
import java.util.*;

@Getter
public class User implements Serializable {

    @Getter(AccessLevel.NONE)
    private List<User> friends;

    @Getter(AccessLevel.NONE)
    private List<Routine> routines;

    @Getter(AccessLevel.NONE)
    private Map<Calendar, Routine> completedRoutines;


    private String name;
    private String gym;
    private int age;
    private int weight;
    private boolean isBeginner;
    private boolean isRoutineActive;

    private Routine activeRoutine;
    private StatisticsCalculator statCalc;
    private Schedule schedule;


    public User(List<User> friends, List<Routine> routines, String name, String gym, int age, int weight, boolean isBeginner){
        this.friends = friends;
        this.routines = routines;
        this.name = name;
        this.gym = gym;
        this.age = age;
        this.weight = weight;
        this.isBeginner = isBeginner;
        this.isRoutineActive = false;
        this.schedule = new Schedule();
        this.statCalc = new StatisticsCalculator(schedule);
    }

    public User(String name, String gym, int age, int weight, boolean isBeginner){
        this.friends = new ArrayList<>();
        this.routines = new ArrayList<>();
        this.age = age;
        this.weight = weight;
        this.isBeginner = isBeginner;
        this.isRoutineActive = false;
        this.schedule = new Schedule();
        this.statCalc = new StatisticsCalculator(schedule);
    }

    // Defensive copy
    public List<User> getFriends() {
        return new ArrayList<>(friends);
    }

    // Defensive copy
    public List<Routine> getRoutines() {
        return new ArrayList<>(routines);
    }

    // Defensive Copy
    public Map<Calendar, Routine> getCompletedRoutinesKeySet(){
        return new HashMap<Calendar, Routine>(completedRoutines);
    }

    public void addFriend(User friend){
        friends.add(friend);
    }

    public void removeFriend(User friend){
        friends.remove(friend);
    }

    public void addRoutine(Routine routine){
        routines.add(routine);
    }

    public void removeRoutine(Routine routine){
        routines.remove(routine);
    }

    public void startRoutine(Routine routine){
       /*TODO Start the routine for the current day*/
        isRoutineActive = true;
        activeRoutine = routine;
        /*TODO redirect to "Workout in progress"-page*/
    }

    public void endActiveRoutine(){
        completedRoutines.put(getTodaysDate(), activeRoutine);
        activeRoutine = null;
        isRoutineActive = false;
    }

    public void checkDay(){
        Calendar today = Calendar.getInstance();
        if (schedule.dayHasRoutine(today)){
            startRoutine(schedule.getRoutineFromDay(today));
        }
        else {
            /*TODO Direct the user to MR so it can create a new routine*/
        }
    }

    public void createRoutine(){
        routines.add(new Routine());
    }

    public void addExerciseToRoutine(Exercise exercise, Routine routine){
        routine.addExercise(exercise);
    }

    public void modifyRoutineDescription(Routine routine, String description){
        routine.setDescription(description);
    }


    private Calendar getTodaysDate(){
        return Calendar.getInstance();
    }

    public String getTodaysRoutineName(){
        return schedule.getRoutineNameFromDay(getTodaysDate());
    }

    public Routine getTodaysRoutine(){
        return schedule.getRoutineFromDay(getTodaysDate());
    }

    public Routine getFinishedRoutine(){
        Calendar today = Calendar.getInstance();
        for(Calendar date : completedRoutines.keySet()){
            if( sameDay(date, today) ){
                return completedRoutines.get(date);
            }
        }
        return null;
    }

    private boolean sameDay(Calendar date1, Calendar date2){
        return  date1.get(Calendar.DAY_OF_YEAR) == date2.get(Calendar.DAY_OF_YEAR) &&
                date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR);
    }
}
