package xyz.namutree0345.skillFight.job

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import xyz.namutree0345.skillFight.skill.MassArrowSkill
import xyz.namutree0345.skillFight.util.StackUtil

class Bower : Job() {

    init {
        this.name = "궁수"
        this.desc = "활의 달인."
        this.icon = Material.BOW
        this.skills.add(MassArrowSkill())
        this.items.add(StackUtil.getItemStack(Material.BOW, Component.text("숙련자의 활", NamedTextColor.WHITE), Component.text("아주 딱딱하고 무거운 활이다.")).let {
            it.addEnchantment(Enchantment.ARROW_INFINITE, 1)
            it.itemMeta = it.itemMeta.let { im ->
                im.isUnbreakable = true
                im
            }
            it
        })
        this.items.add(ItemStack(Material.ARROW))
    }

}