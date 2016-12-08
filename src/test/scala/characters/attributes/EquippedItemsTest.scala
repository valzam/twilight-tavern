package characters.attributes

import items.{Item, ItemAttributes, ItemSlot}
import org.scalatest.{BeforeAndAfterEach, FunSuite}

/**
  * Created by valentin on 07.12.16.
  */
class EquippedItemsTest extends FunSuite with BeforeAndAfterEach {

  var p: EquippedItems = _
  override def beforeEach() {
    p = new EquippedItems
  }

  test("Equipping a weapon should add it to the correct slot") {
    val testWeapon = TestWeapon()
    p.equipItem(testWeapon)

    assert(p.equippedItems(ItemSlot.RightHand) == testWeapon)
  }

  test("Unequipping a weapon should remove it from its slot") {
    val testWeapon = TestWeapon()
    p.equipItem(testWeapon)
    p.unequipItem(testWeapon.slot)

    assert(p.equippedItems.isEmpty)
  }

  test("isEquipped should correctly identify if an item is equipped already") {
    val testWeapon = TestWeapon()
    p.equipItem(testWeapon)

    assert(p.isEquipped(testWeapon))
  }

  test("isOccupied should correctly identify if a slot is already occupied") {
    assert(!p.isOccupied(ItemSlot.RightHand))
  }

}

object TestWeapon {
  def apply(): Item = {
    Item(baseDmg = 3,
      attributes = ItemAttributes(strength = 3, vitality = 2, dexterity = 5),
      name = "Test Weapon", group = "sword", slot = ItemSlot.RightHand)
  }

}