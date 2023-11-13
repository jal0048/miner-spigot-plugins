package me.minermanmk;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import me.minermanmk.Main;

public class SwitchCommand implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            p.playNote(p.getLocation(), (byte) 5, (byte) 5);
            Main.toggleNormalProjectiles();
            if(Main.getNormalProjectiles()){
                p.sendRawMessage("Normal projectiles enabled.");
            }
            else{
                p.sendRawMessage("Custom projectiles enabled.");
            }
        }

        return true;
    }
}