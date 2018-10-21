package se.chalmers.group22.gymcompanion.View.MyRoutines;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import se.chalmers.group22.gymcompanion.R;

import java.util.List;

public class MyRoutinesUserExercisesListAdapter extends ArrayAdapter {

    //to reference the activity
    private Activity context;

    //to store exercises
    private List<String> exerciseNames;

    public MyRoutinesUserExercisesListAdapter(Activity context, List<String> exerciseNames){
        super(context, R.layout.listitem_my_routines_exercise, exerciseNames);
        this.exerciseNames = exerciseNames;
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_my_routines_exercise, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView exerciseName = rowView.findViewById(R.id.textViewExerciseName);
        //TextView amountOfSets = (TextView) rowView.findViewById(R.id.amountOfSetsList);

        ImageButton btnremoveExercise = rowView.findViewById(R.id.btnRemoveExercise);
        btnremoveExercise.setTag(exerciseNames.get(position));

        //this code sets the values of the objects to values from the arrays
        exerciseName.setText(exerciseNames.get(position));
        return rowView;

    }

}
