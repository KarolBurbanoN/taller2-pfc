package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class IgualdadTest extends AnyFunSuite {

  val objConjuntosDifusos = new ConjuntosDifusos()
  
  // Caso 1: Conjuntos difusos idénticos que deberían ser iguales
  test("igualdad - conjuntos idénticos") {
    val cd1: Int => Double = x => Math.sin(x * 0.01)
    val cd2: Int => Double = x => Math.sin(x * 0.01)
    assert(objConjuntosDifusos.igualdad(cd1, cd2))
  }
  
  // Caso 2: Conjuntos difusos con valores similares pero ligeramente diferentes
  test("igualdad - conjuntos con valores similares") {
    val cd1: Int => Double = x => Math.sin(x * 0.01)
    val cd2: Int => Double = x => Math.sin(x * 0.01) + 0.0001 // Diferencia mínima
    assert(!objConjuntosDifusos.igualdad(cd1, cd2))
  }
  
  // Caso 3: Conjuntos difusos con una simetría invertida (inversión de signo en los valores)
  test("igualdad - conjuntos invertidos") {
    val cd1: Int => Double = x => Math.cos(x * 0.01)
    val cd2: Int => Double = x => -Math.cos(x * 0.01)
    assert(!objConjuntosDifusos.igualdad(cd1, cd2))
  }
  
  // Caso 4: Conjuntos difusos donde uno está contenido en otro pero no son iguales
  test("igualdad - subconjunto") {
    val cd1: Int => Double = x => Math.abs(Math.sin(x * 0.01))
    val cd2: Int => Double = x => if (x % 2 == 0) Math.abs(Math.sin(x * 0.01)) else 0.0
    assert(!objConjuntosDifusos.igualdad(cd1, cd2))
  }
  
  // Caso 5: Conjuntos difusos no triviales que resultan en igualdad solo en un rango parcial
  test("igualdad - igualdad parcial en rango") {
    val cd1: Int => Double = x => if (x < 500) 0.5 else Math.sin(x * 0.01)
    val cd2: Int => Double = x => if (x < 500) 0.5 else Math.sin(x * 0.01)
    assert(objConjuntosDifusos.igualdad(cd1, cd2))
  }
}