package characters.player.classes

import characters.player.Player

/**
  * Created by valentin on 17.11.16.
  */
class Warrior(name: String) extends Player(name) {

  combatStats.baseDmg = WarriorBaseStats.BASE_DMG
  attributes.strength = WarriorBaseStats.STRENGTH
  attributes.vitality = WarriorBaseStats.VITALITY
  attributes.dexterity = WarriorBaseStats.DEXTERIRY

  regenerate()

  def attack(): Double ={
    combatStats.baseDmg + attributes.strength * WarriorAttackMulti.MULTI
  }

  def levelUp(): Unit ={

    attributes.strength += 2.0
    attributes.vitality += 3.0
    attributes.dexterity += 1.0

    gainLevel()
  }

}