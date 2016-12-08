package items

import items.ItemSlot.ItemSlot

import scala.util.Random

/**
  * Created by valentin on 18.11.16.
  */
case class Item(name: String, group: String, slot: ItemSlot,
                baseDmg: Int = 0,
                armor: Int = 0,
                attributes: ItemAttributes) {

  val id = IDGenerator()

  override def equals(that: Any): Boolean =
    that match {
      case that: Item => that.canEqual(this) && this.hashCode == that.hashCode
      case _ => false
    }

  //override def canEqual(a: Any) = a.isInstanceOf[Item]

  override def hashCode(): Int = id
}

object IDGenerator {
  val generator = new Random(1828823742)
  def apply(): Int = generator.nextInt()
}