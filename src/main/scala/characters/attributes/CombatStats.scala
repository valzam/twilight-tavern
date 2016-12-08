package characters.attributes

import items.Item

/**
  * Created by valentin on 19.11.16.
  */
class CombatStats {

  private[this] var _baseDmg: Int = 1
  private[this] var _armor: Int = 1

  def addItemCombatStats(item: Item): Unit = {
    baseDmg += item.baseDmg
    armor += item.armor
  }

  def removeItemCombatStats(item: Item): Unit = {
    baseDmg -= item.baseDmg
    armor -= item.armor
  }

  def baseDmg: Int = _baseDmg

  def baseDmg_=(value: Int): Unit = {
    _baseDmg = value
  }

  def armor: Int = _armor

  def armor_=(value: Int): Unit = {
    _armor = value
  }
}
