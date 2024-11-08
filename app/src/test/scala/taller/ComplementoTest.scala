package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ComplementoTest extends AnyFunSuite {
  
  val objConjuntosDifusos = new ConjuntosDifusos()

  test("Complemento de un conjunto debe retornar valores entre 0 y 1") {
    val conjunto = objConjuntosDifusos.grande(6, 2)
    val complementoConj = objConjuntosDifusos.complemento(conjunto)
    
    // Probamos varios valores para asegurarnos que están en el rango [0,1]
    val valores = List(0, 5, 10, 15, 20)
    valores.foreach { x =>
      val resultado = objConjuntosDifusos.pertenece(x, complementoConj)
      assert(resultado >= 0.0 && resultado <= 1.0)
    }
  }

  test("Complemento del complemento debe ser aproximadamente igual al conjunto original") {
    val conjunto = objConjuntosDifusos.grande(4, 1)
    val complementoDoble = objConjuntosDifusos.complemento(objConjuntosDifusos.complemento(conjunto))
    
    // Verificamos para algunos valores que el doble complemento es igual al original
    val x = 10
    val valorOriginal = objConjuntosDifusos.pertenece(x, conjunto)
    val valorComplementoDoble = objConjuntosDifusos.pertenece(x, complementoDoble)
    assert(Math.abs(valorOriginal - valorComplementoDoble) < 0.0001)
  }

  test("Suma de un conjunto y su complemento debe ser aproximadamente 1") {
    val conjunto = objConjuntosDifusos.grande(6, 3)
    val complementoConj = objConjuntosDifusos.complemento(conjunto)
    
    // Probamos que la suma sea aproximadamente 1 para varios valores
    val x = 7
    val suma = objConjuntosDifusos.pertenece(x, conjunto) + 
               objConjuntosDifusos.pertenece(x, complementoConj)
    assert(Math.abs(suma - 1.0) < 0.0001)
  }

  test("Complemento de un conjunto con grado de pertenencia 1 debe ser 0") {
    val conjunto = objConjuntosDifusos.grande(1, 1) // Este conjunto tendrá valores cercanos a 1 para números grandes
    val complementoConj = objConjuntosDifusos.complemento(conjunto)
    
    val x = 100 // Un número suficientemente grande para tener pertenencia cercana a 1
    val valorOriginal = objConjuntosDifusos.pertenece(x, conjunto)
    val valorComplemento = objConjuntosDifusos.pertenece(x, complementoConj)
    
    assert(valorOriginal > 0.99) // El valor original debe ser cercano a 1
    assert(valorComplemento < 0.01) // El complemento debe ser cercano a 0
  }

  test("Complemento de un conjunto con valores negativos debe ser 1") {
    val conjunto = objConjuntosDifusos.grande(7, 3)
    val complementoConj = objConjuntosDifusos.complemento(conjunto)
    
    val valorComplemento = objConjuntosDifusos.pertenece(-1, complementoConj)
    assert(Math.abs(valorComplemento - 1.0) < 0.0001)
  }
}