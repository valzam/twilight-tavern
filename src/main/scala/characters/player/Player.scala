package characters.player

import characters.attributes._
import items.Item

/**
  * Created by valentin on 17.11.16.
  */
abstract class Player(name: String) {

  val status = new Status
  val attributes = new Attributes
  val combatStats = new CombatStats
  val inventory = new Inventory
  val equippedItems = new EquippedItems

  def attack(): Double

  def levelUp(): Unit

  def takeDmg(dmg: Double): Unit ={
    status.health -= dmg
  }

  def gainExp(exp: Double): Unit ={
    status.exp += exp

    if (status.exp >= attributes.expToLevel){
      status.exp = status.exp - attributes.expToLevel
      levelUp()
    }
  }

  def gainLevel(): Unit ={
    println("You level up, congrats!")
    status.level += 1
    attributes.expToLevel += (attributes.expToLevel * Exp.ADDITIONAL_PER_LEVEL).toInt

    regenerate()
  }

  def regenerate(): Unit ={
    status.health = attributes.maxHealth
    status.endurance = attributes.maxEndurance
    status.mana = attributes.maxMana
  }

  def equipItem(item: Item): Unit = {
    if (equippedItems.isOccupied(item.slot)) {
      val previousItem = equippedItems.equippedItems(item.slot)
      unequipItem(previousItem)
    }

      attributes.addItemGeneralAttributes(item)
      combatStats.addItemCombatStats(item)
      equippedItems.equipItem(item)
  }

  def unequipItem(item: Item): Unit = {
    if (equippedItems.isEquipped(item)) {

      attributes.removeItemGeneralAttributes(item)
      combatStats.removeItemCombatStats(item)
      equippedItems.unequipItem(item.slot)

    }
  }

  def displayStatus(): Unit ={
    println(name)
    println(status.toString)
  }
}
