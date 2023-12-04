package me.portmapping.heist.command;

import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.bank.commands.BankCommand;
import me.portmapping.heist.gameplay.crew.command.CrewCommand;
import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.gameplay.guns.command.AmmoCommand;
import me.portmapping.heist.gameplay.guns.command.GunCommand;
import me.portmapping.heist.gameplay.store.command.ShopCommand;
import me.portmapping.heist.gameplay.throwables.builder.Throwable;
import me.portmapping.heist.gameplay.throwables.command.ThrowableCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import revxrsal.commands.autocomplete.SuggestionProviderFactory;
import revxrsal.commands.bukkit.BukkitCommandHandler;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler {
    private final Heists main;
    private final BukkitCommandHandler commandHandler;

    public CommandHandler(Heists main){
        this.main = main;
        commandHandler = BukkitCommandHandler.create(main);
        commandHandler.registerDependency(Heists.class,main);
        //commandHandler.setExceptionHandler(new CommandEx)
        commandHandler.getAutoCompleter().registerSuggestionFactory(0, SuggestionProviderFactory.forType(Player.class,(args,sender,command)->{
            List<String> list = new ArrayList<>();
            for(Player player : main.getServer().getOnlinePlayers()){
                list.add(player.getName());
            }
            return list;
        }));


        this.registerGunAutoCompleter();
        this.registerThrowableAutoCompleter();
        //this.registerStoreAutoCompleter();
        this.register();
    }

    private void registerGunAutoCompleter(){
        List<String> gunsNames = new ArrayList<>();
        for(Gun gun : main.getGunManager().getGuns()){
            gunsNames.add(ChatColor.stripColor(gun.getName()));
        }
        commandHandler.registerValueResolver(Gun.class, context -> main.getGunManager().getGunByName(context.pop()));
        commandHandler.getAutoCompleter().registerSuggestion("gun", gunsNames);
        commandHandler.getAutoCompleter().registerParameterSuggestions(Gun.class, "gun");
    }
    /*private void registerStoreAutoCompleter(){
        List<String> storeTypes = new ArrayList<>();
        for(Gun gun : main.getGunManager().getGuns()){
            storeTypes.add(ChatColor.stripColor(gun.getName()));
        }
        commandHandler.registerValueResolver(StoreType.class, context -> StoreType.valueOf(context.pop()));
        commandHandler.getAutoCompleter().registerSuggestion("storetype", storeTypes);
        commandHandler.getAutoCompleter().registerParameterSuggestions(StoreType.class, "storetype");
    }

     */
    private void registerThrowableAutoCompleter(){
        List<String> throwablesNames = new ArrayList<>();

        for(Throwable throwable : main.getThrowableManager().getThrowables()){
            throwablesNames.add(ChatColor.stripColor(throwable.getName()));

        }
        commandHandler.registerValueResolver(Throwable.class, context -> main.getThrowableManager().getThrowableByName(context.pop()));
        commandHandler.getAutoCompleter().registerSuggestion("throwable", throwablesNames);
        commandHandler.getAutoCompleter().registerParameterSuggestions(Throwable.class, "throwable");
    }
    private void register(){
        commandHandler.register(new GunCommand());
        commandHandler.register(new AmmoCommand());
        commandHandler.register(new ThrowableCommand());
        commandHandler.register(new CrewCommand());
        commandHandler.register(new BankCommand());
        commandHandler.register(new ShopCommand());
    }
}

