package me.Albert.MoreGolems;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		org.bukkit.Bukkit.getConsoleSender().sendMessage("§a[MoreGolems] Loaded");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);		
		 new Metrics(this);	
	};
	
	@EventHandler
	public void GolemListner(BlockPlaceEvent e) {
		Material pumpkin = e.getBlock().getType();
		if (pumpkin == Material.PUMPKIN || pumpkin == Material.JACK_O_LANTERN) {
			String world = e.getBlock().getWorld().getName();
			double x = e.getBlock().getLocation().getX();
			double y = e.getBlock().getLocation().getY();
			double z = e.getBlock().getLocation().getZ();
			if (checkblock(e.getBlock(),Material.DIAMOND_BLOCK)) {
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();            		
        		Bukkit.dispatchCommand(console, "mm m s diamond_golem 1 " +
				world+","+x+","+y+","+z);   
			}
			if (checkblock(e.getBlock(),Material.GOLD_BLOCK)) {
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();            		
        		Bukkit.dispatchCommand(console, "mm m s gold_golem 1 " +
				world+","+x+","+y+","+z);   
			}
			if (checkblock(e.getBlock(),Material.OBSIDIAN)) {
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();            		
        		Bukkit.dispatchCommand(console, "mm m s obsidian_golem 1 " +
				world+","+x+","+y+","+z);   
			}
			if (checkblock(e.getBlock(),Material.EMERALD_BLOCK)) {
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();            		
        		Bukkit.dispatchCommand(console, "mm m s emerald_golem 1 " +
				world+","+x+","+y+","+z);   
			}
			
		}
		
	}
public static boolean checkblock(Block b ,Material m) {
	Block b1 = b.getRelative(BlockFace.DOWN);
	Block b2 = b.getRelative(0,0,-1);
	Block b3 = b.getRelative(0,0,1);
	Block b4 = b.getRelative(0,-1,-1);
	Block b5 = b.getRelative(0,-1,1);
	Block b6 = b.getRelative(0,-2,-1);
	Block b7 = b.getRelative(0,-2,0);
	Block b8 = b.getRelative(0,-2,1);
	Block b9 = b.getRelative(-1,0,0);
	Block b10 = b.getRelative(1,0,0);
	Block b11 = b.getRelative(-1,-1,0);
	Block b12 = b.getRelative(1,-1,0);
	Block b13 = b.getRelative(1,-2,0);
	Block b14 = b.getRelative(-1,-2,0);
	if (b2.getType() == Material.AIR && b3.getType() == Material.AIR
			&& b6.getType() == Material.AIR && b8.getType() == Material.AIR) {
		if (b1.getType() == m && b4.getType() == m && b5.getType() == m
				&& b7.getType() == m) {
			b.setType(Material.AIR);
			b1.setType(Material.AIR);
			b4.setType(Material.AIR);
			b5.setType(Material.AIR);
			b7.setType(Material.AIR);
			return true;
		}
		
	}
	if (b9.getType() == Material.AIR && b10.getType() == Material.AIR
			&& b13.getType() == Material.AIR && b14.getType() == Material.AIR) {
		if (b11.getType() == m && b7.getType() == m && b12.getType() == m
				&& b1.getType() == m) {
			b.setType(Material.AIR);
			b1.setType(Material.AIR);
			b11.setType(Material.AIR);
			b12.setType(Material.AIR);
			b7.setType(Material.AIR);
			return true;
		}
		
	}
	return false;
}
}
