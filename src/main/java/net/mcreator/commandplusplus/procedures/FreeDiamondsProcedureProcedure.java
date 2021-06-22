package net.mcreator.commandplusplus.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.commandplusplus.CommandplusplusModElements;
import net.mcreator.commandplusplus.CommandplusplusMod;

import java.util.Map;

@CommandplusplusModElements.ModElement.Tag
public class FreeDiamondsProcedureProcedure extends CommandplusplusModElements.ModElement {
	public FreeDiamondsProcedureProcedure(CommandplusplusModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency entity for procedure FreeDiamondsProcedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency x for procedure FreeDiamondsProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency y for procedure FreeDiamondsProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency z for procedure FreeDiamondsProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CommandplusplusMod.LOGGER.warn("Failed to load dependency world for procedure FreeDiamondsProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(
					new StringTextComponent("\u00A7aFree Diamonds will get in your inventory in \u00A7f24 \u00A7ahours!"), (false));
		}
		if (world instanceof World && !((World) world).isRemote) {
			((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 64, Explosion.Mode.BREAK);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A7aDid someone try to get free diamonds?"), ChatType.SYSTEM,
						Util.DUMMY_UUID);
		}
	}
}
