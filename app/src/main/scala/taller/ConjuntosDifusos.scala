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
    // Función auxiliar interna para aplicar recursión de cola
    @scala.annotation.tailrec
    def loop(i: Int): Boolean = {
      if (i > 1000) true // Si hemos recorrido todos los elementos hasta 1000, s1 está incluido en s2
      else if (pertenece(i, cd1) > pertenece(i, cd2)) false // Si algún elemento de s1 tiene mayor pertenencia que en s2, no está incluido
      else loop(i + 1) // Continuamos con el siguiente elemento
    }
    loop(0) // Iniciamos la recursión desde 0
  }
  
}
