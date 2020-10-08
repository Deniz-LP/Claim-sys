package de.deniz.claim.listeners;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import de.deniz.claim.commands.Claim;
import de.deniz.claim.main.Main;
import de.deniz.claim.util.ItemBuilder;



public class ListenerS implements Listener {
		
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		int Claims = Main.getPlugin().getConfig().getInt("BTEClaimSystem."+p.getName()+".Claims");
		int Claimsfertig = Main.getPlugin().getConfig().getInt("BTEClaimSystem."+p.getName()+".Claimsfertig");
		if(!(Claims >= 1)) {
		Main.getPlugin().getConfig().set("BTEClaimSystem."+p.getName()+".Claims", 0);
		}
		if(!(Claimsfertig >= 1)) {
			Main.getPlugin().getConfig().set("BTEClaimSystem."+p.getName()+".ClaimsUnfinished", 0);
			}
		for(Player current : Bukkit.getOnlinePlayers()) {
		FileConfiguration Range = Main.getPlugin().getConfig();
		String Rang = Range.getString("Range.Rang Spieler" + current.getName());
		if(Rang.equals("VIP")) {
			Main.VIPs.add(current);
		}else if(Rang.equals("Event")) {
			Main.Eventteam.add(current);
		}else if(Rang.equals("Default")){
			
		}else {
			
			Main.NormalePlayer.add(current);
			
			Range.set("Range.Rang Spieler" + current.getName(), "Default");
			Main.getPlugin().saveConfig();
		}
		
		}
		
		
		p.getInventory().setItem(5, new ItemBuilder(Material.DIAMOND_HOE).setName("§a§lClaim-Item").setLore("§bRechtklicke auf den","§bAnfangs- und Endblock").build());
		p.sendMessage(Main.pr + "§bVersuche das §a§lClaim-Item §bimmer im Inventar zu behalten, sonst muss du rejoinen!");
		return;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		Player pl = e.getPlayer();
		FileConfiguration Claim123 = Main.getPlugin().getConfig();	   
		int Block1X = e.getClickedBlock().getX();
		int Block1Z = e.getClickedBlock().getZ();


		if(!(e.getItem().getType() == Material.DIAMOND_HOE && e.getItem().getItemMeta().getDisplayName().equals("§a§lClaim-Item"))) { 
			e.setCancelled(false);   
		return;
		}
		 
		for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
			
			 for(int i = 1; i <=Claim.MAX_CLAIMS; i++) {
				 int ClaimX1 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".X1-geclaimed");
					int ClaimZ1 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-geclaimed");
					int ClaimX2 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".X2-geclaimed");
					int ClaimZ2 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-geclaimed");
					
					
					
					if(ClaimZ1 >= Block1Z && Block1Z >= ClaimZ2 && ClaimX1 >= Block1X && Block1X >= ClaimX2) {
							pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
							pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich schon §d" + p.getName() + "§c gehört.");
							e.setCancelled(true);
					 return;
					 
				 }else if(ClaimZ1 <= Block1Z && Block1Z <= ClaimZ2 && ClaimX1 >= Block1X && Block1X >= ClaimX2) {
							pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
							pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich schon §d" + p.getName() + "§c gehört.");
							e.setCancelled(true);
							return;
						
					 
				 }else if(ClaimZ1 >= Block1Z && Block1Z >= ClaimZ2 && ClaimX1 <= Block1X && Block1X <= ClaimX2) {
							pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
							pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich schon §d" + p.getName() + "§c gehört.");
							e.setCancelled(true);
							return;
						
					 
					 
				 }else if(ClaimZ1 <= Block1Z && Block1Z <= ClaimZ2 && ClaimX1 <= Block1X && Block1X <= ClaimX2) {
					 pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
						pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich schon §d" + p.getName() + "§c gehört.");
						e.setCancelled(true);
						return;
						}
	/* */		
				 
				 
			 }
			
			 }
		
		for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
			
			 for(int i = 1; i <=Claim.MAX_CLAIMS; i++) {
				 int ClaimX1 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".X1-fertig");
					int ClaimZ1 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-fertig");
					int ClaimX2 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".X2-fertig");
					int ClaimZ2 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-fertig");
					
					
					
					if(ClaimZ1 >= Block1Z && Block1Z >= ClaimZ2 && ClaimX1 >= Block1X && Block1X >= ClaimX2) {
							pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
							pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich fertig bebaut ist!");
							e.setCancelled(true);
					 return;
					 
				 }else if(ClaimZ1 <= Block1Z && Block1Z <= ClaimZ2 && ClaimX1 >= Block1X && Block1X >= ClaimX2) {
							pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
							pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich fertig bebaut ist!");
							e.setCancelled(true);
							return;
						
					 
				 }else if(ClaimZ1 >= Block1Z && Block1Z >= ClaimZ2 && ClaimX1 <= Block1X && Block1X <= ClaimX2) {
							pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
							pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich fertig bebaut ist!");
							e.setCancelled(true);
							return;
						
					 
					 
				 }else if(ClaimZ1 <= Block1Z && Block1Z <= ClaimZ2 && ClaimX1 <= Block1X && Block1X <= ClaimX2) {
					 pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
					 pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich fertig bebaut ist!");
						e.setCancelled(true);
						return;
						}
	/* */		
				 
				 
			 }
			
			 }
		for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
			
			 for(int i = 1; i <=Claim.MAX_CLAIMS; i++) {
				 int ClaimX1 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".X1-ausstehend");
					int ClaimZ1 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-ausstehend");
					int ClaimX2 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".X2-ausstehend");
					int ClaimZ2 = Claim123.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-ausstehend");
					
					
					
					if(ClaimZ1 >= Block1Z && Block1Z >= ClaimZ2 && ClaimX1 >= Block1X && Block1X >= ClaimX2) {
							pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
							pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich schon §d" + p.getName() + "§c gehört.");
							e.setCancelled(true);
					 return;
					 
				 }else if(ClaimZ1 <= Block1Z && Block1Z <= ClaimZ2 && ClaimX1 >= Block1X && Block1X >= ClaimX2) {
							pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
							pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich schon §d" + p.getName() + "§c gehört.");
							e.setCancelled(true);
							return;
						
					 
				 }else if(ClaimZ1 >= Block1Z && Block1Z >= ClaimZ2 && ClaimX1 <= Block1X && Block1X <= ClaimX2) {
							pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
							pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich schon §d" + p.getName() + "§c gehört.");
							e.setCancelled(true);
							return;
						
					 
					 
				 }else if(ClaimZ1 <= Block1Z && Block1Z <= ClaimZ2 && ClaimX1 <= Block1X && Block1X <= ClaimX2) {
					 pl.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a.");
						pl.sendMessage(Main.pr + "§cDu kannst hier nicht claimen weil dieser Bereich schon §d" + p.getName() + "§c gehört.");
						e.setCancelled(true);
						return;
						}
	/* */		
				 
				 
			 }
			
			 }
		
		
		
		
		
		
		
		
		
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			int Claims = Main.getPlugin().getConfig().getInt("BTEClaimSystem."+pl.getName()+".Claims");
			int ClaimsUnfinished = Main.getPlugin().getConfig().getInt("BTEClaimSystem."+pl.getName()+".ClaimsUnfinished");
			if(ClaimsUnfinished >= 4){
			
				pl.sendMessage(Main.pr + "§cDu kannst keine weiteren Grundstücke besiten! Wenn du ein Claim löschen willst wende dich an ein Admin!");
				e.setCancelled(true);
				return;
			}
			int ClaimNummerneu = Claims + 1;
			
			Main.getPlugin().getConfig().set("BTEClaimSystem."+pl.getName()+"."+ClaimNummerneu+".X1", Block1X);
			Main.getPlugin().getConfig().set("BTEClaimSystem."+pl.getName()+"."+ClaimNummerneu+".Z1", Block1Z);
			Main.getPlugin().saveConfig();
			pl.sendMessage(Main.pr + "§dBlock 1 ausgewählt!");
			pl.sendMessage(Main.pr + "§dWenn du 2 Blöcke ausgewählt hast schreibe /claim confirm");
			
			
		}else if(e.getAction() == Action.LEFT_CLICK_BLOCK) {

			int Claims = Main.getPlugin().getConfig().getInt("BTEClaimSystem."+pl.getName()+".Claims");
			int ClaimsUnfinished = Main.getPlugin().getConfig().getInt("BTEClaimSystem."+pl.getName()+".ClaimsUnfinished");
			if(ClaimsUnfinished >= 4){
			
				pl.sendMessage(Main.pr + "§cDu kannst keine weiteren Grundstücke besiten! Wenn du ein Claim löschen willst wende dich an ein Admin!");
				e.setCancelled(true);
				return;
			}
			int ClaimNummerneu = Claims + 1;
			
			Main.getPlugin().getConfig().set("BTEClaimSystem."+pl.getName()+"."+ClaimNummerneu+".X2", Block1X);
			Main.getPlugin().getConfig().set("BTEClaimSystem."+pl.getName()+"."+ClaimNummerneu+".Z2", Block1Z);
			Main.getPlugin().saveConfig();
			pl.sendMessage(Main.pr + "§dBlock 2 ausgewählt!");
			pl.sendMessage(Main.pr + "§dWenn du 2 Blöcke ausgewählt hast schreibe /claim confirm");
			
		}
			e.setCancelled(true);
			return;
		}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		
		Random rand = new Random();
int n = rand.nextInt(1);
n++;
if(n == 1) {
Main.getPlugin().getConfig().set("BTEClaimSystem.Aktualisierung", n);

Main.getPlugin().saveConfig();
}else
	Main.getPlugin().getConfig().set("BTEClaimSystem.Aktualisierung", null);

Main.getPlugin().saveConfig();
return;
	}
		
	

	
}







