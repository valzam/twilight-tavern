package items

import org.scalatest.FunSuite

/**
  * Created by valentin on 08.12.16.
  */
class ImplementedItems$Test extends FunSuite {
  test("There should be at least 1 item after initialization") {
    val itemList = ImplementedItems.getImplementedItems

    assert(itemList.length > 0)
  }
}
