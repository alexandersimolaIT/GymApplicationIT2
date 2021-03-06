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
/***
 * Title: MyRoutinesUserExercisesListAdapter
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 2, 2018
 *
 * Purpose: Adds the list elements to the User Exercises List GUI
 * Uses: listitem_my_routines_exercise.xml
 * Used by: MyRoutinesRoutineInfoFragment.java
 */
public class MyRoutinesUserExercisesListAdapter extends ArrayAdapter {

    //to reference the activity
    private Activity context;

    //to store exercises
    private List<String> exerciseNames;
    private List<Integer> sets;

    public MyRoutinesUserExercisesListAdapter(Activity context, List<String> exerciseNames, List<Integer> sets){
        super(context, R.layout.listitem_my_routines_exercise, exerciseNames);
        this.exerciseNames = exerciseNames;
        this.sets = sets;
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listitem_my_routines_exercise, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView exerciseName = rowView.findViewById(R.id.textViewExerciseName);
        TextView amountOfSets = (TextView) rowView.findViewById(R.id.textViewListItemExercisesSets);


        ImageButton btnremoveExercise = rowView.findViewById(R.id.btnRemoveExercise);
        btnremoveExercise.setTag(exerciseNames.get(position));

        //this code sets the values of the objects to values from the arrays
        exerciseName.setText(exerciseNames.get(position));
        String setsAmountText = (sets.get(position) == 0) ? "" : sets.get(position).toString();
        if (sets.get(position) == 0){
            TextView txtViewSets = rowView.findViewById(R.id.textViewSetsText);
            txtViewSets.setText("");

        }
        amountOfSets.setText(setsAmountText);

        return rowView;

    }

}
