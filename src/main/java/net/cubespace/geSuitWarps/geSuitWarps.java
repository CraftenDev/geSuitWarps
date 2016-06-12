package net.cubespace.geSuitWarps;

import net.cubespace.geSuitWarps.commands.DeleteWarpCommand;
import net.cubespace.geSuitWarps.commands.ListWarpsCommand;
import net.cubespace.geSuitWarps.commands.SetWarpCommand;
import net.cubespace.geSuitWarps.commands.WarpCommand;
import net.cubespace.geSuitWarps.listeners.WarpsListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class geSuitWarps extends JavaPlugin {
    public static geSuitWarps INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        registerListeners();
        registerChannels();
        registerCommands();
    }

    private void registerCommands() {
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("warps").setExecutor(new ListWarpsCommand());
        getCommand("setwarp").setExecutor(new SetWarpCommand());
        getCommand("delwarp").setExecutor(new DeleteWarpCommand());
    }

    private void registerChannels() {
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "geSuitWarps");
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(
                new WarpsListener(), this);
    }

}
