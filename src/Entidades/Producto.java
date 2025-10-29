package Entidades;

import java.util.Random;

public class Producto {

    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio = new Random();

    public Producto(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
        this.calorias = 0;
        this.tiempoPreparacion = 0;
    }

    public Producto(String nombre, double precio, String nombreFabricante,
            String ciudadFabricante, int antiguedadFabricante) {
        this(nombre, precio, new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante));
    }

    public int getCalorias() {
        if (this.calorias == 0) {
            this.calorias = Producto.generadorAleatorio.nextInt(601) + 200;
        }
        return this.calorias;
    }

    public int getTiempoPreparacion() {
        if (this.tiempoPreparacion == 0) {
            this.tiempoPreparacion = Producto.generadorAleatorio.nextInt(16) + 5;
        }
        return this.tiempoPreparacion;
    }

    private static String mostrar(Producto p) {
        return "Nombre: " + p.nombre + "\n" + "Precio Base: $" + p.precio + "\n" + "Calorias: " + p.getCalorias() + "\n"
                + "Tiempo de Preparacion: " + p.getTiempoPreparacion() + " min\n" + p.fabricante;
    }

    private static boolean sonIguales(Producto p1, Producto p2) {
        return p1.nombre.equals(p2.nombre) && Fabricante.sonIguales(p1.fabricante, p2.fabricante);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto otro = (Producto) o;
        return Producto.sonIguales(this, otro);
    }

    @Override
    public String toString() {
        return Producto.mostrar(this);
    }
}
