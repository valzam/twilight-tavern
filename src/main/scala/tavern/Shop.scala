package tavern

import items.Item

/**
  * Created by valentin on 08.12.16.
  */
case class Shop(inventory: Array[Item]) {
  def displayItems(): Unit ={
    println(s"We are selling the following ${inventory.length} items: ")
    for ((item, number) <- inventory.view.zipWithIndex){
      println(s"$number: $item.name")
    }
  }
}
