package items

import attributes.BaseStats

import scala.util.Random

/**
  * Created by valentin on 18.11.16.
  */
abstract class ItemBase {

  val id = IDGenerator()
  val stats = new BaseStats

}

object IDGenerator {
  val generator = new Random(1828823742)
  def apply() = generator.nextInt().toString
}
