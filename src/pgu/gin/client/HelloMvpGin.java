package pgu.gin.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HelloMvpGin implements EntryPoint {

    @Override
    public void onModuleLoad() {
        final HelloGinjector ginjector = GWT.create(HelloGinjector.class);

        final ActivityManager activityManager = ginjector.getActivityManager();

        final SimplePanel appWidget = ginjector.getAppWidget();
        activityManager.setDisplay(appWidget);

        appWidget.getElement().setId("pguSimplePanel");
        RootPanel.get().add(appWidget);

        final PlaceHistoryHandler historyHandler = ginjector.getPlaceHistoryHandler();

        historyHandler.handleCurrentHistory();

        final GreetingServiceAsync greetingService = ginjector.getGreetingService();
        greetingService.greetServer("toto", new AsyncCallback<String>() {

            @Override
            public void onSuccess(final String result) {
                GWT.log("result> " + result);
            }

            @Override
            public void onFailure(final Throwable caught) {
            }
        });

    }
}
