package se.chalmers.group22.gymcompanion.Model.Exercises;

import lombok.Getter;
import se.chalmers.group22.gymcompanion.Enums.INTENSITY;
import se.chalmers.group22.gymcompanion.Enums.MUSCLE_GROUP;
import se.chalmers.group22.gymcompanion.Model.ISortable;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
public abstract class Exercise implements ISortable, Serializable {

    private String name;
    private double difficulty;
    private List<MUSCLE_GROUP> muscleGroups;

    private INTENSITY intensity;

    private boolean completed;

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

    //For testing
    public Exercise(String name, double difficulty){
        this.name = name;
        this.difficulty = difficulty;
    }

    //FOR TESTING
    public Exercise(List<MUSCLE_GROUP> muscleGroups, double difficulty){
        this.muscleGroups = muscleGroups;
        this.difficulty = difficulty;
    }

    public Exercise(){}

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

    public void complete(){
        this.completed = true;
    }


}