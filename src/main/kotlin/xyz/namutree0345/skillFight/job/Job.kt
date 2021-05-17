package xyz.namutree0345.skillFight.job

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import xyz.namutree0345.skillFight.skill.Skill

abstract class Job {

    val skills = arrayListOf<Skill>()

    val items = arrayListOf<ItemStack>()

    var offhandItem = ItemStack(Material.AIR)

    var helmetItem = ItemStack(Material.DIAMOND_HELMET)
    var chestPlateItem = ItemStack(Material.DIAMOND_CHESTPLATE)
    var leggingsItem = ItemStack(Material.DIAMOND_LEGGINGS)
    var bootsItem = ItemStack(Material.DIAMOND_BOOTS)

    var name = "unnamed"
    var desc = "a unnamed job"
    var icon = Material.STICK

}