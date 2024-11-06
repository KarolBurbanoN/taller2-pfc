package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite {

  val objConjuntosDifusos = new ConjuntosDifusos()

  test("Pertenencia de 10 en conjunto grande con d = 5 y e = 2") {
    val conjuntoGrande = objConjuntosDifusos.grande(5, 2)
    assert(conjuntoGrande(10) === Math.pow(10.0 / (10 + 5), 2))
  }

  test("Pertenencia de 0 en conjunto grande con d = 3 y e = 2 es 0") {
    val conjuntoGrande = objConjuntosDifusos.grande(3, 2)
    assert(conjuntoGrande(0) === 0.0)
  }

  test("Pertenencia de 5 en conjunto grande con d = 10 y e = 3") {
    val conjuntoGrande = objConjuntosDifusos.grande(10, 3)
    assert(conjuntoGrande(5) === Math.pow(5.0 / (5 + 10), 3))
  }

  test("Pertenencia de -1 en conjunto grande con d = 2 y e = 1 es 0") {
    val conjuntoGrande = objConjuntosDifusos.grande(2, 1)
    assert(conjuntoGrande(-1) === 0.0)
  }

  test("Pertenencia de 15 en conjunto grande con d = 7 y e = 2") {
    val conjuntoGrande = objConjuntosDifusos.grande(7, 2)
    assert(conjuntoGrande(15) === Math.pow(15.0 / (15 + 7), 2))
  }
}

