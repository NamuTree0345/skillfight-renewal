package xyz.namutree0345.skillFight

import com.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin
import xyz.namutree0345.skillFight.commands.CommandMap
import xyz.namutree0345.skillFight.commands.CommandSkill
import xyz.namutree0345.skillFight.job.Bower
import xyz.namutree0345.skillFight.job.Healer
import xyz.namutree0345.skillFight.job.Job
import xyz.namutree0345.skillFight.job.Sworder
import xyz.namutree0345.skillFight.listener.SkillBaldong

val plugin = JavaPlugin.getPlugin(SkillFightPlugin::class.java)

class SkillFightPlugin : JavaPlugin() {

    companion object {
        val jobs = arrayListOf<Job>()
    }

    override fun onEnable() {
        kommand {
            CommandMap.register(this)
            CommandSkill.register(this)
        }
        server.pluginManager.apply {
            this.registerEvents(SkillBaldong(), this@SkillFightPlugin)
        }
        jobs.add(Bower())
        jobs.add(Sworder())
        jobs.add(Healer())
    }

}