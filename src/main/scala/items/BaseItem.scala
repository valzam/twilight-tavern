package items

import scala.util.Random

/**
  * Created by valentin on 18.11.16.
  */
abstract class BaseItem {

  val id = IDGenerator()
  val attributes: ItemAttributes

}

object IDGenerator {
  val generator = new Random(1828823742)
  def apply(): String = generator.nextInt().toString
}
