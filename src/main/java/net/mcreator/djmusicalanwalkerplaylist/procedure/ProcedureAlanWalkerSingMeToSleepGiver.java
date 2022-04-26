package net.mcreator.djmusicalanwalkerplaylist.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.djmusicalanwalkerplaylist.item.ItemAlanWalkerSingMeToSleep;
import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;

import java.util.Map;

@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class ProcedureAlanWalkerSingMeToSleepGiver extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {
	public ProcedureAlanWalkerSingMeToSleepGiver(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AlanWalkerSingMeToSleepGiver!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemAlanWalkerSingMeToSleep.block, (int) (1));
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
	}
}
