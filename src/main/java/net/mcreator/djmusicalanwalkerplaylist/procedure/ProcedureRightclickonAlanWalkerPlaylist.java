package net.mcreator.djmusicalanwalkerplaylist.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.djmusicalanwalkerplaylist.gui.GuiAlanWalkerPlaylistGUI;
import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;
import net.mcreator.djmusicalanwalkerplaylist.DjMusicAlanWalkerPlaylistMod;

import java.util.Map;

@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class ProcedureRightclickonAlanWalkerPlaylist extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {
	public ProcedureRightclickonAlanWalkerPlaylist(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RightclickonAlanWalkerPlaylist!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure RightclickonAlanWalkerPlaylist!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure RightclickonAlanWalkerPlaylist!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure RightclickonAlanWalkerPlaylist!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure RightclickonAlanWalkerPlaylist!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(DjMusicAlanWalkerPlaylistMod.instance, GuiAlanWalkerPlaylistGUI.GUIID, world, x, y, z);
	}
}
