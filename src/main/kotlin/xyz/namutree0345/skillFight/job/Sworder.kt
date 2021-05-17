package xyz.namutree0345.skillFight.job

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import xyz.namutree0345.skillFight.util.StackUtil

class Sworder : Job() {

    init {
        this.name = "검수"
        this.desc = "검을 잘 다룬다!"
        this.icon = Material.DIAMOND_SWORD
        this.offhandItem = StackUtil.getItemStack(Material.SHIELD, Component.text("그 시절 방패", NamedTextColor.DARK_RED, TextDecoration.BOLD))
        this.items.add(StackUtil.getItemStack(Material.NETHERITE_SWORD, Component.text("숙련자의 검", NamedTextColor.WHITE), Component.text("뭔가 많이 오래되어 보이는 검")).let {
            it.addEnchantment(Enchantment.KNOCKBACK, 2)
            it.addEnchantment(Enchantment.DAMAGE_ALL, 5)
            it.addEnchantment(Enchantment.FIRE_ASPECT, 2)
            it.itemMeta = it.itemMeta.let { im ->
                im.isUnbreakable = true
                im
            }
            it
        })
    }

}