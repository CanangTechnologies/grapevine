package net.canang.grapevine.server;

import net.canang.grapevine.client.model.*;
import net.canang.grapevine.server.model.*;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public class GrapevineConverter {

    public ScoopModel convert(ScoopEntity entity) {
        ScoopModel model = new ScoopModel();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());
        model.setPriceAfter(entity.getPriceAfter());
        model.setPriceBefore(entity.getPriceBefore());
        model.setStatus(entity.getStatus());
        return model;
    }

    public UserModel convert(UserEntity entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setName(entity.getName());
        model.setAge(entity.getAge());
        model.setLatitude(entity.getLatitude());
        model.setLongitude(entity.getLongitude());
        return model;
    }

    public PlaceModel convert(PlaceEntity entity) {
        PlaceModel model = new PlaceModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getName());
        model.setLatitude(entity.getLatitude());
        model.setLongitude(entity.getLongitude());
        return model;
    }

    public ItemModel convert(ItemEntity entity) {
        ItemModel model = new ItemModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

    public CategoryModel convert(CategoryEntity entity) {
        CategoryModel model = new CategoryModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }
}
