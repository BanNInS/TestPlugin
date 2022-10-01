package io.vannindev.test;

import io.vannindev.test.command.HatCommandExecutor;
import io.vannindev.test.command.setblock;
import io.vannindev.test.listeners.BukkitPlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.mlserver.mc.util.CustomConfiguration;

import java.util.HashMap;

public final class Test extends JavaPlugin {

    public static CustomConfiguration config;
    public static HashMap<String, Integer> joinTime;

    @Override
    public void onEnable() {
        getLogger().info("StartPlugin");
        getCommand("hat").setExecutor(new HatCommandExecutor());
        getCommand("setblock").setExecutor(new setblock());

        getServer().getPluginManager().registerEvents(new BukkitPlayerJoinEvent(), this);

        config = new CustomConfiguration(this);
        config.saveDefaultConfig();
        int temp;
        joinTime = new HashMap<>();

        for (String uuid : config.getConfig().getConfigurationSection("players").getKeys(true)) {
            temp = config.getConfig().getInt("players."+uuid+".joinTime",0);
            joinTime.put(uuid,temp);
        }
    }

    @Override
    public void onDisable() {
        for (String uuid : joinTime.keySet()) {
            config.getConfig().set("players." + uuid + ".joinTime", joinTime.get(uuid));
        }
        config.saveConfig();
    }
}
