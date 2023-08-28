package me.portmapping.heist.gameplay.throwables.listener;

import com.cryptomorin.xseries.XSound;
import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.throwables.builder.Throwable;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class ThrowableListener implements Listener {
    private final Heists instance = Heists.getInstance();


    @EventHandler
    private void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (player == null) {
            return;
        }
        if (item == null || item.getType() == Material.AIR) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {

            return;
        }

        if (instance.getThrowableManager().getThrowableByItem
                (item) == null) {

            return;
        }

        Throwable throwable = instance.getThrowableManager().getThrowableByItem(item);
        event.setCancelled(true);

        throwable.playerThrow(player);


    }

    @EventHandler
    private void onHit(ProjectileHitEvent event){
        Location location = null;
        if(!(event.getEntity() instanceof Snowball)){
            return;
        }
        if(event.getHitBlock() != null){
            location = event.getHitBlock().getLocation();
        }
        if(event.getHitEntity() != null){
            location = event.getHitEntity().getLocation();
        }
        Entity entity = event.getEntity();





        for(Throwable throwables:instance.getThrowableManager().getThrowables()){
            if(entity.hasMetadata(throwables.getName())){

                Item item = location.getWorld().dropItem(location,throwables.toItemStack());
                item.setCustomName(throwables.getName());
                item.setCustomNameVisible(true);
                item.setPickupDelay(Integer.MAX_VALUE);
                item.setVelocity(new Vector(0,0,0));
                item.setFireTicks(0);
                item.setVisualFire(false);
                this.playTickingSound(item,throwables);

                Bukkit.getScheduler().runTaskLater(Heists.getInstance(),()->{
                    throwables.explode(item.getLocation());
                    item.remove();
                },throwables.getTimeToDetonate()*20);
                break;
            }
        }
    }


    private void playTickingSound(Item item, Throwable throwable){
        final float[] pitch = {1F};
        final int[] count = {0};
        BukkitTask soundTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (!item.isDead()) {
                    throwable.onTick(item.getLocation());
                   for(int i = 0; i< count[0]; i++){
                       Bukkit.getScheduler().runTaskLater(Heists.getInstance(),()->{
                           item.getWorld().playSound(item.getLocation(), XSound.BLOCK_NOTE_BLOCK_HAT.parseSound(), 1F ,pitch[0]);
                       },10);
                   }
                   count[0] = count[0] +1;
                   pitch[0] +=0.09;
                } else {
                    // Cancel the task when the item entity is dead
                    cancel();
                }
            }
        }.runTaskTimer(Heists.getInstance(), 0, 10);
    }
}
