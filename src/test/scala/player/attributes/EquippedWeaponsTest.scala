package player.attributes

import items.{ItemAttributes, Weapon}
import org.scalatest.{BeforeAndAfterEach, FunSuite}

/**
  * Created by valentin on 07.12.16.
  */
class EquippedWeaponsTest extends FunSuite with BeforeAndAfterEach {

  var p: EquippedWeapons = _
  override def beforeEach() {
    p = new EquippedWeapons
  }

  test("Equipping a weapon should add it to the correct slot") {
    val testWeapon = TestWeapon()
    p.equipWeapon(testWeapon)

    assert(p.rightHand == testWeapon)
  }

}

object TestWeapon {
  def apply(): Weapon = {
    Weapon(baseDmg = 3,
      attributes = ItemAttributes(strength = 3, vitality = 2, dexterity = 5),
      name = "Test Weapon", group = "sword", slot = WeaponSlot.RightHand)
  }

}