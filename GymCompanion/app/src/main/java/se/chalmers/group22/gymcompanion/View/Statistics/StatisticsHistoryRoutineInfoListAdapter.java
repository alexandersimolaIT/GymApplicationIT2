package se.chalmers.group22.gymcompanion.View.Statistics;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

import java.util.ArrayList;
import java.util.List;

public class StatisticsHistoryRoutineInfoListAdapter extends ArrayAdapter {
    private List<String> exerciseNames;
    private List<Boolean> exercisePerformedValues;

    public StatisticsHistoryRoutineInfoListAdapter(Activity context, List<String> exerciseNames, List<Boolean> exercisePerformedValues){

        super(context, R.layout.listitem_history , exerciseNames);

        this.context = context;
        this.exerciseNames = exerciseNames;
        this.exercisePerformedValues = exercisePerformedValues;
    }

    //to reference the Activity
    private final Activity context;

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_history, null,true);

        TextView txtExerciseNames = rowView.findViewById(R.id.txtStatisticsHistoryDetailsExerciseName);
        CheckBox checkBoxExercisePerformed = rowView.findViewById(R.id.checkboxStatisticsHistoryDetails);

        txtExerciseNames.setText(exerciseNames.get(position));
        checkBoxExercisePerformed.setChecked(exercisePerformedValues.get(position));

        return rowView;
    }
}
