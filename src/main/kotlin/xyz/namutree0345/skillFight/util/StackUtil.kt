package xyz.namutree0345.skillFight.util

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object StackUtil {

    fun getItemStack(material: Material, name: Component, vararg lore: Component) : ItemStack {
        return ItemStack(material).let { stack ->
            stack.itemMeta = stack.itemMeta.let { meta ->
                meta.displayName(name)
                meta.lore(lore.toList())
                meta
            }
            stack
        }
    }

}