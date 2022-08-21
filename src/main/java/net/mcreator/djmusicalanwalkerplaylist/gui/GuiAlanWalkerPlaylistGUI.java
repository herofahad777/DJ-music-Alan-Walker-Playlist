
package net.mcreator.djmusicalanwalkerplaylist.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.GuiButton;

import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureGUIClose;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAwTired;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAwStrangerThingsGiver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAwPlay;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAwMemories;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAwHymnForTheWeekendGiver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAwHopeGiver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAwForce;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAwDiamondHeartProcedure;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAwAllFallsDown;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAlanWalkerTheSpectreGiver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAlanWalkerSkyGiver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAlanWalkerSingMeToSleepGiver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAlanWalkerPT2Giver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAlanWalkerOnMyWayGiver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAlanWalkerLilyGiver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAlanWalkerIgniteGiver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAlanWalkerFadedGiver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAlanWalkerDarksideGiver;
import net.mcreator.djmusicalanwalkerplaylist.procedure.ProcedureAlanWalkerAloneGiver;
import net.mcreator.djmusicalanwalkerplaylist.ElementsDjMusicAlanWalkerPlaylistMod;
import net.mcreator.djmusicalanwalkerplaylist.DjMusicAlanWalkerPlaylistMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import java.io.IOException;

@ElementsDjMusicAlanWalkerPlaylistMod.ModElement.Tag
public class GuiAlanWalkerPlaylistGUI extends ElementsDjMusicAlanWalkerPlaylistMod.ModElement {
	public static int GUIID = 1;
	public static HashMap guistate = new HashMap();
	public GuiAlanWalkerPlaylistGUI(ElementsDjMusicAlanWalkerPlaylistMod instance) {
		super(instance, 5);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		elements.addNetworkMessage(GUIButtonPressedMessageHandler.class, GUIButtonPressedMessage.class, Side.SERVER);
		elements.addNetworkMessage(GUISlotChangedMessageHandler.class, GUISlotChangedMessage.class, Side.SERVER);
	}
	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private IInventory internal;
		private World world;
		private EntityPlayer entity;
		private int x, y, z;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		public GuiContainerMod(World world, int x, int y, int z, EntityPlayer player) {
			this.world = world;
			this.entity = player;
			this.x = x;
			this.y = y;
			this.z = z;
			this.internal = new InventoryBasic("", true, 0);
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return internal.isUsableByPlayer(player);
		}

		@Override
		public void onContainerClosed(EntityPlayer playerIn) {
			super.onContainerClosed(playerIn);
			if ((internal instanceof InventoryBasic) && (playerIn instanceof EntityPlayerMP)) {
				this.clearContainer(playerIn, playerIn.world, internal);
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote) {
				DjMusicAlanWalkerPlaylistMod.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}
	}

	public static class GuiWindow extends GuiContainer {
		private World world;
		private int x, y, z;
		private EntityPlayer entity;
		public GuiWindow(World world, int x, int y, int z, EntityPlayer entity) {
			super(new GuiContainerMod(world, x, y, z, entity));
			this.world = world;
			this.x = x;
			this.y = y;
			this.z = z;
			this.entity = entity;
			this.xSize = 435;
			this.ySize = 245;
		}

		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
			this.drawDefaultBackground();
			super.drawScreen(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1, 1, 1, 1);
			zLevel = 100.0F;
		}

		@Override
		public void updateScreen() {
			super.updateScreen();
		}

		@Override
		protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
			super.mouseClicked(mouseX, mouseY, mouseButton);
		}

		@Override
		protected void keyTyped(char typedChar, int keyCode) throws IOException {
			super.keyTyped(typedChar, keyCode);
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
			this.fontRenderer.drawString("Alan Walker Playlist", 166, 10, -1);
		}

		@Override
		public void onGuiClosed() {
			super.onGuiClosed();
			Keyboard.enableRepeatEvents(false);
		}

		@Override
		public void initGui() {
			super.initGui();
			this.guiLeft = (this.width - 435) / 2;
			this.guiTop = (this.height - 245) / 2;
			Keyboard.enableRepeatEvents(true);
			this.buttonList.clear();
			this.buttonList.add(new GuiButton(0, this.guiLeft + 8, this.guiTop + 29, 50, 20, "Faded"));
			this.buttonList.add(new GuiButton(1, this.guiLeft + 58, this.guiTop + 29, 65, 20, "Darkside"));
			this.buttonList.add(new GuiButton(2, this.guiLeft + 123, this.guiTop + 29, 80, 20, "The Spectre"));
			this.buttonList.add(new GuiButton(3, this.guiLeft + 203, this.guiTop + 29, 50, 20, "Alone"));
			this.buttonList.add(new GuiButton(4, this.guiLeft + 253, this.guiTop + 29, 105, 20, "Sing Me To Sleep"));
			this.buttonList.add(new GuiButton(5, this.guiLeft + 8, this.guiTop + 5, 40, 20, "Close"));
			this.buttonList.add(new GuiButton(6, this.guiLeft + 387, this.guiTop + 5, 40, 20, ">>>"));
			this.buttonList.add(new GuiButton(7, this.guiLeft + 358, this.guiTop + 29, 45, 20, "Lily"));
			this.buttonList.add(new GuiButton(8, this.guiLeft + 8, this.guiTop + 50, 70, 20, "On My Way"));
			this.buttonList.add(new GuiButton(9, this.guiLeft + 78, this.guiTop + 50, 40, 20, "Sky"));
			this.buttonList.add(new GuiButton(10, this.guiLeft + 118, this.guiTop + 50, 80, 20, "Alone PT II"));
			this.buttonList.add(new GuiButton(11, this.guiLeft + 198, this.guiTop + 50, 55, 20, "Ignite"));
			this.buttonList.add(new GuiButton(12, this.guiLeft + 253, this.guiTop + 50, 90, 20, "Diamond Heart"));
			this.buttonList.add(new GuiButton(13, this.guiLeft + 8, this.guiTop + 71, 95, 20, "All Falls Down"));
			this.buttonList.add(new GuiButton(14, this.guiLeft + 343, this.guiTop + 50, 50, 20, "Force"));
			this.buttonList.add(new GuiButton(15, this.guiLeft + 103, this.guiTop + 71, 50, 20, "Tired"));
			this.buttonList.add(new GuiButton(16, this.guiLeft + 153, this.guiTop + 71, 45, 20, "Play"));
			this.buttonList.add(new GuiButton(17, this.guiLeft + 198, this.guiTop + 71, 45, 20, "Hope"));
			this.buttonList.add(new GuiButton(18, this.guiLeft + 243, this.guiTop + 71, 100, 20, "Stranger Things"));
			this.buttonList.add(new GuiButton(19, this.guiLeft + 8, this.guiTop + 92, 125, 20, "Hymn For The Weekend"));
			this.buttonList.add(new GuiButton(20, this.guiLeft + 133, this.guiTop + 92, 65, 20, "Memories"));
		}

		@Override
		protected void actionPerformed(GuiButton button) {
			DjMusicAlanWalkerPlaylistMod.PACKET_HANDLER.sendToServer(new GUIButtonPressedMessage(button.id, x, y, z));
			handleButtonAction(entity, button.id, x, y, z);
		}

		@Override
		public boolean doesGuiPauseGame() {
			return false;
		}
	}

	public static class GUIButtonPressedMessageHandler implements IMessageHandler<GUIButtonPressedMessage, IMessage> {
		@Override
		public IMessage onMessage(GUIButtonPressedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			return null;
		}
	}

	public static class GUISlotChangedMessageHandler implements IMessageHandler<GUISlotChangedMessage, IMessage> {
		@Override
		public IMessage onMessage(GUISlotChangedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			return null;
		}
	}

	public static class GUIButtonPressedMessage implements IMessage {
		int buttonID, x, y, z;
		public GUIButtonPressedMessage() {
		}

		public GUIButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(buttonID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			buttonID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
		}
	}

	public static class GUISlotChangedMessage implements IMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage() {
		}

		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(slotID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
			buf.writeInt(changeType);
			buf.writeInt(meta);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			slotID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
			changeType = buf.readInt();
			meta = buf.readInt();
		}
	}
	private static void handleButtonAction(EntityPlayer entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAlanWalkerFadedGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAlanWalkerDarksideGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 2) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAlanWalkerTheSpectreGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 3) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAlanWalkerAloneGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 4) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAlanWalkerSingMeToSleepGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 5) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureGUIClose.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 7) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAlanWalkerLilyGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 8) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAlanWalkerOnMyWayGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 9) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAlanWalkerSkyGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 10) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAlanWalkerPT2Giver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 11) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAlanWalkerIgniteGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 12) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAwDiamondHeartProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 13) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAwAllFallsDown.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 14) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAwForce.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 15) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAwTired.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 16) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAwPlay.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 17) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAwHopeGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 18) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAwStrangerThingsGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 19) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAwHymnForTheWeekendGiver.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 20) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureAwMemories.executeProcedure($_dependencies);
			}
		}
	}

	private static void handleSlotAction(EntityPlayer entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
