package nuclearkat.customitemeffects.listeners;

import nuclearkat.customitemeffects.items.registry.ItemRegistry;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ItemsMenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&cItemsMenu"))){
            return;
        }
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        if (!player.hasPermission("cie.items_menu.bypass")) {
            return;
        }

        int clickedSlot = event.getRawSlot();
        switch (clickedSlot){
            case 12 -> player.getInventory().addItem(ItemRegistry.getInstance().get("BlindingSword").clone());
            case 13 -> player.getInventory().addItem(ItemRegistry.getInstance().get("WidowsBlade").clone());
            case 14 -> player.getInventory().addItem(ItemRegistry.getInstance().get("FireballWand").clone());
            case 15 -> player.getInventory().addItem(ItemRegistry.getInstance().get("HealingStaff").clone());
        }

    }
}
