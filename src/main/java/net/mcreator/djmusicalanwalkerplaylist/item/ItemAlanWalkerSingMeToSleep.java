
package net.mcreator.djmusicalanwalkerplaylist.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.djmusicalanwalkerplaylist.creativetab.TabDJMusicAlanWalker;
import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;

@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class ItemAlanWalkerSingMeToSleep extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {
	@GameRegistry.ObjectHolder("dj_music_alan_walker_playlist:alan_walker_sing_me_to_sleep")
	public static final Item block = null;
	public ItemAlanWalkerSingMeToSleep(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0,
				new ModelResourceLocation("dj_music_alan_walker_playlist:alan_walker_sing_me_to_sleep", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("alan_walker_sing_me_to_sleep", ElementsDjMusicAlanWalkerPlaylistMod.sounds
					.get(new ResourceLocation("dj_music_alan_walker_playlist:alan_walker_-_sing_me_to_sleep")));
			setUnlocalizedName("alan_walker_sing_me_to_sleep");
			setRegistryName("alan_walker_sing_me_to_sleep");
			setCreativeTab(TabDJMusicAlanWalker.tab);
		}
	}
}
