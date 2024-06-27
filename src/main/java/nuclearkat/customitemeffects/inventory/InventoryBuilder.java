package nuclearkat.customitemeffects.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    private final InventoryHolder holder;
    private final int inventorySize;
    private final String inventoryTitle;
    private final ItemStack[] items;

    public InventoryBuilder(InventoryHolder holder, int inventorySize, String inventoryTitle) {
        this.holder = holder;
        this.inventorySize = inventorySize;
        this.inventoryTitle = ChatColor.translateAlternateColorCodes('&', inventoryTitle);
        this.items = new ItemStack[inventorySize];
    }

    public InventoryBuilder setItem(ItemStack item, int index){
        if (index >= inventorySize) throw new IndexOutOfBoundsException("Inventory size is " + inventorySize + ", index is " + index);
        this.items[index] = new ItemStack(item);
        return this;
    }

    public InventoryBuilder addItem(ItemStack item){
        for (int i = 0; i < inventorySize; i++){
            if (this.items[i] == null) {
                this.setItem(item, i);
                return this;
            }
        }
        return this;
    }

    public InventoryBuilder removeItem(int index){
        if (index >= inventorySize) throw new IndexOutOfBoundsException("Inventory size is " + inventorySize + ", index is " + index);
        this.items[index] = null;
        return this;
    }

    public Inventory build(){
        Inventory inventory = Bukkit.createInventory(holder, inventorySize, inventoryTitle);
        for (int i = 0; i < inventorySize; i++){
            if (this.items[i] != null) inventory.setItem(i, this.items[i]);
        }
        return inventory;
    }
}
