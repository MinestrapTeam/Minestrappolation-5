package minestrapp;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import werty.guidance.util.PlayerHelper;

public class EventManager {
	
	@SubscribeEvent
	public void playerJoined(EntityJoinWorldEvent e){
		if(e.getEntity() instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)e.getEntity();
			if(!PlayerHelper.getPersistedPlayerTag(player).getBoolean(NBTTags.GUIDE_GIVEN)){
				player.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.minechiridion));
				PlayerHelper.getPersistedPlayerTag(player).setBoolean(NBTTags.GUIDE_GIVEN, true);
			}
		}
	}
}
