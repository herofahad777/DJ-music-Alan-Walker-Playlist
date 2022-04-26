
package net.mcreator.djmusicalanwalkerplaylist.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.djmusicalanwalkerplaylist.item.ItemW;
import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;

@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class TabDJMusicAlanWalker extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {
	public TabDJMusicAlanWalker(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabdj_music_alan_walker") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemW.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
