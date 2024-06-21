package nuclearkat.customitemeffects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomSword extends ItemStackCreation {

    public CustomSword(String displayName, Material materialType, String... lore){
        super(displayName, materialType, 3, lore);
    }

    @Override
    public void onUse(Player player) {
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.BLINDNESS, getCooldown(), 1);
        player.addPotionEffect(potionEffect);
    }


}
