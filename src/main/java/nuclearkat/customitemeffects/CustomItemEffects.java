package nuclearkat.customitemeffects;

import nuclearkat.customitemeffects.command.AdminMenuCommand;
import nuclearkat.customitemeffects.inventory.InventoryManager;
import nuclearkat.customitemeffects.items.ItemBuilder;
import nuclearkat.customitemeffects.items.registry.ItemRegistry;
import nuclearkat.customitemeffects.items.swords.BlindingSword;
import nuclearkat.customitemeffects.items.staffs.FireballWand;
import nuclearkat.customitemeffects.items.staffs.HealingStaff;
import nuclearkat.customitemeffects.items.swords.WidowsBlade;
import nuclearkat.customitemeffects.listeners.ItemsMenuListener;
import nuclearkat.customitemeffects.listeners.CustomItemListener;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class CustomItemEffects extends JavaPlugin {

    private final Map<String, NamespacedKey> cachedKeys = new HashMap<>();
    private final List<ItemBuilder> itemBuilderList = new ArrayList<>();
    private final Map<String, Inventory> customInventoryMap = new HashMap<>();
    private final InventoryManager inventoryManager;

    {
        registerNamespacedKey("CustomItem", new NamespacedKey(this, "custom_item"));

        BlindingSword blindingSword = new BlindingSword("&4Blinding&cSword", Material.DIAMOND_SWORD, "&7Blinds enemies on use, 3 second cooldown");
        WidowsBlade widowsBlade = new WidowsBlade("&4Widows&0Blade", Material.DIAMOND_SWORD, "&7Poisons enemies on use, 5 second cooldown");
        FireballWand fireballWand = new FireballWand("&4Fireball&cWand", Material.STICK, "&7Throws fireballs at enemies on use, 5 second cooldown");
        HealingStaff healingStaff = new HealingStaff("&6Healing&eStaff", Material.STICK, "&7Heals you for 2 hearts on use, 7 second cooldown");

        itemBuilderList.add(blindingSword);
        itemBuilderList.add(widowsBlade);
        itemBuilderList.add(fireballWand);
        itemBuilderList.add(healingStaff);

        ItemRegistry.getInstance().register("BlindingSword", blindingSword.getItemStack());
        ItemRegistry.getInstance().register("WidowsBlade", widowsBlade.getItemStack());
        ItemRegistry.getInstance().register("FireballWand", fireballWand.getItemStack());
        ItemRegistry.getInstance().register("HealingStaff", healingStaff.getItemStack());

        this.inventoryManager = new InventoryManager();
    }


    @Override
    public void onEnable() {
        this.registerListeners();
        this.registerCommands();
    }

    @Override
    public void onDisable() {

    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new CustomItemListener(this), this);
        getServer().getPluginManager().registerEvents(new ItemsMenuListener(), this);
    }

    private void registerCommands() {
        getCommand("ciegui").setExecutor(new AdminMenuCommand(inventoryManager));
    }

    public void registerNamespacedKey(String key, NamespacedKey namespacedKey) {
        cachedKeys.put(key, namespacedKey);
    }

    public NamespacedKey getRegisteredKey(String key) {
        return cachedKeys.get(key);
    }

    public List<ItemBuilder> getItemBuilderList() {
        return Collections.unmodifiableList(itemBuilderList);
    }

    public Inventory getCustomInventory(String name) {
        if (!customInventoryMap.containsKey(name)) {
            return null;
        }
        return customInventoryMap.get(name);
    }

}
