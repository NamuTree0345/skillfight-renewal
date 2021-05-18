package xyz.namutree0345.skillFight.listener

import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import xyz.namutree0345.skillFight.SkillFightPlugin

class NinjaSpecial : Listener {

    @EventHandler
    fun fallDamage(event: EntityDamageEvent) {
        if(event.entityType == EntityType.PLAYER) {
            if(SkillFightPlugin.selectedJobs.containsKey((event.entity as Player).uniqueId)) {
                if(SkillFightPlugin.selectedJobs[(event.entity as Player).uniqueId]?.name == "닌자") {
                    if(event.cause == EntityDamageEvent.DamageCause.FALL) {
                        event.damage /= 2
                    }
                }
            }
        }
    }

}