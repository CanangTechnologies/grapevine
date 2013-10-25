package net.canang.grapevine.client.callback;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public abstract class DefaultCallback<T> implements AsyncCallback<T> {

    public void onFailure(Throwable t) {
        throw new RuntimeException("Error: " + t.getMessage(), t);
    }
}
