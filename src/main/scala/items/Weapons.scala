package items

/**
  * Created by valentin on 18.11.16.
  */
abstract class Weapon extends ItemBase{
  val dmg: Double
}

abstract class Shield extends ItemBase{
  val armor: Double
}

class WoddenSword extends Weapon {
  override val dmg: Double = 2
  stats.strength = 3
}

class WoddenShields extends Shield {
  override val armor: Double = 3
  stats.vitality = 2
}
