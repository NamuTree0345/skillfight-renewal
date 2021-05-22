package xyz.namutree0345.skillFight.job

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Boomber : Job() {

    init {
        this.name = "폭탄병"
        this.desc = "펑!"
        this.icon = Material.TNT
        this.items.add(ItemStack(Material.TNT, 64))
    }

}