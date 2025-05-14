package org.mainbzclass.bzhelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class BzKeyHandler {

    public static KeyBinding bzKey;

    public static void init() {
        bzKey = new KeyBinding("key.bzhelper.openbazaar", Keyboard.KEY_B, "key.categories.bzhelper");
        ClientRegistry.registerKeyBinding(bzKey);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (bzKey != null && bzKey.isPressed()) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/bz");
        }
    }
}
