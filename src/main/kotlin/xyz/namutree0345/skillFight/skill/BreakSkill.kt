package xyz.namutree0345.skillFight.skill

import com.destroystokyo.paper.block.TargetBlockInfo
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import xyz.namutree0345.skillFight.util.StackUtil

class BreakSkill : Skill() {

    init {
        this.icon = Material.STICK
        this.iconName = "장풍"
        this.iconDesc = "장풍(?)"

        this.wand = StackUtil.getItemStack(Material.STICK, Component.text("흐어업", NamedTextColor.GREEN, TextDecoration.BOLD))
    }

    override fun activate(activatedBy: Player) {
        val base = activatedBy.getTargetBlock(10, TargetBlockInfo.FluidMode.NEVER)?.also {
            //it.breakNaturally()
            it.breakNaturally(ItemStack(Material.STICK), true)
        }
        activatedBy.world.spawnParticle(Particle.EXPLOSION_NORMAL, base?.location!!, 1)
    }
}