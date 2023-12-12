package world.biomedisplay;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public class BiomeColorMapper {
    private final Map<String, ChatColor> biomeColorMap = new HashMap<>();

    public BiomeColorMapper() {
        initializeBiomeColors();
    }

    private void initializeBiomeColors() {
        // Mapping biomes to colors
        biomeColorMap.put("PLAINS", ChatColor.GREEN);
        biomeColorMap.put("SUNFLOWER_PLAINS", ChatColor.GREEN);
        biomeColorMap.put("FLOWER_FOREST", ChatColor.GREEN);

        biomeColorMap.put("FOREST", ChatColor.DARK_GREEN);
        biomeColorMap.put("TAIGA_HILLS", ChatColor.DARK_GREEN);
        biomeColorMap.put("WOODED_HILLS", ChatColor.DARK_GREEN);
        biomeColorMap.put("JUNGLE", ChatColor.DARK_GREEN);
        biomeColorMap.put("JUNGLE_HILLS", ChatColor.DARK_GREEN);
        biomeColorMap.put("JUNGLE_EDGE", ChatColor.DARK_GREEN);
        biomeColorMap.put("BIRCH_FOREST", ChatColor.DARK_GREEN);
        biomeColorMap.put("BIRCH_FOREST_HILLS", ChatColor.DARK_GREEN);
        biomeColorMap.put("DARK_FOREST", ChatColor.DARK_GREEN);
        biomeColorMap.put("GIANT_TREE_TAIGA", ChatColor.DARK_GREEN);
        biomeColorMap.put("GIANT_TREE_TAIGA_HILLS", ChatColor.DARK_GREEN);
        biomeColorMap.put("MODIFIED_JUNGLE", ChatColor.DARK_GREEN);
        biomeColorMap.put("MODIFIED_JUNGLE_EDGE", ChatColor.DARK_GREEN);
        biomeColorMap.put("TALL_BIRCH_FOREST", ChatColor.DARK_GREEN);
        biomeColorMap.put("TALL_BIRCH_HILLS", ChatColor.DARK_GREEN);
        biomeColorMap.put("DARK_FOREST_HILLS", ChatColor.DARK_GREEN);

        biomeColorMap.put("DESERT", ChatColor.YELLOW);
        biomeColorMap.put("DESERT_HILLS", ChatColor.YELLOW);
        biomeColorMap.put("DESERT_LAKES", ChatColor.YELLOW);
        biomeColorMap.put("BADLANDS", ChatColor.YELLOW);
        biomeColorMap.put("WOODED_BADLANDS_PLATEAU", ChatColor.YELLOW);
        biomeColorMap.put("BADLANDS_PLATEAU", ChatColor.YELLOW);

        biomeColorMap.put("MOUNTAINS", ChatColor.GRAY);
        biomeColorMap.put("MOUNTAIN_EDGE", ChatColor.GRAY);
        biomeColorMap.put("WOODED_MOUNTAINS", ChatColor.GRAY);
        biomeColorMap.put("GRAVELLY_MOUNTAINS", ChatColor.GRAY);
        biomeColorMap.put("TAIGA_MOUNTAINS", ChatColor.GRAY);
        biomeColorMap.put("SWAMP_HILLS", ChatColor.GRAY);

        biomeColorMap.put("MUSHROOM_FIELDS", ChatColor.LIGHT_PURPLE);
        biomeColorMap.put("MUSHROOM_FIELD_SHORE", ChatColor.LIGHT_PURPLE);
        biomeColorMap.put("CHERRY_GROVE", ChatColor.LIGHT_PURPLE);

        biomeColorMap.put("BEACH", ChatColor.GOLD);

        biomeColorMap.put("DEEP_OCEAN", ChatColor.BLUE);
        biomeColorMap.put("WARM_OCEAN", ChatColor.BLUE);
        biomeColorMap.put("LUKEWARM_OCEAN", ChatColor.BLUE);
        biomeColorMap.put("COLD_OCEAN", ChatColor.BLUE);

        biomeColorMap.put("DEEP_WARM_OCEAN", ChatColor.DARK_BLUE);
        biomeColorMap.put("DEEP_LUKEWARM_OCEAN", ChatColor.DARK_BLUE);
        biomeColorMap.put("DEEP_COLD_OCEAN", ChatColor.DARK_BLUE);
        biomeColorMap.put("DEEP_FROZEN_OCEAN", ChatColor.DARK_BLUE);

        biomeColorMap.put("SMALL_END_ISLANDS", ChatColor.DARK_PURPLE);
        biomeColorMap.put("END_MIDLANDS", ChatColor.DARK_PURPLE);
        biomeColorMap.put("END_HIGHLANDS", ChatColor.DARK_PURPLE);
        biomeColorMap.put("END_BARRENS", ChatColor.DARK_PURPLE);
        biomeColorMap.put("THE_VOID", ChatColor.DARK_PURPLE);

        // Default color for unspecified biomes
        biomeColorMap.put("DEFAULT", ChatColor.WHITE);
    }

    public ChatColor getBiomeColor(String biome) {
        return biomeColorMap.getOrDefault(biome, ChatColor.WHITE);
    }
}
