package src.repository;


import src.model.Charakteren;
import src.model.Produkten;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryRepository<T> implements Repository<T> {
    private final Map<String, T> data = new HashMap<>();

    /**
     * Extracts the key for the repository.
     * If the object is a Charakteren, it uses the ID.
     * If the object is a Produkten, it uses the name.
     *
     * @param obj The object to determine the key for.
     * @return The unique key as a String.
     */
    private String getKey(T obj) {
        if (obj instanceof Charakteren) {
            return String.valueOf(((Charakteren) obj).getId());
        } else if (obj instanceof Produkten) {
            return ((Produkten) obj).getName();
        }
        throw new IllegalArgumentException("Unsupported type: " + obj.getClass().getSimpleName());
    }

    @Override
    public void create(T obj) {
        String key = getKey(obj);
        data.put(key, obj);
    }

    @Override
    public T get(String key) {
        return data.get(key);
    }

    @Override
    public void update(T obj) {
        String key = getKey(obj);
        data.put(key, obj);
    }

    @Override
    public void delete(String key) {
        data.remove(key);
    }

    @Override
    public List<T> getAll() {
        return data.values().stream().collect(Collectors.toList());
    }
}
