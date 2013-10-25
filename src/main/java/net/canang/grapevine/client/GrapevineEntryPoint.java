package net.canang.grapevine.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.UmbrellaException;
import net.canang.grapevine.client.controller.ScoopController;
import net.canang.grapevine.client.widget.MessageDialog;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public class GrapevineEntryPoint implements EntryPoint {

    private final ScoopServiceAsync scoopServiceAsync = GWT.create(ScoopService.class);

    public void onModuleLoad() {
        GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {

            public void onUncaughtException(Throwable e) {
                Throwable ue = unwrap(e);
                MessageDialog msgDialog = new MessageDialog(ue, "Erro durante execução");
                msgDialog.center();
                msgDialog.show();
            }
        });

        new ScoopController(scoopServiceAsync);
    }

    private Throwable unwrap(Throwable e) {
        if (e instanceof UmbrellaException) {
            UmbrellaException ue = (UmbrellaException) e;
            if (ue.getCauses().size() == 1) {
                return unwrap(ue.getCauses().iterator().next());
            }
        }
        return e;
    }
}
