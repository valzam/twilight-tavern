package attributes

/**
  * Created by valentin on 17.11.16.
  */
class Status {

  var health: Double = 1
  var mana: Double = 1
  var endurance: Double = 1
  var level: Double = 1
  var exp: Double = 1

  override def toString: String = {
    "Level: " + level + "\n" +
    "Exp: " + exp + "\n" +
    "Health: " + health +"\n" +
    "Mana: " + mana + "\n" +
    "Endurance: " + endurance
  }
}
