package player.attributes

import items.BaseItem

/**
  * Created by valentin on 17.11.16.
  */
class Inventory {
  var gold = 1
  var items: Map[Int, BaseItem] = Map()

  def addItem(i: BaseItem): Int ={
    val position = if (items.isEmpty) 1 else items.keys.max + 1
    items += (position -> i)

    position
  }

  def removeItem(position: Int): Unit ={
    items -= position
  }

}
