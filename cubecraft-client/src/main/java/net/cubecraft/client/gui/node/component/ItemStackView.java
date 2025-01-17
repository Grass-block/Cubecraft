package net.cubecraft.client.gui.node.component;

import me.gb2022.commons.registry.TypeItem;
import net.cubecraft.client.gui.node.Node;
import net.cubecraft.client.render.chunk.RenderBatch;
import net.cubecraft.client.render.item.ItemRenderer;
import net.cubecraft.world.item.ItemStack;
import org.lwjgl.opengl.GL11;

@TypeItem("item_stack")
public final class ItemStackView extends Node {
    private final int size;
    private RenderBatch renderBatch;
    private ItemStack item;

    public ItemStackView(int size) {
        this.size = size;
    }

    public void setItem(ItemStack item) {
        this.item = item;
        this.renderBatch = ItemRenderer.getModel(item);
    }

    public ItemStack getItem() {
        return item;
    }

    @Override
    public void render(float interpolationTime) {
        var x = this.layout.getAbsoluteX();
        var y = this.layout.getAbsoluteY();
        var size = this.size;

        if (this.renderBatch == null) {
            return;
        }

        GL11.glPushMatrix();
        GL11.glTranslatef(x, y + size * 1.32f, 0.0F);
        GL11.glScalef(size, size, size);

        this.renderBatch.call();

        GL11.glPopMatrix();
    }
}
