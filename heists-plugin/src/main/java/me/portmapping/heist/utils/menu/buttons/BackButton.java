package me.portmapping.heist.utils.menu.buttons;

import lombok.AllArgsConstructor;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import me.portmapping.heist.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class BackButton extends Button {

    private Menu back;

    @Override
    public ItemStack getButtonItem(final Player player) {
        return new ItemBuilder(Material.INK_SAC).setDurability(1).setName(CC.t("&cGo Back")).toItemStack();
    }


    @Override
    public void clicked(final Player player, final int i, final ClickType clickType) {
        this.back.openMenu(player);
    }
}
