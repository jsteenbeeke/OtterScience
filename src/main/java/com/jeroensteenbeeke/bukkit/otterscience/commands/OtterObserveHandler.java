package com.jeroensteenbeeke.bukkit.otterscience.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import com.jeroensteenbeeke.bk.basics.commands.CommandMatcher;
import com.jeroensteenbeeke.bk.basics.commands.ParameterIntegrityChecker;
import com.jeroensteenbeeke.bk.basics.commands.PlayerAwareCommandHandler;
import com.jeroensteenbeeke.bukkit.otterscience.OtterSciencePlugin;
import com.jeroensteenbeeke.bukkit.otterscience.generator.OtterLabGenerator;

public class OtterObserveHandler extends PlayerAwareCommandHandler {
	private OtterSciencePlugin plugin;

	public OtterObserveHandler(OtterSciencePlugin plugin) {
		super(plugin.getServer(), OtterSciencePlugin.OTTER_PERMISSION);
		this.plugin = plugin;
	}

	@Override
	public CommandMatcher getMatcher() {
		return ifNameIs("otter").andArgIs(0, "observe").itMatches();
	}

	@Override
	public void onAuthorizedAndPlayerFound(Player player, Command command,
			String label, String[] args) {
		World lab = plugin.getServer().getWorld(OtterSciencePlugin.LABNAME);

		if (player.getWorld().equals(lab)) {
			Location l = player.getLocation();

			player.teleport(new Location(l.getWorld(), l.getX(),
					OtterLabGenerator.GLASS_HEIGHT + 1, l.getZ()));
		}

	}

	@Override
	public ParameterIntegrityChecker getParameterChecker() {

		return ifArgCountIs(1).itIsProper();
	}

}
