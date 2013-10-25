package net.canang.grapevine.client.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.FlexTable;
import net.canang.grapevine.client.data.DataSource;
import net.canang.grapevine.client.data.ScoopDataSource;
import net.canang.grapevine.client.model.ScoopModel;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
@SuppressWarnings({"ALL"})
public class ScoopTable extends FlexTable {

    private DataSource<ScoopModel> source;

    private int selectedRow;

    public ScoopTable() {
        setText(0, 0, "ID");
        setText(0, 1, "Name");
        setText(0, 2, "Description");
        setText(0, 3, "Before");
        setText(0, 4, "After");
        setText(0, 5, "Reporter");
        setText(0, 6, "Place");
        setCellPadding(6);

        getRowFormatter().addStyleName(0, "listHeader");
        addStyleName("list");
        getCellFormatter().addStyleName(0, 1, "listTextColumn");
        getCellFormatter().addStyleName(0, 2, "listTextColumn");
        getCellFormatter().addStyleName(0, 3, "listNumericColumn");
        getCellFormatter().addStyleName(0, 4, "listNumericColumn");

        addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                Cell td = getCellForEvent(event);
                if (td == null) return;

                boolean sameRow = selectedRow == td.getRowIndex();
                changeRow(selectedRow, false);
                selectedRow = td.getRowIndex();
                changeRow(selectedRow, !sameRow);
                if (sameRow) selectedRow = 0;
            }
        });
    }

    public void fillTable(List<ScoopModel> scoops) {
        source = new ScoopDataSource(scoops);
        updateAll();
    }

    private void updateAll() {
        for (int i = this.getRowCount() - 1; i > 0; i--) {
            this.removeRow(1);
        }

        int rows = source.getRowCount();
        for (int i = 0; i < rows; i++) {
            ScoopModel m = source.getRow(i);
            insertRow(i + 1, m);
        }
        this.selectedRow = 0;
    }

    private void insertRow(final int row, ScoopModel m) {
        setText(row, 0, m.getId().toString());
        setText(row, 1, m.getTitle());
        setText(row, 2, m.getDescription());
        setText(row, 3, m.getPriceBefore().toEngineeringString());
        setText(row, 4, m.getPriceAfter().toEngineeringString());
        setText(row, 5, m.getReporter().getName());
        setText(row, 6, m.getPlace().getName());
        getCellFormatter().addStyleName(row, 3, "listNumericColumn");
        getCellFormatter().addStyleName(row, 4, "listNumericColumn");
    }

    /**
     * Marca a seleção da linha na tabela.
     *
     * @param row
     * @param selected
     */
    private void changeRow(int row, boolean selected) {
        if (row > 0) {
            Element tr = getRowFormatter().getElement(row);
            if (tr != null)
                DOM.setStyleAttribute(tr, "backgroundColor", selected ? "#ffce00" : "#ffffff");
        }
    }

    public ScoopModel getScoopModelSelected() {
        if (source == null || selectedRow == 0)
            return null;

        return source.getRow(selectedRow - 1);
    }

    public void add(ScoopModel m) {
        source.add(m);
        updateAll();
    }

    public void remove(ScoopModel m) {
        source.remove(m);
        updateAll();
    }
}
