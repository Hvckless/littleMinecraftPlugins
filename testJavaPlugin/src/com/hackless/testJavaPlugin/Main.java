package com.hackless.testJavaPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.entity.Player;
import org.bukkit.World;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

import org.bukkit.Bukkit;

import org.bukkit.Material;

import org.bukkit.plugin.Plugin;

import java.lang.Math;
import java.lang.Integer;

public class Main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	@Override
	public void onDisable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		Location thisPlayer = e.getPlayer().getLocation();
		Block b = p.getWorld().getBlockAt(Integer.parseInt(Math.round(thisPlayer.getX()-0.5)+""), Integer.parseInt(Math.round(thisPlayer.getY())+""), Integer.parseInt(Math.round(thisPlayer.getZ()-0.5)+""));
		Block b2 = p.getWorld().getBlockAt(Integer.parseInt(Math.round(thisPlayer.getX()-0.5)+""), Integer.parseInt(Math.round(thisPlayer.getY()-1)+""), Integer.parseInt(Math.round(thisPlayer.getZ()-0.5)+""));
		
		if(b.getType() == Material.IRON_TRAPDOOR) {
			if(b2.getType() == Material.BLACKSTONE) {
				p.setVelocity(new Vector(p.getLocation().getDirection().getX(), 1, p.getLocation().getDirection().getZ()));
				p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_NODAMAGE, SoundCategory.MASTER, 10.0f, 0.1f);
			}
		}
		
		 
	}
	
}
