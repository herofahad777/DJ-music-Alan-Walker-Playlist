package net.mcreator.djmusicalanwalkerplaylist.procedure;

import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;

import java.util.Map;
import java.io.*;
import java.net.*;

@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class ProcedureDownloader extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement{

	public ProcedureDownloader(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
	
try 
    {
    File path = new File("songs/1.16.zip");
    BufferedInputStream in = new BufferedInputStream(new URL("https://www.dropbox.com/s/hmx1lnzmux6cuzj/1.16.zip?dl=1").openStream());
    FileOutputStream fileOutputStream = new FileOutputStream(path.getAbsolutePath());
    byte dataBuffer[] = new byte[1024];
    int bytesRead;
    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) 
        fileOutputStream.write(dataBuffer, 0, bytesRead);
    
    } 
catch (IOException e) 
{
    // handle exception
}
}

}