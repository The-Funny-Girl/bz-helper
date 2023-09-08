package com.bzhelper.mod;

import net.minecraft.client.gui.screen.Screen;  // <-- This import seems correct
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class BzHelper extends Screen {
    protected BzHelper() {
        super(new LiteralText("Bazaar GUI"));
    }

    @Override
    protected void init() {
        this.addButton(new ButtonWidget(this.width / 2 - 50, this.height / 2 - 10, 100, 20, new LiteralText("Close"), button -> this.onClose()));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrices);  // <-- Make sure renderBackground is available in your environment
        super.render(matrices, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    private void onClose() {
        this.client.openScreen(null);  // <-- Make sure client and openScreen are available in your environment
    }
}
