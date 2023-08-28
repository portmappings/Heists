/*    */ package me.portmapping.heist.utils.tasks;
/*    */
/*    */
import me.portmapping.heist.Heists;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

/*    */ 
/*    */ public class Tasks {
/*    */   public static void run(Heists plugin, Callable callable) {
/*  9 */     if (plugin.isDisabling()) {
/* 10 */       callable.call();
/*    */       return;
/*    */     } 
/* 13 */     plugin.getServer().getScheduler().runTask((Plugin)plugin, callable::call);
/*    */   }
/*    */   
/*    */   public static void runAsync(Heists plugin, Callable callable) {
/* 17 */     if (plugin.isDisabling()) {
/* 18 */       callable.call();
/*    */       return;
/*    */     } 
/* 21 */     plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, callable::call);
/*    */   }
/*    */   
/*    */   public static void runLater(Heists plugin, Callable callable, long delay) {
/* 25 */     if (plugin.isDisabling()) {
/* 26 */       callable.call();
/*    */       return;
/*    */     } 
/* 29 */     plugin.getServer().getScheduler().runTaskLater((Plugin)plugin, callable::call, delay);
/*    */   }
/*    */   
/*    */   public static BukkitTask runAsyncLater(Heists plugin, Callable callable, long delay) {
/* 33 */     if (plugin.isDisabling()) {
/* 34 */       callable.call();
/* 35 */       return null;
/*    */     } 
/* 37 */     return plugin.getServer().getScheduler().runTaskLaterAsynchronously((Plugin)plugin, callable::call, delay);
/*    */   }
/*    */   
/*    */   public static void runTimer(Heists plugin, Callable callable, long delay, long interval) {
/* 41 */     if (plugin.isDisabling()) {
/* 42 */       callable.call();
/*    */       return;
/*    */     } 
/* 45 */     plugin.getServer().getScheduler().runTaskTimer((Plugin)plugin, callable::call, delay, interval);
/*    */   }
/*    */   
/*    */   public static void runAsyncTimer(Heists plugin, Callable callable, long delay, long interval) {
/* 49 */     if (plugin.isDisabling()) {
/* 50 */       callable.call();
/*    */       return;
/*    */     } 
/* 53 */     plugin.getServer().getScheduler().runTaskTimerAsynchronously((Plugin)plugin, callable::call, delay, interval);
/*    */   }
/*    */   
/*    */   public static interface Callable {
/*    */     void call();
/*    */   }
/*    */ }


/* Location:              /home/hugo/Downloads/Main-1.0-SNAPSHOT.jar!/com/kiopvp/core/utilities/general/Tasks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */