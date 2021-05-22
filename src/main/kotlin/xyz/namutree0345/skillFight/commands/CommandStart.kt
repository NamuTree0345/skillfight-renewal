package xyz.namutree0345.skillFight.commands

import com.github.monun.kommand.KommandDispatcherBuilder
import com.github.monun.kommand.argument.integer
import com.github.monun.kommand.argument.string
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.title.Title
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import xyz.namutree0345.skillFight.SkillFightPlugin
import xyz.namutree0345.skillFight.gui.SkillGui
import xyz.namutree0345.skillFight.util.StackUtil
import xyz.namutree0345.skillFight.util.TickUtil
import java.time.Duration

object CommandStart {
    internal fun register(builder: KommandDispatcherBuilder) {
        builder.register("start") {
            require { this is Player && this.isOp }
            executes {
                var time = 3
                TickUtil.runTaskUntilTheTime({
                    Bukkit.getOnlinePlayers().forEach {
                        it.showTitle(Title.title(
                            Component.text("$time", (if(time == 3) NamedTextColor.GREEN else if(time == 2) NamedTextColor.YELLOW else NamedTextColor.RED)),
                            Component.empty(),
                            Title.Times.of(
                                Duration.ZERO,
                                Duration.ofMillis(1000),
                                Duration.ZERO
                            )
                        ))
                    }
                    time--
                }, 60, 20)
                TickUtil.runTaskAfterTheTime({
                    Bukkit.getOnlinePlayers().forEach {
                        it.showTitle(Title.title(
                            Component.text("Loading...", NamedTextColor.WHITE),
                            Component.empty(),
                            Title.Times.of(
                                Duration.ZERO,
                                Duration.ofMillis(1000),
                                Duration.ZERO
                            )
                        ))
                    }
                    val loc = ((it.sender as Player).world).locateNearestStructure((it.sender as Player).location, map, 1000, true)
                    Bukkit.getOnlinePlayers().forEach { plr ->
                        if(SkillFightPlugin.selectedJobs.containsKey(plr.uniqueId)) {
                            plr.inventory.helmet = SkillFightPlugin.selectedJobs[plr.uniqueId]?.helmetItem
                            plr.inventory.chestplate = SkillFightPlugin.selectedJobs[plr.uniqueId]?.chestPlateItem
                            plr.inventory.leggings = SkillFightPlugin.selectedJobs[plr.uniqueId]?.leggingsItem
                            plr.inventory.boots = SkillFightPlugin.selectedJobs[plr.uniqueId]?.bootsItem
                            SkillFightPlugin.selectedJobs[plr.uniqueId]?.items?.forEach { item ->
                                plr.inventory.addItem(item)
                            }
                            SkillFightPlugin.selectedJobs[plr.uniqueId]?.skills?.forEach { skill ->
                                plr.inventory.addItem(skill.wand)
                            }
                            plr.inventory.setItemInOffHand(SkillFightPlugin.selectedJobs[plr.uniqueId]?.offhandItem)
                            plr.addPotionEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 255))
                            plr.teleport(loc?.add(0.0, 100.0, 0.0)!!)
                        }
                    }
                }, 60)
            }
        }
    }
}