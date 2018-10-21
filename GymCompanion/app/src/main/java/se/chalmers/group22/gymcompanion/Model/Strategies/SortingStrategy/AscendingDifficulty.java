package se.chalmers.group22.gymcompanion.Model.Strategies.SortingStrategy;

import se.chalmers.group22.gymcompanion.Model.ISortable;

import java.util.Comparator;
import java.util.List;

/***
 * Title: AscendingDifficulty
 *
 * @author Alexander Bergsten
 * @author Marcus Svensson
 * @author Erik Bock
 * @author Augustas Eidikis
 * @author Daniel Olsson
 *
 * Created: October 19, 2018
 *
 * Purpose: Sorts in ascending difficulty order.
 * Used by: BrowseViewModel.java, GymCompanionSortAndFilterTest.java
 * Uses: ISortable.java
 */
public class AscendingDifficulty implements SortingStrategy {

    @Override
    public <T extends ISortable> void sort(List<T> list){
        list.sort(Comparator.comparingDouble(ISortable::getDifficulty));
    }

}
