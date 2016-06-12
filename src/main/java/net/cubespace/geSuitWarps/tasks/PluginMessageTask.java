package net.cubespace.geSuitWarps.tasks;

import net.cubespace.geSuitWarps.geSuitWarps;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.ByteArrayOutputStream;
import java.util.Collection;

public class PluginMessageTask extends BukkitRunnable {
	private final ByteArrayOutputStream bytes;

	public PluginMessageTask(ByteArrayOutputStream bytes) {
		this.bytes = bytes;
	}

	public void run() {
		Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
		if (onlinePlayers.isEmpty()) {
			geSuitWarps.INSTANCE.getLogger().info("Tried to send a pluginMessage with an empty server. Cancelling.");
		} else {
			onlinePlayers.iterator().next().sendPluginMessage(geSuitWarps.INSTANCE, "geSuitBans", bytes.toByteArray());
		}
	}
}
