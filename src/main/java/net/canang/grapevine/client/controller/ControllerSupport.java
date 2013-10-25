package net.canang.grapevine.client.controller;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;

import java.util.HashMap;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public class ControllerSupport implements ClickHandler {

    private HashMap<String, ClickHandler> handlers;

    public ControllerSupport() {
        handlers = new HashMap<String, ClickHandler>();
    }

    public void onClick(ClickEvent event) {
        Widget w = (Widget) event.getSource();
        if (w == null) {
            return;
        }
        String text = w.getElement().getInnerText();
        ClickHandler handler = handlers.get(text);
        if (handler != null) {
            handler.onClick(event);
        }
    }

    public void registerHandler(Widget w, ClickHandler h) {
        if (w == null || h == null) {
            return;
        }
        w.addDomHandler(h, ClickEvent.getType());
        String text = w.getElement().getInnerText();
        handlers.put(text, h);
    }
}
