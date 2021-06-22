package net.mcreator.commandplusplus.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.commandplusplus.CommandplusplusModElements;
import net.mcreator.commandplusplus.CommandplusplusMod;

import java.util.Map;

@CommandplusplusModElements.ModElement.Tag
public class VersionProcedureProcedure extends CommandplusplusModElements.ModElement {
	public VersionProcedureProcedure(CommandplusplusModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency entity for procedure VersionProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7fCommand++\u00A7a's version installed is \u00A7f1.0.0\u00A7a."),
					(false));
		}
	}
}
