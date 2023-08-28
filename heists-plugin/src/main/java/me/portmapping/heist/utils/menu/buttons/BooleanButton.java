package me.portmapping.heist.utils.menu.buttons;

import lombok.AllArgsConstructor;
import me.portmapping.heist.utils.file.Callback;
import me.portmapping.heist.utils.menu.Button;
import me.portmapping.heist.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

@AllArgsConstructor
public class BooleanButton extends Button {

    private boolean confirm;
    private Callback<Boolean> callback;
    private boolean closeAfterResponse;

    @Override
    public String getName(Player p0) {
        return null;
    }

    @Override
    public List<String> getDescription(Player p0) {
        return null;
    }

    @Override
    public Material getMaterial(Player p0) {
        return null;
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        ItemStack itemStack = new ItemStack(Material.LEGACY_WOOL, 1, this.confirm ? ((byte) 5) : ((byte) 14));
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(this.confirm ? "§aConfirm" : "§cCancel");
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType) {
        if (this.closeAfterResponse) {
            Menu menu = Menu.currentlyOpenedMenus.get(player.getUniqueId());

            if (menu != null) {
                menu.setClosedByMenu(true);
            }

            player.closeInventory();
        }

        if (this.confirm) {
            //CompatibleSound.VILLAGER_YES.play(player);
        } else {
            //CompatibleSound.DIG_GRAVEL.play(player);
        }

        this.callback.callback(this.confirm);
    }
}