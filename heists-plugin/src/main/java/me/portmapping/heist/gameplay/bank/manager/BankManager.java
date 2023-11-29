package me.portmapping.heist.gameplay.bank.manager;

import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.bank.build.BankTransactionLog;
import me.portmapping.heist.gameplay.bank.build.BankTransactionType;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.framework.Manager;
import org.bukkit.entity.Player;

import java.time.LocalDateTime;

public class BankManager extends Manager {
    public BankManager(Heists instance) {
        super(instance);
    }

    public void deposit(Player player, int amount){
        Profile profile = getInstance().getPlayerManager().getProfile(player);

        if(profile.getCash()>=amount){

            BankTransactionLog bankTransactionLog = new BankTransactionLog(LocalDateTime.now(),amount,BankTransactionType.DEPOSIT);
            profile.getBankTransactionLogs().add(bankTransactionLog);
            profile.setBankMoney(profile.getBankMoney()+amount);
            profile.setCash(profile.getCash()-amount);
            player.sendMessage(CC.GREEN+"You deposited $"+ amount +" in your bank account.");

        }else{
            player.sendMessage(CC.GREEN+"You don't have enough cash to make this deposit.");
        }
    }

    public void withdraw(Player player, int amount){
        Profile profile = getInstance().getPlayerManager().getProfile(player);

        if(profile.getBankMoney()>=amount){
            BankTransactionLog bankTransactionLog = new BankTransactionLog(LocalDateTime.now(),amount, BankTransactionType.WITHDRAWAL);
            profile.getBankTransactionLogs().add(bankTransactionLog);

            profile.setBankMoney(profile.getBankMoney()-amount);
            profile.setCash(profile.getCash()+amount);
            player.sendMessage(CC.GREEN+"You withdrew $"+ amount +" from your bank account.");
        }else{
            player.sendMessage(CC.GREEN+"You don't have enough balance to make this withdrawal.");
        }
    }
}
