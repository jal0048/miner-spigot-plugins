package me.minermanmk;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Event;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.EventListener;
import java.util.logging.Level;

public class Main extends JavaPlugin {

    public static boolean normalProjectiles = false;
    //public static boolean normalAdventureBlocks = false;
    @Override
    public void onEnable() {
        super.onEnable();
        this.getLogger().log(Level.FINE, "Plugin Initialized.");
        CustomCommand1 command1 = new CustomCommand1();
        command1.targetItem = Material.DIAMOND_AXE;
        this.getCommand("mkTest1").setExecutor(new CustomCommand1());
        this.getCommand("mkTest2").setExecutor(command1);
        getServer().getPluginManager().registerEvents(new CustomProjectileSpeeds(), this);
        SwitchCommand switchProjectiles = new SwitchCommand();
        this.getCommand("toggleProjSpeedMod").setExecutor(new SwitchCommand());
        getServer().getPluginManager().registerEvents(new CustomProjectileLauncher(), this);
        getServer().getPluginManager().registerEvents(new CustomRaygun(), this);
        getServer().getPluginManager().registerEvents(new DisableUsables(), this);
    }
    @Override
    public void onDisable() {
        super.onDisable();
        this.getLogger().log(Level.WARNING, "Plugin Terminated.");
    }

    public static void toggleNormalProjectiles() {
        normalProjectiles = !normalProjectiles;
    }
    public static boolean getNormalProjectiles() {
        return normalProjectiles;
    }

}


