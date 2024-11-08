package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class IgualdadTest extends AnyFunSuite {

  val objConjuntosDifusos = new ConjuntosDifusos()

  // Función para crear conjuntos constantes
  def constante(valor: Double): ConjDifuso = (elem: Int) => valor

  test("igualdad - dos conjuntos idénticos") {
    val cd1: ConjDifuso = s => if (s % 2 == 0) 0.5 else 0.3
    val cd2: ConjDifuso = s => if (s % 2 == 0) 0.5 else 0.3
    assert(objConjuntosDifusos.igualdad(cd1, cd2) === true)
  }

  test("igualdad - conjuntos diferentes en un elemento") {
    val cd1: ConjDifuso = s => if (s == 500) 0.8 else 0.5
    val cd2: ConjDifuso = s => 0.5
    assert(objConjuntosDifusos.igualdad(cd1, cd2) === false)
  }

  test("igualdad - conjunto constante igual a otro constante") {
    val cd1 = constante(0.5)
    val cd2 = constante(0.5)
    assert(objConjuntosDifusos.igualdad(cd1, cd2) === true)
  }

  test("igualdad - conjunto constante distinto de otro constante") {
    val cd1 = constante(0.5)
    val cd2 = constante(0.3)
    assert(objConjuntosDifusos.igualdad(cd1, cd2) === false)
  }

  test("igualdad - inclusión recíproca implica igualdad") {
    val cd1: ConjDifuso = s => if (s < 500) 0.2 else 0.6
    val cd2: ConjDifuso = s => if (s < 500) 0.2 else 0.6
    assert(objConjuntosDifusos.igualdad(cd1, cd2) === true)
  }
}

