package org.tuxdevelop.spring.cloud.demo.repository;

import org.tuxdevelop.spring.cloud.demo.service.dto.common.CommonPojo;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public abstract class MapRepository<T extends CommonPojo> {

    private AtomicLong currentId;
    private final Map<Long, T> dataStore;

    public MapRepository() {
        this.currentId = new AtomicLong(1L);
        this.dataStore = new LinkedHashMap<>();
    }

    public T save(final T entity) {
        final Long id;
        if (entity.getId() == null || findById(entity.getId()) == null) {
            id = getNextId();
            entity.setId(id);
        } else {
            id = entity.getId();
        }
        dataStore.put(id, entity);
        return entity;
    }

    public T findById(final Long id) {
        final T entity;
        if (id != null && dataStore.containsKey(id)) {
            entity = dataStore.get(id);
        } else {
            entity = null;
        }
        return entity;
    }

    public Boolean delete(final T entity) {
        final Boolean result;
        if (findById(entity.getId()) != null) {
            dataStore.remove(entity.getId());
            result = Boolean.TRUE;
        } else {
            result = Boolean.FALSE;
        }
        return result;
    }

    public List<T> findAll() {
        return new LinkedList<>(dataStore.values());
    }

    synchronized Long getNextId() {
        return currentId.getAndIncrement();
    }

}
