package ar.edu.unlam

class DiscoRigido (id:Int,precio:Double,cantDisponible:Int,var capacidadEnMb:Double):Producto(id,precio,cantDisponible){

    override fun cantidadDinero(): Double {
        return cantDisponible*precio
    }

    override fun compareTo(other: Producto): Int {
        return this.id.compareTo(other.id)
    }


}