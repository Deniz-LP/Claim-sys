package de.deniz.claim.util;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder{
	
	private ItemStack itemJoin;
	private ItemMeta itemMetaJoin;

	public ItemBuilder(Material material, short subID) {
		itemJoin = new ItemStack(material, 1, subID);
		itemMetaJoin = itemJoin.getItemMeta();
	}
	
	
	public ItemBuilder(Material material) {
		this(material, (short)0);
	}
	
	public ItemBuilder setName(String name) {
		itemMetaJoin.setDisplayName(name);
		return this;
	}
	
	public ItemBuilder setLore(String... lore) {
		itemMetaJoin.setLore(Arrays.asList(lore));
		return this;
	}
	
	public ItemBuilder setAmount(int amount) {
		itemJoin.setAmount(amount);
		return this;
	}
	
	public ItemStack build() {
		itemJoin.setItemMeta(itemMetaJoin);
		return itemJoin;
	}
	
}
