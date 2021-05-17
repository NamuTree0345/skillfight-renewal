package xyz.namutree0345.skillFight.util

import org.bukkit.Bukkit
import xyz.namutree0345.skillFight.plugin

object TickUtil {

    fun runTaskBeforeTheTime(runnable: Runnable, repeatWhile: Long, repeatGangyuk: Long) {
        val taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, runnable, 0L, repeatGangyuk)
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, { Bukkit.getScheduler().cancelTask(taskId) }, repeatWhile)
    }

}