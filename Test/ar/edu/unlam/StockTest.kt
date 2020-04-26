package ar.edu.unlam

import org.junit.Assert.*
import org.junit.Test
import java.lang.Exception

class StockTest{
    @Test(expected = Exception::class)
    fun verificarQueLanceUnaExcepcionSiElProductoEstaDuplicado(){
        var seagate: Producto = DiscoRigido(1, 2000.0, 2, 500.0)
        var toshiba: Producto = DiscoRigido(2, 3000.0, 5, 750.0)
        var western: Producto = DiscoRigido(3, 3500.0, 1, 500.0)
        var musimundo: Stock = Stock()

        musimundo.agregarProductos(seagate)
        musimundo.agregarProductos(seagate)
    }

    @Test(expected = Exception::class)
    fun verificarQueAlEliminarUnProductoInexistenteLanceUnaExcepcion(){
        var seagate: Producto = DiscoRigido(1, 2000.0, 2, 500.0)
        var toshiba: Producto = DiscoRigido(2, 3000.0, 5, 750.0)
        var western: Producto = DiscoRigido(3, 3500.0, 1, 500.0)
        var musimundo: Stock = Stock()

        musimundo.eliminarProductos(seagate)
    }

    @Test()
    fun verificarLaListaDeDiscoRigido(){
        var seagate: Producto = DiscoRigido(1, 2000.0, 2, 500.0)
        var toshiba: Producto = DiscoRigido(2, 3000.0, 5, 750.0)
        var western: Producto = DiscoRigido(3, 3500.0, 1, 500.0)
        var musimundo: Stock = Stock()

        musimundo.agregarProductos(seagate)
        musimundo.agregarProductos(toshiba)
        musimundo.agregarProductos(western)

        var valorObtenido:Int = musimundo.obtenerListaDiscoRigido().size
        var valorEsperado:Int = 3

        assertEquals(valorObtenido,valorEsperado)
    }
}