package com.pomodoro.api.repository;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import org.springframework.stereotype.Repository;

/**
 * Used as the default repository interface for dealing with the google
 * datastore.
 *
 * @author Brad
 */
@Repository
interface DataStoreCrudRepository<T, I> {

    default Datastore getDatastore() {
        return DatastoreOptions.getDefaultInstance().getService();
    }

    I create(T type);

    T read(I id);

    I update(T type);

    void delete(I id);

}
