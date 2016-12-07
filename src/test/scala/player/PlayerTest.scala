package player

import attributes.{Exp, WeaponSlot}
import items.{ItemAttributes, Weapon}
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
    assert(p.stats.expToLevel == newExpNeeded )
  }

  test("Gaining a level should fully heal the character") {
    p.gainLevel()
    assert(p.status.health == p.stats.maxHealth)
    assert(p.status.endurance == p.stats.maxEndurance)
    assert(p.status.mana == p.stats.maxMana)
  }

  test("Equipping an item should add the item's stats to the player's stats"){
    val testItem = TestWeapon()
    p.equipItem(testItem)

    assert(p.stats.dexterity == 6)
    assert(p.stats.strength == 4)
    assert(p.stats.vitality == 3)
    assert(p.stats.combatStats.baseDmg == 4)
  }

  test("Equipping a weapon should increase the player's base dmg") {
    val testWeapon = TestWeapon()
    p.equipItem(testWeapon)

    assert(p.stats.combatStats.baseDmg == 4)
  }

  test("Equipping a shield should increase the player's armor") {
    val testShield = TestShield()
    p.equipItem(testShield)

    assert(p.stats.combatStats.armor == 4)
  }

  test("Unequipping an item should lower the player's stats by the item's stats") {

  }
}

class MockPlayer(name: String) extends Player(name) {
  override def attack(): Double = 0

  override def levelUp(): Unit = {
    gainLevel()
  }
}

object TestWeapon {
  def apply(): Weapon = {
    Weapon(baseDmg = 3,
      attributes = ItemAttributes(strength = 3, vitality = 2, dexterity = 5),
      name = "Test Weapon", group = "sword", slot = WeaponSlot.RightHand)
  }

}

object TestShield {
  def apply(): Weapon = {
    Weapon(armor = 3,
      attributes = ItemAttributes(strength = 3, vitality = 2, dexterity = 5),
      name = "Test Shield", group = "shield", slot = WeaponSlot.LeftHand)
  }

}