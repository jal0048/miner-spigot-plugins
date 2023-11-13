package me.minermanmk;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class DisableUsables implements Listener {

    @EventHandler
    public void onFire(PlayerInteractEvent event) {
        Action eventAction;
        Player target;
        Material targetBlockType;

        eventAction = event.getAction();
        target = event.getPlayer();
        GameMode targetGamemode = target.getGameMode();

        if(!event.hasBlock()) return;
        targetBlockType = event.getClickedBlock().getType();

        if(targetGamemode == GameMode.ADVENTURE && (eventAction == Action.RIGHT_CLICK_AIR || eventAction == Action.RIGHT_CLICK_BLOCK) && targetBlockType != Material.CHEST){
            event.setCancelled(true);
        }
    }
}
