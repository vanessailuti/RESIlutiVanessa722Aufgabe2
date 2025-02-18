package src.repository;


import src.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T> implements Repository<T> {
    private final Map<Integer, T> data = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(T obj) {
        data.putIfAbsent(obj.getClass().getModifiers(), obj);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(String name) {
        return data.get(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(T obj) {
        data.replace(obj.getClass().getModifiers(), obj);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String name) {
        data.remove(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> getAll() {
        return data.values().stream().toList();
    }
}
