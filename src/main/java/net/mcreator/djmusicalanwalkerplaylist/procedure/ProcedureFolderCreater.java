package net.mcreator.djmusicalanwalkerplaylist.procedure;

import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;

import java.util.Map;
import java.io.*;
@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class ProcedureFolderCreater extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {
	public ProcedureFolderCreater(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 43);
	}

	public static void executeProcedure(Map<String, Object> dependencies){
      File path = new File("songs").getAbsoluteFile();
      boolean bool = path.mkdir();  
      if(bool) 
         System.out.println("Folder is created successfully");      
	}
}
