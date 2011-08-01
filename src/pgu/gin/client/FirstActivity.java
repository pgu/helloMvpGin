package pgu.gin.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class FirstActivity extends AbstractActivity implements FirstView.Presenter {

    @Inject
    FirstView view;
    @Inject
    PlaceController placeController;

    FirstPlace place;

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
    }

    @Override
    public void goTo(final Place place) {
        placeController.goTo(place);
    }

    public AbstractActivity setPlace(final FirstPlace place) {
        this.place = place;
        return this;
    }
}
