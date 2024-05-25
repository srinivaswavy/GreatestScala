import org.scalatest.funsuite.AnyFunSuite
class CalculatorTest extends AnyFunSuite {
  val calculator = new Calculator()

  test("Test addtions") {
    assert(3 == calculator.add(1,2))
  }
  test("Test subtractions") {
    assert(-1 == calculator.subtract(1,2))
  }
}
