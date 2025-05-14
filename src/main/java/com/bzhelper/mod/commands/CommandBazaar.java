package com.bzhelper.mod.commands;

import com.bzhelper.mod.bz_helper.BazaarGuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommandBazaar extends CommandBase {

    @Override
    public String getCommandName() {
        return "bazaar";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/bazaar - Opens the Bazaar Helper GUI";
    }

    // Set command permission level
    @Override
    public int getRequiredPermissionLevel() {
        return 0; // Anyone can use this command
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) sender;

            if (player.worldObj.isRemote) {
                // Client-side: Open the GUI
                Minecraft.getMinecraft().displayGuiScreen(new BazaarGuiScreen());
            } else {
                // Server-side: Send a message
                player.addChatMessage(new ChatComponentText("This command can only be used client-side."));
            }
        }
    }

    /**
     * Register the command
     */
    public static void register() {
        // For client-side commands
        ClientCommandHandler.instance.registerCommand(new CommandBazaar());
    }

    /**
     * Register server-side command
     * Call this method during server starting event
     */
    public static void registerServer(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandBazaar());
    }
}