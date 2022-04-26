package net.mcreator.djmusicalanwalkerplaylist.procedure;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;

import java.util.Map;

@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class ProcedureGUIClose extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {
	public ProcedureGUIClose(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GUIClose!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).closeScreen();
	}
}
