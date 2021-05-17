package xyz.namutree0345.skillFight.job

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import xyz.namutree0345.skillFight.skill.HealSkill
import xyz.namutree0345.skillFight.skill.SwordSkill
import xyz.namutree0345.skillFight.util.StackUtil

class Healer : Job() {

    init {
        this.name = "힐러"
        this.desc = "회복 장인"
        this.icon = Material.DIAMOND_SWORD
        this.items.add(StackUtil.getItemStack(Material.SPLASH_POTION, Component.text("???", NamedTextColor.DARK_PURPLE)).let {
            it.itemMeta = (it.itemMeta as PotionMeta).let { im ->
                im.addCustomEffect(PotionEffect(PotionEffectType.REGENERATION, 1200, 3), true)
                im
            }
            it
        })
        this.items.add(StackUtil.getItemStack(Material.LINGERING_POTION, Component.text("????", NamedTextColor.DARK_PURPLE)).let {
            it.itemMeta = (it.itemMeta as PotionMeta).let { im ->
                im.addCustomEffect(PotionEffect(PotionEffectType.REGENERATION, 600, 3), true)
                im
            }
            it
        })
        this.skills.add(HealSkill())
    }

}