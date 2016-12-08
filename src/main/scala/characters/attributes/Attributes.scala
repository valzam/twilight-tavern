package characters.attributes

import items.Item

/**
  * Created by valentin on 17.11.16.
  */

class Attributes {
  //TODO Factor the high level stats into another class
  var maxHealth: Int = 10
  var maxEndurance: Int = 1
  var maxMana: Int = 1

  var expToLevel: Int = 10

  private[this] var _strength: Int = 1
  private[this] var _dexterity: Int = 1
  private[this] var _vitality: Int = 1
  private[this] var _intelligence: Int = 1

  def setAllToOne(): Unit ={
    strength = 1
    dexterity = 1
    vitality = 1
    intelligence = 1
  }

  def addItemGeneralAttributes(item: Item): Unit ={
    strength += item.attributes.strength
    dexterity += item.attributes.dexterity
    vitality += item.attributes.vitality
    intelligence += item.attributes.intelligence
  }

  def removeItemGeneralAttributes(item: Item): Unit ={
    strength -= item.attributes.strength
    dexterity -= item.attributes.dexterity
    vitality -= item.attributes.vitality
    intelligence -= item.attributes.intelligence
  }

  def strength: Int = _strength

  def strength_=(value: Int): Unit = {
    _strength = value
  }

  def dexterity: Int = _dexterity

  def dexterity_=(value: Int): Unit = {
    _dexterity = value
  }

  def vitality: Int = _vitality

  def vitality_=(value: Int): Unit = {
    _vitality = value
    maxHealth = (maxHealth + BaseStatsMulti.MAX_HEALTH * vitality).toInt
    maxEndurance = (maxEndurance + BaseStatsMulti.MAX_ENDURANCE * vitality).toInt
  }

  def intelligence: Int = _intelligence

  def intelligence_=(value: Int): Unit = {
    _intelligence = value
    maxMana = (maxMana + BaseStatsMulti.MAX_MANA * intelligence).toInt
  }

}
