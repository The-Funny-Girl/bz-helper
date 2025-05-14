package org.mainbzclass.bzhelper;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "bzhelper", name = "Bazaar Helper", version = "1.0", clientSideOnly = true)
public class Bzhelper {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        BzKeyHandler handler = new BzKeyHandler();
        ClientRegistry.registerKeyBinding(BzKeyHandler.bzKey);
        MinecraftForge.EVENT_BUS.register(handler);
    }
}
