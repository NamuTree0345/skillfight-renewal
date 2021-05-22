package xyz.namutree0345.skillFight

import com.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin
import xyz.namutree0345.skillFight.commands.CommandMap
import xyz.namutree0345.skillFight.commands.CommandSkill
import xyz.namutree0345.skillFight.commands.CommandStart
import xyz.namutree0345.skillFight.job.*
import xyz.namutree0345.skillFight.listener.JobSelectorFeature
import xyz.namutree0345.skillFight.listener.NinjaSpecial
import xyz.namutree0345.skillFight.listener.SkillBaldong
import java.util.*
import kotlin.collections.HashMap

val plugin = JavaPlugin.getPlugin(SkillFightPlugin::class.java)

class SkillFightPlugin : JavaPlugin() {

    companion object {
        val selectedJobs = HashMap<UUID, Job>()
        val jobs = arrayListOf<Job>()
    }

    override fun onEnable() {
        kommand {
            CommandMap.register(this)
            CommandSkill.register(this)
            CommandStart.register(this)
        }
        server.pluginManager.apply {
            this.registerEvents(SkillBaldong(), this@SkillFightPlugin)
            this.registerEvents(JobSelectorFeature(), this@SkillFightPlugin)
            this.registerEvents(NinjaSpecial(), this@SkillFightPlugin)
        }
        jobs.add(Bower())
        jobs.add(Sworder())
        jobs.add(Healer())
        jobs.add(Ninja())
        jobs.add(Magicer())
    }

}