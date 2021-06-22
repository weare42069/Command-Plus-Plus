package net.mcreator.commandplusplus.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.commandplusplus.CommandplusplusModElements;
import net.mcreator.commandplusplus.CommandplusplusMod;

import java.util.Map;

@CommandplusplusModElements.ModElement.Tag
public class CommandPlusPlusProcedureProcedure extends CommandplusplusModElements.ModElement {
	public CommandPlusPlusProcedureProcedure(CommandplusplusModElements instance) {
		super(instance, 8);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency entity for procedure CommandPlusPlusProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7fCommands marked with * are trolls, be careful with that!"),
					(false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aCommands listed for \u00A7fCommand++\u00A7a:"), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7f /commandplusplus - Shows a list of custom commands"), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7f /explode <int> - Explodes the blocks near you"), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7f /commandplusplusversion - Shows the version installed"),
					(false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7f /startspiderarmy - Starts a spider army near you"), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7f /freediamonds* - Get free diamonds!"), (false));
		}
	}
}
