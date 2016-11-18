package npc.enemies

import attributes.{Inventory, Reward, BaseStats, Status}


/**
  * Created by valentin on 17.11.16.
  */
abstract class MonsterBase {
  val status = new Status
  val stats = new BaseStats
  val inventory = new Inventory
  val reward = new Reward

  def attack(): Double = {
    return stats.baseDmg
  }

  def takeDmg(dmg: Double): Unit = {
    status.health -= dmg
  }
}