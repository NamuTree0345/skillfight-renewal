package xyz.namutree0345.skillFight.commands

import com.github.monun.kommand.KommandContext
import com.github.monun.kommand.KommandDispatcherBuilder
import com.github.monun.kommand.argument.KommandArgument
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.StructureType
import org.bukkit.entity.Player

var map: StructureType = StructureType.VILLAGE

object CommandMap {

    internal fun register(builder: KommandDispatcherBuilder) {
        builder.register("map") {
            require { this is Player && this.isOp }
            then("structure" to StructureTypeArgument) {
                executes { context ->
                    map = context.parseArgument("structure")
                    context.sender.sendMessage(Component.text("성공적으로 맵이 선택되었습니다!", NamedTextColor.GREEN))
                }
            }
        }
    }

}

object StructureTypeArgument : KommandArgument<StructureType> {

    override fun parse(context: KommandContext, param: String): StructureType? {
        val list = StructureType.getStructureTypes().entries.toList()
        val newList = arrayListOf<StructureType>()
        for (set in list) {
            newList.add(set.value)
        }
        return newList.find { it.name == param }
    }

    override fun suggest(context: KommandContext, target: String): Collection<String> {
        val list = StructureType.getStructureTypes().entries.toList()
        val newList = arrayListOf<String>()
        for (set in list) {
            newList.add(set.key)
        }
        return newList
    }
}
