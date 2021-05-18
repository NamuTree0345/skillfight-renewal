package xyz.namutree0345.skillFight.listener

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import xyz.namutree0345.skillFight.SkillFightPlugin
import xyz.namutree0345.skillFight.job.Job

class JobSelectorFeature : Listener {

    @EventHandler
    fun selectJob(event: InventoryClickEvent) {
        if(event.view.title() == Component.text("직업 선택", NamedTextColor.GREEN, TextDecoration.BOLD)) {
            if(event.currentItem != null) {
                event.isCancelled = true
                var selectedJob: Job? = null
                for(job in SkillFightPlugin.jobs) {
                    if(job.icon == event.currentItem?.type) {
                        selectedJob = job
                        break;
                    }
                }
                if(selectedJob != null) {
                    SkillFightPlugin.selectedJobs[event.view.player.uniqueId] = selectedJob!!
                    event.view.close()
                    event.view.player.sendMessage(Component.text("직업 선택 완료!", NamedTextColor.GREEN))
                }
            }
        }
    }

}