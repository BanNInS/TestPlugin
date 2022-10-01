package io.vannindev.test.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class HatCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        PlayerInventory inv = player.getInventory();
        ItemStack hand = inv.getItemInOffHand();
        if (hand.getType()== Material.AIR) return true;
        ItemStack helmet = inv.getHelmet();
        inv.setItemInOffHand(helmet);
        inv.setHelmet(hand);
        Bukkit.broadcastMessage("test");
        return true;
    }
}