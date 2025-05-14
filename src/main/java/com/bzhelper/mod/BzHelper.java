package com.bzhelper.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.mainbzclass.bzhelper.Config;

@Mod(modid = BzHelper.MODID, version = BzHelper.VERSION, name = BzHelper.NAME)
public class BzHelper {
    public static final String MODID = "bzhelper";
    public static final String VERSION = "1.0";
    public static final String NAME = "Bazaar Helper";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Mod initialization code
    }

    // Method to open the Bazaar GUI
    public static void openBazaarGui() {
        Minecraft.getMinecraft().displayGuiScreen(new BazaarGuiScreen());
    }
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.load(event); // <--- Konfiguration laden
    }
    // Bazaar GUI Screen class
    public static class BazaarGuiScreen extends GuiScreen {

        @Override
        public void initGui() {
            this.buttonList.add(new GuiButton(
                    0,
                    this.width / 2 - 50,
                    this.height / 2 - 10,
                    100,
                    20,
                    "Close"
            ));
        }

        @Override
        public void drawScreen(int mouseX, int mouseY, float partialTicks) {
            this.drawDefaultBackground();
            super.drawScreen(mouseX, mouseY, partialTicks);

            // Draw title
            this.drawCenteredString(this.fontRendererObj, "Bazaar Helper", this.width / 2, 20, 0xFFFFFF);
        }

        @Override
        protected void actionPerformed(GuiButton button) {
            if (button.id == 0) {
                this.mc.displayGuiScreen(null);
            }
        }

        @Override
        public boolean doesGuiPauseGame() {
            return false;
        }
    }
}