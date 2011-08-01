package pgu.gin.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

public class SecondViewImpl extends Composite implements SecondView {

    private SecondView.Presenter listener;

    public SecondViewImpl() {
        final Button btn = new Button("Im Second. Go to First.");
        initWidget(btn);

        btn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                listener.goTo(new FirstPlace());
            }
        });
    }

    @Override
    public void setPresenter(final Presenter listener) {
        this.listener = listener;
    }

}
