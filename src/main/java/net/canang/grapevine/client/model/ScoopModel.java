package net.canang.grapevine.client.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ScoopModel implements Serializable {

    private Long id;

    private String title;

    private String description;

    private BigDecimal priceBefore;
    private BigDecimal priceAfter;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoopModel that = (ScoopModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
