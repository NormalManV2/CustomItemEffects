package nuclearkat.customitemeffects.listeners;

import nuclearkat.customitemeffects.CustomItemEffects;
import nuclearkat.customitemeffects.items.ItemStackCreation;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CustomItemListener implements Listener {

    private final CustomItemEffects customItemEffects;

    public CustomItemListener(CustomItemEffects customItemEffects) {
        this.customItemEffects = customItemEffects;
    }

    // TODO: Figure a more efficient way to check for custom items.
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
        if (!(event.getDamager() instanceof Player)){
            return;
        }
        if (!(event.getEntity() instanceof Player)){
            return;
        }
        Player damager = (Player) event.getDamager();
        Player target = (Player) event.getEntity();
        ItemStack heldItem = damager.getInventory().getItemInMainHand();
        if (!isCustomItem(heldItem)) return;

        for (ItemStackCreation customItem : CustomItemEffects.CUSTOM_ITEMS){
           if (heldItem.isSimilar(customItem.getCreatedItemStack())) {
               customItem.onUse(damager, target);
               break;
           }
        }


    }

    private boolean isCustomItem(ItemStack itemStack){
        if (itemStack == null || !itemStack.hasItemMeta()){
            return false;
        }
        ItemMeta itemMeta  = itemStack.getItemMeta();
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();

        return container.has(new NamespacedKey(customItemEffects, "custom_item"), PersistentDataType.STRING);
    }

}
