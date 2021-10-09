package com.hackless.randomItemOnDamage;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.lang.Math;

public class Main extends JavaPlugin implements Listener{
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		
		storeItemToArray();
	}
	@Override
	public void onDisable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player corn = (Player)e.getEntity();
			
			corn.getInventory().getStorageContents();
			
			for(ItemStack kill : corn.getInventory().getStorageContents()) {
				/*
				corn.sendMessage(kill.getType()+"");
				corn.sendMessage("---------------");
				*/
				
				if(kill != null) {
					kill.setType((Material)ItemArray.get((int)Math.round(Math.random()*ItemArray.size())));
				}
			}
		}
	}
	
	
	public static void storeItemToArray() {
		for(Object pop : Material.values()) {
			//ItemArray.add(10);
			
			//System.out.println(pop);
			
			ItemArray.add(pop);
			
		}
		System.out.println(ItemArray.size());
	}
	
	public static ArrayList<Object> ItemArray = new ArrayList<Object>();
	
}
