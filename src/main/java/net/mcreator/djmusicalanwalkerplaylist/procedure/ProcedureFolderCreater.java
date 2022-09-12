package net.mcreator.djmusicalanwalkerplaylist.procedure;

import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;

import java.util.Map;
import java.io.File;
@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class ProcedureFolderCreater extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {
	public ProcedureFolderCreater(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 43);
	}

	public static void executeProcedure(Map<String, Object> dependencies){
		//Import file class  
  
//Import Scanner class   
import java.util.Scanner;   
    //Main() method start          
      //Using Scanner class to get the path from the user where he wants to create a folder.  
      System.out.println("Enter the path where you want to create a folder: ");  
      Scanner sc = new Scanner(System.in);  
      String path = sc.next();  
      //Using Scanner class to get the folder name from the user  
      System.out.println("Enter the name of the desired a directory: ");  
      path = path+sc.next();  
      //Instantiate the File class   
      File f1 = new File(path);  
      //Creating a folder using mkdir() method  
      boolean bool = f1.mkdir();  
      if(bool){  
         System.out.println("Folder is created successfully");
         mcserv.getPlayerList().sendMessage(new TextComponentString("Folder is created successfully"));
  
      }else{  
         System.out.println("Error Found!");
         mcserv.getPlayerList().sendMessage(new TextComponentString("Error Found!"));

      }  
     

	}
}
