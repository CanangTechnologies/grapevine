package net.canang.grapevine.server;

import net.canang.grapevine.client.model.ScoopModel;
import net.canang.grapevine.server.model.ScoopEntity;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public class ScoopConverter {

    public ScoopModel convert(ScoopEntity entity){
        ScoopModel model = new ScoopModel();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());
        model.setPriceAfter(entity.getPriceAfter());
        model.setPriceBefore(entity.getPriceBefore());
        model.setStatus(entity.getStatus());
        return model;
    }
}
