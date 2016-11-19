package attributes

/**
  * Created by valentin on 17.11.16.
  */

class BaseStats {
  //TODO Factor the high level stats into another class
  var maxHealth: Double = 1
  var maxEndurance: Double = 1
  var maxMana: Double = 1

  var expToLevel: Double = 10

  val combatStats = new CombatStats

  private[this] var _strength: Double = 1
  private[this] var _dexterity: Double = 1
  private[this] var _vitality: Double = 1
  private[this] var _intelligence: Double = 1

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
    maxHealth = maxHealth + BaseStatsMulti.MAX_HEALTH * vitality
    maxEndurance = maxEndurance + BaseStatsMulti.MAX_ENDURANCE * vitality
  }

  def intelligence: Double = _intelligence

  def intelligence_=(value: Double): Unit = {
    _intelligence = value
    maxMana = maxMana + BaseStatsMulti.MAX_MANA * intelligence
  }

}
