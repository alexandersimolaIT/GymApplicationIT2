package se.chalmers.group22.gymcompanion.View.Browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import se.chalmers.group22.gymcompanion.R;

public class BrowseSelectionFragment extends Fragment {
    public static BrowseSelectionFragment getInstance() {
        return new BrowseSelectionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BrowseActivity) getActivity()).setActionBarTitle("Choose a muscle group");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_browse_selection, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
