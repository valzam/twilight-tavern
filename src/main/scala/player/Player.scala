package player

import attributes._
import items.Item

/**
  * Created by valentin on 17.11.16.
  */
abstract class Player(name: String) {

  val status = new Status
  val stats = new BaseStats
  val inventory = new Inventory
  val equippedItems = new EquippedItems

  stats.setAllToOne()

  def attack(): Double

  def levelUp(): Unit

  def takeDmg(dmg: Double): Unit ={
    status.health -= dmg
  }

  def gainExp(exp: Double): Unit ={
    status.exp += exp

    if (status.exp >= stats.expToLevel){
      status.exp = status.exp - stats.expToLevel
      levelUp()
    }
  }

  def gainLevel(): Unit ={
    status.level += 1
    stats.expToLevel += stats.expToLevel * Exp.ADDITIONAL_PER_LEVEL

    regenerate()
  }

  def regenerate(): Unit ={
    status.health = stats.maxHealth
    status.endurance = stats.maxEndurance
    status.mana = stats.maxMana
  }

  def equipItem(item: Item): Unit = {
    if (equippedItems.isOccupied(item.slot)) {
      val previousItem = equippedItems.equippedItems(item.slot)
      unequipItem(previousItem)
    }

      stats.addItemGeneralAttributes(item)
      stats.combatStats.baseDmg += item.baseDmg
      stats.combatStats.armor += item.armor
      equippedItems.equipItem(item)
  }

  def unequipItem(item: Item): Unit = {
    if (equippedItems.isEquipped(item)) {

      stats.removeItemGeneralAttributes(item)
      stats.combatStats.baseDmg -= item.baseDmg
      stats.combatStats.armor -= item.armor
      equippedItems.unequipItem(item.slot)

    }
  }

  def displayStatus(): Unit ={
    println(name)
    println(status.toString)
  }
}
