package xyz.namutree0345.skillFight.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import xyz.namutree0345.skillFight.SkillFightPlugin

class SkillBaldong : Listener {

    @EventHandler
    fun rightClick(event: PlayerInteractEvent) {
        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
            for (job in SkillFightPlugin.jobs) {
                for (sk in job.skills) {
                    if (event.player.inventory.itemInMainHand.displayName() == sk.wand.displayName()) {
                        sk.activate(event.player)
                        return
                    }
                }
            }
        }
    }
}