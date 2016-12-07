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
    weapon.slot match {
      case WeaponSlot.RightHand => rightHand = weapon
      case WeaponSlot.LeftHand => leftHand = weapon
      case WeaponSlot.TwoHand => twoHand = weapon
    }
  }
}

object WeaponSlot extends Enumeration {
  type WeaponSlot = Value
  val RightHand, LeftHand, TwoHand = Value
}