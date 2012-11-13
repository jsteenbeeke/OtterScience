package com.jeroensteenbeeke.bukkit.otterscience.generator;

import org.bukkit.World;

import com.jeroensteenbeeke.bukkit.otterscience.OtterSciencePlugin;

public class NoonTask implements Runnable {
	private final OtterSciencePlugin plugin;

	public NoonTask(OtterSciencePlugin plugin) {
		super();
		this.plugin = plugin;
	}

	@Override
	public void run() {
		for (World w : plugin.getServer().getWorlds()) {
			if (OtterSciencePlugin.LABNAME.equals(w.getName())) {
				w.setTime(6000L);
			}
		}

	}

}
