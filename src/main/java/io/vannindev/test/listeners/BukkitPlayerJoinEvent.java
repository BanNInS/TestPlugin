package io.vannindev.test.listeners;

import io.vannindev.test.Test;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BukkitPlayerJoinEvent implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e){
        Player player = e.getPlayer();
        int temp;
        if (Test.joinTime.get(player.getUniqueId().toString())==null)temp=0;
        else temp = Test.joinTime.get(player.getUniqueId().toString());
        temp++;
        e.setJoinMessage(ChatColor.YELLOW + player.getName() + "が"+temp+"回目の参加です。");
        Test.joinTime.put(player.getUniqueId().toString(),temp);
        if (!player.hasPlayedBefore())player.sendMessage("初参加");
        else player.sendMessage("Not初参加");
    }

}
