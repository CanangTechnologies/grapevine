package net.canang.grapevine.server.model;

import javax.jdo.annotations.*;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class CategoryEntity {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
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
