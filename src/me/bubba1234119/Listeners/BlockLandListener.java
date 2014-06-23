package me.bubba1234119.Listeners;

import me.bubba1234119.EnderDragonBlocks;

import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class BlockLandListener implements Listener{
	
	EnderDragonBlocks plugin;
	public BlockLandListener(EnderDragonBlocks plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onLand(EntityChangeBlockEvent e)
	{
		if(e.getEntity() instanceof FallingBlock)
		{
			if(plugin.falling.contains((FallingBlock)e.getEntity()))
			{
				plugin.falling.remove((FallingBlock)e.getEntity());
				e.setCancelled(true);
			}
			else if(plugin.override)
			{
				e.setCancelled(true);
			}
		}
	}

}
