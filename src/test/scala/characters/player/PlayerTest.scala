package characters.player

import characters.attributes.Exp
import items.{Item, ItemAttributes, ItemSlot}
import org.scalatest.{BeforeAndAfterEach, FunSuite}

/**
  * Created by valentin on 19.11.16.
  */

class PlayerTest extends FunSuite with BeforeAndAfterEach {

  var p: MockPlayer = _
  override def beforeEach() {
   p = new MockPlayer("Test")
  }


  test("Gaining more than the necessary exp should call the level up method") {
    val expGained = 11
    p.gainExp(expGained)
    assert(p.status.level == 2)
  }

  test("Gaining a level should increase the needed exp for the next level") {
    p.gainLevel()
    val newExpNeeded = 10 + 10 * Exp.ADDITIONAL_PER_LEVEL
    assert(p.attributes.expToLevel == newExpNeeded )
  }

  test("Gaining a level should fully heal the character") {
    p.gainLevel()
    assert(p.status.health == p.attributes.maxHealth)
    assert(p.status.endurance == p.attributes.maxEndurance)
    assert(p.status.mana == p.attributes.maxMana)
  }

  test("Equipping an item should add the item's stats to the characters.player's stats"){
    val testItem = TestWeapon()
    p.equipItem(testItem)

    assert(p.attributes.dexterity == 6)
    assert(p.attributes.strength == 4)
    assert(p.attributes.vitality == 3)
    assert(p.combatStats.baseDmg == 4)
  }

  test("Equipping a weapon should increase the characters.player's base dmg") {
    val testWeapon = TestWeapon()
    p.equipItem(testWeapon)

    assert(p.combatStats.baseDmg == 4)
  }

  test("Equipping a shield should increase the characters.player's armor") {
    val testShield = TestShield()
    p.equipItem(testShield)

    assert(p.combatStats.armor == 4)
  }

  test("Equipping an item when the slot already has an equipped item should correctly update the stats ") {
    val testItem1 = TestWeapon()
    val testItem2 = TestWeapon2()
    p.equipItem(testItem1)
    p.equipItem(testItem2)

    assert(p.attributes.dexterity == 7)
    assert(p.attributes.strength == 5)
    assert(p.attributes.vitality == 4)
    assert(p.combatStats.baseDmg == 5)
  }

  test("Unequipping an item should lower the characters.player's stats by the item's stats") {
    val testWeapon = TestWeapon()
    p.equipItem(testWeapon)
    p.unequipItem(testWeapon)

    assert(p.attributes.dexterity == 1)
    assert(p.attributes.strength == 1)
    assert(p.attributes.vitality == 1)
    assert(p.combatStats.baseDmg == 1)
  }

  test("Uneqipping an item that was not equipped should do nothing") {
    val testWeapon = TestWeapon()
    p.unequipItem(testWeapon)

    assert(p.attributes.dexterity == 1)
    assert(p.attributes.strength == 1)
    assert(p.attributes.vitality == 1)
    assert(p.combatStats.baseDmg == 1)
  }
}

class MockPlayer(name: String) extends Player(name) {
  override def attack(): Double = 0

  override def levelUp(): Unit = {
    gainLevel()
  }
}

object TestWeapon {
  def apply(): Item = {
    Item(baseDmg = 3,
      attributes = ItemAttributes(strength = 3, vitality = 2, dexterity = 5),
      name = "Test Weapon", group = "sword", slot = ItemSlot.RightHand)
  }

}

object TestWeapon2 {
  def apply(): Item = {
    Item(baseDmg = 4,
      attributes = ItemAttributes(strength = 4, vitality = 3, dexterity = 6),
      name = "Test Weapon", group = "sword", slot = ItemSlot.RightHand)
  }

}

object TestShield {
  def apply(): Item = {
    Item(armor = 3,
      attributes = ItemAttributes(strength = 3, vitality = 2, dexterity = 5),
      name = "Test Shield", group = "shield", slot = ItemSlot.LeftHand)
  }

}