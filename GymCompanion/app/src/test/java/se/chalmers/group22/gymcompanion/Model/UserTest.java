package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    private User user = new User(null, "Test", "Test Gym", 20, 75, true);

    @Test
    public void startRoutineTest(){
        Routine routine = new Routine();
        user.startRoutine(routine);
        assertTrue(user.isRoutineActive());
    }

    @Test
    public void checkDayTest(){

    }
    @Test
    public void endActiveRoutineTest(){
        user.endActiveRoutine();
        assertFalse(user.isRoutineActive());
    }

}