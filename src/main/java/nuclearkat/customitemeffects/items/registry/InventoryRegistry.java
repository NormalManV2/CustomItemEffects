package nuclearkat.customitemeffects.items.registry;

import nuclearkat.customitemeffects.api.impl.AbstractRegistry;
import org.bukkit.inventory.Inventory;

public class InventoryRegistry extends AbstractRegistry<Inventory> {

    private static InventoryRegistry instance;

    private InventoryRegistry() {}

    public static InventoryRegistry getInstance() {
        if (instance == null) {
            instance = new InventoryRegistry();
        }
        return instance;
    }
}
