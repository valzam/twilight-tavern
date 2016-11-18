package player.classes

import player.Player

/**
  * Created by valentin on 17.11.16.
  */
class Warrior(name: String) extends Player(name) {

  stats.baseDmg = 3
  stats.strength = 4
  stats.vitality = 7
  stats.dexterity = 2

  regenerate()

  def attack(): Double ={
    return stats.baseDmg + stats.strength * 1.5
  }

  def levelUp(): Unit ={

    status.level += 1

    stats.strength += 2.0
    stats.vitality += 3.0
    stats.dexterity += 1.0

    regenerate()
  }

}
