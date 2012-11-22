package com.jeroensteenbeeke.bukkit.otterscience.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import com.jeroensteenbeeke.bk.basics.commands.CommandMatcher;
import com.jeroensteenbeeke.bk.basics.commands.ParameterIntegrityChecker;
import com.jeroensteenbeeke.bk.basics.commands.PlayerAwareCommandHandler;
import com.jeroensteenbeeke.bk.basics.util.Messages;
import com.jeroensteenbeeke.bukkit.otterscience.OtterSciencePlugin;

public class OtterSetSpawnHandler extends PlayerAwareCommandHandler {
	private OtterSciencePlugin plugin;

	public OtterSetSpawnHandler(OtterSciencePlugin plugin) {
		super(plugin.getServer(), OtterSciencePlugin.OTTER_PERMISSION);
		this.plugin = plugin;
	}

	@Override
	public CommandMatcher getMatcher() {
		return ifNameIs("otter").andArgIs(0, "setspawn").itMatches();
	}

	@Override
	public void onAuthorizedAndPlayerFound(Player player, Command command,
			String label, String[] args) {
		Location l = player.getLocation();

		if (OtterSciencePlugin.LABNAME.equals(l.getWorld().getName())) {
			l.getWorld().setSpawnLocation(l.getBlockX(), l.getBlockY(),
					l.getBlockZ());
			Messages.broadcast(plugin.getServer(),
					"&cLab spawn location updated");
		}

	}

	@Override
	public ParameterIntegrityChecker getParameterChecker() {

		return ifArgCountIs(1).itIsProper();
	}
}
