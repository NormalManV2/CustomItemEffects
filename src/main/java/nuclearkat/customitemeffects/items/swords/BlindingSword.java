package nuclearkat.customitemeffects.items.swords;

import nuclearkat.customitemeffects.CustomItemEffects;
import nuclearkat.customitemeffects.items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlindingSword extends ItemBuilder {

    private final CustomItemEffects customItemEffects = CustomItemEffects.getPlugin(CustomItemEffects.class);

    public BlindingSword(String displayName, Material materialType,  String... lore){
        super(displayName, materialType, 3,  lore);
    }

    @Override
    public void onUse(Player player, Player target) {
        if (isOnCooldown(player)){
            return;
        }
        double abilityChance = customItemEffects.getConfig().getDouble("items.blinding_sword.ability_chance", 0.5);
        if (Math.random() < abilityChance) {
            PotionEffect potionEffect = new PotionEffect(PotionEffectType.BLINDNESS, 40, 1);
            target.addPotionEffect(potionEffect);
            player.spawnParticle(Particle.ASH, target.getEyeLocation().add(0, 0.5, 0), 5);
            applyCooldown(player);
        }
    }
}
