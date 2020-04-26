package ar.edu.unlam

open abstract class Producto(val id:Int,var precio:Double,var cantDisponible:Int):Comparable<Producto>{
    abstract fun cantidadDinero():Double



}