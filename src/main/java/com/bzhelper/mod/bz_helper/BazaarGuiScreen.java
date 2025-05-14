package com.bzhelper.mod.bz_helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiButton;

public class BazaarGuiScreen extends GuiScreen {

    public BazaarGuiScreen() {
        // No need for title parameter in Forge 1.8.9
    }

    @Override
    public void initGui() {
        // Add close button
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
        // Draw background
        this.drawDefaultBackground();

        // Draw title
        this.drawCenteredString(this.fontRendererObj, "Bazaar Helper", this.width / 2, 20, 0xFFFFFF);

        // Draw buttons and other components
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        // Handle button clicks
        if (button.id == 0) {
            this.onClose();
        }
    }

    private void onClose() {
        // Close this screen
        this.mc.displayGuiScreen(null);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}