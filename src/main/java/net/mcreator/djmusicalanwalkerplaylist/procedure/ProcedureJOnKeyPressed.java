package net.mcreator.djmusicalanwalkerplaylist.procedure;

import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;

import java.util.Map;
import java.util.HashMap;

@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class ProcedureJOnKeyPressed extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {
	public ProcedureJOnKeyPressed(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 44);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			ProcedureFolderCreater.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			ProcedureDownloader.executeProcedure($_dependencies);
		}
	}
}
