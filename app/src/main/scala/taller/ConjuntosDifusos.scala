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

}
