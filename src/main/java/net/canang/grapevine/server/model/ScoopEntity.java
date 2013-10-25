package net.canang.grapevine.server.model;

import javax.jdo.annotations.*;
import java.math.BigDecimal;

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
    private Integer status; // todo enum WHISPER, RUMOR, FACT

    @Persistent
    private BigDecimal priceBefore;

    @Persistent
    private BigDecimal priceAfter;

    @Persistent
    private PlaceEntity place;

    @Persistent
    private UserEntity reporter;


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

    public BigDecimal getPriceBefore() {
        return priceBefore;
    }

    public void setPriceBefore(BigDecimal priceBefore) {
        this.priceBefore = priceBefore;
    }

    public BigDecimal getPriceAfter() {
        return priceAfter;
    }

    public void setPriceAfter(BigDecimal priceAfter) {
        this.priceAfter = priceAfter;
    }

    public UserEntity getReporter() {
        return reporter;
    }

    public void setReporter(UserEntity reporter) {
        this.reporter = reporter;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }
}
