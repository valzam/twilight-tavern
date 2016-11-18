package attributes

/**
  * Created by valentin on 17.11.16.
  */
class BaseStats {
  //TODO Factor the high level stats into another class
  var baseDmg: Double = 1
  var maxHealth: Double = 10
  var maxEndurance: Double = 5
  var maxMana: Double = 5
  var expToLevel: Double = 10

  private[this] var _strength: Double = 0
  private[this] var _dexterity: Double = 0
  private[this] var _vitality: Double = 0
  private[this] var _intelligence: Double = 0

  def setAllToOne(): Unit ={
    strength = 1
    dexterity = 1
    vitality = 1
    intelligence = 1
  }

  def strength: Double = _strength

  def strength_=(value: Double): Unit = {
    _strength = value
  }

  def dexterity: Double = _dexterity

  def dexterity_=(value: Double): Unit = {
    _dexterity = value
  }

  def vitality: Double = _vitality

  def vitality_=(value: Double): Unit = {
    _vitality = value
    maxHealth = maxHealth + 0.5* vitality
    maxEndurance = maxEndurance + 0.25 * vitality
  }

  def intelligence: Double = _intelligence

  def intelligence_=(value: Double): Unit = {
    _intelligence = value
    maxMana = maxMana * 0.4 * intelligence
  }

}
