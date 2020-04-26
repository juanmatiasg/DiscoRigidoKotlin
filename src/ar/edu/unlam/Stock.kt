package ar.edu.unlam

import java.util.*
import kotlin.collections.ArrayList


class Stock {
    var listaDeProducto:TreeSet<Producto>

    init{
        listaDeProducto= TreeSet<Producto>()
    }

    fun agregarProductos(productos:Producto){
        if(!this.listaDeProducto.contains(productos)){
            this.listaDeProducto.add(productos)
        }
        else{
            throw Exception("Este Producto ya existe")
        }
    }

    fun eliminarProductos(productos:Producto) {
        if(this.listaDeProducto.contains(productos)){
            this.listaDeProducto.remove(productos)
        }
        else{
            throw Exception("El producto no se puede eliminar por que no existe en la lista")
        }
    }

    fun getListaDeproductos():Set<Producto>{
        return this.listaDeProducto
    }

    fun incrementarPrecios(porcentajeIncremento:Double):Unit{
        var producto:Producto

        var ite = this.listaDeProducto.iterator()

        while(ite.hasNext()){
            producto = ite.next()
            producto.precio=producto.precio*1+porcentajeIncremento/100

        }
    }

    fun obtenerListaDiscoRigido():List<DiscoRigido>{

        var listaRigidos = ArrayList<DiscoRigido>()

        for(r:Producto in listaDeProducto){
            if(r is DiscoRigido){
                listaRigidos.add(r)
            }
        }
        return listaRigidos
    }

    fun descontarProductos(cantidadDescontar:Int,idProducto:Int){
        var contable:Iterator<Producto> = this.listaDeProducto.iterator()
        var p:Producto
        var stockActual:Int

        if(cantidadDescontar<0){
            throw CantidadInvalida("La cantidad no puede ser un valor negativo")
        }

        while(contable.hasNext()){
            p=contable.next()

            if(p.id==idProducto){
                stockActual=p.cantDisponible
                if(stockActual>=cantidadDescontar){
                    p.cantDisponible=stockActual-cantidadDescontar
                }
                else{
                    throw SuperaMaximoDescontar("No")
                }
            }
        }
        throw ProductoInexistente("El producto no esta en la lista")
    }




}


