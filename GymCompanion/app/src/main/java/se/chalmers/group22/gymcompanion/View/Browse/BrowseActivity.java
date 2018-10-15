package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
=======
import android.widget.SearchView;
import se.chalmers.group22.gymcompanion.View.BaseActivity;
>>>>>>> master
import se.chalmers.group22.gymcompanion.View.NavigationFragment;
import se.chalmers.group22.gymcompanion.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import se.chalmers.group22.gymcompanion.ViewModel.BrowseViewModel;

public class BrowseActivity extends BaseActivity {

    /** pageIndex
     * @value 1
     * */
    private static final int index = 1;
    private final Fragment fragmentStart = new BrowseStartFragment();
    private final Fragment fragmentSelection = new BrowseSelectionFragment();
    private final Fragment fragmentSelectedItem = new BrowseSelectedItemFragment();
    private final Fragment navigationFragment = new NavigationFragment();
    private final FragmentManager fm = getSupportFragmentManager();

<<<<<<< HEAD
    BrowseViewModel browseViewModel;
=======
    private BrowseViewModel browseViewModel = new BrowseViewModel();
>>>>>>> master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        browseViewModel = new BrowseViewModel();

        //Sends the activity index to NavigationFragment via Bundle
        Bundle navBundle = new Bundle();
        navBundle.putInt("index", index);
        navigationFragment.setArguments(navBundle);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.browse_container, fragmentSelectedItem, "3").hide(fragmentSelectedItem);
        transaction.add(R.id.browse_container, fragmentSelection, "2").hide(fragmentSelection);
        transaction.add(R.id.browse_container, fragmentStart, "1");
        transaction.add(R.id.navigation, navigationFragment);
        transaction.commit();
    }

<<<<<<< HEAD
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void goToBrowseSelection(View view){
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.hide(fragmentStart);
        transaction.show(fragmentSelection);
        transaction.commit();
    }

    public void goToSelectedItem(View view){
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.hide(fragmentSelection);
        transaction.show(fragmentSelectedItem);
        transaction.commit();
=======
    public BrowseViewModel getViewModel(){
        return browseViewModel;
>>>>>>> master
    }
}
