package me.bubba1234119.Listeners;

import java.util.List;

import me.bubba1234119.EnderDragonBlocks;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

public class ExplosionListener implements Listener {

	EnderDragonBlocks plugin;
	public ExplosionListener(EnderDragonBlocks plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void entityExplosion(EntityExplodeEvent e)
	{
		
		if(e.getEntityType() == EntityType.ENDER_DRAGON)
		{	
			if(!e.isCancelled())
			{
			World w = e.getLocation().getWorld();
			List<Block> blocks = e.blockList();
			for(Block block : blocks)
			{
				@SuppressWarnings("deprecation")
				FallingBlock falling = w.spawnFallingBlock(block.getLocation(), block.getType(), block.getData());
			    float x = (float) -1 + (float) (Math.random() * ((2 - -2) + 1));
		        float y = (float) -5 + (float)(Math.random() * ((6 - -6) + 1));
		        float z = (float) -0.3 + (float)(Math.random() * ((0.4 - -0.4) + 1));
		        falling.setVelocity(new Vector(x,y,z));
		        if(plugin.destroy)
				plugin.falling.add(falling);
			}
		}
	}
  }
}
