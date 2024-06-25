package nuclearkat.customitemeffects.command;

import nuclearkat.customitemeffects.inventory.InventoryManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminMenuCommand implements CommandExecutor {

    private final InventoryManager inventoryManager;

    public AdminMenuCommand(InventoryManager inventoryManager){
        this.inventoryManager = inventoryManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            return false;
        }

        Player player = (Player) commandSender;
        if (!player.hasPermission("cie.adminmenu")){
            return false;
        }
        player.openInventory(inventoryManager.getAdminMenu());
        return true;
    }
}
