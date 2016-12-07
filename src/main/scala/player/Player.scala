package player

import attributes._
import items.{BaseItem, Weapon}

/**
  * Created by valentin on 17.11.16.
  */
abstract class Player(name: String) {

  val status = new Status
  val stats = new BaseStats
  val inventory = new Inventory
  val armor = new Armor
  val equippedWeapons = new EquippedWeapons

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

  def equipItem(item: BaseItem): Unit = {
    addItemGeneralAttributes(item)

    item match {
      case w: Weapon => equipWeapon(w)
      case _ =>
    }

    def equipWeapon(w: Weapon): Unit ={
      stats.combatStats.baseDmg += w.baseDmg
      stats.combatStats.armor += w.armor
      equippedWeapons.equipWeapon(w)
    }
  }

  def addItemGeneralAttributes(item: BaseItem): Unit ={
    stats.strength += item.attributes.strength
    stats.dexterity += item.attributes.dexterity
    stats.vitality += item.attributes.vitality
    stats.intelligence += item.attributes.intelligence
  }

  def displayStatus(): Unit ={
    println(name)
    println(status.toString)
  }
}
