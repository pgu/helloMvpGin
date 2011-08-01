package pgu.gin.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class HelloModule extends AbstractGinModule {

    @Override
    protected void configure() {
        GWT.log("configure ");

        bind(HasOneWidget.class).to(SimplePanel.class).in(Singleton.class);
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

        bind(ActivityMapper.class).to(AppActivityMapper.class).in(Singleton.class);

        bind(AppPlaceHistoryMapper.class).in(Singleton.class);

        bind(FirstView.class).to(FirstViewImpl.class).in(Singleton.class);
        bind(SecondView.class).to(SecondViewImpl.class).in(Singleton.class);

    }

    @Singleton
    @Provides
    PlaceController getPlaceController(final EventBus eventBus) {
        return new PlaceController(eventBus);
    }

    @Singleton
    @Provides
    PlaceHistoryHandler getPlaceHistoryHandler(final AppPlaceHistoryMapper historyMapper, final EventBus eventBus,
            final PlaceController placeController) {
        final PlaceHistoryHandler phh = new PlaceHistoryHandler(historyMapper);
        phh.register(placeController, eventBus, new FirstPlace());
        return phh;
    }

    @Singleton
    @Provides
    ActivityManager getActivityManager(final ActivityMapper activityMapper, final EventBus eventBus) {
        final ActivityManager am = new ActivityManager(activityMapper, eventBus);
        return am;
    }
}
