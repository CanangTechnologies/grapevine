package net.canang.grapevine.server.model;

import javax.jdo.annotations.*;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class ScoopEntity {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private String title;

    @Persistent
    private String description;

    @Persistent
    private PlaceEntity place;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }
}
