package events

import events.PlayerEvent.PlayerEvent


/**
  * Created by valentin on 08.12.16.
  */
object PlayerEventEngine {
  val eventLog: Array[PlayerEvent] = Array()

  def apply(e: PlayerEvent): Unit = e match {
    case PlayerEvent.LevelUp => printMsg("You leveled up, congrats!", e)
    case PlayerEvent.Died => printMsg("You died!", e)
    case _ => print("Unknown event")
  }

  private def printMsg(m: String, e: PlayerEvent): Unit = {
    eventLog :+ e
    println(m)
  }
}

object PlayerEvent extends Enumeration {
  type PlayerEvent = Value
  val LevelUp, Died = Value
}
