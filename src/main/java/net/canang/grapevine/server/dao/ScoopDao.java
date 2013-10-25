package net.canang.grapevine.server.dao;

import net.canang.grapevine.server.model.ScoopEntity;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public interface ScoopDao {

    ScoopEntity findById(Long id);

    void save(ScoopEntity me);

    void delete(ScoopEntity me);

    List<ScoopEntity> findScoops();

    List<ScoopEntity> findScoops(Float latitude, Float longitude);

}
