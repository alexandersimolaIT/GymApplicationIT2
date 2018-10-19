package se.chalmers.group22.gymcompanion.Model;


import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Model.Exercises.CardioExercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.io.Serializable;
import java.util.*;

public class StatisticsCalculator implements Serializable {
    private Schedule schedule;

    public StatisticsCalculator(Schedule schedule){
       this.schedule = schedule;
    }

    public Map<Calendar, Exercise> getSpecificExercise(Exercise specificExercise){
        Map<Calendar, Exercise> specificExerciseMap = new HashMap<>();
        for(Calendar day : schedule.getScheduleKeySet()){
            Routine r = schedule.getRoutineFromDay(day);
            for(Exercise exercise : r.getExercises()){
                if(exercise.getName().equals(specificExercise.getName())){
                    specificExerciseMap.put(day, exercise);
                }
            }
        }
        return specificExerciseMap;
    }

    public Map<Calendar, Double> getGraphDataPoints(Calendar date, int weekOffset){

        Map<Calendar, Double> graphMap = new HashMap<>();

        double score;

        for (int i = 0; i < 7; i++){
            score = 0;

            Calendar cal = new GregorianCalendar();
            cal.set(Calendar.DAY_OF_YEAR, Calendar.DAY_OF_YEAR + (i-date.get(Calendar.DAY_OF_WEEK)) + (7 * weekOffset));

            if(schedule.dateHasRoutine(cal)){

                for (Exercise e : schedule.getRoutineFromDay(cal).getExercises()){
                    score += e.calculateScore();
                }
            }

            graphMap.put(cal, score);
        }

        return graphMap;
    }



}
