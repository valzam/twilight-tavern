package game

import attributes.Reward
import npc.enemies.{MonsterBase, Rat}
import player.Player

/**
  * Created by valentin on 17.11.16.
  */
object Fight {

  def engage(p: Player, m: MonsterBase): Unit ={

    while (p.status.health > 0 && m.status.health > 0){
      val dmgPlayer = p.attack()
      val monsterDmg = m.attack()

      p.takeDmg(monsterDmg)
      m.takeDmg(dmgPlayer)
    }

    if (p.status.health <= 0){
      println("You died!")
    } else {
      println("You defeated the evil monster!")
      assignLoot(p, m.reward)
    }
  }

  def assignLoot(p: Player, r: Reward): Unit ={
    p.inventory.gold += r.gold
    p.gainExp(r.exp)
  }
}
