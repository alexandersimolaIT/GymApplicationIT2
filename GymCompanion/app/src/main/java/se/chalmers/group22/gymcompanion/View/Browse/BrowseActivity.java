package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Toast;
import se.chalmers.group22.gymcompanion.R;
import se.chalmers.group22.gymcompanion.View.*;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

import java.util.ArrayList;
import java.util.List;

/***
 * Title: BrowseActivity
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: September 20, 2018
 *
 * Purpose: Manages user interaction and handles which Fragments are in view of the user when this activity is active
 * Used by: BrowseResultFragment.java, BrowseRecommendedFragment.java, BrowseAddExerciseFragment.java,
 *          BrowseMuscleGroupsFragment.java, BrowseStartFragment.java, NavigationFragment.java,
 *          fragment_statistics_start.xml
 * Uses:    BrowseViewModel.java, BrowseStartFragment.java, BrowseMuscleGroupsFragment.java, BrowseResultFragment.java,
 *          BrowseRecommendedFragment.java, BrowseAddExerciseFragment.java, NavigationFragment.java
 */

public class BrowseActivity extends ObserverActivity {

    /** pageIndex
     * @value 1
     * */
    private static final int index = 1;
    private final Fragment fragmentStart = FragmentFactory.createBrowseStartFragment();
    private final Fragment fragmentSelection = FragmentFactory.createBrowseMuscleGroupsFragment();
    private final Fragment fragmentResult = FragmentFactory.createBrowseResultFragment();
    private final Fragment fragmentRecommended = FragmentFactory.createBrowseRecommendedFragment();
    private final Fragment fragmentAddExercise = FragmentFactory.createBrowseAddExerciseFragment();
    private final Fragment navigationFragment = FragmentFactory.createNavigationFragment();
    private List<Fragment> fragments = new ArrayList<>();
    private final FragmentManager fm = getSupportFragmentManager();
    private FragmentOrganizer fo;

    private BrowseViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        viewModel = new BrowseViewModel();

        //Sends the activity index to NavigationFragment via Bundle
        Bundle navBundle = new Bundle();
        navBundle.putInt("index", index);
        navigationFragment.setArguments(navBundle);

        fillFragmentsList();

        fo = new FragmentOrganizer(fragments,fm,navigationFragment,R.id.browse_container);

        if(getIntent().getExtras() != null){
            fo.setUpFragments(fragmentResult);
        }
        else {
            fo.setUpFragments(fragmentStart);
        }
    }

    private void fillFragmentsList(){
        fragments.add(fragmentStart);
        fragments.add(fragmentRecommended);
        fragments.add(fragmentResult);
        fragments.add(fragmentSelection);
        fragments.add(fragmentAddExercise);
    }

    public void goToStart(View view) {
        fo.changeToFragment(fragmentStart);
    }

    public void goToMuscleGroupSelection(View view){
        fo.changeToFragment(fragmentSelection);
    }

    public void goToRecommendedSelection(View view){
        fo.changeToFragment(fragmentRecommended);
    }

    public void resultBack(View view){
        //Decides where to go back to
        switch(viewModel.getIndex()){
            case 0:
                fo.changeToFragment(fragmentStart);
                break;
            case 1:
                fo.changeToFragment(fragmentSelection);
                break;
            case 2:
                fo.changeToFragment(fragmentRecommended);
                break;
            case 3:
                fo.changeToFragment(fragmentRecommended);
                break;
            default:
                break;
        }
        //Resetting the checkboxes
        viewModel.setCbxRoutine(true);
        viewModel.setCbxExercise(true);
    }

    public void goToResult(String s) {
        fo.changeToFragment(fragmentResult);

        String x;
        x = s.replace(" ", "_");
        viewModel.setMuscleGroup(x);
        viewModel.setIndex(1);
        viewModel.filter(x);
    }

    public void goToResultFromSearch(String s){

        fo.changeToFragment(fragmentResult);

        viewModel.setIndex(0);
        viewModel.search(s);
        //fragmentResult.onResume();
    }

    public void goToResultFromRecommended(View view) {
        int i = Integer.valueOf((String)view.getTag());
        viewModel.setIndex(i);
        viewModel.filter();
        fo.changeToFragment(fragmentResult);
    }

    private void goToAddExercise(){
        fo.changeToFragment(fragmentAddExercise);
    }

    public void onAddClick(View view){
        String s = view.getTag().toString();

        int index = viewModel.compareRoutineExercises(s);

        //ROUTINE
        if(index == 0) {
            viewModel.addRoutineToUser(s);
            Toast.makeText(this, "Routine added to My Routines!", Toast.LENGTH_SHORT).show();
        } //EXERCISE
        else if (index == 1) {
            viewModel.setExerciseToAdd(s);
            goToAddExercise();
        }
    }

    public void onAddExerciseToRoutineClick(View view) {
        int i = (int)view.getTag();
        viewModel.addExerciseToUserRoutine(i);
        Toast.makeText(this, "Exercise added to the routine!", Toast.LENGTH_SHORT).show();
    }

    public void infoBack(View view){
        fo.changeToFragment(fragmentResult);
    }

    public BrowseViewModel getViewModel(){
        return viewModel;
    }

}