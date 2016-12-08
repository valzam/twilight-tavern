package characters.npc.enemies

import characters.attributes.{CombatStats, Inventory, Status}


/**
  * Created by valentin on 17.11.16.
  */
abstract class MonsterBase {
  val status = new Status
  val combatStats = new CombatStats
  val inventory = new Inventory
  val reward: Reward

  def attack(): Double = {
    combatStats.baseDmg
  }

  def takeDmg(dmg: Double): Unit = {
    status.health -= dmg
  }
}
