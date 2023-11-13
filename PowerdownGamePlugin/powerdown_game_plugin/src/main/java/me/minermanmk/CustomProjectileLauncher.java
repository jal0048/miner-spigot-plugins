package me.minermanmk;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.util.Vector;

import java.util.Objects;
import java.util.Random;

public class CustomProjectileLauncher implements Listener {

    public static float shotgunSpread = 5F;
    public static float shotgunSpeed = 2F;
    public static int shotgunPelletCount = 9;
    @EventHandler
    public void onFire(PlayerInteractEvent event) {
        Action eventAction;
        Player target;
        ItemStack targetItemStack;

        if(!event.hasItem()){
            return;
        }
        eventAction = event.getAction();
        target = event.getPlayer();
        targetItemStack = event.getItem();
        Vector direction = target.getEyeLocation().getDirection().normalize();
        Location playerLocation = target.getEyeLocation();
        if((eventAction == Action.RIGHT_CLICK_AIR || eventAction == Action.RIGHT_CLICK_BLOCK) && targetItemStack.getType() == Material.GOLDEN_HOE){
            fireShotgun(target, playerLocation, direction);
            event.setCancelled(true);
        }
    }
    public void setShotgunSpread(float newF){
        shotgunSpread = newF;
    }
    public void setShotgunSpeed(float newF){
        shotgunSpeed = newF;
    }
    public void setShotgunPelletCount(int newI){
        shotgunPelletCount = newI;
    }

    public void fireShotgun(Player target, Location playerLocation, Vector direction){
        for (int i = 0; i < shotgunPelletCount; i++){
            target.getWorld().spawnArrow(playerLocation, direction, shotgunSpeed, shotgunSpread);
        }
    }

}
