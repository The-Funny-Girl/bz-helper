package com.bzhelper.mod.bz_helper;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.client.util.math.MatrixStack;

public class BazaarGuiScreen extends Screen {
    protected BazaarGuiScreen() {
        super(new LiteralText("Bazaar GUI"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, partialTicks);
    }

    @Override
    public void init() {
        this.addButton(new ButtonWidget(this.width / 2 - 50, this.height / 2 - 10, 100, 20, new LiteralText("Close"), button -> this.onClose()));
    }

    private void onClose() {
        this.client.openScreen(null);
    }
}
