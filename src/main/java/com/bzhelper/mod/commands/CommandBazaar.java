package com.bzhelper.mod.commands;

import com.bzhelper.mod.YourModMain;
import com.bzhelper.mod.bz_helper.BazaarGuiScreen;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommandBazaar extends CommandBase {
    @Override
    public String getName() {
        return "bz";
    }

    @Override
    public String getUsage(ServerCommandSource source) {
        return "/bz - Open the Bazaar";
    }

    @Override
    public void execute(ServerCommandSource source, String[] args) throws CommandException {
        if (source.getWorld().isClient) {
            source.getPlayer().openHandledScreen(new BazaarGuiScreen());
        }
    }

    @SubscribeEvent
    public static void onServerStarting(net.minecraftforge.fml.event.server.FMLServerStartingEvent event) {
        event.getCommandDispatcher().register(new CommandBazaar());
    }
}
