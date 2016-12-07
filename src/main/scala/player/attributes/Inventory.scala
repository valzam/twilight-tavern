package player.attributes

import items.Item

/**
  * Created by valentin on 17.11.16.
  */
class Inventory {
  var gold = 1
  var items: Map[Int, Item] = Map()

  def addItem(i: Item): Int ={
    val position = if (items.isEmpty) 1 else items.keys.max + 1
    items += (position -> i)

    position
  }

  def removeItem(position: Int): Unit ={
    items -= position
  }

}
