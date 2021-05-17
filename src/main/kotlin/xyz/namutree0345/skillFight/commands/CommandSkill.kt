package xyz.namutree0345.skillFight.commands

import com.github.monun.kommand.KommandDispatcherBuilder
import com.github.monun.kommand.argument.integer
import org.bukkit.entity.Player
import xyz.namutree0345.skillFight.gui.SkillGui
import xyz.namutree0345.skillFight.skill.Skill

var skillMap: HashMap<Player, Skill> = HashMap()

object CommandSkill {

    internal fun register(builder: KommandDispatcherBuilder) {
        builder.register("cc") {
            require { this is Player }
            executes { context ->
                SkillGui.showSkillPage(context.sender as Player, 0)
            }
            then("page" to integer(1)) {
                executes { context ->
                    SkillGui.showSkillPage(context.sender as Player, context.parseArgument<Int>("page").minus(1))
                }
            }
        }
    }

}