package org.mainbzclass.bzhelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = BzHelper.MODID, name = BzHelper.NAME, version = BzHelper.VERSION)
public class BzHelper {
    public static final String MODID = "bzhelper";
    public static final String NAME = "Bz Helper";
    public static final String VERSION = "1.01";

    // Define the keybinding
    public static KeyBinding openBazaarKey;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("[BZHelper] Pre-initialization started");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("[BZHelper] Initialization started");

        // Register the keybinding with a default key of "B"
        openBazaarKey = new KeyBinding("Open Bazaar", Keyboard.KEY_B, "BZ Helper");
        ClientRegistry.registerKeyBinding(openBazaarKey);

        // Register this class for event handling
        MinecraftForge.EVENT_BUS.register(this);

        // Register the command handler
        ClientCommandHandler.instance.registerCommand(new BazaarCommand());

        System.out.println("[BZHelper] Mod initialized with keybinding: " + Keyboard.getKeyName(openBazaarKey.getKeyCode()));
        System.out.println("[BZHelper] Check Controls menu under 'BZ Helper' category");
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        // Check if our key is pressed
        if (openBazaarKey != null && openBazaarKey.isPressed()) {
            sendBazaarCommand();
            System.out.println("[BZHelper] Key pressed! Sending /bz command");
        }
    }

    private void sendBazaarCommand() {
        if (Minecraft.getMinecraft().thePlayer != null) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/bz");
        }
    }

    // Command to open bazaar
    public class BazaarCommand implements ICommand {
        private final List<String> aliases;

        public BazaarCommand() {
            aliases = new ArrayList<>();
            aliases.add("bzhelper");
            aliases.add("bzh");
        }

        @Override
        public String getCommandName() {
            return "bzhelper";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "/bzhelper";
        }

        @Override
        public List<String> getCommandAliases() {
            return aliases;
        }

        @Override
        public void processCommand(ICommandSender sender, String[] args) {
            sender.addChatMessage(new ChatComponentText("§a[BZ Helper] §fOpening Bazaar..."));
            if (Minecraft.getMinecraft().thePlayer != null) {
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/bz");
            }
        }

        @Override
        public boolean canCommandSenderUseCommand(ICommandSender sender) {
            return true;
        }

        @Override
        public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
            return null;
        }

        @Override
        public boolean isUsernameIndex(String[] args, int index) {
            return false;
        }

        @Override
        public int compareTo(ICommand o) {
            return 0;
        }
    }
}