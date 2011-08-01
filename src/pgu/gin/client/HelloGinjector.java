package pgu.gin.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.SimplePanel;

@GinModules({ HelloModule.class })
public interface HelloGinjector extends Ginjector {

    SimplePanel getAppWidget();

    GreetingServiceAsync getGreetingService();

    PlaceHistoryHandler getPlaceHistoryHandler();

    ActivityManager getActivityManager();

}
