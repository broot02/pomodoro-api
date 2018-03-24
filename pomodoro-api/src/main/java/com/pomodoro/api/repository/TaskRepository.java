package com.pomodoro.api.repository;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.pomodoro.api.model.Task;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Brad
 */
@Repository
public class TaskRepository implements DataStoreCrudRepository<Task, Long> {

    @Override
    public Long create(Task type) {
        Datastore ds = getDatastore();

        Key taskKey = ds.allocateId(ds.newKeyFactory().setKind("Task").newKey());
        Entity entity = Entity.newBuilder(taskKey)
                .set("name", type.getName())
                .set("description", type.getDescription())
                .build();

        ds.add(entity);
        return entity.getKey().getId();
    }

    @Override
    public Task read(Long id) {
        Datastore ds = getDatastore();

        Key taskKey = ds.newKeyFactory().setKind("Task").newKey(id);
        Entity entity = ds.get(taskKey);

        Task task = new Task();
        task.setName(entity.getString("name"));
        task.setDescription(entity.getString("description"));
        task.setId(entity.getKey().getId());

        return task;

    }

    @Override
    public Long update(Task type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
