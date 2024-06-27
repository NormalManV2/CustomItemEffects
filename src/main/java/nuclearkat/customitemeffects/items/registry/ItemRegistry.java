package nuclearkat.customitemeffects.items.registry;

import nuclearkat.customitemeffects.api.impl.AbstractRegistry;
import org.bukkit.inventory.ItemStack;

public class ItemRegistry extends AbstractRegistry<ItemStack> {

    private static ItemRegistry instance;

    private ItemRegistry() {}

    public static ItemRegistry getInstance() {
        if (instance == null) {
            instance = new ItemRegistry();
        }
        return instance;
    }
}
