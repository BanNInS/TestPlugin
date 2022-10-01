package io.vannindev.test.command;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setblock implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        Location loc = player.getLocation().clone();
        loc.setY(loc.getY()+2);
        loc.getBlock().setType(Material.DIAMOND_BLOCK);
        return true;
    }
}
