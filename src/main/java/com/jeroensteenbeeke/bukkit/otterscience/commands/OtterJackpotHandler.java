package com.jeroensteenbeeke.bukkit.otterscience.commands;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.jeroensteenbeeke.bk.basics.commands.CommandMatcher;
import com.jeroensteenbeeke.bk.basics.commands.ParameterIntegrityChecker;
import com.jeroensteenbeeke.bk.basics.commands.PlayerAwareCommandHandler;
import com.jeroensteenbeeke.bukkit.otterscience.OtterSciencePlugin;

public class OtterJackpotHandler extends PlayerAwareCommandHandler {

	public OtterJackpotHandler(OtterSciencePlugin plugin) {
		super(plugin.getServer(), OtterSciencePlugin.OTTER_PERMISSION);
	}

	@Override
	public CommandMatcher getMatcher() {
		return ifNameIs("otter").andArgIs(0, "jackpot").itMatches();
	}

	@Override
	public void onAuthorizedAndPlayerFound(Player player, Command command,
			String label, String[] args) {

		World world = player.getLocation().getWorld();

		world.dropItem(player.getLocation(), new ItemStack(Material.REDSTONE,
				64));
		world.dropItem(player.getLocation(), new ItemStack(Material.REDSTONE,
				64));
		world.dropItem(player.getLocation(), new ItemStack(Material.REDSTONE,
				64));
		world.dropItem(player.getLocation(), new ItemStack(Material.REDSTONE,
				64));
		world.dropItem(player.getLocation(), new ItemStack(Material.REDSTONE,
				64));
		world.dropItem(player.getLocation(), new ItemStack(Material.REDSTONE,
				64));
		world.dropItem(player.getLocation(), new ItemStack(
				Material.REDSTONE_LAMP_OFF, 64));
		world.dropItem(player.getLocation(), new ItemStack(
				Material.REDSTONE_TORCH_ON, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.LEVER, 64));
		world.dropItem(player.getLocation(), new ItemStack(
				Material.STONE_BUTTON, 64));
		world.dropItem(player.getLocation(), new ItemStack(
				Material.STONE_PLATE, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.WOOD_PLATE,
				64));
		world.dropItem(player.getLocation(), new ItemStack(
				Material.PISTON_BASE, 64));
		world.dropItem(player.getLocation(), new ItemStack(
				Material.PISTON_STICKY_BASE, 64));
		world.dropItem(player.getLocation(), new ItemStack(
				Material.DETECTOR_RAIL, 64));
		world.dropItem(player.getLocation(), new ItemStack(
				Material.POWERED_RAIL, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.NOTE_BLOCK,
				64));
		world.dropItem(player.getLocation(), new ItemStack(Material.NOTE_BLOCK,
				64));
		world.dropItem(player.getLocation(), new ItemStack(Material.RAILS, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.RAILS, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.RAILS, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.TNT, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.TNT, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.TNT, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.STRING, 64));
		world.dropItem(player.getLocation(), new ItemStack(
				Material.TRIPWIRE_HOOK, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.DIODE, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.DIODE, 64));
		world.dropItem(player.getLocation(),
				new ItemStack(Material.DIAMOND, 64));
		world.dropItem(player.getLocation(),
				new ItemStack(Material.DIAMOND, 64));
		world.dropItem(player.getLocation(),
				new ItemStack(Material.DIAMOND, 64));
		world.dropItem(player.getLocation(), new ItemStack(Material.IRON_BLOCK,
				64));
		world.dropItem(player.getLocation(), new ItemStack(Material.IRON_BLOCK,
				64));
		world.dropItem(player.getLocation(), new ItemStack(Material.IRON_BLOCK,
				64));
		world.dropItem(player.getLocation(), new ItemStack(Material.IRON_BLOCK,
				64));
		world.dropItem(player.getLocation(), new ItemStack(Material.IRON_BLOCK,
				64));
	}

	@Override
	public ParameterIntegrityChecker getParameterChecker() {

		return ifArgCountIs(1).itIsProper();
	}
}
