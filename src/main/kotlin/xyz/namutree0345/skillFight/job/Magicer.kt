package xyz.namutree0345.skillFight.job

import org.bukkit.Material
import xyz.namutree0345.skillFight.skill.EvokerFangSkill
import xyz.namutree0345.skillFight.skill.SwordSkill

class Magicer : Job() {

    init {
        this.name = "마법사"
        this.desc = "마법을 부린다"
        this.icon = Material.END_ROD
        this.skills.add(EvokerFangSkill())
    }

}