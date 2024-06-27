package nuclearkat.customitemeffects.inventory;

import nuclearkat.customitemeffects.items.registry.InventoryRegistry;
import nuclearkat.customitemeffects.items.registry.ItemRegistry;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class InventoryManager {

    public InventoryManager() {
        this.registerInventories();
    }

    private Inventory itemsMenu(){
        InventoryBuilder itemsMenu = new InventoryBuilder(null, 27, ChatColor.translateAlternateColorCodes('&', "&cItemsMenu"));

        itemsMenu.setItem(ItemRegistry.getInstance().get("BlindingSword"), 12);
        itemsMenu.setItem(ItemRegistry.getInstance().get("WidowsBlade"), 13);
        itemsMenu.setItem(ItemRegistry.getInstance().get("FireballWand"), 14);
        itemsMenu.setItem(ItemRegistry.getInstance().get("HealingStaff"), 15);

        return itemsMenu.build();
    }

    private void registerInventories(){
        InventoryRegistry.getInstance().register("ItemsMenu", itemsMenu());
    }

}
