package xyz.namutree0345.skillFight.job

import org.bukkit.Material
import xyz.namutree0345.skillFight.skill.BreakSkill
import xyz.namutree0345.skillFight.skill.DashSkill

class Ninja : Job() {

    init {
        this.name = "닌자"
        this.desc = "어디선가 서늘한 느낌이 느껴진다.."
        this.icon = Material.STICK
        this.skills.add(DashSkill())
        this.skills.add(BreakSkill())
    }

}