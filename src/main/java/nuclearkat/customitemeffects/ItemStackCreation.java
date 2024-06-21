package nuclearkat.customitemeffects;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ItemStackCreation {
    private final String displayName;


    private final Material materialType;
    private final List<String> lore;
    private final ItemStack createdItem;

    protected final int cooldown;

    public ItemStackCreation(String displayName, Material materialType, int cooldown, String... lore){
        this.displayName = ChatColor.translateAlternateColorCodes('&', displayName);
        this.materialType = materialType;
        this.lore = Arrays.asList(lore);
        this.cooldown = cooldown;
        this.createdItem = createItemStack();
    }

    public abstract void onUse(Player player);

    public int getCooldown(){
        return cooldown;
    }

    protected ItemStack createItemStack(){
        ItemStack itemStack = new ItemStack(materialType);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);

        List<String> itemLore = new ArrayList<>();

        for (String string : lore){
            String foundLore = ChatColor.translateAlternateColorCodes('&', string);
            itemLore.add(foundLore);
        }
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public ItemStack getCreatedItemStack(){
        return createdItem;
    }

    public List<String> getLore() {
        return lore;
    }

    public Material getMaterialType() {
        return materialType;
    }

    public String getDisplayName() {
        return displayName;
    }
}
