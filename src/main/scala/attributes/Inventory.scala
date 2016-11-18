package attributes

import items.ItemBase

/**
  * Created by valentin on 17.11.16.
  */
class Inventory {
  var gold = 1
  var items: Map[Int,ItemBase] = Map()

  def addItem(i: ItemBase): Int ={
    val position = if (items.isEmpty) 1 else items.keys.max + 1
    items += (position -> i)

    return position
  }

  def removeItem(position: Int): Unit ={
    items -= position
  }

}
