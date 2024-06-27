package nuclearkat.customitemeffects.items.staffs;

import nuclearkat.customitemeffects.items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class FireballWand extends ItemBuilder {

    public FireballWand(String displayName, Material materialType, String... lore){
        super(displayName, materialType, 5, lore);
    }

    @Override
    public void onUse(Player player, Player target) {
        if (isOnCooldown(player)){
            return;
        }
        player.spawnParticle(Particle.FLAME, target.getLocation(), 5, 0.2, 0.2, 0.2);
        target.setFireTicks(60);
    }
}
