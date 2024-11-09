package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class InterseccionTests extends AnyFunSuite {

    val objConjuntosDifusos = new ConjuntosDifusos()

    test("Intersección de un conjunto consigo mismo") {
        val conjunto = objConjuntosDifusos.grande(4, 2)
        val interseccion = objConjuntosDifusos.interseccion(conjunto, conjunto)
        assert((0 to 1000).forall(n => interseccion(n) == conjunto(n)))
    }

    test("Intersección de dos conjuntos distintos, grado mínimo en ambos") {
        val conjunto1 = objConjuntosDifusos.grande(3, 2)
        val conjunto2 = objConjuntosDifusos.grande(5, 2)
        val interseccion = objConjuntosDifusos.interseccion(conjunto1, conjunto2)
        assert((0 to 1000).forall(n => interseccion(n) == math.min(conjunto1(n), conjunto2(n))))
    }

    test("Intersección de un conjunto con el conjunto vacío") {
        val conjunto = objConjuntosDifusos.grande(4, 2)
        val conjuntoVacio: objConjuntosDifusos.ConjDifuso = _ => 0.0
        val interseccion = objConjuntosDifusos.interseccion(conjunto, conjuntoVacio)
        assert((0 to 1000).forall(n => interseccion(n) == 0.0))
    }

    test("Intersección de un conjunto con un conjunto universal") {
        val conjunto = objConjuntosDifusos.grande(4, 2)
        val conjuntoUniversal: objConjuntosDifusos.ConjDifuso = _ => 1.0
        val interseccion = objConjuntosDifusos.interseccion(conjunto, conjuntoUniversal)
        assert((0 to 1000).forall(n => interseccion(n) == conjunto(n)))
    }

    test("Intersección de dos conjuntos idénticos, mismos parámetros") {
        val conjunto1 = objConjuntosDifusos.grande(4, 2)
        val conjunto2 = objConjuntosDifusos.grande(4, 2)
        val interseccion = objConjuntosDifusos.interseccion(conjunto1, conjunto2)
        assert((0 to 1000).forall(n => interseccion(n) == conjunto1(n)))
    }

    test("Intersección de dos conjuntos con ligera superposición") {
        val conjunto1 = objConjuntosDifusos.grande(4, 1)
        val conjunto2 = objConjuntosDifusos.grande(6, 1)
        val interseccion = objConjuntosDifusos.interseccion(conjunto1, conjunto2)
        assert((0 to 1000).forall(n => interseccion(n) == math.min(conjunto1(n), conjunto2(n))))
    }

    test("Intersección de dos conjuntos con superposición total") {
        val conjunto1 = objConjuntosDifusos.grande(4, 2)
        val conjunto2 = objConjuntosDifusos.grande(6, 2)
        val interseccion = objConjuntosDifusos.interseccion(conjunto1, conjunto2)
        assert((0 to 1000).forall(n => interseccion(n) == math.min(conjunto1(n), conjunto2(n))))
    }

}
