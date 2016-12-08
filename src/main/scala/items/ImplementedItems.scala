package items

/**
  * Created by valentin on 08.12.16.
  */
object ImplementedItems {
  var itemList: Array[Item] = Array()
  initializeItemList()

  def initializeItemList(): Unit ={
    addItem(WoodenSword())
    addItem(WoodenShield())
  }

  def addItem(i: Item): Unit ={
    itemList = itemList :+ i
  }

  def getImplementedItems: Array[Item] = {
    itemList
  }
}

object WoodenSword {
  def apply(): Item = Item(baseDmg = 3,
    attributes = ItemAttributes(strength = 5),
    name= "Wooden Sword",
    group = "sword", slot = ItemSlot.RightHand)
}

object WoodenShield {
  def apply(): Item = Item(armor = 5,
    attributes = ItemAttributes(vitality = 5),
    name= "Wooden Shield",
    group = "shield", slot = ItemSlot.LeftHand)
}