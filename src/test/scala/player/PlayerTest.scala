package player

import attributes.Exp
import org.scalatest.{BeforeAndAfterEach, FunSuite}

/**
  * Created by valentin on 19.11.16.
  */

class PlayerTest extends FunSuite with BeforeAndAfterEach {

  var p: MockPlayer = _
  override def beforeEach() {
   p = new MockPlayer("Test")
  }


  test("Gaining more than the necessary should call the level up method") {
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

}

class MockPlayer(name: String) extends Player(name) {
  override def attack(): Double = 0

  override def levelUp(): Unit = {
    gainLevel()
  }
}