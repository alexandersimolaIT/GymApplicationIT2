package se.chalmers.group22.gymcompanion.ViewModel;

import se.chalmers.group22.gymcompanion.Model.ModelObserver;
import se.chalmers.group22.gymcompanion.Model.ViewModelObserver;

import java.util.ArrayList;
import java.util.List;


/***
 * Title: ObservableViewModelViewModel
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 19, 2018
 *
 * Purpose: All Viewmodels that are observable handle viewModelObservers in the same way,
 * which means that code could be abstracted out of them into a common super class
 */

abstract public class ObservableViewModelViewModel extends BaseViewModel implements se.chalmers.group22.gymcompanion.Model.ObservableViewModel, ModelObserver {

    private List<ViewModelObserver> viewModelObservers = new ArrayList<>();

    @Override
    public void notifyObservers() {
        for (ViewModelObserver o : viewModelObservers){
            o.update();
        }
    }

    @Override
    public void addObserver(ViewModelObserver viewModelObserver) {
        this.viewModelObservers.add(viewModelObserver);
    }

    @Override
    public void removeObserver(ViewModelObserver viewModelObserver) {
        this.viewModelObservers.remove(viewModelObserver);
    }

    @Override
    public void updateView() {
        notifyObservers();
    }
}
