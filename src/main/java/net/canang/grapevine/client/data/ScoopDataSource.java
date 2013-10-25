package net.canang.grapevine.client.data;

import net.canang.grapevine.client.model.ScoopModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public class ScoopDataSource implements DataSource<ScoopModel> {

    private List<ScoopModel> data = new ArrayList<ScoopModel>();

    public ScoopDataSource(List<ScoopModel> scoops) {
        if (scoops != null) {
            for (ScoopModel m : scoops) {
                data.add(m);
            }
        }
    }

    public int getRowCount() {
        return data.size();
    }

    public ScoopModel getRow(int i) {
        return data.get(i);
    }

    public void add(ScoopModel m) {
        if (m == null) return;

        if (data.contains(m)) {
            int i = data.indexOf(m);
            data.set(i, m);
        } else {
            data.add(m);
        }
    }

    public void remove(ScoopModel m) {
        if (m == null || m.getId() == null) return;

        for (int i = 0; i < data.size(); i++) {
            if (m.getId().equals(data.get(i).getId())) {
                data.remove(i);
                break;
            }
        }
    }

}
