package pgu.gin.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

public class FirstViewImpl extends Composite implements FirstView {

    private FirstView.Presenter listener;

    public FirstViewImpl() {
        final Button btn = new Button("Im First. Go to Second.");
        initWidget(btn);

        btn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                listener.goTo(new SecondPlace());
            }
        });
    }

    @Override
    public void setPresenter(final Presenter listener) {
        this.listener = listener;
    }

}
