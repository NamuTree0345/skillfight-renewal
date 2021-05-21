package xyz.namutree0345.skillFight.skill

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.title.Title
import org.bukkit.Color
import org.bukkit.FireworkEffect
import org.bukkit.Material
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Firework
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import xyz.namutree0345.skillFight.util.StackUtil
import xyz.namutree0345.skillFight.util.TickUtil

class HealSkill : Skill() {

    init {
        this.icon = Material.HEART_OF_THE_SEA
        this.iconName = "우리 모두 회복"
        this.iconDesc = "반지름 50블럭 이내의 사람들 회복"

        this.wand = StackUtil.getItemStack(Material.HEART_OF_THE_SEA, Component.text("회복회복", NamedTextColor.GREEN, TextDecoration.BOLD))
    }

    override fun activate(activatedBy: Player) {
        println("ac")
        healFun(activatedBy)
        for (e in activatedBy.getNearbyEntities(50.0, 50.0, 50.0)) {
            if(e is Player) {
                healFun(e)
            }
        }
    }

    private fun healFun(e: Entity) {
        val firework = e.world.spawnEntity(e.location, EntityType.FIREWORK) as Firework
        val builder = FireworkEffect.builder()
        builder.withTrail().withFlicker().withFade(
            Color.GREEN, Color.WHITE, Color.YELLOW, Color.BLUE,
            Color.FUCHSIA, Color.PURPLE, Color.MAROON, Color.LIME, Color.ORANGE)
            .withColor(Color.RED)
            .with(FireworkEffect.Type.STAR);
        firework.fireworkMeta = firework.fireworkMeta.let {
            it.addEffect(builder.build())
            it.power = 1
            it
        }
        firework.detonate()
        e.showTitle(
            Title.title(
                Component.text("회복!", NamedTextColor.YELLOW),
                Component.text("당신은 힐러에 의해 ", NamedTextColor.GREEN)
                    .append(Component.text("힐 ", NamedTextColor.DARK_RED, TextDecoration.BOLD))
                    .append(Component.text("당했습니다!", NamedTextColor.GREEN))
            )
        )
        TickUtil.runTaskUntilTheTime({
            (e as Player).addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 20, 2))
        }, 400, 20)
    }
}