package net.mcreator.djmusicalanwalkerplaylist.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.djmusicalanwalkerplaylist.item.ItemAlanWalkerOnMyWay;
import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.Map;

@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class ProcedureAlanWalkerOnMyWayGiver extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {
	public ProcedureAlanWalkerOnMyWayGiver(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 25);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AlanWalkerOnMyWayGiver!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Link: - https://www.youtube.com/watch?v=dhYOPzcsbGM"), (false));
		}
		Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors()).schedule(() -> {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Giving Song On My Way"), (true));
			}
			Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors()).schedule(() -> {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAlanWalkerOnMyWay.block, (int) (1));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}, 1000, TimeUnit.MILLISECONDS);
		}, 1000, TimeUnit.MILLISECONDS);
	}
}
