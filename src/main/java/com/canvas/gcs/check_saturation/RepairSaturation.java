package com.canvas.gcs.check_saturation;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.option.KeyBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepairSaturation implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("gcs_saturation_fix");
	private static KeyBinding keyBinding;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Repair Saturation world!");
		
	}
}
