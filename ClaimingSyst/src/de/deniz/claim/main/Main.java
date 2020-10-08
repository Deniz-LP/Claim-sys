package de.deniz.claim.main;


import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import java.sql.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.deniz.claim.commands.Claim;
import de.deniz.claim.listeners.Block;
import de.deniz.claim.listeners.ListenerS;



public class Main extends JavaPlugin {
	
	private static Main plugin;
	public static FileConfiguration cfg;
	public static String pr = "§c[§0B§4T§eE§a-Claim§c] ";
	public static String np = pr + "§cDazu hast du §4KEINE §cRechte!";
	public static String nf = pr + "§cDieser Spieler wurde nicht gefunden.";
	public static String cmd = pr +  "Das ist leider nur als Spieler nutzbar!";
	
	public static ArrayList<Player> VIPs = new ArrayList<>();
	public static ArrayList<Player> Eventteam = new ArrayList<>();
	public static ArrayList<Player> NormalePlayer = new ArrayList<>();
	public static HashMap<Integer, Integer> test = new HashMap<>();
	public static String dbID = "";

	
	
	
	public void onEnable() {
		
		plugin = this;
		PluginManager pm = Bukkit.getServer().getPluginManager();
		cfg = getConfig();
		getCommand("claim").setExecutor(new Claim());
		
		pm.registerEvents(new ListenerS(), this);
		pm.registerEvents(new Block(), this);
		
		
	}
	public static Main getPlugin() {
		return plugin;
	}
	
	public void onDisable() {
		
			}
	public static void setUp(Player p) {
		
	}
	public static String Publisher = "Deniz_LP";
}