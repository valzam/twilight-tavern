package player.classes

import player.Player

/**
  * Created by valentin on 17.11.16.
  */
class Warrior(name: String) extends Player(name) {

  stats.combatStats.baseDmg = WarriorBaseStats.BASE_DMG
  stats.strength = WarriorBaseStats.STRENGTH
  stats.vitality = WarriorBaseStats.VITALITY
  stats.dexterity = WarriorBaseStats.DEXTERIRY

  regenerate()

  def attack(): Double ={
    stats.combatStats.baseDmg + stats.strength * WarriorAttackMulti.MULTI
  }

  def levelUp(): Unit ={

    stats.strength += 2.0
    stats.vitality += 3.0
    stats.dexterity += 1.0

    gainLevel()
  }

}