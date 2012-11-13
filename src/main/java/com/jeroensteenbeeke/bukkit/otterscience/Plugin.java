package com.jeroensteenbeeke.bukkit.otterscience;

import java.util.logging.Logger;

import com.jeroensteenbeeke.bk.basics.JSPlugin;

public class Plugin extends JSPlugin {
	private Logger logger = Logger.getLogger("Minecraft");

	@Override
	public void onEnable() {
		logger.info("Enabled otterscience plugin");

	}

	@Override
	public void onDisable() {

	}
}
