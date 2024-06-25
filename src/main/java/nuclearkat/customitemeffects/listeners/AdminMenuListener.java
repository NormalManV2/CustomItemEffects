package nuclearkat.customitemeffects.listeners;

import nuclearkat.customitemeffects.CustomItemEffects;
import nuclearkat.customitemeffects.items.swords.BlindingSword;
import nuclearkat.customitemeffects.items.swords.WidowsBlade;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AdminMenuListener implements Listener {

    private final CustomItemEffects customItemEffects;

    public AdminMenuListener(CustomItemEffects customItemEffects){
        this.customItemEffects = customItemEffects;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&cAdminMenu"))){
            return;
        }
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        int clickedSlot = event.getRawSlot();
        switch (clickedSlot){

            case 12 -> player.getInventory().addItem(customItemEffects.getCustomItem("BlindingSword").clone());
            case 13 -> player.getInventory().addItem(customItemEffects.getCustomItem("WidowsBlade").clone());

        }

    }

}
