package net.canang.grapevine.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import net.canang.grapevine.client.model.ScoopModel;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
@RemoteServiceRelativePath("scoopService")
public interface ScoopService extends RemoteService {

    void save(ScoopModel model) throws RuntimeException;

    void delete(ScoopModel model) throws RuntimeException;

    List<ScoopModel> findScoops() throws RuntimeException;

    List<ScoopModel> findScoops(Float latitude, Float longitude) throws RuntimeException;

}
