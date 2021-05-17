package xyz.namutree0345.skillFight.skill

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.entity.Player
import xyz.namutree0345.skillFight.util.StackUtil

abstract class Skill {

    var wand = StackUtil.getItemStack(Material.STICK, Component.text("unused wand"))

    var icon = Material.STICK
    var iconName = "unnamed"
    var iconDesc = "unnamed"

    val maxCooltime = 20

    private var cooltime = 0

    abstract fun activate(activatedBy: Player)

}