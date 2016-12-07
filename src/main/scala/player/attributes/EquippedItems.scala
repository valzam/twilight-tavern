package player.attributes

import items.{Item, ItemSlot}
import items.ItemSlot.ItemSlot

/**
  * Created by valentin on 18.11.16.
  */
class EquippedItems {

  var equippedItems:Map[ItemSlot, Item] = Map()

  def equipItem(item: Item): Unit = {
    item.slot match {
      case ItemSlot.RightHand => equippedItems += (ItemSlot.RightHand -> item)
      case ItemSlot.LeftHand => equippedItems += (ItemSlot.LeftHand -> item)
      case ItemSlot.TwoHand => equippedItems += (ItemSlot.TwoHand -> item)
    }
  }

  def unequipItem(slot: ItemSlot): Unit = {
    equippedItems -= slot
  }

  def isEquipped(item: Item): Boolean = {
    val i = equippedItems.get(item.slot)
    i match {
      case Some(i) => i == item
      case None => false
    }
  }

  def isOccupied(slot: ItemSlot): Boolean = {
    equippedItems.get(slot).isDefined
  }
}

