package xyz.namutree0345.skillFight

import com.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin
import xyz.namutree0345.skillFight.commands.CommandMap
import xyz.namutree0345.skillFight.commands.CommandSkill
import xyz.namutree0345.skillFight.job.Bower
import xyz.namutree0345.skillFight.job.Job
import xyz.namutree0345.skillFight.job.Sworder

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
        jobs.add(Bower())
        jobs.add(Sworder())
    }

}