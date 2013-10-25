package net.canang.grapevine.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import net.canang.grapevine.client.ScoopService;
import net.canang.grapevine.client.model.ScoopModel;
import net.canang.grapevine.server.dao.ScoopDao;
import net.canang.grapevine.server.dao.ScoopDaoImpl;
import net.canang.grapevine.server.model.ScoopEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public class ScoopServiceImpl extends RemoteServiceServlet implements ScoopService {

    private static Logger log = Logger.getLogger(ScoopServiceImpl.class.getName());

    private ScoopDao dao = new ScoopDaoImpl();

    private ScoopConverter converter = new ScoopConverter();

    public void save(ScoopModel m) {
        try {
            dao.save(new ScoopEntity());
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public void delete(ScoopModel m) {
        try {
            dao.delete(dao.findById(m.getId()));
        } catch (RuntimeException e) {
        }
    }

    public List<ScoopModel> findScoops() {
        List<ScoopModel> models = new ArrayList<ScoopModel>();
        try {
            List<ScoopEntity> scoops = dao.findScoops();
            for (ScoopEntity scoop : scoops) {
                models.add(converter.convert(scoop));
            }
        } catch (RuntimeException e) {
        }
        return models;
    }

    public List<ScoopModel> findScoops(Float latitude, Float longitude) {
        List<ScoopModel> models = new ArrayList<ScoopModel>();
        try {
            List<ScoopEntity> scoops = dao.findScoops(latitude, longitude);
            for (ScoopEntity scoop : scoops) {
                models.add(converter.convert(scoop));
            }
        } catch (RuntimeException e) {
        }
        return models;
    }
}
