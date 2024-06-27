package nuclearkat.customitemeffects.api.impl;

import nuclearkat.customitemeffects.api.RegistryInterface;
import org.bukkit.Bukkit;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractRegistry<T> implements RegistryInterface<T> {

    protected final Map<String, T> registry = new ConcurrentHashMap<>();

    @Override
    public Map<String, T> getRegistry(){
        return Collections.unmodifiableMap(registry);
    }

    /**
     * Registers an object with an associated key to the registry.
     *
     * @param key The key to assign to the value.
     * @param object The object to register.
     */
    @Override
    public void register(String key, T object){
        if (key == null || object == null) {
            throw new IllegalArgumentException("Key or Object cannot be null");
        }
        registry.put(key, object);
    }

    /**
     * Unregisters an object with associated key.
     *
     * @param key The key to unregister.
     */
    @Override
    public void unregister(String key){
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        registry.remove(key);
    }

    /**
     * Get an object from the registry.
     *
     * @param key The key used to get the object.
     * @return Returns the object found with associated key.
     */
    @Override
    public T get(String key){
        T object = registry.get(key);
        if (object == null) {
            Bukkit.getLogger().severe("Object with key " + key + " not found in " + this.getClass().getSimpleName());
        }
        return object;
    }
}
