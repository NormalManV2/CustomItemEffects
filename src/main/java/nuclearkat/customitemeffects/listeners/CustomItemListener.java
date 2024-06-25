package nuclearkat.customitemeffects.listeners;

import nuclearkat.customitemeffects.CustomItemEffects;
import nuclearkat.customitemeffects.items.util.ItemUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class CustomItemListener implements Listener {

    private final CustomItemEffects customItemEffects;

    public CustomItemListener(CustomItemEffects customItemEffects) {
        this.customItemEffects = customItemEffects;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
        if (!(event.getDamager() instanceof Player damager) || !(event.getEntity() instanceof Player target)) {
            return;
        }

        ItemStack heldItem = damager.getInventory().getItemInMainHand();
        if (!ItemUtils.isCustomItem(heldItem)) {
            System.out.println("held item is not custom!");
            return;
        }

        customItemEffects.getItemBuilderList().stream()
                .filter(customItem -> ItemUtils.isSimilar(heldItem, customItem.getItemStack()))
                .findFirst()
                .ifPresent(customItem -> {
                    System.out.println("Custom Ability Triggered!");
                    customItem.onUse(damager, target);
                });
    }
}



