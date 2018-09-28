package se.chalmers.group22.gymcompanion.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import se.chalmers.group22.gymcompanion.R;

public class ScheduleActivity extends AppCompatActivity implements INavigation {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
    }

    @Override
    public void startActivityBrowse(View view) {
        Intent intent = new Intent(this, BrowseActivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivityMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivityStatistics(View view) {
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivityMyRoutines(View view) {
        Intent intent = new Intent(this, MyRoutinesAcivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivitySchedule(View view) {
        // NOTHING
    }
}
