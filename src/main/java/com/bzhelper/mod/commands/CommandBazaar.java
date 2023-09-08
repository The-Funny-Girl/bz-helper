// CommandBazaar.java
package com.example.mod.commands;

import com.example.mod.YourModMain;
import com.example.mod.gui.BazaarGuiScreen;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod.EventBusSubscriber(modid = YourModMain.MODID)
public class CommandBazaar extends CommandBase {
    @Override
    public String getName() {
        return "bz";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/bz - Open the Bazaar";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender.getEntityWorld().isRemote) {
            sender.getEntityWorld().getMinecraft().displayGuiScreen(new BazaarGuiScreen());
        }
    }

    public static void onServerStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandBazaar());
    }
}
