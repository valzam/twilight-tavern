package items

/**
  * Created by valentin on 18.11.16.
  */
abstract class Weapon extends ItemBase{
}

abstract class Shield extends ItemBase{
}

class WoddenSword extends Weapon {
  stats.combatStats.baseDmg = 3
  stats.strength = 3
}

class WoddenShields extends Shield {
  stats.combatStats.armor = 3
  stats.vitality = 2
}
