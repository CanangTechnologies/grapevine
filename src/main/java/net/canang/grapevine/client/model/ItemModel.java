package net.canang.grapevine.client.model;

import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public class ItemModel implements Serializable{

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
