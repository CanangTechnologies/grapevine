package net.canang.grapevine.client.controller;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.ui.*;
import net.canang.grapevine.client.GrapevineServiceAsync;
import net.canang.grapevine.client.callback.DefaultCallback;
import net.canang.grapevine.client.model.ScoopModel;
import net.canang.grapevine.client.widget.ScoopTable;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
@SuppressWarnings({"ALL"})
public class ScoopController extends ControllerSupport {

    private GrapevineServiceAsync service;

    private VerticalPanel mainPanel = new VerticalPanel();
    private ScoopTable scoopTable = new ScoopTable();
    private HorizontalPanel buttonPanel = new HorizontalPanel();
    private Label lastUpdatedLabel = new Label();

    public ScoopController(GrapevineServiceAsync s) {
        this.service = s;

//            final ScoopModelDialog incluirDialog = new IncluirScoopModelDialog();
//            registerHandler(incluirDialog.getbSalvar(), new ClickHandler() {
//                @Override
//                public void onClick(ClickEvent event) {
//                    final ScoopModel m = incluirDialog.getScoopModel();
//                    if (m == null) return;
//
//                    service.add(m, new DefaultCallback<Long>() {
//                        @Override
//                        public void onSuccess(Long result) {
//                            m.setId(result);
//
//                            scoopTable.add(m);
//                            incluirDialog.hide();
//                        }
//
//                    });
//                }
//            });
//            registerHandler(incluirDialog.getbCancelar(), new ClickHandler() {
//                @Override
//                public void onClick(ClickEvent event) {
//                    incluirDialog.hide();
//                }
//            });
//
//            Button bNova = new Button("Nova");
//            registerHandler(bNova, new ClickHandler() {
//                @Override
//                public void onClick(ClickEvent event) {
//                    incluirDialog.center();
//                    incluirDialog.show();
//                }
//            });

        Button bEditar = new Button("Editar");
        registerHandler(bEditar, new ClickHandler() {
            public void onClick(ClickEvent event) {
                ScoopModel m = scoopTable.getScoopModelSelected();
                if (m == null) return;

//                    incluirDialog.setScoopModel(m);
//                    incluirDialog.center();
//                    incluirDialog.show();
            }
        });

        Button bExcluir = new Button("Excluir");
        registerHandler(bExcluir, new ClickHandler() {
            public void onClick(ClickEvent event) {
                final ScoopModel m = scoopTable.getScoopModelSelected();
                if (m == null) return;

                service.delete(m, new DefaultCallback<Void>() {
                    public void onSuccess(Void result) {
                    }
                });
            }
        });

        Button bAtualizar = new Button("Atualizar");
        registerHandler(bAtualizar, new ClickHandler() {
            public void onClick(ClickEvent event) {
                fillTable();
            }
        });

        buttonPanel.addStyleName("buttonPanel");
//            buttonPanel.add(bNova);
//            buttonPanel.add(bEditar);
//            buttonPanel.add(bExcluir);
//            buttonPanel.add(bAtualizar);
        mainPanel.add(scoopTable);
        mainPanel.add(buttonPanel);
        mainPanel.add(lastUpdatedLabel);
        RootPanel.get("ScoopModelList").add(mainPanel);

        fillTable();
    }

    private void updateStateButtons(final boolean enabled) {
        Iterator<Widget> it = buttonPanel.iterator();
        while (it.hasNext()) {
            Widget w = it.next();
            if (w instanceof Button) {
                ((Button) w).setEnabled(enabled);
            }
        }
    }

    private void fillTable() {
        updateStateButtons(false);
        service.findScoops(new DefaultCallback<List<ScoopModel>>() {
            public void onSuccess(List<ScoopModel> scoops) {
                scoopTable.clear();
                fillTable(scoops);
                updateStateButtons(true);
            }

            @Override
            public void onFailure(Throwable caught) {
                updateStateButtons(true);
                super.onFailure(caught);
            }
        });
    }

    private void fillTable(List<ScoopModel> scoops) {
        scoopTable.fillTable(scoops);
        lastUpdatedLabel.setText("Última consulta: " + DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_MEDIUM).format(new Date()));
    }
}
