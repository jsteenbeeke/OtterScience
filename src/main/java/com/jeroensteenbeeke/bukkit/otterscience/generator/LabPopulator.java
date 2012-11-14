package com.jeroensteenbeeke.bukkit.otterscience.generator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.jeroensteenbeeke.bukkit.otterscience.OtterSciencePlugin;
import com.jeroensteenbeeke.bukkit.otterscience.generator.OtterLabGenerator.Mode;

public class LabPopulator extends BlockPopulator {
	private final OtterSciencePlugin plugin;

	public LabPopulator(OtterSciencePlugin plugin) {
		super();
		this.plugin = plugin;
	}

	@Override
	public void populate(World world, Random rand, Chunk chunk) {
		Mode mode = Mode.getMode(chunk.getX(), chunk.getZ());

		if (mode == Mode.BOTTOM_RIGHT) {
			int y = OtterLabGenerator.GLASS_HEIGHT + 1;

			chunk.getBlock(8, y, 8).setType(Material.CHEST);
			chunk.getBlock(8, y, 9).setType(Material.CHEST);

			chunk.getBlock(10, y, 10).setType(Material.WORKBENCH);

			Chest chest = (Chest) chunk.getBlock(8, y, 8).getState();

			Inventory i = chest.getInventory();

			if (i == null) {
				i = plugin.getServer().createInventory(chest,
						InventoryType.CHEST);
			}

			i.addItem(new ItemStack(Material.REDSTONE, 64));
			i.addItem(new ItemStack(Material.REDSTONE, 64));
			i.addItem(new ItemStack(Material.REDSTONE, 64));
			i.addItem(new ItemStack(Material.REDSTONE, 64));
			i.addItem(new ItemStack(Material.REDSTONE, 64));
			i.addItem(new ItemStack(Material.REDSTONE, 64));
			i.addItem(new ItemStack(Material.REDSTONE_LAMP_OFF, 64));
			i.addItem(new ItemStack(Material.REDSTONE_TORCH_ON, 64));
			i.addItem(new ItemStack(Material.LEVER, 64));
			i.addItem(new ItemStack(Material.STONE_BUTTON, 64));
			i.addItem(new ItemStack(Material.STONE_PLATE, 64));
			i.addItem(new ItemStack(Material.WOOD_PLATE, 64));
			i.addItem(new ItemStack(Material.PISTON_BASE, 64));
			i.addItem(new ItemStack(Material.PISTON_STICKY_BASE, 64));
			i.addItem(new ItemStack(Material.DETECTOR_RAIL, 64));
			i.addItem(new ItemStack(Material.POWERED_RAIL, 64));
			i.addItem(new ItemStack(Material.RAILS, 64));
			i.addItem(new ItemStack(Material.RAILS, 64));
			i.addItem(new ItemStack(Material.RAILS, 64));
			i.addItem(new ItemStack(Material.TNT, 64));
			i.addItem(new ItemStack(Material.TNT, 64));
			i.addItem(new ItemStack(Material.TNT, 64));
			i.addItem(new ItemStack(Material.STRING, 64));
			i.addItem(new ItemStack(Material.TRIPWIRE_HOOK, 64));
			i.addItem(new ItemStack(Material.DIODE, 64));
			i.addItem(new ItemStack(Material.DIODE, 64));
			i.addItem(new ItemStack(Material.DIAMOND, 64));
			i.addItem(new ItemStack(Material.DIAMOND, 64));
			i.addItem(new ItemStack(Material.DIAMOND, 64));
			i.addItem(new ItemStack(Material.IRON_BLOCK, 64));
			i.addItem(new ItemStack(Material.IRON_BLOCK, 64));
			i.addItem(new ItemStack(Material.IRON_BLOCK, 64));
			i.addItem(new ItemStack(Material.IRON_BLOCK, 64));
			i.addItem(new ItemStack(Material.IRON_BLOCK, 64));

		}
	}

}
