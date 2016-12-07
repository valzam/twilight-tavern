package player

import attributes._
import items.{BaseItem, Shield, Weapon}

/**
  * Created by valentin on 17.11.16.
  */
abstract class Player(name: String) {

  val status = new Status
  val stats = new BaseStats
  val inventory = new Inventory
  val armor = new Armor
  val weapons = new Weapons

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
    item match {
      case w: Weapon => equipWeapon(w)
      case s: Shield => equipShield(s)
      case _ =>
    }
  }

  def equipWeapon(weapon: Weapon): Unit ={
    addItemGeneralAttributes(weapon)
    stats.combatStats.baseDmg += weapon.baseDmg
    weapons.rightHand = weapon
  }

  def equipShield(shield: Shield): Unit ={
    addItemGeneralAttributes(shield)
    stats.combatStats.armor += shield.armor
    weapons.leftHand = shield
  }

  def addItemGeneralAttributes(item: BaseItem): Unit ={
    stats.strength += item.stats.strength
    stats.dexterity += item.stats.dexterity
    stats.vitality += item.stats.vitality
    stats.intelligence += item.stats.intelligence
  }

  def displayStatus(): Unit ={
    println(name)
    println(status.toString)
  }
}
