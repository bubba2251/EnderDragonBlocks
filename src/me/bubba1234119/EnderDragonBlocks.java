package me.bubba1234119;

import java.io.File;
import java.util.ArrayList;

import me.bubba1234119.Listeners.BlockLandListener;
import me.bubba1234119.Listeners.ExplosionListener;

import org.bukkit.Bukkit;
import org.bukkit.entity.FallingBlock;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderDragonBlocks extends JavaPlugin{

	public ArrayList<FallingBlock>falling = new ArrayList<FallingBlock>();
	public File configFile = new File(this.getDataFolder().getPath(),"config.yml");
	public boolean destroy;
	public boolean override;
	public void onEnable()
	{
		PluginManager pm = Bukkit.getServer().getPluginManager();
		this.destroy = this.getConfig().getBoolean("destroyOnLand");
		this.override = this.getConfig().getBoolean("override");
		pm.registerEvents(new ExplosionListener(this), this);
		if(destroy)
		pm.registerEvents(new BlockLandListener(this),this);
		if(!configFile.exists())
		this.saveDefaultConfig();
		else
		{
		this.reloadConfig();
		}
	}
	public void onDisable()
	{
		if(configFile.exists())
		this.reloadConfig();
	}
	
	
}
