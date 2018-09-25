package se.chalmers.group22.gymcompanion.Model;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;

import static org.junit.Assert.assertEquals;

public class ActiveRoutineTest {

    private ActiveRoutine activeRoutine;
    private Routine routine = new Routine();

    @Test
    public void completeExercise() {
        Exercise se = new StrengthExercise(10, 3);
        routine.getExercises().add(se);
        activeRoutine = new ActiveRoutine(routine);
        activeRoutine.completeExercise(se);
        assertEquals(se, activeRoutine.getCompletedExercises().get(0));
    }
}