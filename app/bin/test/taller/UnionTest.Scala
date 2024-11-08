package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class UnionTest extends AnyFunSuite {
    val objConjuntosDifusos = new ConjuntosDifusos()

    test("La unión de dos conjuntos vacíos debe ser vacía") {
        val conjunto1 = Set.empty[Int]
        val conjunto2 = Set.empty[Int]
        assert(objConjuntosDifusos.union(conjunto1, conjunto2).isEmpty)
    }

    test("La unión de un conjunto con un conjunto vacío debe ser el mismo conjunto") {
        val conjunto1 = Set(1, 2, 3)
        val conjunto2 = Set.empty[Int]
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == conjunto1)
    }

    test("La unión de dos conjuntos sin elementos comunes debe contener todos los elementos") {
        val conjunto1 = Set(1, 2, 3)
        val conjunto2 = Set(4, 5, 6)
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == Set(1, 2, 3, 4, 5, 6))
    }

    test("La unión de dos conjuntos con algunos elementos comunes debe contener todos los elementos únicos") {
        val conjunto1 = Set(1, 2, 3)
        val conjunto2 = Set(3, 4, 5)
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == Set(1, 2, 3, 4, 5))
    }

    test("La unión de dos conjuntos con todos los elementos comunes debe ser igual a cualquiera de los conjuntos") {
        val conjunto1 = Set(1, 2, 3)
        val conjunto2 = Set(1, 2, 3)
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == conjunto1)
    }

    test("La unión de un conjunto consigo mismo debe ser el mismo conjunto") {
        val conjunto1 = Set(1, 2, 3)
        assert(objConjuntosDifusos.union(conjunto1, conjunto1) == conjunto1)
    }

    test("La unión de un conjunto con un superconjunto debe ser el superconjunto") {
        val conjunto1 = Set(1, 2)
        val conjunto2 = Set(1, 2, 3)
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == conjunto2)
    }

    test("La unión de dos conjuntos con múltiples elementos comunes debe contener todos los elementos únicos") {
        val conjunto1 = Set(1, 2, 3, 4)
        val conjunto2 = Set(3, 4, 5, 6)
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == Set(1, 2, 3, 4, 5, 6))
    }

    test("La unión de dos conjuntos con elementos negativos debe contener todos los elementos únicos") {
        val conjunto1 = Set(-1, -2, -3)
        val conjunto2 = Set(-3, -4, -5)
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == Set(-1, -2, -3, -4, -5))
    }

    test("La unión de dos conjuntos con elementos duplicados debe contener todos los elementos únicos") {
        val conjunto1 = Set(1, 2, 2, 3)
        val conjunto2 = Set(3, 4, 4, 5)
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == Set(1, 2, 3, 4, 5))
    }
    
    test("La unión de dos conjuntos grandes debe contener todos los elementos únicos") {
        val conjunto1 = (1 to 1000000).toSet
        val conjunto2 = (500000 to 1500000).toSet
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == (1 to 1500000).toSet)
    }

    test("La unión de un conjunto grande con un conjunto vacío debe ser el conjunto grande") {
        val conjunto1 = (1 to 1000000).toSet
        val conjunto2 = Set.empty[Int]
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == conjunto1)
    }

    test("La unión de dos conjuntos grandes con pocos elementos comunes debe contener todos los elementos únicos") {
        val conjunto1 = (1 to 1000000).toSet
        val conjunto2 = (1000001 to 2000000).toSet
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == (1 to 2000000).toSet)
    }

    test("La unión de dos conjuntos grandes con muchos elementos comunes debe contener todos los elementos únicos") {
        val conjunto1 = (1 to 1000000).toSet
        val conjunto2 = (500000 to 1500000).toSet
        assert(objConjuntosDifusos.union(conjunto1, conjunto2) == (1 to 1500000).toSet)
    }
}
