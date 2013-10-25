package net.canang.grapevine.client.data;

import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 10/25/13
 */
public interface DataSource<T extends Serializable> {

    int getRowCount();

    T getRow(int index);

    void add(T t);

    void remove(T t);

}
