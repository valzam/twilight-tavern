package npc.enemies

/**
  * Created by valentin on 17.11.16.
  */
class Rat extends MonsterBase {

  val reward = Reward(gold = 5, exp = 10)
  status.health = 5
  stats.combatStats.baseDmg = 3

}

class Zombie extends MonsterBase {

  val reward = Reward(gold = 6, exp = 15)
  status.health = 10
  stats.combatStats.baseDmg = 5

}

