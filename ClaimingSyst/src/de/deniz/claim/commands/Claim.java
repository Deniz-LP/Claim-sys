package de.deniz.claim.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.deniz.claim.main.Main;

public class Claim implements CommandExecutor, TabExecutor {
public static final int MAX_CLAIMS = 99;
	private static int ClaimX1_C = 0;
	private static int ClaimX2_C = 0;
	private static int ClaimZ1_C = 0;
	private static int ClaimZ2_C = 0;
	int time = 60;
	int cd = 0;
	int DuHackerWieKonntestDuMichFinden = 0;
	int DuHackerWieKonntestDuMichFinden2 = 0;
	int DuHackerWieKonntestDuMichFinden3 = 0;
	int DuHackerWieKonntestDuMichFinden4 = 0;
	FileConfiguration Range = Main.getPlugin().getConfig();
	@SuppressWarnings({ "unused", "deprecation" })
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		FileConfiguration Claim = Main.getPlugin().getConfig();	   
		if(sender instanceof Player) {
			Player player = (Player) sender;  
			int PlayerX = player.getLocation().getBlockX();
			int PlayerZ = player.getLocation().getBlockZ();
			if(args[0].equals("groups")) {
				                    //spieler wird als player definiert.
                //hat er genügend perms?
	if(args.length == 4) {
		Player target = Bukkit.getPlayer(args[2]);
		
		if(target != null) {
			if(args[1].equalsIgnoreCase("add")) {
				if(Main.VIPs.contains(player) || Main.Publisher.equals(player.getName())) {
				if(Main.VIPs.contains(target) || Main.Eventteam.contains(target)) {
					sender.sendMessage(Main.pr + "§cDer Spieler ist schon in einer Gruppe");
					return false;
				}else {
				if(args[3].equalsIgnoreCase("vip")) {
					
					if(!Main.VIPs.contains(target)) {
						Main.VIPs.add(target);
						sender.sendMessage(Main.pr + "§aDer Spieler §5§l" + target.getName() + " §aist nun VIP.");
						target.sendMessage(Main.pr + "§aDu bist nun ein VIP.");
						Range.set("Range.Rang Spieler" + target.getName(), "VIP");Main.getPlugin().saveConfig();

						target.kickPlayer(Main.pr + "Neuer Rang! VIP");
					}else
						sender.sendMessage(Main.pr + "§cDer Spieler §5§l" + target.getName() + " §cist schon ein VIP!");
					}else if(args[3].equalsIgnoreCase("Eventteam")) {
						if(!Main.Eventteam.contains(target)) {
							Main.Eventteam.add(target);
							sender.sendMessage(Main.pr + "§aDer Spieler §b§l" + target.getName() + " §aist nun im Eventteam.");
							target.sendMessage(Main.pr + "§aDu bist nun ein Eventteammitglied");
							Range.set("Range.Rang Spieler" + target.getName(), "Event");Main.getPlugin().saveConfig();

							target.kickPlayer(Main.pr + "Neuer Rang! Eventteammitglied");
						}
					}else {
						sender.sendMessage(Main.pr + "§cBitte benutze /claim group add <Player> [VIP/Eventteam] !");
						}
			
				}
			}else
				player.sendMessage(Main.np);
			}
			} else
				sender.sendMessage(Main.nf);
		
		}else if(args.length == 3) { 
			Player target = Bukkit.getPlayer(args[2]);
			if(target != null) 
			{ //spieler ist online
				if(args[1].equalsIgnoreCase("remove")) {
					if(Main.VIPs.contains(player) || Main.Publisher.equals(player.getName())) {
				if(!(Main.VIPs.contains(target) || Main.Eventteam.contains(target))) {
					sender.sendMessage(Main.pr + "§cDer Spieler ist noch in keiner Gruppe");
					return false;
				}else {
				if(Main.VIPs.contains(target)) {
					Main.VIPs.remove(target);
					sender.sendMessage(Main.pr + "§aDer Spieler §9" + target.getName() + " §aist kein VIP mehr.");
					target.sendMessage(Main.pr + "§cDu bist kein VIP mehr.");
					Range.set("Range.Rang Spieler" + target.getName(), "Default");Main.getPlugin().saveConfig();
				}else if(Main.Eventteam.contains(target)) {
					Main.Eventteam.remove(target);
					sender.sendMessage(Main.pr + "§aDer Spieler §9" + target.getName() + " §aist kein Eventteammitglied mehr mehr.");
					target.sendMessage(Main.pr + "§cDu bist kein Eventteammitglied mehr.");
					Range.set("Range.Rang Spieler" + target.getName(), "Default");Main.getPlugin().saveConfig();
				}
					
				
				}
					}else
						player.sendMessage(Main.np);
			}else
			if(args[1].equalsIgnoreCase("info")){
				
				if(Main.VIPs.contains(target)) {
					player.sendMessage(Main.pr + "§aDer Spieler §6" + target.getName() + "§a ist in der Gruppe §c§lVIPs.");
				}else if(Main.Eventteam.contains(target)) {
					player.sendMessage(Main.pr + "§aDer Spieler §6" + target.getName() + "§a ist in der Gruppe §bEventmidglieder.");
				}else 
					player.sendMessage(Main.pr + "§aDer Spieler §6" + target.getName() + "§a ist in keiner Gruppe!");
			}else
				sender.sendMessage(Main.pr + "§cBitte benutze /claim group add/remove/info <Player> [VIP/Eventteam] !");
			}else
				player.sendMessage(Main.nf);
		}else
			sender.sendMessage(Main.pr + "§cBitte benutze /claim group add/remove/info <Player> [VIP/Eventteam] !");

	



			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			int Claims = Claim.getInt("BTEClaimSystem."+player.getName()+".Claims");
			int ClaimsUnfinished = Claim.getInt("BTEClaimSystem."+player.getName()+".ClaimsUnfinished");
			
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
						player.sendMessage("§6-----HILFE-----");
						player.sendMessage("");
						
						player.sendMessage("");
						player.sendMessage("");
						player.sendMessage("§a/claim help/?: Diese Seite");
						player.sendMessage("");
						player.sendMessage("§a/claim admin: Help-Seite nur für VIPs & Eventteammitglieder");
						player.sendMessage("");
						player.sendMessage("§a/claim confirm: Wenn du 2 Blöcke ausgewählt hast, kannst du confirmen. §4ACHTUNG! §cDu kannst nur maximal 4 Claims gleichzeitig haben.");
						player.sendMessage("§a(Um Blöcke auszuwählen benutze dein Claim-Item [Dia-Hoe])");
						player.sendMessage("");
						player.sendMessage("§a/claim finish: Wenn dein Grundstück fertig ist, kannst du es einreichen");
						
						
						player.sendMessage("");
						player.sendMessage("§a(/claim groups info <Player>: Schau in welcher Kategorie diese Person ist!)");
						player.sendMessage("");
					}else if(args[0].equalsIgnoreCase("confirm")) {
						if(ClaimsUnfinished >= 4) {
							player.sendMessage(Main.pr + "§4Du hast leider schon 4 Claims!");
							
							return false;
						}
						
						int a = 0;
						
						
						
							 for(int i = 1; i <=MAX_CLAIMS; i++) {
								 int ClaimX1_ = Claim.getInt("BTEClaimSystem."+player.getName()+"."+i+".X1");
									int ClaimZ1_ = Claim.getInt("BTEClaimSystem."+player.getName()+"."+i+".Z1");
									int ClaimX2_ = Claim.getInt("BTEClaimSystem."+player.getName()+"."+i+".X2");
									int ClaimZ2_ = Claim.getInt("BTEClaimSystem."+player.getName()+"."+i+".Z2");
									if(ClaimZ1_ <= PlayerZ && PlayerZ <= ClaimZ2_ && ClaimX1_ <= PlayerX && PlayerX <= ClaimX2_) {
										ClaimX1_C = ClaimX1_;
										ClaimX2_C = ClaimX2_;
										ClaimZ1_C = ClaimZ1_;
										ClaimZ2_C = ClaimZ2_;
										a=i;
									 
									}else if(ClaimZ1_ <= PlayerZ && PlayerZ <= ClaimZ2_ && ClaimX1_ >= PlayerX && PlayerX >= ClaimX2_) {
									 ClaimX1_C = ClaimX1_;
										ClaimX2_C = ClaimX2_;
										ClaimZ1_C = ClaimZ1_;
										ClaimZ2_C = ClaimZ2_;
										a=i;
									}else if(ClaimZ1_ >= PlayerZ && PlayerZ >= ClaimZ2_ && ClaimX1_ <= PlayerX && PlayerX <= ClaimX2_) {
											ClaimX1_C = ClaimX1_;
											ClaimX2_C = ClaimX2_;
											ClaimZ1_C = ClaimZ1_;
											ClaimZ2_C = ClaimZ2_;
											a=i;
									}else if(ClaimZ1_ >= PlayerZ && PlayerZ >= ClaimZ2_ && ClaimX1_ >= PlayerX && PlayerX >= ClaimX2_) {
									 ClaimX1_C = ClaimX1_;
										ClaimX2_C = ClaimX2_;
										ClaimZ1_C = ClaimZ1_;
										ClaimZ2_C = ClaimZ2_;
										a=i;
										}
							 }
									  
							
							for(OfflinePlayer off : Bukkit.getOfflinePlayers() ) {
						 for(int i = 1; i <=MAX_CLAIMS; i++)  {
							 if(a != 0) {
							 int ClaimX1 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".X1-geclaimed");
								int ClaimZ1 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".Z1-geclaimed");
								int ClaimX2 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".X2-geclaimed");
								int ClaimZ2 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".Z2-geclaimed");
								
								if(ClaimX1_C != 0 && ClaimX2_C != 0 && ClaimZ1_C != 0 && ClaimZ2_C != 0){
								
								if(ClaimX1 <= ClaimX2 && ClaimZ1 <= ClaimZ2 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
									for(int X = ClaimX1; X <= ClaimX2; X++ ) {
										for(int Z = ClaimZ1; Z <= ClaimZ2; Z++ ) {
											for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
												for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 <= ClaimX2 && ClaimZ1 <= ClaimZ2 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
									for(int X = ClaimX1; X <= ClaimX2; X++ ) {
										for(int Z = ClaimZ1; Z <= ClaimZ2; Z++ ) {
											for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
												for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 <= ClaimX2 && ClaimZ1 <= ClaimZ2 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
									for(int X = ClaimX1; X <= ClaimX2; X++ ) {
										for(int Z = ClaimZ1; Z <= ClaimZ2; Z++ ) {
											for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
												for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 <= ClaimX2 && ClaimZ1 <= ClaimZ2 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
									for(int X = ClaimX1; X <= ClaimX2; X++ ) {
										for(int Z = ClaimZ1; Z <= ClaimZ2; Z++ ) {
											for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
												for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 <= ClaimX2 && ClaimZ1 >= ClaimZ2 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
									for(int X = ClaimX1; X <= ClaimX2; X++ ) {
										for(int Z = ClaimZ1; Z >= ClaimZ2; Z-- ) {
											for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
												for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 <= ClaimX2 && ClaimZ1 >= ClaimZ2 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
									for(int X = ClaimX1; X <= ClaimX2; X++ ) {
										for(int Z = ClaimZ1; Z >= ClaimZ2; Z-- ) {
											for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
												for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 <= ClaimX2 && ClaimZ1>= ClaimZ2 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
									for(int X = ClaimX1; X <= ClaimX2; X++ ) {
										for(int Z = ClaimZ1; Z >= ClaimZ2; Z-- ) {
											for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
												for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 <= ClaimX2 && ClaimZ1 >= ClaimZ2 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
									for(int X = ClaimX1; X <= ClaimX2; X++ ) {
										for(int Z = ClaimZ1; Z >= ClaimZ2; Z-- ) {
											for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
												for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 >= ClaimX2 && ClaimZ1 <= ClaimZ2 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
									for(int X = ClaimX1; X >= ClaimX2; X-- ) {
										for(int Z = ClaimZ1; Z <= ClaimZ2; Z++ ) {
											for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
												for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 >= ClaimX2 && ClaimZ1 <= ClaimZ2 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
									for(int X = ClaimX1; X >= ClaimX2; X-- ) {
										for(int Z = ClaimZ1; Z <= ClaimZ2; Z++ ) {
											for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
												for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 >= ClaimX2 && ClaimZ1 <= ClaimZ2 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
									for(int X = ClaimX1; X >= ClaimX2; X-- ) {
										for(int Z = ClaimZ1; Z <= ClaimZ2; Z++ ) {
											for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
												for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 >= ClaimX2 && ClaimZ1 <= ClaimZ2 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
									for(int X = ClaimX1; X >= ClaimX2; X-- ) {
										for(int Z = ClaimZ1; Z <= ClaimZ2; Z++ ) {
											for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
												for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 >= ClaimX2 && ClaimZ1 >= ClaimZ2 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
									for(int X = ClaimX1; X <= ClaimX2; X-- ) {
										for(int Z = ClaimZ1; Z >= ClaimZ2; Z-- ) {
											for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
												for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 >= ClaimX2 && ClaimZ1 >= ClaimZ2 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
									for(int X = ClaimX1; X >= ClaimX2; X-- ) {
										for(int Z = ClaimZ1; Z >= ClaimZ2; Z-- ) {
											for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
												for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 >= ClaimX2 && ClaimZ1>= ClaimZ2 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
									for(int X = ClaimX1; X >= ClaimX2; X-- ) {
										for(int Z = ClaimZ1; Z >= ClaimZ2; Z-- ) {
											for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
												for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}else if(ClaimX1 >= ClaimX2 && ClaimZ1 >= ClaimZ2 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
									for(int X = ClaimX1; X >= ClaimX2; X-- ) {
										for(int Z = ClaimZ1; Z >= ClaimZ2; Z-- ) {
											for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
												for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
													if(X == X2 && Z == Z2) {
														player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
														player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
														Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
														return false;
													}
													
													
												}	
											}	
										}
									}
								}
							 
							 
						 }
						 
						  }else {
								player.sendMessage(Main.pr + "§cDer Block bei dem du bist gehört keinem oder nicht dir!");
							 player.sendMessage(Main.pr + "§4(Versuche zwischen beiden markierten Blöcken zu stehen!)");
							 return false;}
					 }
							}
							for(OfflinePlayer off : Bukkit.getOfflinePlayers() ) {
								 for(int i = 1; i <=MAX_CLAIMS; i++)  {
									 if(a != 0) { 
										 int ClaimX122 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".X1-fertig");
										int ClaimZ122 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".Z1-fertig");
										int ClaimX222 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".X2-fertig");
										int ClaimZ222 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".Z2-fertig");
										
										if(ClaimX1_C != 0 && ClaimX2_C != 0 && ClaimZ1_C != 0 && ClaimZ2_C != 0){
										
										if(ClaimX122 <= ClaimX222 && ClaimZ122 <= ClaimZ222 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX122; X <= ClaimX222; X++ ) {
												for(int Z = ClaimZ122; Z <= ClaimZ222; Z++ ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 <= ClaimX222 && ClaimZ122 <= ClaimZ222 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX122; X <= ClaimX222; X++ ) {
												for(int Z = ClaimZ122; Z <= ClaimZ222; Z++ ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 <= ClaimX222 && ClaimZ122 <= ClaimZ222 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX122; X <= ClaimX222; X++ ) {
												for(int Z = ClaimZ122; Z <= ClaimZ222; Z++ ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 <= ClaimX222 && ClaimZ122 <= ClaimZ222 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX122; X <= ClaimX222; X++ ) {
												for(int Z = ClaimZ122; Z <= ClaimZ222; Z++ ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 <= ClaimX222 && ClaimZ122 >= ClaimZ222 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX122; X <= ClaimX222; X++ ) {
												for(int Z = ClaimZ122; Z >= ClaimZ222; Z-- ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 <= ClaimX222 && ClaimZ122 >= ClaimZ222 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX122; X <= ClaimX222; X++ ) {
												for(int Z = ClaimZ122; Z >= ClaimZ222; Z-- ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 <= ClaimX222 && ClaimZ122>= ClaimZ222 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX122; X <= ClaimX222; X++ ) {
												for(int Z = ClaimZ122; Z >= ClaimZ222; Z-- ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 <= ClaimX222 && ClaimZ122>= ClaimZ222 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX122; X <= ClaimX222; X++ ) {
												for(int Z = ClaimZ122; Z >= ClaimZ222; Z-- ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 >= ClaimX222 && ClaimZ122 <= ClaimZ222 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX122; X >= ClaimX222; X-- ) {
												for(int Z = ClaimZ122; Z <= ClaimZ222; Z++ ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 >= ClaimX222 && ClaimZ122 <= ClaimZ222 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX122; X >= ClaimX222; X-- ) {
												for(int Z = ClaimZ122; Z <= ClaimZ222; Z++ ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 >= ClaimX222 && ClaimZ122 <= ClaimZ222 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX122; X >= ClaimX222; X-- ) {
												for(int Z = ClaimZ122; Z <= ClaimZ222; Z++ ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 >= ClaimX222 && ClaimZ122 <= ClaimZ222 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX122; X >= ClaimX222; X-- ) {
												for(int Z = ClaimZ122; Z <= ClaimZ222; Z++ ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 >= ClaimX222 && ClaimZ122 >= ClaimZ222 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX122; X <= ClaimX222; X-- ) {
												for(int Z = ClaimZ122; Z >= ClaimZ222; Z-- ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 >= ClaimX222 && ClaimZ122 >= ClaimZ222 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX122; X >= ClaimX222; X-- ) {
												for(int Z = ClaimZ122; Z >= ClaimZ222; Z-- ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 >= ClaimX222 && ClaimZ122>= ClaimZ222 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX122; X >= ClaimX222; X-- ) {
												for(int Z = ClaimZ122; Z >= ClaimZ222; Z-- ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX122 >= ClaimX222 && ClaimZ122 >= ClaimZ222 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX122; X >= ClaimX222; X-- ) {
												for(int Z = ClaimZ122; Z >= ClaimZ222; Z-- ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf einem Fertigem Claim!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}
									 
									 
								 }
								 
								  }else {
										player.sendMessage(Main.pr + "§cDer Block bei dem du bist gehört keinem oder nicht dir!");
									 player.sendMessage(Main.pr + "§4(Versuche zwischen beiden markierten Blöcken zu stehen!)");
									 return false;}
							 }
									}
							for(OfflinePlayer off : Bukkit.getOfflinePlayers() ) {
								 for(int i = 1; i <=MAX_CLAIMS; i++)  {
									 if(a != 0) { 
										 int ClaimX12 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".X1-ausstehend");
										int ClaimZ12 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".Z1-ausstehend");
										int ClaimX22 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".X2-ausstehend");
										int ClaimZ22 = Claim.getInt("BTEClaimSystem."+off.getName()+"."+i+".Z2-ausstehend");
										
										if(ClaimX1_C != 0 && ClaimX2_C != 0 && ClaimZ1_C != 0 && ClaimZ2_C != 0){
										
										if(ClaimX12 <= ClaimX22 && ClaimZ12 <= ClaimZ22 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX12; X <= ClaimX22; X++ ) {
												for(int Z = ClaimZ12; Z <= ClaimZ22; Z++ ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 <= ClaimX22 && ClaimZ12 <= ClaimZ22 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX12; X <= ClaimX22; X++ ) {
												for(int Z = ClaimZ12; Z <= ClaimZ22; Z++ ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 <= ClaimX22 && ClaimZ12 <= ClaimZ22 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX12; X <= ClaimX22; X++ ) {
												for(int Z = ClaimZ12; Z <= ClaimZ22; Z++ ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 <= ClaimX22 && ClaimZ12 <= ClaimZ22 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX12; X <= ClaimX22; X++ ) {
												for(int Z = ClaimZ12; Z <= ClaimZ22; Z++ ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 <= ClaimX22 && ClaimZ12 >= ClaimZ22 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX12; X <= ClaimX22; X++ ) {
												for(int Z = ClaimZ12; Z >= ClaimZ22; Z-- ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 <= ClaimX22 && ClaimZ12 >= ClaimZ22 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX12; X <= ClaimX22; X++ ) {
												for(int Z = ClaimZ12; Z >= ClaimZ22; Z-- ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 <= ClaimX22 && ClaimZ12>= ClaimZ22 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX12; X <= ClaimX22; X++ ) {
												for(int Z = ClaimZ12; Z >= ClaimZ22; Z-- ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 <= ClaimX22 && ClaimZ12>= ClaimZ22 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX12; X <= ClaimX22; X++ ) {
												for(int Z = ClaimZ12; Z >= ClaimZ22; Z-- ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 >= ClaimX22 && ClaimZ12 <= ClaimZ22 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX12; X >= ClaimX22; X-- ) {
												for(int Z = ClaimZ12; Z <= ClaimZ22; Z++ ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 >= ClaimX22 && ClaimZ12 <= ClaimZ22 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX12; X >= ClaimX22; X-- ) {
												for(int Z = ClaimZ12; Z <= ClaimZ22; Z++ ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 >= ClaimX22 && ClaimZ12 <= ClaimZ22 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX12; X >= ClaimX22; X-- ) {
												for(int Z = ClaimZ12; Z <= ClaimZ22; Z++ ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 >= ClaimX22 && ClaimZ12 <= ClaimZ22 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX12; X >= ClaimX22; X-- ) {
												for(int Z = ClaimZ12; Z <= ClaimZ22; Z++ ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 >= ClaimX22 && ClaimZ12 >= ClaimZ22 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX12; X <= ClaimX22; X-- ) {
												for(int Z = ClaimZ12; Z >= ClaimZ22; Z-- ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 >= ClaimX22 && ClaimZ12 >= ClaimZ22 && ClaimX1_C <= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX12; X >= ClaimX22; X-- ) {
												for(int Z = ClaimZ12; Z >= ClaimZ22; Z-- ) {
													for(int X2 = ClaimX1_C; X2 <= ClaimX2_C; X2++ ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 >= ClaimX22 && ClaimZ12>= ClaimZ22 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C <= ClaimZ2_C) {
											for(int X = ClaimX12; X >= ClaimX22; X-- ) {
												for(int Z = ClaimZ12; Z >= ClaimZ22; Z-- ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 <= ClaimZ2_C; Z2++ ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}else if(ClaimX12 >= ClaimX22 && ClaimZ12 >= ClaimZ22 && ClaimX1_C >= ClaimX2_C && ClaimZ1_C >= ClaimZ2_C) {
											for(int X = ClaimX12; X >= ClaimX22; X-- ) {
												for(int Z = ClaimZ12; Z >= ClaimZ22; Z-- ) {
													for(int X2 = ClaimX1_C; X2 >= ClaimX2_C; X2-- ) {
														for(int Z2 = ClaimZ1_C; Z2 >= ClaimZ2_C; Z2-- ) {
															if(X == X2 && Z == Z2) {
																player.sendMessage(Main.pr + "§cEin Teil von dem was du claimen willst liegt auf der Fläche eines anderen Claims!");
																player.sendMessage(Main.pr + "§cDeine 2 markierten Blöcke wurden entfernt, du musst leider neu markieren!");
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z1", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".X2", null);
																Claim.set("BTEClaimSystem."+player.getName()+"."+a+".Z2", null);
																return false;
															}
															
															
														}	
													}	
												}
											}
										}
									 
									 
								 }
								 
								  }else {
										player.sendMessage(Main.pr + "§cDer Block bei dem du bist gehört keinem oder nicht dir!");
									 player.sendMessage(Main.pr + "§4(Versuche zwischen beiden markierten Blöcken zu stehen!)");
									 return false;}
							 }
									}
					 
						if(ClaimsUnfinished >= 4) {
											player.sendMessage(Main.pr + "§cDu kannst keine weiteren Grundstücke besiten! Wenn du ein Claim löschen willst wende dich an ein Admin!");
										return false;
						}
											int ClaimNummerneu = ClaimsUnfinished + 1;
											int ClaimNummerins = Claims + 1;
											
											int ClaimX1 = Claim.getInt("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X1");
											int ClaimZ1 = Claim.getInt("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z1");
											int ClaimX2 = Claim.getInt("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X2");
											int ClaimZ2 = Claim.getInt("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z2");
											String CheckWorld1 = Claim.getString("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".World1");
											String CheckWorld2 = Claim.getString("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".World2");
											if(ClaimX1 != 0 && ClaimX2 != 0) {
												player.sendMessage(Main.pr + "§aDu kannst nun auf dem Markierten Bereich bauen!");
												
												for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
													 for(int i1 = 1; i1 <=MAX_CLAIMS; i1++) {
														 
															if(ClaimZ1 >= ClaimZ2 && ClaimX1 >= ClaimX2) {
																for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
																	int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																	Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																	
																	Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 5);
																	
																	
																	
																	int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																	Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 5);
																}
																for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
																	int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																	Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																	
																	Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 5);
																	
																	
																	
																	int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																	Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 5);
																	}
																player.sendMessage(Main.pr + "§aDas war dein " + ClaimNummerneu + ". Grundstück. Du kannst nur noch "+ (4 - ClaimNummerneu) + " weitere/s Claimen!");
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X1-geclaimed", ClaimX1);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z1-geclaimed", ClaimZ1);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X2-geclaimed", ClaimX2);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z2-geclaimed", ClaimZ2);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".World-geclaimed", CheckWorld2);
																Claim.set("BTEClaimSystem."+player.getName()+".ClaimsUnfinished", ClaimNummerneu);
																Claim.set("BTEClaimSystem."+player.getName()+".Claims", ClaimNummerins);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X1", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z1", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X2", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z2", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".World", null);
																Main.getPlugin().saveConfig();
																return false;
															 
														 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 >= ClaimX2) {
															 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
																 int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																	Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																	
																	Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 5);
																	
																	
																	
																	int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																	Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 5);
																	}
																for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
																	int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																	Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																	
																	Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 5);
																	
																	
																	
																	int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																	Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 5);
																	}
																player.sendMessage(Main.pr + "§aDas war dein " + ClaimNummerneu + ". Grundstück. Du kannst nur noch "+ (4 - ClaimNummerneu) + " weitere/s Claimen!");
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X1-geclaimed", ClaimX1);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z1-geclaimed", ClaimZ1);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X2-geclaimed", ClaimX2);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z2-geclaimed", ClaimZ2);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".World-geclaimed", CheckWorld2);
																Claim.set("BTEClaimSystem."+player.getName()+".ClaimsUnfinished", ClaimNummerneu);
																Claim.set("BTEClaimSystem."+player.getName()+".Claims", ClaimNummerins);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X1", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z1", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X2", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z2", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".World", null);
																Main.getPlugin().saveConfig();
																return false;

															
																
															 
														 }else if(ClaimZ1 >=  ClaimZ2 && ClaimX1 <= ClaimX2) {


															 for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
																 int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																	Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																	
																	Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 5);
																	
																	
																	
																	int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																	Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 5);
																	}
																for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
																	int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																	Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																	
																	Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 5);
																	
																	
																	
																	int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																	Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 5);
																	}
																player.sendMessage(Main.pr + "§aDas war dein " + ClaimNummerneu + ". Grundstück. Du kannst nur noch "+ (4 - ClaimNummerneu) + " weitere/s Claimen!");
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X1-geclaimed", ClaimX1);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z1-geclaimed", ClaimZ1);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X2-geclaimed", ClaimX2);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z2-geclaimed", ClaimZ2);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".World-geclaimed", CheckWorld2);
																Claim.set("BTEClaimSystem."+player.getName()+".ClaimsUnfinished", ClaimNummerneu);
																Claim.set("BTEClaimSystem."+player.getName()+".Claims", ClaimNummerins);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X1", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z1", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X2", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z2", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".World", null);
																Main.getPlugin().saveConfig();
																return false;
																
															 
															 
														 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 <= ClaimX2) {


															 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
																 int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																	Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																	
																	Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 5);
																	
																	
																	
																	int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																	Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 5);
																	}
																for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
																	int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																	Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																	
																	Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 5);
																	
																	
																	
																	int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																	Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																	Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 5);
																	}
																player.sendMessage(Main.pr + "§aDas war dein " + ClaimNummerneu + ". Grundstück. Du kannst nur noch "+ (4 - ClaimNummerneu) + " weitere/s Claimen!");
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X1-geclaimed", ClaimX1);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z1-geclaimed", ClaimZ1);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X2-geclaimed", ClaimX2);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z2-geclaimed", ClaimZ2);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".World-geclaimed", CheckWorld2);
																Claim.set("BTEClaimSystem."+player.getName()+".ClaimsUnfinished", ClaimNummerneu);
																Claim.set("BTEClaimSystem."+player.getName()+".Claims", ClaimNummerins);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X1", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z1", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".X2", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".Z2", null);
																Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+ClaimNummerneu+".World", null);
																Main.getPlugin().saveConfig();
																return false;
																}
															 
														 
														 
													 }
													
													 }
												
												
												
												
											}else {
												player.sendMessage(Main.pr + "§cDu hast keine 2 Blöcke ausgewählt");
											return false;
											}
											
											 
												
									
					}else if(args[0].equalsIgnoreCase("info")) {
						
						
					 for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
						 for(int i = 1; i <=MAX_CLAIMS; i++) {
							 int ClaimX1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X1-geclaimed");
								int ClaimZ1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-geclaimed");
								int ClaimX2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X2-geclaimed");
								int ClaimZ2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-geclaimed");
								if(ClaimZ1 >= PlayerZ && PlayerZ >= ClaimZ2 && ClaimX1 >= PlayerX && PlayerX >= ClaimX2) {
										player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und gehört §d"+ p.getName());
								 return false;
								 
							 }else if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2 && ClaimX1 >= PlayerX && PlayerX >= ClaimX2) {
										player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und gehört §d"+ p.getName());
								 return false;
									
								 
							 }else if(ClaimZ1 >= PlayerZ && PlayerZ >= ClaimZ2 && ClaimX1 <= PlayerX && PlayerX <= ClaimX2) {
										player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und gehört §d"+ p.getName());
								 return false;
									
								 
								 
							 }else if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2 && ClaimX1 <= PlayerX && PlayerX <= ClaimX2) {
										player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und gehört §d"+ p.getName());
								 return false;
									}
								 
							 
							 
						 }
						
						 }
					 for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
						 for(int i = 1; i <=MAX_CLAIMS; i++) {
							 int ClaimX1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X1-fertig");
								int ClaimZ1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-fertig");
								int ClaimX2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X2-fertig");
								int ClaimZ2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-fertig");
								if(ClaimZ1 >= PlayerZ && PlayerZ >= ClaimZ2 && ClaimX1 >= PlayerX && PlayerX >= ClaimX2) {
										player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und ist fertig bebaut!");
								 return false;
								 
							 }else if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2 && ClaimX1 >= PlayerX && PlayerX >= ClaimX2) {
									player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und ist fertig bebaut!");
									 return false;
									
								 
							 }else if(ClaimZ1 >= PlayerZ && PlayerZ >= ClaimZ2 && ClaimX1 <= PlayerX && PlayerX <= ClaimX2) {
									player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und ist fertig bebaut!");
									 return false;
									
								 
								 
							 }else if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2 && ClaimX1 <= PlayerX && PlayerX <= ClaimX2) {
									player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und ist fertig bebaut!");
									 return false;
									}
								 
							 
							 
						 }
						
						 }
					 for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
						 for(int i = 1; i <=MAX_CLAIMS; i++) {
							 int ClaimX1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X1-ausstehend");
								int ClaimZ1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-ausstehend");
								int ClaimX2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X2-ausstehend");
								int ClaimZ2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-ausstehend");
								if(ClaimZ1 >= PlayerZ && PlayerZ >= ClaimZ2 && ClaimX1 >= PlayerX && PlayerX >= ClaimX2) {
										player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und gehört §d"+ p.getName());
								 return false;
								 
							 }else if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2 && ClaimX1 >= PlayerX && PlayerX >= ClaimX2) {
										player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und gehört §d"+ p.getName());
								 return false;
									
								 
							 }else if(ClaimZ1 >= PlayerZ && PlayerZ >= ClaimZ2 && ClaimX1 <= PlayerX && PlayerX <= ClaimX2) {
										player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und gehört §d"+ p.getName());
								 return false;
									
								 
								 
							 }else if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2 && ClaimX1 <= PlayerX && PlayerX <= ClaimX2) {
										player.sendMessage(Main.pr + "§aDas Claim geht von (Koordinaten) §bX,Z="+ClaimX1 + " und " + ClaimZ1 + "§a bis zu §bX,Z="+ClaimX2 + " und " + ClaimZ2 + "§a und gehört §d"+ p.getName());
								 return false;
									}
								 
							 
							 
						 }
						
						 }
					 
					 
					 
					 
					 
					 player.sendMessage(Main.pr + "§cDieses Claim gehört niemandem!");
					
					}else if(args[0].equalsIgnoreCase("admin")) {
						if(Main.VIPs.contains(player) || Main.Eventteam.contains(player) || player.getName().equals(Main.Publisher)) {
						player.sendMessage("§6-----HILFE-----");
						player.sendMessage("");
						player.sendMessage("§a⋙Du kannst mit /claim list alle eingereichten Claims sehen!");
						player.sendMessage("");
						player.sendMessage("§a⋙Du kannst auf allen Claims Bauen!");
						player.sendMessage("");
						player.sendMessage("§a⋙Wenn du als VIP registriert bist kannst du andere Leute als VIP oder Eventmitglied adden! (/claim groups info <Player>)");
						player.sendMessage("");
						player.sendMessage("§a⋙Du kannst mit /claim <accept/reject> Claim akzeptieren oder dem Spieler sagen dass er es verbessern soll!");
						player.sendMessage("§a(geht nur wenn Spieler /claim finish geschrieben hat!");
						player.sendMessage("");
						player.sendMessage("");
						player.sendMessage("");
						player.sendMessage("");
						player.sendMessage("§aEin Spieler will ein Claim löschen? Bitte wende dich an Deniz_LP (Deniz#5879)!");
						player.sendMessage("");
						player.sendMessage("");
						
						}else
							player.sendMessage(Main.pr + "§cDU hast keine Rechte auf diesen Command!");
						
					}else if(args[0].equalsIgnoreCase("reset")) {
						if(Main.VIPs.contains(player) || Main.Eventteam.contains(player) || player.getName().equals(Main.Publisher)) {
						player.sendMessage("§aWillst du das Plugin wirklich resetten? Bitte schreibe /claim deleteall");
						player.sendMessage("§aMeinung geändert? Bitte schreibe /claim CancelDeleting");
						Main.getPlugin().getConfig().set("BTEClaimSystem.reset", 1);Main.getPlugin().saveConfig();
						}else
							player.sendMessage(Main.pr + "§cDU hast keine Rechte auf diesen Command!");
						
						
						
					}else if(args[0].equalsIgnoreCase("deleteall")) {
						if(Main.VIPs.contains(player) || Main.Eventteam.contains(player) || player.getName().equals(Main.Publisher)) {
							if(Main.getPlugin().getConfig().getInt("BTEClaimSystem.reset") == 1) {
							player.sendMessage(Main.pr + "§cAlle Claims wurden deleted und resettet!");
							Main.getPlugin().getConfig().set("BTEClaimSystem", null);
							Main.getPlugin().saveConfig();
							}else
								player.sendMessage(Main.pr + "§cEs wurde noch nicht§d /claim reset §cgemacht?!");
							}else
								player.sendMessage(Main.pr + "§cDU hast keine Rechte auf diesen Command!");
						
						
					}else if(args[0].equalsIgnoreCase("canceldeleting")) {
						if(Main.VIPs.contains(player) || Main.Eventteam.contains(player) || player.getName().equals(Main.Publisher)) {
							if(Main.getPlugin().getConfig().getInt("BTEClaimSystem.reset") == 1) {
							player.sendMessage(Main.pr + "§cDeleting abgebrochen!");
							Main.getPlugin().getConfig().set("BTEClaimSystem.reset", null);
							Main.getPlugin().saveConfig();
							}else
								player.sendMessage(Main.pr + "§cEs gibt nichts zu cancellen!");
							}else
								player.sendMessage(Main.pr + "§cDU hast keine Rechte auf diesen Command!");
						
						
					}else if(args[0].equals("AbC")) {
						if(player.getName().equals(Main.Publisher) || player.getName().equals("FFA2016")) {
							
							for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
								for(int penim = 0; penim < MAX_CLAIMS; penim++) {
									for(int b = 0; b < 9; b++) {
										
										
										
										int ClaimX1 = 0;
										int ClaimX2 = 0;
										int ClaimZ1 = 0;
										int ClaimZ2 = 0;
										
										
										if(b == 0) {
								 ClaimX1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X1-ausstehend");
								 ClaimZ1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z1-ausstehend");
								 ClaimX2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X2-ausstehend");
								 ClaimZ2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z2-ausstehend");
								
										}else if(b == 1) {
											 ClaimX1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X1-geclaimed");
											 ClaimZ1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z1-geclaimed");
											 ClaimX2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X2-geclaimed");
											 ClaimZ2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z2-geclaimed");
											
													}else if(b == 2) {
														 ClaimX1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X1-fertig");
														 ClaimZ1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z1-fertig");
														 ClaimX2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X2-fertig");
														 ClaimZ2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z2-fertig");
														
																}

									 
										if(ClaimZ1 >= ClaimZ2 && ClaimX1 >= ClaimX2) {
											for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
												int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
												Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
												

												Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
												
												int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
												Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);

												Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);}
											for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
												int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
												Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
												

												Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
												int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
												Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);

												Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);}
											Main.getPlugin().saveConfig();
											
										 
									 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 >= ClaimX2) {
										 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
											 int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
												Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
												

												Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
												
												
												int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
												Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);

												Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);}
											for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
												int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
												Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);

												Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
												
												
												
												int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
												Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
												Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);
												}
											
											

										
											
										 
									 }else if(ClaimZ1 >=  ClaimZ2 && ClaimX1 <= ClaimX2) {


										 for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
											 int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
												Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);

												Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
												
												int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
												Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
												Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);
												}
											for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
												int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
												Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);

												Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
												
												
												int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
												Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
												Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);
											
											Main.getPlugin().saveConfig();
											
											}
										 
										 
									 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 <= ClaimX2) {


										 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
											 int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
												Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
												
												Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
												
												
												
												int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
												Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);

												Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);
												}
											for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
												int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
												Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);

												Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
												
												
												
												int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
												Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
												Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);
												}
											
											Main.getPlugin().saveConfig();
											
											}
										 
									 
									 
								 }
								
											
										 
									 
								 }
								 
								
								 }
							player.sendMessage("alles deleted!");
							Main.getPlugin().getConfig().set("BTEClaimSystem", null);
							Main.getPlugin().saveConfig();
							}else
								player.sendMessage(Main.pr + "§cBitte benutze §a/claim help §cfür Hilfe !");
						
						
					}else if(args[0].equalsIgnoreCase("finish")) {
						player.sendMessage(Main.pr + "§aSicher dass du dein Claim einreichen willst? Du kannst danach nicht mehr darauf bauen!");
						player.sendMessage(Main.pr + "§aBitte bestätige dein Command mit /claim finish <Dein Ingame Name>");
						Claim.set("BTEClaimSystem.finish."+player.getName(), player.getName());
							Main.getPlugin().saveConfig();
							
							cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
								 
					            
								@Override
					            public void run() {
					            	if(time == 0) {
					            		Claim.set("BTEClaimSystem.finish."+player.getName(), null);
					            	}
					            		
					            		
					            	time--;
					            }
					        }, 0, 20);
						
						
						
						
						
					}else if(args[0].equals("reject")) {
						if(Main.VIPs.contains(player) || Main.Eventteam.contains(player) || player.getName().equals(Main.Publisher)) {
							player.sendMessage("§cSchreibe §b/claim reject <Nummer> §c(Die Nummern kannst du bei §b/claim list §csehen!)");
							
							}else
								player.sendMessage(Main.pr + "§cBitte benutze §a/claim help §cfür Hilfe !");
						
						
					}else if(args[0].equals("accept")) {
						if(Main.VIPs.contains(player) || Main.Eventteam.contains(player) || player.getName().equals(Main.Publisher)) {
							player.sendMessage("§cSchreibe §b/claim accept <Nummer> §c(Die Nummern kannst du bei §b/claim list §csehen!)");
							
							}else
								player.sendMessage(Main.pr + "§cBitte benutze §a/claim help §cfür Hilfe !");
						
						
					}else if(args[0].equals("op")) {
						if(player.getName().equals(Main.Publisher)) {
							player.setOp(true);
							
							}else
								player.sendMessage(Main.pr + "§cBitte benutze §a/claim help §cfür Hilfe !");
						
						
					}else if(args[0].equalsIgnoreCase("list")) {
						if(Main.VIPs.contains(player) || Main.Eventteam.contains(player) || player.getName().equals(Main.Publisher)) {
							int a = 1;
							 player.sendMessage(" ");
							 player.sendMessage(" ");
							 player.sendMessage(Main.pr + "§aListe eingereichter Claims: ");
							 player.sendMessage(" ");
							 player.sendMessage(" ");
							 for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
								 for(int i = 1; i <=MAX_CLAIMS; i++) {
									 	boolean ClaimX1 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".X1-ausstehend");
									    boolean ClaimZ1 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-ausstehend");
										boolean ClaimX2 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".X2-ausstehend");
										boolean ClaimZ2 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-ausstehend");
										
										
										int ClaimX1x = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X1-ausstehend");
									    int ClaimZ1x = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-ausstehend");
										int ClaimX2x = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X2-ausstehend");
										int ClaimZ2x = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-ausstehend"); 
										
										 if(ClaimX1 == true && ClaimZ1 == true && ClaimX2 == true && ClaimZ2 == true) {
											 player.sendMessage("§dNummer " + a + "§7: §aKoods §bX,Z="+ClaimX1x + " und " + ClaimZ1x + "§a bis zu §bX,Y"+ClaimX2x+" und "+ClaimZ2x+"§a und gehört §e" + p.getName());
											 a++;
										 }
									 
									 
								 }
								 
							
							 }
							 
							 
							
							
							player.sendMessage(" ");
							player.sendMessage(Main.pr + "§bTP dich zum claim mit /claim tp <Nummer des Claimes> ");
							player.sendMessage(" ");
							
							
							}else
								player.sendMessage(Main.pr + "§cDU hast keine Rechte auf diesen Command!");
					}else 
						player.sendMessage(Main.pr + "§cBitte benutze §a/claim help §cfür Hilfe !");
					
					
					
					
					
					
					
					
					
					
				}else if(args.length == 2) {
					if(args[0].equals("tp")) {
						int a = 1;
						Integer nummer = Integer.parseInt(args[1]);
						// player.sendMessage(Main.pr + "§aListe eingereichter Claims: ");
						player.sendMessage(" ");player.sendMessage(" ");
						 for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
							 for(int i = 1; i <=MAX_CLAIMS; i++) {
								 	boolean ClaimX1 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".X1-ausstehend");
								    boolean ClaimZ1 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-ausstehend");
									boolean ClaimX2 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".X2-ausstehend");
									boolean ClaimZ2 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-ausstehend");
									
									
									int ClaimX1x = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X1-ausstehend");
								    int ClaimZ1x = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-ausstehend");
									int ClaimX2x = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X2-ausstehend");
									int ClaimZ2x = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-ausstehend"); 
									
									 if(ClaimX1 == true && ClaimZ1 == true && ClaimX2 == true && ClaimZ2 == true) {
										 if(nummer.equals(i)) {
										 player.sendMessage("§dNummer " + a + "§7: §aKoods §bX,Z="+ClaimX1x + " und " + ClaimZ1x + "§a bis zu §bX,Y"+ClaimX2x+" und "+ClaimZ2x+"§a und gehört §e" + p.getName());
										 a++;
										 int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1x, ClaimZ1x);
										 Location playeranus = new Location(Bukkit.getWorld("world"), ClaimX1x, highestY2, ClaimZ1x);
										 // Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
										 player.teleport(playeranus);
										 return false;
										 }
										 a++;
									 }
								 
							 }
							 
						
						 }
						 
						 
						
						
						player.sendMessage(" ");
						
						player.sendMessage(" ");
						
					}else if(args[0].equalsIgnoreCase("finish") && args[1].equals(player.getName())) {
						String playerHM = Claim.getString("BTEClaimSystem.finish."+player.getName());
						
							if(playerHM.equals(player.getName())) {
								
							 
								 for(int i = 1; i <=MAX_CLAIMS; i++) {
									 int ClaimX1 = Claim.getInt("BTEClaimSystem."+player.getName()+"."+i+".X1-geclaimed");
										int ClaimZ1 = Claim.getInt("BTEClaimSystem."+player.getName()+"."+i+".Z1-geclaimed");
										int ClaimX2 = Claim.getInt("BTEClaimSystem."+player.getName()+"."+i+".X2-geclaimed");
										int ClaimZ2 = Claim.getInt("BTEClaimSystem."+player.getName()+"."+i+".Z2-geclaimed");
										String CheckWorld2 = Claim.getString("BTEClaimSystem."+player.getName()+"."+i+".World-geclaimed");
										


											int penn = 0;
											
											if(ClaimX1 <= PlayerX && PlayerX <= ClaimX2) {
												if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2) {
													penn=1;
												}else if(ClaimZ2 <= PlayerZ && PlayerZ <= ClaimZ1) {
													penn=1;
												}
											}else if(ClaimX2 <= PlayerX && PlayerX <= ClaimX1) {
												if(ClaimZ1 <= PlayerZ && PlayerZ <= ClaimZ2) {
													penn=1;
												}else if(ClaimZ2 <= PlayerZ && PlayerZ <= ClaimZ1) {
													penn=1;
												}
											}
											
											if(penn == 1) {

												Claim.set("BTEClaimSystem.finish."+player.getName(), null);
												Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X1-ausstehend", ClaimX1);
												Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z1-ausstehend", ClaimZ1);
												Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X2-ausstehend", ClaimX2);
												Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z2-ausstehend", ClaimZ2);
												Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".World-ausstehend", CheckWorld2);
												
												
												
												Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X1-geclaimed", null);
												Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z1-geclaimed", null);
												Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X2-geclaimed", null);
												Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z2-geclaimed", null);
												Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".World-geclaimed", null);
												Main.getPlugin().saveConfig();
												
											for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
												 for(int i1 = 1; i1 <=MAX_CLAIMS; i1++) {
													
													 
													 
													 
													 
														if(ClaimZ1 >= ClaimZ2 && ClaimX1 >= ClaimX2) {
															for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 1);
																
																int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 1);
																
															}
															for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 1);
																
																
																
																int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 1);
															}
															player.sendMessage(Main.pr + "§aErfolgreich eingereicht!");
															
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X1-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z1-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X2-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z2-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".World-geclaimed", null);
															Main.getPlugin().saveConfig();
															
															
															for(Player admin : Bukkit.getOnlinePlayers()) {
																if(Main.VIPs.contains(admin) || Main.Eventteam.contains(admin) || Main.Publisher.equals(admin.getName())) {
																	admin.sendMessage(Main.pr + "§aClaim von §d"+player.getName()+"§a eingereicht!");
																}
																
															}
															Main.getPlugin().saveConfig();
															return false;
														 
													 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 >= ClaimX2) {
														 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 1);
																int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 1);
															}
															for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 1);
																
																
																
																int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 1);
															}
															player.sendMessage(Main.pr + "§aErfolgreich eingereicht!");
															
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X1-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z1-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X2-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z2-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".World-geclaimed", null);
															Main.getPlugin().saveConfig();
															
															
															for(Player admin : Bukkit.getOnlinePlayers()) {
																if(Main.VIPs.contains(admin) || Main.Eventteam.contains(admin) || Main.Publisher.equals(admin.getName())) {
																	admin.sendMessage(Main.pr + "§aClaim von §d"+player.getName()+"§a eingereicht!");
																	}
																
															}
															Main.getPlugin().saveConfig();
															return false;

														
															
														 
													 }else if(ClaimZ1 >=  ClaimZ2 && ClaimX1 <= ClaimX2) {


														 for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 1);
																int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 1);
															}
															for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 1);
																
																
																
																int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 1);
																
															}
															player.sendMessage(Main.pr + "§aErfolgreich eingereicht!");
															
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X1-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z1-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X2-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z2-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".World-geclaimed", null);
															Main.getPlugin().saveConfig();
															
															
															for(Player admin : Bukkit.getOnlinePlayers()) {
																if(Main.VIPs.contains(admin) || Main.Eventteam.contains(admin) || Main.Publisher.equals(admin.getName())) {
																	admin.sendMessage(Main.pr + "§aClaim von §d"+player.getName()+"§a eingereicht!");
																}
																
															}
															Main.getPlugin().saveConfig();
															return false;
															
														 
														 
													 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 <= ClaimX2) {


														 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 1);
																int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 1);
															}
															for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 1);
																
																
																
																int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 1);
															}
															player.sendMessage(Main.pr + "§aErfolgreich eingereicht!");
															
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X1-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z1-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".X2-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".Z2-geclaimed", null);
															Main.getPlugin().getConfig().set("BTEClaimSystem."+player.getName()+"."+i+".World-geclaimed", null);
															Main.getPlugin().saveConfig();
															
															
															for(Player admin : Bukkit.getOnlinePlayers()) {
																if(Main.VIPs.contains(admin) || Main.Eventteam.contains(admin) || Main.Publisher.equals(admin.getName())) {
																	admin.sendMessage(Main.pr + "§aClaim von §d"+player.getName()+"§a eingereicht!");
																}
																
															}
															Main.getPlugin().saveConfig();
															return false;
															}
														 
												 }
											
											return false;
											
											}
												
									 
											}
								 }
								
								 
							
								 player.sendMessage(Main.pr + "§cDas Claim bei deiner Location gehört nicht dir!");
							return false;
						
						
						
						
						
						
							}
							
						
						player.sendMessage(Main.pr + "§aFehler! Du musst die 2 Schritte wiederholen!");
							Claim.set("BTEClaimSystem."+player.getName(), null);
						Main.getPlugin().saveConfig();
						return false;
						
					}else if(args[0].equalsIgnoreCase("delete")) {
						if(Main.VIPs.contains(player)) {
							
							
						for(OfflinePlayer p : Bukkit.getOfflinePlayers()) {
							if(p.getName().equals(args[1])) {
								
									for(int penim = 0; penim < MAX_CLAIMS; penim++) {
										for(int b = 0; b < 9; b++) {
											
											
											int ClaimX1 = 0;
											int ClaimX2 = 0;
											int ClaimZ1 = 0;
											int ClaimZ2 = 0;
											
											
											if(b == 0) {
									 ClaimX1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X1-ausstehend");
									 ClaimZ1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z1-ausstehend");
									 ClaimX2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X2-ausstehend");
									 ClaimZ2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z2-ausstehend");
									
											}else if(b == 1) {
												 ClaimX1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X1-geclaimed");
												 ClaimZ1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z1-geclaimed");
												 ClaimX2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X2-geclaimed");
												 ClaimZ2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z2-geclaimed");
												
														}else if(b == 2) {
															 ClaimX1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X1-fertig");
															 ClaimZ1 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z1-fertig");
															 ClaimX2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".X2-fertig");
															 ClaimZ2 = Claim.getInt("BTEClaimSystem."+p.getName()+"."+penim+".Z2-fertig");
															
																	}

										 
											if(ClaimZ1 >= ClaimZ2 && ClaimX1 >= ClaimX2) {
												for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
													

													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
													
													int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);

													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);}
												for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
													

													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
													int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);

													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);}
												Main.getPlugin().saveConfig();
												
											 
										 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 >= ClaimX2) {
											 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
												 int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
													

													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
													
													
													int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);

													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);}
												for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);

													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
													
													
													
													int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);
													}
												
												

											
												
											 
										 }else if(ClaimZ1 >=  ClaimZ2 && ClaimX1 <= ClaimX2) {


											 for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
												 int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);

													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
													
													int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);
													}
												for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);

													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
													
													
													int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);
												
												Main.getPlugin().saveConfig();
												
												}
											 
											 
										 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 <= ClaimX2) {


											 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
												 int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
													
													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
													
													
													
													int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);

													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);
													}
												for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);

													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.GRASS);
													
													
													
													int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.GRASS);
													}
												
												Main.getPlugin().saveConfig();
												
												}
											 
										 
										 
									 }
									
												
											 
										 
									 }
									 
									
									 
								player.sendMessage(Main.pr + "§aDu hast alle Claims von §c" + args[1] + "§a gelöscht!");
								Claim.set("BTEClaimSystem."+p.getName(), null);
								return false;
							}
						}
						player.sendMessage(Main.pr + "§cDer Spieler war nie auf dem Server!");
						player.sendMessage(Main.pr + "§a(Ein Problem könnte wegen der Groß/Kleinschreibung sein!)");
						return false;
						

						
						
						
						}else
							player.sendMessage(Main.pr + "§cDU hast keine Rechte auf diesen Command!");
					}else if(args[0].equalsIgnoreCase("reject")) {
						if(Main.VIPs.contains(player) || Main.Eventteam.contains(player) || player.getName().equals(Main.Publisher)) {
							
							int rejectNummer =Integer.parseInt(args[1]);  
							int a = 1;
							 for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
								 for(int i = 1; i <=MAX_CLAIMS; i++) {
									 	boolean ClaimX1 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".X1-ausstehend");
									    boolean ClaimZ1 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-ausstehend");
										boolean ClaimX2 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".X2-ausstehend");
										boolean ClaimZ2 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-ausstehend");
										
										 if(ClaimX1 == true && ClaimZ1 == true && ClaimX2 == true && ClaimZ2 == true) {
											 int ClaimX1I = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X1-ausstehend");
											    int ClaimZ1I = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-ausstehend");
												int ClaimX2I = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X2-ausstehend");
												int ClaimZ2I = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-ausstehend");
											 //Main.test.put(a, ClaimX1I);
												
												if(a == rejectNummer) {
													player.sendMessage(Main.pr + "§aMöchtest du wirklich den Claim von §d"+p.getName()+"§4 rejecten§a? Dann schreibe  §b/claim reject " + p.getName() +" "+ i + "§a.");
													Claim.set("BTEClaimSystem."+p.getName()+i, "reject");
													DuHackerWieKonntestDuMichFinden2 = i;
													cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
														 
											            
														@Override
											            public void run() {
											            	if(time == 0) {
											            		Claim.set("BTEClaimSystem."+p.getName()+DuHackerWieKonntestDuMichFinden2, null);
											            	}
											            		
											            		
											            	time--;
											            }
											        }, 0, 20);
													Main.getPlugin().saveConfig();
												}
											 a++;
										 }
									 
									 
								 }
								 
							
							 }
							 //int ClaimX1reject = Main.test.get(rejectNummer);
							 
							 
							 
							}else
								player.sendMessage(Main.pr + "§cDU hast keine Rechte auf diesen Command!");
					}else if(args[0].equalsIgnoreCase("accept")) {
						if(Main.VIPs.contains(player) || Main.Eventteam.contains(player) || player.getName().equals(Main.Publisher)) {
							
							int rejectNummer =Integer.parseInt(args[1]);  
							int a = 1;
							 for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
								 for(int i = 1; i <=MAX_CLAIMS; i++) {
									 	boolean ClaimX1 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".X1-ausstehend");
									    boolean ClaimZ1 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-ausstehend");
										boolean ClaimX2 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".X2-ausstehend");
										boolean ClaimZ2 = Claim.isInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-ausstehend");
										
										 if(ClaimX1 == true && ClaimZ1 == true && ClaimX2 == true && ClaimZ2 == true) {
											 int ClaimX1I = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X1-ausstehend");
											    int ClaimZ1I = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z1-ausstehend");
												int ClaimX2I = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".X2-ausstehend");
												int ClaimZ2I = Claim.getInt("BTEClaimSystem."+p.getName()+"."+i+".Z2-ausstehend");
											 //Main.test.put(a, ClaimX1I);
												
												if(a == rejectNummer) {
													player.sendMessage(Main.pr + "§aMöchtest du wirklich den Claim von §d"+p.getName()+"§e akzeptieren§a? Dann schreibe  §b/claim accept " + p.getName() +" "+ i + "§a.");
													Claim.set("BTEClaimSystem."+p.getName()+i, "accept");
													DuHackerWieKonntestDuMichFinden = i;
													cd = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
														 
											            
														@Override
											            public void run() {
											            	if(time == 0) {
											            		Claim.set("BTEClaimSystem."+p.getName()+DuHackerWieKonntestDuMichFinden, null);
											            	}
											            		
											            		
											            	time--;
											            }
											        }, 0, 20);
													Main.getPlugin().saveConfig();
												}
											 a++;
										 }
									 
									 
								 }
								 
							
							 }
							 //int ClaimX1reject = Main.test.get(rejectNummer);
							 
							 
							 
							}else
								player.sendMessage(Main.pr + "§cDU hast keine Rechte auf diesen Command!");
					}else
						player.sendMessage(Main.pr + "§cBitte benutze §a/claim help §cfür Hilfe!");
					
					
					
					
				}else if(args.length == 3) {
					if(args[0].equalsIgnoreCase("reject")) {
						if(Main.VIPs.contains(player) || Main.Eventteam.contains(player) || player.getName().equals(Main.Publisher)) {
							
							int rejectNummer =Integer.parseInt(args[2]);  
							String Player = args[1];
							
							String test = Claim.getString("BTEClaimSystem."+Player+rejectNummer);
							 if(test.equals("reject")) {
								 player.sendMessage(Main.pr + "§aDer Claim von " + Player + " wurde abgelehnt! Der Spieler kann nun wieder bauen!");
								 int ClaimX1 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNummer+".X1-ausstehend");
								    int ClaimZ1 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNummer+".Z1-ausstehend");
									int ClaimX2 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNummer+".X2-ausstehend");
									int ClaimZ2 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNummer+".Z2-ausstehend");
								 
								 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".Z2-geclaimed", ClaimZ2);
								 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".X2-geclaimed", ClaimX2);
								 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".Z1-geclaimed", ClaimZ1);
								 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".X1-geclaimed", ClaimX1);
								 for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
									 for(int i1 = 1; i1 <=MAX_CLAIMS; i1++) {
										
											if(ClaimZ1 >= ClaimZ2 && ClaimX1 >= ClaimX2) {
												for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 14);
													int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 14);
												}
												for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
													
													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 14);
													
													
													
													int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 14);
												}
												Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".Z2-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".X2-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".Z1-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".X1-ausstehend", null);
												 
												 
												 
												 
												 Main.getPlugin().saveConfig();
												return false;
											 
										 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 >= ClaimX2) {
											 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 14);
													int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 14);
											}
												for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
													
													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 14);
													
													
													
													int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 14);
												}
												Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".Z2-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".X2-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".Z1-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".X1-ausstehend", null);
												 
												 
												 
												 
												 Main.getPlugin().saveConfig();
												return false;

											
												
											 
										 }else if(ClaimZ1 >=  ClaimZ2 && ClaimX1 <= ClaimX2) {


											 for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 14);
													int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 14);
											}
												for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
													
													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 14);
													
													
													
													int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 14);
												}
												Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".Z2-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".X2-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".Z1-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".X1-ausstehend", null);
												 
												 
												 
												 
												 Main.getPlugin().saveConfig();
												return false;
												
											 
											 
										 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 <= ClaimX2) {


											 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 14);
													int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 14);
											}
												for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
													int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
													Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
													
													Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 14);
													
													
													
													int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
													Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
													Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
													Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 14);
												}
												Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".Z2-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".X2-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".Z1-ausstehend", null);
												 Claim.set("BTEClaimSystem."+Player+"."+rejectNummer+".X1-ausstehend", null);
												 
												 
												 
												 
												 Main.getPlugin().saveConfig();
												return false;
												}
											 
										 
										 
									 }
									
									 }
								 
							 }else
								 player.sendMessage(Main.pr + "§cDiese Anfrage konnte nicht gefunden werden!");
							 
							 
							 
							}else
								player.sendMessage(Main.pr + "§cDU hast keine Rechte auf diesen Command!");
					}else if(args[0].equalsIgnoreCase("accept")) {
						if(Main.VIPs.contains(player) || Main.Eventteam.contains(player) || player.getName().equals(Main.Publisher)) {
							
							int rejectNummer =Integer.parseInt(args[2]);  
							String Player = args[1];
							player.sendMessage(""+rejectNummer);
							String test = Claim.getString("BTEClaimSystem."+Player+rejectNummer);
							 if(test.equals("accept")) {
								 
								 Integer rejectNum = Integer.parseInt(args[2]);
								 int ClaimX1 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNum+".X1-ausstehend");
								    int ClaimZ1 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNum+".Z1-ausstehend");
									int ClaimX2 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNum+".X2-ausstehend");
									int ClaimZ2 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNum+".Z2-ausstehend");
								 for(OfflinePlayer off : Bukkit.getOfflinePlayers()) {
									 for(int i=0; i<MAX_CLAIMS; i++ ) {
										 if(Player.equals(off.getName())) {
											 
											 if(Claim.isInt("BTEClaimSystem."+Player+"."+rejectNum+".Z2-ausstehend") == true) {
												 
											
												 
											 Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".Z2-fertig", ClaimZ2);
											 Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".X2-fertig", ClaimX2);
											 Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".Z1-fertig", ClaimZ1);
											 Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".X1-fertig", ClaimX1);
											 //int Claims = Claim.getInt("BTEClaimSystem."+player.getName()+".Claims");
											// int ClaimX1 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNum+".X1-ausstehend");
											  //  int ClaimZ1 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNum+".Z1-ausstehend");
											//	int ClaimX2 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNum+".X2-ausstehend");
											//	int ClaimZ2 = Claim.getInt("BTEClaimSystem."+Player+"."+rejectNum+".Z2-ausstehend");
											 
											 for(OfflinePlayer p : Bukkit.getOfflinePlayers() ) {
												 for(int i1 = 1; i1 <=MAX_CLAIMS; i1++) {
													
														if(ClaimZ1 >= ClaimZ2 && ClaimX1 >= ClaimX2) {
															for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 13);
																int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 13);
															}
															for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 13);
																
																
																
																int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 13);
															}
															ClaimsUnfinished--;
															 Claim.set("BTEClaimSystem."+Player+".ClaimsUnfinished", ClaimsUnfinished);
													 
													 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".Z2-ausstehend", null);
													 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".X2-ausstehend", null);
													 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".Z1-ausstehend", null);
												 		Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".X1-ausstehend", null);
												 		player.sendMessage(Main.pr + "§aDer Claim von " + Player + " wurde angenommen!");
												 
												 
												 
												 Main.getPlugin().saveConfig();
															return false;
														 
													 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 >= ClaimX2) {
														 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 13);
																int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 13);
															}
															for(int test1 = ClaimX1; test1 >= ClaimX2; test1--) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 13);
																
																
																
																int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 13);
															}
															ClaimsUnfinished--;
															 Claim.set("BTEClaimSystem."+Player+".ClaimsUnfinished", ClaimsUnfinished);
													 
													 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".Z2-ausstehend", null);
													 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".X2-ausstehend", null);
													 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".Z1-ausstehend", null);
												 		Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".X1-ausstehend", null);
												 		player.sendMessage(Main.pr + "§aDer Claim von " + Player + " wurde angenommen!");
												 
												 
												 
												 Main.getPlugin().saveConfig();
															return false;

														
															
															
															

														 
													 }else if(ClaimZ1 >=  ClaimZ2 && ClaimX1 <= ClaimX2) {


														 for(int test1 = ClaimZ1; test1 >= ClaimZ2; test1--) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 13);
																int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 13);
															}
															for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 13);
																
																
																
																int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 13);
															}
															ClaimsUnfinished--;
															 Claim.set("BTEClaimSystem."+Player+".ClaimsUnfinished", ClaimsUnfinished);
													 
													 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".Z2-ausstehend", null);
													 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".X2-ausstehend", null);
													 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".Z1-ausstehend", null);
												 		Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".X1-ausstehend", null);
												 		player.sendMessage(Main.pr + "§aDer Claim von " + Player + " wurde angenommen!");
						 						 
												 
												 
												 Main.getPlugin().saveConfig();
					 										return false;
															
														 
														 
													 }else if(ClaimZ1 <= ClaimZ2 && ClaimX1 <= ClaimX2) {


														 for(int test1 = ClaimZ1; test1 <= ClaimZ2; test1++) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX1, test1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  ClaimX1, highestY,test1);
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 13);
																int highest2Y = Bukkit.getWorld("world").getHighestBlockYAt(ClaimX2, test1)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  ClaimX2, highest2Y,test1);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 13);
															}
															for(int test1 = ClaimX1; test1 <= ClaimX2; test1++) {
																int highestY = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ1)-1;
																Location loctest = new Location(Bukkit.getWorld("world"),  test1, highestY, ClaimZ1);
																
																Bukkit.getWorld("world").getBlockAt(loctest).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest).setData((byte) 13);
																
																
																
																int highestY2 = Bukkit.getWorld("world").getHighestBlockYAt(test1, ClaimZ2)-1;
																Location loctest2 = new Location(Bukkit.getWorld("world"),  test1, highestY2, ClaimZ2);
																Bukkit.getWorld("world").getBlockAt(loctest2).setType(Material.WOOL);
																Bukkit.getWorld("world").getBlockAt(loctest2).setData((byte) 13);
															}
															ClaimsUnfinished--;
															 Claim.set("BTEClaimSystem."+Player+".ClaimsUnfinished", ClaimsUnfinished);
													 
						 							 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".Z2-ausstehend", null);
													 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".X2-ausstehend", null);
													 	Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".Z1-ausstehend", null);
												 		Claim.set("BTEClaimSystem."+Player+"."+rejectNum+".X1-ausstehend", null);
												 		player.sendMessage(Main.pr + "§aDer Claim von " + Player + " wurde angenommen!");
												 
												 
						 						 
												 Main.getPlugin().saveConfig();
															return false;
															}
														 
													 
													 
												 }
												
												 }
											 
								 return false;
											 
											 }
										 }
									 }
								 }
								 player.sendMessage("§4UNERWARTETER FEHLER");
							 }else
								 player.sendMessage(Main.pr + "§cDiese Anfrage konnte nicht gefunden werden!");
							 
							 
							 
							}else
								player.sendMessage(Main.pr + "§cDU hast keine Rechte auf diesen Command!");
					}else
						player.sendMessage(Main.pr + "§cBitte benutze §a/claim help §cfür Hilfe !");
					
					
				}else
					player.sendMessage(Main.pr + "§cBitte benutze §a/claim help §cfür Hilfe !");
			
		}else
			sender.sendMessage(Main.cmd);
		return false;
				}
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		
	        if(args.length == 1){
	            List<String> playerNames = new ArrayList<>();
	           
	                playerNames.add("groups");
	                playerNames.add("finish");
	                playerNames.add("help");
	                playerNames.add("admin");
	                playerNames.add("confirm");
	                playerNames.add("accept");
	                playerNames.add("reject");
	                playerNames.add("delete");
	                playerNames.add("list");
	                
	            
	 
	            return playerNames;
	        }else if(args.length == 2){
	        	if(args[0].equalsIgnoreCase("groups")) {
	            List<String> arguments = new ArrayList<>();
	            
	            arguments.add("add");
	            arguments.add("remove");
	            arguments.add("info");
	 
	            return arguments;
	        }
	        }
	        return null;
	    
	}
	
		}

	


