package xyz.namutree0345.skillFight.skill

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.entity.Player
import org.bukkit.util.Vector
import xyz.namutree0345.skillFight.util.StackUtil

class DashSkill : Skill() {

    init {
        this.icon = Material.STICK
        this.iconName = "닌자의 발걸음"
        this.iconDesc = "우리들의.. 발걸음?!"

        this.wand = StackUtil.getItemStack(Material.STICK, Component.text("슥삭", NamedTextColor.GREEN, TextDecoration.BOLD))
    }

    override fun activate(activatedBy: Player) {
        val loc = activatedBy.location
        activatedBy.velocity = activatedBy.velocity.add(activatedBy.location.direction.multiply(5))
        for(i in 0..5) {
            for(j in 0..10) {
                activatedBy.world.run {
                    spawnParticle(Particle.EXPLOSION_NORMAL, activatedBy.location.add(activatedBy.location.direction.add(Vector(0, j, 0)).multiply(i)), 1)
                }
            }
        }
    }
}