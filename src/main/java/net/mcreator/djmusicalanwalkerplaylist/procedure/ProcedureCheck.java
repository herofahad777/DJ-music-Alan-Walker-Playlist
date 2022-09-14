//package net.mcreator.djmusicalanwalkerplaylist.procedure;

//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//import net.minecraftforge.fml.common.FMLCommonHandler;
//import net.minecraftforge.common.MinecraftForge;

// net.minecraft.world.World;
//import net.minecraft.util.text.TextComponentString;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.entity.Entity;

//import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;

// java.util.Map;
//import java.io.*;
//import java.io.IOException;
//import java.nio.channels.Channels;
//import java.nio.channels.ReadableByteChannel;
//import java.net.*;
//@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
//public class ProcedureCheck extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {

//	public ProcedureCheck(ElementsDjMusicAlanWalkerPlaylistMod instance) {
//		super(instance, 40);
//	}

//	public static void executeProcedure(Map<String, Object> dependencies) {
//	String p = "";
//	File path = new File ("folderc").getAbsoluteFile();
 //     boolean bool = path.mkdir();  
 //     if(bool){  
    //     System.out.println("Folder is created successfully");  
  //    }else{  
    //     System.out.println("Error Found!");  
   //   }  
//try 
  //  {
  ///  File pa = new File(path+"/1.16.zip");
  ///  p = pa.getAbsolutePath();
 ////   BufferedInputStream in = new BufferedInputStream(new URL("https://www.dropbox.com/s/hmx1lnzmux6cuzj/1.16.zip?dl=1").openStream());
//FileOutputStream fileOutputStream = new FileOutputStream(p);
  //  System.out.println(p);
  //  byte dataBuffer[] = new byte[1024];
  //  int bytesRead;
  ///  while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
  //      fileOutputStream.write(dataBuffer, 0, bytesRead);
 //   }
//} catch (IOException e) {
 //   // handle exception
//}

	//	if (dependencies.get("world") == null) {
	//		System.err.println("Failed to load dependency world for procedure Check!");
	//		return;
	//	}
	//	World world = (World) dependencies.get("world");
	//	{
	//		MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
	//		if (mcserv != null)
	///			mcserv.getPlayerList().sendMessage(new TextComponentString("Working"+p));
	//	}
	
//	}
//	@SubscribeEvent
//	public void onPlayerLoggedIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
//		Entity entity = event.player;
//		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
//		dependencies.put("x", (int) entity.posX);
	//	dependencies.put("y", (int) entity.posY);
	//	dependencies.put("z", (int) entity.posZ);
	//	dependencies.put("world", entity.world);
	//	dependencies.put("entity", entity);
	//	dependencies.put("event", event);
	//	this.executeProcedure(dependencies);
//	}

	//@Override
	//public void preInit(FMLPreInitializationEvent event) {
//		MinecraftForge.EVENT_BUS.register(this);
//	}
//}