package net.canang.grapevine.server.dao;

import net.canang.grapevine.server.model.ScoopEntity;

import javax.jdo.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public class ScoopDaoImpl implements ScoopDao {

    private static final PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("ggc-pm");

    public void save(ScoopEntity me) {
        PersistenceManager pm = getPersistenceManager();
        try {
            pm.makePersistent(me);
        } catch (Exception e) {
            throw new RuntimeException("Error:" + e.getMessage());
        } finally {
            pm.close();
        }
    }

    public void delete(ScoopEntity scoop) {
        PersistenceManager pm = getPersistenceManager();
        try {
            ScoopEntity me = pm.getObjectById(ScoopEntity.class, scoop.getId());
            pm.deletePersistent(me);
        } catch (Exception e) {
            throw new RuntimeException("Error" + e.getMessage());
        } finally {
            pm.close();
        }
    }

    public List<ScoopEntity> findScoops() {
        PersistenceManager pm = getPersistenceManager();
        try {
            Query q = pm.newQuery(ScoopEntity.class);
            List<ScoopEntity> lista = (List<ScoopEntity>) q.execute();
            lista.size();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException("Error:" + e.getMessage());
        } finally {
            pm.close();
        }
    }

    public List<ScoopEntity> findScoops(Float latitude, Float longitude) {
        PersistenceManager pm = getPersistenceManager();
        try {
            Query q = pm.newQuery(ScoopEntity.class);
            List<ScoopEntity> lista = (List<ScoopEntity>) q.execute();
            lista.size();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException("Error:" + e.getMessage());
        } finally {
            pm.close();
        }
    }

    public ScoopEntity findById(Long id) {
        PersistenceManager pm = getPersistenceManager();
        try {
            return pm.getObjectById(ScoopEntity.class, id);
        } catch (JDOObjectNotFoundException nex) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error:" + e.getMessage());
        } finally {
            pm.close();
        }
    }

    private PersistenceManager getPersistenceManager() {
        return factory.getPersistenceManager();
    }
}
