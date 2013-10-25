package net.canang.grapevine.client.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
@SuppressWarnings({"ALL"})
public class MessageDialog extends DialogBox {

    public MessageDialog(Throwable ex, String title) {
        this(ex.getMessage(), title, "labelError");
    }

    public MessageDialog(String msg, String title) {
        this(msg, title, "");
    }

    public MessageDialog(String msg, String title, String cssClass) {
        final Button bFechar = new Button("Fechar");
        bFechar.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                hide();
            }
        });

        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<h4>" + title + "</h4>"));
        dialogVPanel.add(new HTML("<p class='" + (cssClass == null ? "" : cssClass) + "'>" + msg + "</p>"));

        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_JUSTIFY);
        dialogVPanel.add(bFechar);
        add(dialogVPanel);
    }
}
