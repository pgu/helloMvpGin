package pgu.gin.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AppActivityMapper implements ActivityMapper {

    @Inject
    Provider<FirstActivity> firstActivityProvider;
    @Inject
    Provider<SecondActivity> secondActivityProvider;

    @Override
    public Activity getActivity(final Place place) {

        if (place instanceof FirstPlace) {
            return firstActivityProvider.get().setPlace((FirstPlace) place);
        } else if (place instanceof SecondPlace) {
            return secondActivityProvider.get().setPlace((SecondPlace) place);
        }

        return null;
    }
}
