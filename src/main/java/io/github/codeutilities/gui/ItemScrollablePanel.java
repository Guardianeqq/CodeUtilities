package io.github.codeutilities.gui;

import io.github.cottonmc.cotton.gui.widget.*;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemScrollablePanel extends WScrollPanel {

    private final WGridPanel itemPanel = (WGridPanel) this.children.get(0);

    public ItemScrollablePanel(List<ItemStack> items) {
        super(new WGridPanel(1));

        setItems(items);
    }

    public void setItems(List<ItemStack> items) {
        this.children.clear();
        itemPanel.setSize(0, 0);
        horizontalScrollBar.setValue(0);

        int renderIndex = 0;
        for (ItemStack item : items) {
            ClickableGiveItem i = new ClickableGiveItem(item);
            itemPanel.add(i, (int) (renderIndex % 14 * 17.8), renderIndex / 14 * 18, 17, 18);
            renderIndex++;
        }
        layout();
    }
}