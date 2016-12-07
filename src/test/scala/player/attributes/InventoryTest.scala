package player.attributes

import items.WoodenSword
import org.scalatest.FunSuite

/**
  * Created by valentin on 19.11.16.
  */
class InventoryTest extends FunSuite {

  def fixture =
    new {
      val testInv = new Inventory
      val testItem = WoodenSword()
    }

  test("An inventory should start with 1 gold"){
    val f = fixture
    assert (f.testInv.gold == 1)
  }

  test("addItem should add an item to the items map"){
    val f = fixture
    val position = f.testInv.addItem(f.testItem)

    assert(f.testInv.items(position) == f.testItem)
  }

  test("If it exists remove item should remove an item from the items list") {
    val f = fixture
    val position = f.testInv.addItem(f.testItem)
    f.testInv.removeItem(position)

    assert(f.testInv.items.isEmpty)
  }

  test("If the item doesn't exist removeItem should not do anything"){
    val f = fixture
    f.testInv.addItem(f.testItem)
    f.testInv.removeItem(2)

    assert(f.testInv.items.size == 1)
  }

}
