package net.mcreator.commandplusplus.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.commandplusplus.CommandplusplusModElements;
import net.mcreator.commandplusplus.CommandplusplusMod;

import java.util.Map;
import java.util.HashMap;

@CommandplusplusModElements.ModElement.Tag
public class ExplodeProcedureProcedure extends CommandplusplusModElements.ModElement {
	public ExplodeProcedureProcedure(CommandplusplusModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency entity for procedure ExplodeProcedure!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency cmdparams for procedure ExplodeProcedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency x for procedure ExplodeProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency y for procedure ExplodeProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency z for procedure ExplodeProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency world for procedure ExplodeProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !((World) world).isRemote) {
			((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())), Explosion.Mode.BREAK);
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aExploded blocks near you!"), (false));
		}
	}
}
