package com.bzhelper.mod.bz_helper;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.until.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class BazaarGuiScreen extends
Screen {
    protected BazzarGuiScreen(Text title) 
    {
        super(title);
    }

    @Override
    public void render (MatrixStackmatrices, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrieces);
        super.render(matrices, mouseX, mouseY, partialTicks);
    }

@Override
protected void inti() 
    {this.addButton(newButtonWidget(this.width / 2 - 50, this.height / 2 - 10, 100, 20 new LiteralText("Close"), 
                                    button -> this.onClose()));
        }

    pritvate void onClose() {
        this.client.openScreen(null);
    }
}
        
            
