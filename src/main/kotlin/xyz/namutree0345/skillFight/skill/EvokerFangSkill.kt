package xyz.namutree0345.skillFight.skill

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Color
import org.bukkit.FireworkEffect
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.EvokerFangs
import org.bukkit.entity.Firework
import org.bukkit.entity.Player
import xyz.namutree0345.skillFight.util.StackUtil
import xyz.namutree0345.skillFight.util.TickUtil

class EvokerFangSkill : Skill() {

    init {
        this.icon = Material.BLAZE_ROD
        this.iconName = "소환사의 이빨"
        this.iconDesc = "소환사의 이빨을 모은 조각이다.."

        this.wand = StackUtil.getItemStack(Material.BLAZE_ROD, Component.text("소환사의 막대기", NamedTextColor.GREEN, TextDecoration.BOLD))
    }

    override fun activate(activatedBy: Player) {
        var i = 0
        TickUtil.runTaskUntilTheTime({
            val fangLoc = activatedBy.location.add(activatedBy.location.direction.multiply(i + 1))
            val evokerFangs = (activatedBy.world.spawnEntity(fangLoc, EntityType.EVOKER_FANGS)) as EvokerFangs
            evokerFangs.owner = activatedBy
            val firework = activatedBy.world.spawnEntity(fangLoc.add(0.0, 1.0, 0.0), EntityType.FIREWORK) as Firework
            val builder = FireworkEffect.builder()
            builder.withTrail().withFlicker().withFade(
                Color.GREEN, Color.WHITE, Color.YELLOW, Color.BLUE,
                Color.FUCHSIA, Color.PURPLE, Color.MAROON, Color.LIME, Color.ORANGE)
                .withColor(Color.YELLOW)
                .with(FireworkEffect.Type.BALL);
            firework.fireworkMeta = firework.fireworkMeta.let {
                it.addEffect(builder.build())
                it.power = 1
                it
            }
            firework.detonate()
            i++
        }, 20, 4)
    }
}