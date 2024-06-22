package nuclearkat.customitemeffects.items.swords;

import nuclearkat.customitemeffects.items.ItemStackCreation;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomSword extends ItemStackCreation {

    public CustomSword(String displayName, Material materialType, String... lore){
        super(displayName, materialType, 3, lore);
    }

    @Override
    public void onUse(Player player, Player target) {
        if (isOnCooldown(player)){
            return;
        }
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.BLINDNESS, 2, 1);
        target.addPotionEffect(potionEffect);
        player.spawnParticle(Particle.ASH, target.getEyeLocation().add(0, 0.5, 0), 5);
        applyCooldown(player);
    }
}
