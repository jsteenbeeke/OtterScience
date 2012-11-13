package com.jeroensteenbeeke.bukkit.otterscience.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import com.jeroensteenbeeke.bk.basics.commands.CommandMatcher;
import com.jeroensteenbeeke.bk.basics.commands.ParameterIntegrityChecker;
import com.jeroensteenbeeke.bk.basics.commands.PlayerAwareCommandHandler;
import com.jeroensteenbeeke.bukkit.otterscience.OtterSciencePlugin;

public class OtterToLabHandler extends PlayerAwareCommandHandler {
	private OtterSciencePlugin plugin;

	public OtterToLabHandler(OtterSciencePlugin plugin) {
		super(plugin.getServer(), OtterSciencePlugin.OTTER_PERMISSION);
		this.plugin = plugin;
	}

	@Override
	public CommandMatcher getMatcher() {
		return ifNameIs("otter").andArgIs(0, "lab").itMatches();
	}

	@Override
	public void onAuthorizedAndPlayerFound(Player player, Command command,
			String label, String[] args) {
		World lab = plugin.getServer().getWorld(OtterSciencePlugin.LABNAME);

		if (!player.getWorld().equals(lab)) {
			player.teleport(new Location(lab, 0, 53, 0));
		}

	}

	@Override
	public ParameterIntegrityChecker getParameterChecker() {

		return ifArgCountIs(1).itIsProper();
	}

}
