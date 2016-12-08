package game

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

    choice match {
      case "0" => displayCharInfo()
      case _ => print("I don't know that option")
    }
  }

  def displayChoices(): Unit ={
    println("0: Display my character info")
  }

  def displayCharInfo(): Unit ={
    print("Your character is: ")
    println(p.displayStatus())
  }

}
