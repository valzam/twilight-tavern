package player

import attributes._

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

  def regenerate(): Unit ={
    status.health = stats.maxHealth
    status.endurance = stats.maxEndurance
    status.mana = stats.maxMana
  }

  def displayStatus(): Unit ={
    println(name)
    println(status.toString)
  }
}
