package events

import events.PlayerEvent.PlayerEvent

/**
  * Created by valentin on 08.12.16.
  */
object PlayerEventEngine {
  def apply(e: PlayerEvent): Unit = e match {
    case PlayerEvent.LevelUp => println("You leveled up, congrats!")
  }
}

object PlayerEvent extends Enumeration {
  type PlayerEvent = Value
  val LevelUp = Value
}
