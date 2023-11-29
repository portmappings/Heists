package me.portmapping.heist.gameplay.bank.build;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
public class BankTransactionLog {
    private final UUID uuid = UUID.randomUUID();
    private final LocalDateTime date;
    private final int amount;
    private final BankTransactionType transactionType;

}
