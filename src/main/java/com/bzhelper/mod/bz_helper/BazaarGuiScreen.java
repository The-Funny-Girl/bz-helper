package com.bzhelper.mod.bz_helper;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class BazaarGuiScreen extends Screen {
    protected BazaarGuiScreen() {
        super(new LiteralText("Bazaar GUI"));
    }

    @Override
    protected void init() {
        this.addButton(new Button(this.width / 2 - 50, this.height / 2 - 10, 100, 20, new LiteralText("Close"), button -> this.onClose()));
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    private void onClose() {
        this.client.openScreen(null);
    }
}
