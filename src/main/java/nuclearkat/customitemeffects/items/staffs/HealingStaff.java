package nuclearkat.customitemeffects.items.staffs;

import nuclearkat.customitemeffects.items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class HealingStaff extends ItemBuilder {

    public HealingStaff(String displayName, Material materialType, String... lore){
        super(displayName, materialType, 7, lore);
    }

    @Override
    public void onUse(Player player, Player target) {
        if (isOnCooldown(player)){
            return;
        }
        double playerHealth = player.getHealth();
        player.setHealth(playerHealth + 2.0);
        player.spawnParticle(Particle.HEART, player.getLocation(), 5, 0.5, 0.5, 0.5);
    }
}
