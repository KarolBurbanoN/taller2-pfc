package taller

class ConjuntosDifusos {
  type ConjDifuso = Int => Double
  def pertenece (elem: Int, s:ConjDifuso): Double = {
    s(elem)
  }

  def grande (d:Int, e:Int): ConjDifuso = {
    // Creamos una función interna que evaluará cada número
    def evaluarGrande(n: Int): Double = {
      // Para evitar división por cero cuando n es negativo
      if (n < 0) 0.0
      else {
        // Calculamos (n/(n+d))^e
        val base = n.toDouble / (n + d).toDouble
        // Usamos Math.pow para elevar a la e
        Math.pow(base, e)
      }
    }
    // Retornamos la función que representa el conjunto difuso
    evaluarGrande
  }

  def complemento(c: ConjDifuso): ConjDifuso = {
    // Creamos una función que calcula el complemento
    def calcularComplemento(x: Int): Double = {
      // El complemento es 1 - f(x)
      1.0 - c(x)
    }
    
    // Retornamos la función que representa el complemento
    calcularComplemento
  }

  def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    // Creamos una función que calcula la unión de dos conjuntos difusos
    def calcularUnion(n: Int): Double = {
      // La unión es el máximo de las pertenencias
      math.max(cd1(n), cd2(n))
    }
    
    // Retornamos la función que representa la unión
    calcularUnion
  }


  def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    // Creamos una función que calcula la intersección de dos conjuntos difusos
    def calcularInterseccion(n: Int): Double = {
      // La intersección es el mínimo de las pertenencias
      math.min(cd1(n), cd2(n))
    }
    
    // Retornamos la función que representa la intersección
    calcularInterseccion
  }

  def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
        @scala.annotation.tailrec
        def loop(s: Int): Boolean = {
          if (s > 1000) true // Finaliza cuando se recorren todos los elementos hasta 1000
          else if (pertenece(s, cd1) > pertenece(s, cd2)) false // Si no cumple la inclusion retorna false
          else loop(s + 1) 
        }
        loop(0) 
      }

      // Función para verificar si dos conjuntos difusos son iguales
      def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
        inclusion(cd1, cd2) && inclusion(cd2, cd1)
      }
    }
