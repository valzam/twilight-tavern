package characters.npc.enemies

/**
  * Created by valentin on 17.11.16.
  */
class Rat extends MonsterBase {

  val reward = Reward(gold = 5, exp = 5)
  status.health = 5
  combatStats.baseDmg = 3

}

class Zombie extends MonsterBase {

  val reward = Reward(gold = 6, exp = 15)
  status.health = 15
  combatStats.baseDmg = 10

}

