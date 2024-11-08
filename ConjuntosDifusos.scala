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

def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
      @scala.annotation.tailrec
      def auxInclusion(s: Int): Boolean = {
        if (s > 1000) true // Finaliza cuando se recorren todos los elementos hasta 1000
        else if (pertenece(s, cd1) > pertenece(s, cd2)) false // Si no cumple la inclusion retorna false
        else auxInclusion(s + 1) 
      }
      auxInclusion(0) 
    }

    // Función para verificar si dos conjuntos difusos son iguales
    def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
      inclusion(cd1, cd2) && inclusion(cd2, cd1)
    }
  }