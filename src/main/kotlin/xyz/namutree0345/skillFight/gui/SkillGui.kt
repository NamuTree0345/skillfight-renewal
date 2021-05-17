package xyz.namutree0345.skillFight.gui

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import xyz.namutree0345.skillFight.SkillFightPlugin
import xyz.namutree0345.skillFight.util.StackUtil


class SkillGui {

    companion object {
        fun showSkillPage(sender: Player, page: Int) {
            val inv = Bukkit.createInventory(null, 9, Component.text("직업 선택", NamedTextColor.GREEN, TextDecoration.BOLD))
            // 1, 3, 5, 7
            var att = 1
            for(i in (page * 4)..(SkillFightPlugin.jobs.size + (page * 4))) {
                println(i)
                if(SkillFightPlugin.jobs.size - 1 >= i) {
                    val job = SkillFightPlugin.jobs[i]
                    inv.setItem(att, StackUtil.getItemStack(job.icon, Component.text(job.name, NamedTextColor.AQUA, TextDecoration.BOLD)))
                    att += 2
                }
            }

            sender.openInventory(inv)
        }
    }
}