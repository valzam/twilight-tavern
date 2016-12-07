package items

import player.attributes.WeaponSlot
import player.attributes.WeaponSlot.WeaponSlot

/**
  * Created by valentin on 18.11.16.
  */
case class Weapon(baseDmg: Int = 0,
                  armor: Int = 0,
                  attributes: ItemAttributes,
                  name: String,
                  group: String, slot: WeaponSlot) extends BaseItem

object WoodenSword {
  def apply(): Weapon = Weapon(baseDmg = 3,
                      attributes = ItemAttributes(strength = 5),
                      name= "Wooden Sword",
                      group = "sword", slot = WeaponSlot.RightHand)
}