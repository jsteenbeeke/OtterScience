package com.jeroensteenbeeke.bukkit.otterscience;

import java.util.logging.Logger;

import org.bukkit.generator.ChunkGenerator;

import com.jeroensteenbeeke.bk.basics.JSPlugin;
import com.jeroensteenbeeke.bukkit.otterscience.commands.OtterExperimentHandler;
import com.jeroensteenbeeke.bukkit.otterscience.commands.OtterObserveHandler;
import com.jeroensteenbeeke.bukkit.otterscience.commands.OtterOutdoorHandler;
import com.jeroensteenbeeke.bukkit.otterscience.commands.OtterToLabHandler;
import com.jeroensteenbeeke.bukkit.otterscience.generator.NoonTask;
import com.jeroensteenbeeke.bukkit.otterscience.generator.OtterLabGenerator;

public class OtterSciencePlugin extends JSPlugin {
	private Logger logger = Logger.getLogger("Minecraft");

	public static final String LABNAME = "lab";

	public static final String OTTER_PERMISSION = "is.otter";

	public static final String DEFAULT_WORLD_NAME = "world";

	@Override
	public void onEnable() {
		logger.info("Enabled otterscience plugin");

		getServer().getScheduler().scheduleSyncRepeatingTask(this,
				new NoonTask(this), 20L, 600L);

		addCommandHandler(new OtterObserveHandler(this));
		addCommandHandler(new OtterExperimentHandler(this));
		addCommandHandler(new OtterToLabHandler(this));
		addCommandHandler(new OtterOutdoorHandler(this));
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		if (LABNAME.equals(worldName)) {
			return new OtterLabGenerator();
		}

		return super.getDefaultWorldGenerator(worldName, id);
	}

	@Override
	public void onDisable() {

	}
}
