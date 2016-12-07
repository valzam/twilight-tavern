package player.attributes

import items.Weapon

/**
  * Created by valentin on 18.11.16.
  */
class EquippedWeapons {
  var rightHand: Weapon = _
  var leftHand: Weapon = _
  var twoHand: Weapon = _

  var weaponsList: List[(String, String)] = List()

  def equipWeapon(weapon: Weapon): Unit = {
    weapon.group match {
      case "sword" => rightHand = weapon
      case "shield" => leftHand = weapon
      case "2hSword" => twoHand = weapon
    }
  }
}
