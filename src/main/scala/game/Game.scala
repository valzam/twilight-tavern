package game

import player.classes.Warrior
import npc.enemies.Rat

/**
  * Created by valentin on 17.11.16.
  */
object Game {
  def main(args: Array[String]): Unit = {
    val p = new Warrior("Poi")

    for (i <- 1 to 6){
      p.displayStatus()
      val enemy = new Rat
      Fight.engage(p, enemy)
    }

  }
}
