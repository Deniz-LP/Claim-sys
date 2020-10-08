package de.deniz.claim.listeners;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import de.deniz.claim.commands.Claim;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import de.deniz.claim.main.Main;

public class Block implements Listener{
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		int PlayerX = e.getBlock().getX();
		int PlayerZ = e.getBlock().getZ();
		
		Player player = e.getPlayer();
		
		
		if(Main.VIPs.contains(player) || Main.Eventteam.contains(player)) {
			e.setCancelled(false);
			return;
		}
		FileConfiguration Claim111 = Main.getPlugin().getConfig();
		 for(int i = 1; i <= Claim.MAX_CLAIMS ;i++) {
			 	int ClaimX1 = Claim111.getInt("BTEClaimSystem."+player.getName()+"."+i+".X1-geclaimed");
				int ClaimZ1 = Claim111.getInt("BTEClaimSystem."+player.getName()+"."+i+".Z1-geclaimed");
				int ClaimX2 = Claim111.getInt("BTEClaimSystem."+player.getName()+"."+i+".X2-geclaimed");
				int ClaimZ2 = Claim111.getInt("BTEClaimSystem."+player.getName()+"."+i+".Z2-geclaimed");
				
				
					
						
							if(ClaimZ1 >= ClaimZ2 && ClaimX1 >= ClaimX2) {
								for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
									
									if(PlayerX == ClaimX1 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == ClaimX2 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
								}
								for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
									if(PlayerX == test1 && PlayerZ == ClaimZ1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == ClaimX2 && PlayerZ == ClaimZ2) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
										
								}
						 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 >= ClaimX2) {
							 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
									
									if(PlayerX == ClaimX1 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == ClaimX2 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
								}
								for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
									if(PlayerX == test1 && PlayerZ == ClaimZ1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == test1 && PlayerZ == ClaimZ2) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
										
								
								}
						 }else if(ClaimZ1 >=  ClaimZ2 && ClaimX1 <= ClaimX2) {
							 for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
									
									if(PlayerX == ClaimX1 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == ClaimX2 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
								}
								for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
									if(PlayerX == test1 && PlayerZ == ClaimZ1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == test1 && PlayerZ == ClaimZ2) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
										
								}
						 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 <= ClaimX2) {
							 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
									
									if(PlayerX == ClaimX1 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == ClaimX2 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
								}
								for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
									if(PlayerX == test1 && PlayerZ == ClaimZ1) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == test1 && PlayerZ == ClaimZ2) {
										player.sendMessage(Main.pr + "§cDu kannst deinen Rand nicht abbauen!");
										e.setCancelled(true);
										return;
									}
										
								}
							 
						 
						 
					 }
					
					 
				 
				
				 
				
				if(ClaimZ1 >= PlayerZ && PlayerZ >= ClaimZ2 && ClaimX1 >= PlayerX && PlayerX >= ClaimX2) {
						
							e.setCancelled(false);
							return;
				 
				 
			 
				}else if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2 && ClaimX1 >= PlayerX && PlayerX >= ClaimX2) {
						
							e.setCancelled(false);
							return;
				 
			 
			 
				}else 	if(ClaimZ1 >= PlayerZ && PlayerZ >= ClaimZ2 && ClaimX1 <= PlayerX && PlayerX <= ClaimX2) {
						
							e.setCancelled(false);
							return;
						 
				 
				 
			 
				}else 	if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2 && ClaimX1 <= PlayerX && PlayerX <= ClaimX2) {
						
							e.setCancelled(false);
							return;
							
			 }
		 }
		 player.sendMessage(Main.pr + "§cAbbauen Fehlgeschlagen! Claim gehört nicht dir oder wird überprüft.");
			e.setCancelled(true);
			return;
					}
				
	@EventHandler
	public void onPlaye(BlockPlaceEvent e) {
		int PlayerX = e.getBlock().getX();
		int PlayerZ = e.getBlock().getZ();
		
		Player player = e.getPlayer();
		if(Main.VIPs.contains(player) || Main.Eventteam.contains(player)) {
			e.setCancelled(false);
			return;
		}
		FileConfiguration Claim1112 = Main.getPlugin().getConfig();
		 for(int i = 1; i <=Claim.MAX_CLAIMS;i++) {
			 	int ClaimX1 = Claim1112.getInt("BTEClaimSystem."+player.getName()+"."+i+".X1-geclaimed");
				int ClaimZ1 = Claim1112.getInt("BTEClaimSystem."+player.getName()+"."+i+".Z1-geclaimed");
				int ClaimX2 = Claim1112.getInt("BTEClaimSystem."+player.getName()+"."+i+".X2-geclaimed");
				int ClaimZ2 = Claim1112.getInt("BTEClaimSystem."+player.getName()+"."+i+".Z2-geclaimed");
				
				
					
						
							if(ClaimZ1 >= ClaimZ2 && ClaimX1 >= ClaimX2) {
								for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
									
									if(PlayerX == ClaimX1 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == ClaimX2 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
								}
								for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
									if(PlayerX == test1 && PlayerZ == ClaimZ1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == test1 && PlayerZ == ClaimZ2) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
										
								}
						 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 >= ClaimX2) {
							 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
									
									if(PlayerX == ClaimX1 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == ClaimX2 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
								}
								for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
									if(PlayerX == test1 && PlayerZ == ClaimZ1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == test1 && PlayerZ == ClaimZ2) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
										
								
								}
						 }else if(ClaimZ1 >=  ClaimZ2 && ClaimX1 <= ClaimX2) {
							 for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
									
									if(PlayerX == ClaimX1 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == ClaimX2 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
								}
								for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
									if(PlayerX == test1 && PlayerZ == ClaimZ1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == test1 && PlayerZ == ClaimZ2) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
										
								}
						 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 <= ClaimX2) {
							 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
									
									if(PlayerX == ClaimX1 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == ClaimX2 && PlayerZ == test1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
								}
								for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
									if(PlayerX == test1 && PlayerZ == ClaimZ1) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
									
									
									if(PlayerX == test1 && PlayerZ == ClaimZ2) {
										player.sendMessage(Main.pr + "§cDu kannst auf deinem Rand nichts platzieren!");
										e.setCancelled(true);
										return;
									}
										
								}
							 
						 
						 
					 }
					
					 
				 
				
				 
				
				if(ClaimZ1 >= PlayerZ && PlayerZ >= ClaimZ2 && ClaimX1 >= PlayerX && PlayerX >= ClaimX2) {
						
							e.setCancelled(false);
							return;
				 
				 
			 
				}else if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2 && ClaimX1 >= PlayerX && PlayerX >= ClaimX2) {
						
							e.setCancelled(false);
							return;
				 
			 
			 
				}else 	if(ClaimZ1 >= PlayerZ && PlayerZ >= ClaimZ2 && ClaimX1 <= PlayerX && PlayerX <= ClaimX2) {
						
							e.setCancelled(false);
							return;
						 
				 
				 
			 
				}else 	if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2 && ClaimX1 <= PlayerX && PlayerX <= ClaimX2) {
						
							e.setCancelled(false);
							return;
							
			 }
		 }
		 player.sendMessage(Main.pr + "§cAbbauen Fehlgeschlagen! Claim gehört nicht dir oder wird überprüft.");
			e.setCancelled(true);
			return;
					}
					}