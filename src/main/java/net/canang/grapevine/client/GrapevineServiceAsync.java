package net.canang.grapevine.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import net.canang.grapevine.client.model.ScoopModel;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public interface GrapevineServiceAsync {

    void save(ScoopModel model, AsyncCallback<Void> callback);

    void delete(ScoopModel model, AsyncCallback<Void> callback);

    void findScoops(AsyncCallback<List<ScoopModel>> callback);

    void findScoops(Float latitude, Float longitude, AsyncCallback<List<ScoopModel>> callback);

}
