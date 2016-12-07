package npc.enemies

import player.attributes.{Inventory, BaseStats, Status}


/**
  * Created by valentin on 17.11.16.
  */
abstract class MonsterBase {
  val status = new Status
  val stats = new BaseStats
  val inventory = new Inventory
  val reward: Reward

  def attack(): Double = {
    stats.combatStats.baseDmg
  }

  def takeDmg(dmg: Double): Unit = {
    status.health -= dmg
  }
}
