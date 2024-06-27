package nuclearkat.customitemeffects.api;

import java.util.Map;

public interface RegistryInterface<T> {
    Map<String, T> getRegistry();
    void register(String key, T item);
    void unregister(String key);
    T get(String key);
}
