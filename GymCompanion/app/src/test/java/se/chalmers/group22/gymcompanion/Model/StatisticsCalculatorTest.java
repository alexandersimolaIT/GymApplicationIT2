package se.chalmers.group22.gymcompanion.Model;

import org.junit.Before;
import org.junit.Test;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.User.User;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.Model.Workout.Routine;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StatisticsCalculatorTest {
    User user;
    INTENSITY intensity;

    private String userName;
    private String gym;
    private int age;
    private int weight;
    private boolean isBeginner;

    private List<Integer> repetitions;
    private List<Double> weightList;
    private int sets;
    private int timespent;
    private List<MUSCLE_GROUP> muscleGroup;

    private Exercise exercise;
    private StrengthExercise strengthExercise;
    private CardioExercise cardioExercise;
    private List<Routine> routines;
    private Routine routine;
    private Calendar calendar;


    @Before
    public void init(){
        intensity =INTENSITY.LOW;

        userName = "BOOOOOOOOOOOOOCK";
        gym = "Welcome to my mine";
        age = 12;
        weight = 2;
        isBeginner = false;

        weightList = new ArrayList<>();
        weightList.add(10.0);
        weightList.add(5.0);
        repetitions = new ArrayList<>();
        repetitions.add(2);
        repetitions.add(4);
        sets = 2;
        timespent = 100;
        muscleGroup = new ArrayList<>();

        exercise = new StrengthExercise("Lift",3.5,muscleGroup,"","",repetitions,sets, weightList, intensity);
        strengthExercise = new StrengthExercise("Lift",3.5,muscleGroup,"","",repetitions,sets,weightList,intensity);
        cardioExercise = new CardioExercise("Run",4.4,muscleGroup,"","",intensity,timespent);
        routine = new Routine();
        routines = new ArrayList<>();
        routines.add(routine);

        calendar = Calendar.getInstance();
        user = new User(null,routines,userName,gym,age,weight,isBeginner);
        user.addExerciseToRoutine(exercise,routines.get(0));
        user.getSchedule().addRoutine(routines.get(0),calendar);
    }
    
    @Test
    public void calculateStrengthScoreTest(){
        assertTrue(!user.getGraphData(0).isEmpty());
    }



}