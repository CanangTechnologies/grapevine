package net.canang.grapevine.server.model;

import javax.jdo.annotations.*;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class BallotEntity {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private ScoopEntity scoop;

    @Persistent
    private UserEntity user;

    @Persistent
    private Integer ballot; // todo enum  VERIFIED, FALSE, OUT_OF_STOCK

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScoopEntity getScoop() {
        return scoop;
    }

    public void setScoop(ScoopEntity scoop) {
        this.scoop = scoop;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Integer getBallot() {
        return ballot;
    }

    public void setBallot(Integer ballot) {
        this.ballot = ballot;
    }
}
