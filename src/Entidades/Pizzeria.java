package Entidades;

import java.util.ArrayList;
import java.util.Iterator;

public class Pizzeria implements Iterable<Producto> {

    public String nombre;
    public int capacidad;
    public ArrayList<Producto> productos;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }

    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }

    public boolean sonIguales(Producto p) {
        for (Producto producto : this.productos) {
            if (producto.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public void agregar(Producto p) {
        if (this.productos.size() >= this.capacidad) {
            System.out.println("No se puede agregar. Capacidad máxima alcanzada.");
        } else if (this.sonIguales(p)) {
            System.out.println("El producto ya existe en la pizzería.");
        } else {
            this.productos.add(p);
            System.out.println("Producto agregado exitosamente.");
        }
    }

    public double getPrecioProductos(TipoProducto tipo) {
        double total = 0;
        switch (tipo) {
            case PIZZAS:
                total = this.getPrecioDePizzas();
                break;
            case POSTRES:
                total = this.getPrecioDePostres();
                break;
            case TODOS:
                total = this.getPrecioTotal();
                break;
        }
        return total;
    }

    public double getPrecioDePizzas() {
        double total = 0;
        for (Producto p : this.productos) {
            if (p instanceof Pizza) {
                Pizza pizza = (Pizza) p;
                total += pizza.getPrecioTotal();
            }
        }
        return total;
    }

    public double getPrecioDePostres() {
        double total = 0;
        for (Producto p : this.productos) {
            if (p instanceof Postre) {
                total += ((Postre) p).getPrecioTotal();
            }
        }
        return total;
    }

    public double getPrecioTotal() {
        return this.getPrecioDePizzas() + this.getPrecioDePostres();
    }

    @Override
    public Iterator<Producto> iterator() {
        return this.productos.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Precio Total de Pizzas: $");
        sb.append(this.getPrecioDePizzas());
        sb.append("\n");

        sb.append("Precio Total de Postres: $");
        sb.append(this.getPrecioDePostres());
        sb.append("\n");

        sb.append("PRECIO TOTAL GENERAL: $");
        sb.append(this.getPrecioTotal());
        sb.append("\n");

        sb.append("===== DETALLE DE PRODUCTOS =====\n");
        for (Producto p : this.productos) {
            sb.append(p.toString()).append("\n\n");
        }

        sb.append("===== PRECIOS TOTALES =====\n");
        sb.append("Precio Total de Pizzas: $").append(this.getPrecioDePizzas()).append("\n");
        sb.append("Precio Total de Postres: $").append(this.getPrecioDePostres()).append("\n");
        sb.append("PRECIO TOTAL GENERAL: $").append(this.getPrecioTotal()).append("\n");

        return sb.toString();
    }
}
