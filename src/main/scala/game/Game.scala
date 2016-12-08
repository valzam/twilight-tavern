package game

import characters.npc.enemies.{Rat, Zombie}
import characters.player.Player
import characters.player.classes.Warrior

import scala.io._

/**
  * Created by valentin on 17.11.16.
  */
object Game extends App {
  println("What is your name? ")
  val name = Source.stdin.getLines.next()
  val p = new Warrior(name)

  while (true) {
    println("What do you want to do?")
    displayChoices()
    val choice = Source.stdin.getLines.next()
    clearScreen()

    choice match {
      case "0" => displayCharInfo()
      case "1" => startFight(p)
      case _ => print("I don't know that option")
    }
  }

  def displayChoices(): Unit ={
    println("0: Display my character info")
    println("1: Fight an evil monster")
  }

  def startFight(p: Player): Unit ={
    val m = new Rat
    Fight.engage(p, m)
  }

  def displayCharInfo(): Unit ={
    print("Your character is: ")
    println(p.displayStatus())
  }

  def clearScreen(): Unit ={
    print("\033[2J")
  }

}
