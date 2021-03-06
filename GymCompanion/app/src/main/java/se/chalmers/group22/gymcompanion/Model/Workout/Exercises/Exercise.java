package se.chalmers.group22.gymcompanion.Model.Workout.Exercises;

import lombok.AccessLevel;
import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.ISortable;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/***
 * Title: Exercise
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 19, 2018
 *
 * Purpose: An abstract class containing attributes and methods concerning physical exercises
 * Used by: GymCompanion.java, GymCompanionSortAndFilterTest.java, RoutineTest.java,
 *      UserTest.java, ParserTest.java, Parser.java, StatisticsCalculator.java,
 *      User.java, Routine.java, BrowseViewModel.java, MyRoutinesViewModel.java,
 *      StatisticsViewModel.java, CardioExercise.java, StrengthExercise.java,
 *      GymCompanionTest.java, LocalDatabase.java, MainViewModel.java
 * Uses: INTENSITY.java, ISortable.java, MUSCLE_GROUP.java
 *
*/

@Getter
public abstract class Exercise implements ISortable, Serializable {

    private String name;
    private double difficulty;

    @Getter(AccessLevel.NONE)
    private List<MUSCLE_GROUP> muscleGroups;

    private INTENSITY intensity;

    private boolean completed = false;

    //Might need a Guide class later
    private String description;
    private String videoguide;

    public Exercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroups, String description, String videoguide){
        this.name = name;
        this.difficulty = difficulty;
        this.muscleGroups = muscleGroups;
        this.description = description;
        this.videoguide = videoguide;
    }

    public Exercise(Exercise exercise){
        this.name = exercise.getName();
        this.difficulty = exercise.getDifficulty();
        this.completed = exercise.isCompleted();
        this.muscleGroups = exercise.getMuscleGroups();
        this.description = exercise.getDescription();
        this.intensity = exercise.getIntensity();
        this.videoguide = exercise.getVideoguide();
    }

    public boolean containsMuscleGroup(MUSCLE_GROUP mg) {
        return muscleGroups.contains(mg);

    }

    public Exercise(String name, double difficulty, List<MUSCLE_GROUP> muscleGroups, String description, String videoguide, INTENSITY intensity){
        this.name = name;
        this.difficulty = difficulty;
        this.muscleGroups = muscleGroups;
        this.description = description;
        this.videoguide = videoguide;
        this.completed = false;
        this.intensity = intensity;
    }

    /** calculateScore
     *
     * @return
     */
    abstract public double calculateScore();

    public void toggleCompletion(boolean completed){
        this.completed = completed;
    }

    public List<MUSCLE_GROUP> getMuscleGroups(){
        return new ArrayList<>(muscleGroups);
    }

    abstract public Exercise clone();


    //FOR TESTING

    public Exercise(String name, double difficulty){
        this.name = name;
        this.difficulty = difficulty;
    }

    public Exercise(String name){
        this.name = name;
    }


    public Exercise(List<MUSCLE_GROUP> muscleGroups, double difficulty){
        this.muscleGroups = muscleGroups;
        this.difficulty = difficulty;
    }

}
