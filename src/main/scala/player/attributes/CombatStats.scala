package player.attributes

/**
  * Created by valentin on 19.11.16.
  */
class CombatStats {

  private[this] var _baseDmg: Double = 1
  private[this] var _armor: Double = 1

  def baseDmg: Double = _baseDmg

  def baseDmg_=(value: Double): Unit = {
    _baseDmg = value
  }

  def armor: Double = _armor

  def armor_=(value: Double): Unit = {
    _armor = value
  }
}
