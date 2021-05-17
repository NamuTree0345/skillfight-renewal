package xyz.namutree0345.skillFight.skill

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import xyz.namutree0345.skillFight.util.StackUtil
import xyz.namutree0345.skillFight.util.TickUtil

class MassArrowSkill : Skill() {

    init {
        this.icon = Material.ARROW
        this.iconName = "화살 돌격!"
        this.iconDesc = "겁나 많은 화살로 적에게 돌격합니다"

        this.wand = StackUtil.getItemStack(Material.ARROW, Component.text("돌격의 화살", NamedTextColor.GREEN, TextDecoration.BOLD))
    }

    override fun activate(activatedBy: Player) {
        TickUtil.runTaskUntilTheTime({
            val arrow = activatedBy.launchProjectile(Arrow::class.java)
            arrow.isGlowing = true
            arrow.velocity = activatedBy.location.direction.multiply(5)
            arrow.addScoreboardTag(activatedBy.uniqueId.toString() + "-arrow-skill");
        }, 60L, 1L)
    }
}