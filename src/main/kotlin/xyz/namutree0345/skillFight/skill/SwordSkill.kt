package xyz.namutree0345.skillFight.skill

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.bukkit.util.EulerAngle
import org.bukkit.util.Vector
import xyz.namutree0345.skillFight.util.StackUtil
import xyz.namutree0345.skillFight.util.TickUtil

class SwordSkill : Skill() {

    init {
        this.icon = Material.ARROW
        this.iconName = "느려...?"
        this.iconDesc = "칼을 온방향으로 던집니다"

        this.wand = StackUtil.getItemStack(Material.IRON_SWORD, Component.text("느려", NamedTextColor.GREEN, TextDecoration.BOLD))
    }

    override fun activate(activatedBy: Player) {

        for(i in 0..4) {
            val armorStand = (activatedBy.world.spawnEntity(
                activatedBy.location,
                EntityType.ARMOR_STAND
            )) as org.bukkit.entity.ArmorStand

            if (i > 2) {
                armorStand.velocity = activatedBy.location.direction.multiply(10).rotateAroundZ((i - 2) * 1.0)
            } else {
                armorStand.velocity = activatedBy.location.direction.multiply(10).rotateAroundX((i - 2) * 1.0)
            }
            armorStand.isInvulnerable = true
            armorStand.setDisabledSlots(
                EquipmentSlot.OFF_HAND,
                EquipmentSlot.HAND,
                EquipmentSlot.HEAD,
                EquipmentSlot.CHEST,
                EquipmentSlot.FEET,
                EquipmentSlot.LEGS
            )
            armorStand.isInvisible = true
            armorStand.setArms(true)
            armorStand.rightArmPose = EulerAngle(270.0, 0.0, 90.0 * (i - 4))
            armorStand.equipment?.setItemInMainHand(ItemStack(Material.IRON_SWORD))
            TickUtil.runTaskUntilTheTime({
                armorStand.world.spawnParticle(Particle.FLAME, armorStand.location.x, armorStand.location.y + 1, armorStand.location.z, 1)
                for(e in armorStand.location.getNearbyLivingEntities(4.0)) {
                    if(e.type != EntityType.PLAYER) {
                        e.damage(3.0)
                    }
                }
            }, 60L, 1L)
            TickUtil.runTaskAfterTheTime({
                if(!armorStand.isDead) armorStand.remove()
            }, 60L)
        }
    }

}