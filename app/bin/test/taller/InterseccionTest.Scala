package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class InterseccionTest extends AnyFunSuite {
    val objConjuntosDifusos = new ConjuntosDifusos()

    test("La intersección de dos conjuntos con un solo elemento común debe devolver ese elemento") {
        val conjunto1 = Set(1, 2, 3)
        val conjunto2 = Set(3, 4, 5)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == Set(3))
    }

    test("La intersección de dos conjuntos con elementos en diferentes órdenes debe devolver los elementos comunes") {
        val conjunto1 = Set(3, 2, 1)
        val conjunto2 = Set(1, 2, 3)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == Set(1, 2, 3))
    }

    test("La intersección de dos conjuntos con elementos repetidos debe devolver los elementos comunes sin repeticiones") {
        val conjunto1 = Set(1, 1, 2, 2, 3, 3)
        val conjunto2 = Set(2, 2, 3, 3, 4, 4)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == Set(2, 3))
    }

    test("La intersección de dos conjuntos con elementos de diferentes tipos debe devolver los elementos comunes") {
        val conjunto1 = Set(1, "a", 2, "b")
        val conjunto2 = Set("a", "b", 3, 4)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == Set("a", "b"))
    }

    test("La intersección de dos conjuntos con elementos de tipo Option debe devolver los elementos comunes") {
        val conjunto1 = Set(Some(1), None, Some(2))
        val conjunto2 = Set(None, Some(2), Some(3))
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == Set(None, Some(2)))
    }

    test("La intersección de dos conjuntos vacíos debe ser vacía") {
        val conjunto1 = Set.empty[Int]
        val conjunto2 = Set.empty[Int]
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2).isEmpty)
    }

    test("La intersección de un conjunto no vacío y un conjunto vacío debe ser vacía") {
        val conjunto1 = Set(1, 2, 3)
        val conjunto2 = Set.empty[Int]
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2).isEmpty)
    }

    test("La intersección de dos conjuntos sin elementos comunes debe ser vacía") {
        val conjunto1 = Set(1, 2, 3)
        val conjunto2 = Set(4, 5, 6)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2).isEmpty)
    }

    test("La intersección de dos conjuntos con algunos elementos comunes debe devolver los elementos comunes") {
        val conjunto1 = Set(1, 2, 3)
        val conjunto2 = Set(2, 3, 4)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == Set(2, 3))
    }

    test("La intersección de dos conjuntos con todos los elementos comunes debe devolver el mismo conjunto") {
        val conjunto1 = Set(1, 2, 3)
        val conjunto2 = Set(1, 2, 3)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == conjunto1)
    }

    test("La intersección de un conjunto consigo mismo debe devolver el mismo conjunto") {
        val conjunto1 = Set(1, 2, 3)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto1) == conjunto1)
    }

    test("La intersección de un conjunto con un superconjunto debe devolver el conjunto") {
        val conjunto1 = Set(1, 2)
        val conjunto2 = Set(1, 2, 3)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == conjunto1)
    }

    test("La intersección de dos conjuntos con múltiples elementos comunes debe devolver los elementos comunes") {
        val conjunto1 = Set(1, 2, 3, 4)
        val conjunto2 = Set(3, 4, 5, 6)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == Set(3, 4))
    }

    test("La intersección de dos conjuntos con elementos negativos debe devolver los elementos comunes") {
        val conjunto1 = Set(-1, -2, -3)
        val conjunto2 = Set(-3, -4, -5)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == Set(-3))
    }

    test("La intersección de dos conjuntos con elementos duplicados debe devolver los elementos comunes") {
        val conjunto1 = Set(1, 2, 2, 3)
        val conjunto2 = Set(3, 4, 4, 5)
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == Set(3))
    }

    test("La intersección de dos conjuntos grandes debe devolver los elementos comunes") {
        val conjunto1 = (1 to 1000000).toSet
        val conjunto2 = (500000 to 1500000).toSet
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == (500000 to 1000000).toSet)
    }

    test("La intersección de un conjunto grande y un conjunto vacío debe ser vacía") {
        val conjunto1 = (1 to 1000000).toSet
        val conjunto2 = Set.empty[Int]
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2).isEmpty)
    }

    test("La intersección de dos conjuntos grandes con pocos elementos comunes debe devolver los elementos comunes") {
        val conjunto1 = (1 to 1000000).toSet
        val conjunto2 = (1000001 to 2000000).toSet
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2).isEmpty)
    }

    test("La intersección de dos conjuntos grandes con muchos elementos comunes debe devolver los elementos comunes") {
        val conjunto1 = (1 to 1000000).toSet
        val conjunto2 = (500000 to 1500000).toSet
        assert(objConjuntosDifusos.intersect(conjunto1, conjunto2) == (500000 to 1000000).toSet)
    }
}