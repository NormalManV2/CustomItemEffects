package nuclearkat.customitemeffects;

import nuclearkat.customitemeffects.items.ItemStackCreation;
import nuclearkat.customitemeffects.items.swords.CustomSword;
import nuclearkat.customitemeffects.items.swords.WidowsBlade;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class CustomItemEffects extends JavaPlugin {

    public static List<ItemStackCreation> CUSTOM_ITEMS = new ArrayList<>();

    static {
        CUSTOM_ITEMS.add(new CustomSword("&4Blinding&cBlade", Material.DIAMOND_SWORD, "&7Blinds enemies on use, 3 second cooldown"));
        CUSTOM_ITEMS.add(new WidowsBlade("&4Widows&0Blade", Material.DIAMOND_SWORD, "&7Poisons enemies on use, 5 second cooldown"));
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
