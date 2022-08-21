package net.mcreator.djmusicalanwalkerplaylist.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.djmusicalanwalkerplaylist.item.ItemAlanWalkerAllFallsDown;
import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.Map;

@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class ProcedureAwAllFallsDown extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {
	public ProcedureAwAllFallsDown(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 29);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AwAllFallsDown!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Link: - https://www.youtube.com/watch?v=6RLLOEzdxsM"), (false));
		}
		Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors()).schedule(() -> {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Giving Song All Falls Down"), (true));
			}
			Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors()).schedule(() -> {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAlanWalkerAllFallsDown.block, (int) (1));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}, 1000, TimeUnit.MILLISECONDS);
		}, 1000, TimeUnit.MILLISECONDS);
	}
}
