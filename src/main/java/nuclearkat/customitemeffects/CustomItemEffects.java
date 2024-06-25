package nuclearkat.customitemeffects;

import nuclearkat.customitemeffects.command.AdminMenuCommand;
import nuclearkat.customitemeffects.inventory.InventoryManager;
import nuclearkat.customitemeffects.items.ItemBuilder;
import nuclearkat.customitemeffects.items.swords.BlindingSword;
import nuclearkat.customitemeffects.items.swords.WidowsBlade;
import nuclearkat.customitemeffects.listeners.AdminMenuListener;
import nuclearkat.customitemeffects.listeners.CustomItemListener;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class CustomItemEffects extends JavaPlugin {

    private final Map<String, NamespacedKey> cachedKeys = new HashMap<>();
    private final List<ItemBuilder> itemBuilderList = new ArrayList<>();
    private final Map<String, ItemStack> customItemMap = new HashMap<>();
    private final InventoryManager inventoryManager = new InventoryManager(this);

    {
        registerNamespacedKey("CustomItem", new NamespacedKey(this, "custom_item"));

        BlindingSword blindingSword = new BlindingSword(this, "&4Blinding&cSword", Material.DIAMOND_SWORD, "&7Blinds enemies on use, 3 second cooldown");
        WidowsBlade widowsBlade = new WidowsBlade(this, "&4Widows&0Blade", Material.DIAMOND_SWORD, "&7Poisons enemies on use, 5 second cooldown");

        itemBuilderList.add(blindingSword);
        itemBuilderList.add(widowsBlade);

        customItemMap.put("BlindingSword", blindingSword.getItemStack());
        customItemMap.put("WidowsBlade", widowsBlade.getItemStack());

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
        getServer().getPluginManager().registerEvents(new AdminMenuListener(this), this);
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
        return itemBuilderList;
    }

    public ItemStack getCustomItem(String itemKey) {
        return customItemMap.get(itemKey);
    }
}
