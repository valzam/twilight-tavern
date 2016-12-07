package items

/**
  * Created by valentin on 18.11.16.
  */
abstract class Weapon extends BaseItem{
  val baseDmg: Int
}

abstract class Shield extends BaseItem{
  val armor: Int
}

case class WoddenSword() extends Weapon {
  val baseDmg = 3
  val stats = ItemAttributes(strength = 5)
}

case class WoddenShields() extends Shield {
  val armor = 3
  val stats = ItemAttributes(vitality = 5)
}
