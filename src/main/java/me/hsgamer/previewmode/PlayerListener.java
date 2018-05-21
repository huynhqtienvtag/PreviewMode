package me.hsgamer.previewmode;

import fr.xephi.authme.events.LoginEvent;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onRegistered(LoginEvent e) {
        if (!(e.getPlayer().hasPermission("previewmode.bypass") || e.getPlayer().isOp())) {
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
            e.getPlayer().sendMessage(ChatColor.RED + "You are in Preview Mode");
        } else {
            e.getPlayer().sendMessage(ChatColor.GREEN + "You have bypassed PreviewMode. Enjoy your game");
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onRespawn(PlayerRespawnEvent e) {
        if (!(e.getPlayer().hasPermission("previewmode.bypass") || e.getPlayer().isOp())) {
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onChangeWorld(PlayerChangedWorldEvent e) {
        if (!(e.getPlayer().hasPermission("previewmode.bypass") || e.getPlayer().isOp())) {
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
    }

}
