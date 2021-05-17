package xyz.namutree0345.skillFight.commands

import com.github.monun.kommand.KommandDispatcherBuilder
import com.github.monun.kommand.argument.integer
import com.github.monun.kommand.argument.string
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.entity.Player
import xyz.namutree0345.skillFight.gui.SkillGui
import xyz.namutree0345.skillFight.skill.Skill
import xyz.namutree0345.skillFight.util.StackUtil

var skillMap: HashMap<Player, Skill> = HashMap()

object CommandSkill {

    internal fun register(builder: KommandDispatcherBuilder) {
        builder.register("cc") {
            require { this is Player }
            then("select") {
                executes { context ->
                    SkillGui.showSkillPage(context.sender as Player, 0)
                }
                then("page" to integer(1)) {
                    executes { context ->
                        SkillGui.showSkillPage(context.sender as Player, context.parseArgument<Int>("page").minus(1))
                    }
                }
            }
            then("otherarg" to string("wand")) {
                then("name" to string(), "material" to string()) {
                    require { this is Player && this.isOp }
                    executes {
                        (it.sender as Player).inventory.addItem(
                            StackUtil.getItemStack(
                                Material.getMaterial(
                                    it.parseArgument<String>(
                                        "material"
                                    )
                                )!!,
                                Component.text(it.parseArgument<String>("name").replace("_", " "), NamedTextColor.GREEN, TextDecoration.BOLD)
                            )
                        )
                        it.sender.sendMessage(Component.text("성공적으로 추가되었습니다!", NamedTextColor.GREEN))
                    }
                }
        }
        }
    }

}