package se.chalmers.group22.gymcompanion;

import org.junit.Test;
import se.chalmers.group22.gymcompanion.Model.Routine;
import se.chalmers.group22.gymcompanion.Model.Schedule;


import java.util.Date;

import static org.junit.Assert.*;

public class ScheduleTest {

    @Test
    public void addRoutineTest() {
        Schedule s = new Schedule();
        Routine r = new Routine();
        Date d = new Date();
        d.setTime(7);

        s.addRoutine(r, d);

        assertTrue(s.getRoutine(d).equals(r));

    }
}
