package me.minermanmk;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CustomCommand1 implements CommandExecutor {

    // This method is called, when somebody uses our command
    public Material targetItem = Material.DIAMOND_HOE;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            ItemStack items = new ItemStack(targetItem, 20);
            p.getInventory().addItem(items);
        }


        return true;
    }
}