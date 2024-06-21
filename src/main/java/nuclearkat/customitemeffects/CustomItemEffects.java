package nuclearkat.customitemeffects;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class CustomItemEffects extends JavaPlugin {

    public static List<ItemStackCreation> CUSTOM_ITEMS = new ArrayList<>();

    static {
        CustomSword sword = new CustomSword("&4SomeCustomSword", Material.NETHERITE_SWORD, "&6Some random sword lore");
        CUSTOM_ITEMS.add(sword);

    }


    @Override
    public void onEnable() {

        

    }

    @Override
    public void onDisable() {

    }
}
