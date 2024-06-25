package nuclearkat.customitemeffects.items.util;

import nuclearkat.customitemeffects.CustomItemEffects;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ItemUtils {

    private static final CustomItemEffects customItemEffects = CustomItemEffects.getPlugin(CustomItemEffects.class);


    public static boolean isSimilar(ItemStack heldItem, ItemStack customItem){
        if (heldItem == null && !heldItem.hasItemMeta()) {
            System.out.println("held item is null || held item has no meta");
            return false;
        }
        ItemMeta meta1 = heldItem.getItemMeta();
        ItemMeta meta2 = customItem.getItemMeta();
        if (meta1 == null || meta2 == null) {
            System.out.println("held item meta is null || custom item meta is null");
            return false;
        }

        if (!meta1.getDisplayName().equals(meta2.getDisplayName())) {
            System.out.println("held item name is not the same as custom item name");
            return false;
        }

        if (!meta1.getLore().equals(meta2.getLore())) {
            System.out.println("held item lore is not the same as custom item lore");
            return false;
        }

        PersistentDataContainer data1 = meta1.getPersistentDataContainer();
        PersistentDataContainer data2 = meta2.getPersistentDataContainer();

        return data1.has(customItemEffects.getRegisteredKey("CustomItem"), PersistentDataType.STRING) &&
                data2.has(customItemEffects.getRegisteredKey("CustomItem"), PersistentDataType.STRING) &&
                data1.get(customItemEffects.getRegisteredKey("CustomItem"), PersistentDataType.STRING)
                        .equals(data2.get(customItemEffects.getRegisteredKey("CustomItem"), PersistentDataType.STRING));
    }

    public static boolean isCustomItem(ItemStack itemStack){
        if (itemStack == null || !itemStack.hasItemMeta()){
            return false;
        }
        ItemMeta itemMeta  = itemStack.getItemMeta();
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();

        return container.has(customItemEffects.getRegisteredKey("CustomItem"), PersistentDataType.STRING);
    }

}
