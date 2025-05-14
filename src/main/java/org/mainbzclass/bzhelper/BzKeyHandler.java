package org.mainbzclass.bzhelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class BzKeyHandler {

    // Define the key binding with appropriate context and modifiers
    public static KeyBinding bzKey = new KeyBinding("Open Bazaar (/bz)", Keyboard.KEY_B, "BZ Helper");

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (bzKey.isPressed()) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/bz");
        }
    }
}
//