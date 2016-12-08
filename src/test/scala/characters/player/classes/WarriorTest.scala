package characters.player.classes

import org.scalatest.FunSuite

/**
  * Created by valentin on 19.11.16.
  */
class WarriorTest extends FunSuite {

  val fixture =
    new {
      val testWarrior = new Warrior("Test")
    }

  test("Creating a warrior should correctly set the base stats") {
    val f = fixture
    assert(f.testWarrior.attributes.strength == WarriorBaseStats.STRENGTH)
    assert(f.testWarrior.attributes.vitality == WarriorBaseStats.VITALITY)
    assert(f.testWarrior.attributes.dexterity == WarriorBaseStats.DEXTERIRY)
    assert(f.testWarrior.combatStats.baseDmg == WarriorBaseStats.BASE_DMG)
  }

  test("Attacking should correctly calculate the damage") {
    val f = fixture
    val expectedDmg = 7.5
    assert(expectedDmg == f.testWarrior.attack())
  }

}
