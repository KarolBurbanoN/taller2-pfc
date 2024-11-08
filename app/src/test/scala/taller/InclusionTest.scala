package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class InclusionTest extends AnyFunSuite {
  
  val objConjuntosDifusos = new ConjuntosDifusos()

  test("Conjunto difuso incluido en si mismo") {
    val conjunto = objConjuntosDifusos.grande(4, 2)
    assert(objConjuntosDifusos.inclusion(conjunto, conjunto))
  }

  test("Conjunto con d menor incluido en conjunto con d mayor") {
    val conjunto1 = objConjuntosDifusos.grande(4, 2) // Conjunto con d = 3
    val conjunto2 = objConjuntosDifusos.grande(7, 2) // Conjunto con d = 5
    assert(!objConjuntosDifusos.inclusion(conjunto1, conjunto2))
  }

  test("Conjunto con d mayor no incluido en conjunto con d menor") {
    val conjunto1 = objConjuntosDifusos.grande(5, 2) // Conjunto con d = 5
    val conjunto2 = objConjuntosDifusos.grande(3, 2) // Conjunto con d = 3
    assert(objConjuntosDifusos.inclusion(conjunto1, conjunto2))
  }

  test("Conjunto con e mayor incluido en conjunto con e menor") {
    val conjunto1 = objConjuntosDifusos.grande(5, 2)
    val conjunto2 = objConjuntosDifusos.grande(5, 0)
    assert(objConjuntosDifusos.inclusion(conjunto1, conjunto2))
  }

  test("Conjunto con e menor no incluido en conjunto con e mayor") {
    val conjunto1 = objConjuntosDifusos.grande(5, 1)
    val conjunto2 = objConjuntosDifusos.grande(5, 4)
    assert(!objConjuntosDifusos.inclusion(conjunto1, conjunto2))
  }
}