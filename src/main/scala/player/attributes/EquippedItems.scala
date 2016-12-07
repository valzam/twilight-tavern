package player.attributes

import items.{Item, ItemSlot}
import items.ItemSlot.ItemSlot

/**
  * Created by valentin on 18.11.16.
  */
class EquippedItems {

  var equippedWeapons:Map[ItemSlot, Item] = Map()

  def equipItem(item: Item): Unit = {
    item.slot match {
      case ItemSlot.RightHand => equippedWeapons += (ItemSlot.RightHand -> item)
      case ItemSlot.LeftHand => equippedWeapons += (ItemSlot.LeftHand -> item)
      case ItemSlot.TwoHand => equippedWeapons += (ItemSlot.TwoHand -> item)
    }
  }

  def unequipItem(slot: ItemSlot): Unit = {
    equippedWeapons -= slot
  }
}

