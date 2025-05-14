package org.mainbzclass.bzhelper;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Config {
    public static boolean logDirtBlock = true;
    public static int magicNumber = 42;
    public static String magicNumberIntroduction = "The magic number is...";
    public static Set<Item> items = new HashSet<>();

    private static Configuration config;

    public static void load(FMLPreInitializationEvent event) {
        File configFile = new File(event.getModConfigurationDirectory(), "bzhelper.cfg");
        config = new Configuration(configFile);
        syncConfig();
    }

    private static void syncConfig() {
        logDirtBlock = config.getBoolean("logDirtBlock", Configuration.CATEGORY_GENERAL, true, "Whether to log the dirt block on common setup");
        magicNumber = config.getInt("magicNumber", Configuration.CATEGORY_GENERAL, 42, 0, Integer.MAX_VALUE, "A magic number");
        magicNumberIntroduction = config.getString("magicNumberIntroduction", Configuration.CATEGORY_GENERAL, "The magic number is...", "Introduction message for the magic number");

        String[] defaultItems = new String[] { "minecraft:iron_ingot" };
        String[] itemStrings = config.getStringList("items", Configuration.CATEGORY_GENERAL, defaultItems, "A list of items to log on common setup");

        // Parse and validate items
        items = new HashSet<>();
        for (String itemString : itemStrings) {
            ResourceLocation loc = new ResourceLocation(itemString);
            Item item = GameRegistry.findItem(loc.getResourceDomain(), loc.getResourcePath());
            if (item != null) {
                items.add(item);
            }
        }

        if (config.hasChanged()) {
            config.save();
        }
    }
}
//