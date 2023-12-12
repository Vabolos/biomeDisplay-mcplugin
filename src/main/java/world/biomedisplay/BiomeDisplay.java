package world.biomedisplay;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BiomeDisplay extends JavaPlugin implements Listener {
    private final Map<UUID, Boolean> biomeDisplayEnabled = new HashMap<>();
    private String lastBiome = ""; // Variable to store the last biome name
    private final BiomeColorMapper biomeColorMapper = new BiomeColorMapper();

    @Override
    public void onEnable() {
        // Registering the event listener
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("togglebiomedisplay")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "This command can only be executed by a player!");
                return true;
            }

            Player player = (Player) sender;
            UUID playerUUID = player.getUniqueId();

            if (!biomeDisplayEnabled.containsKey(playerUUID)) {
                biomeDisplayEnabled.put(playerUUID, true);
            } else {
                boolean isEnabled = biomeDisplayEnabled.get(playerUUID);
                biomeDisplayEnabled.put(playerUUID, !isEnabled);
            }

            boolean isEnabled = biomeDisplayEnabled.get(playerUUID);
            sender.sendMessage(ChatColor.GREEN + "Biome display " + (isEnabled ? "enabled" : "disabled"));
            return true;
        }
        return false;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        if (!biomeDisplayEnabled.containsKey(playerUUID) || !biomeDisplayEnabled.get(playerUUID)) {
            return; // Biome display is not enabled for this player
        }

        String currentBiome = player.getLocation().getBlock().getBiome().name();
        ChatColor biomeColor = biomeColorMapper.getBiomeColor(currentBiome);


        // Replacing underscores with spaces and converting to title case
        currentBiome = ChatColor.translateAlternateColorCodes('&', currentBiome.replace("_", " ").toLowerCase());

        if (!lastBiome.equalsIgnoreCase(currentBiome)) {
            // Display the biome name as an action bar message only if it's a new biome
            sendActionBar(player, String.valueOf(biomeColor) + ChatColor.ITALIC + currentBiome);
            lastBiome = currentBiome; // Update the last biome to the current biome
        }
    }

    // Method to send action bar messages
    public void sendActionBar(Player player, String message) {
        player.sendTitle("", message, 10, 40, 15); // Parameters: title, subtitle, fadeIn, stay, fadeOut
    }
}
