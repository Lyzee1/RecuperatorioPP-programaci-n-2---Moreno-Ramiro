package Entidades;

public class Fabricante {

    private String nombre;
    private String ciudad;
    private int antiguedad;

    public Fabricante(String nombre, String ciudad, int antiguedad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.antiguedad = antiguedad;
    }

    public static boolean sonIguales(Fabricante f1, Fabricante f2) {
        return f1.nombre.equals(f2.nombre) && f1.ciudad.equals(f2.ciudad) && f1.antiguedad == f2.antiguedad;
    }

    private String getInfoFabricante() {
        return "Fabricante: " + this.nombre + " Ciudad: " + this.ciudad + " Antigüedad: " + this.antiguedad + " años";
    }

    @Override
    public String toString() {
        return this.getInfoFabricante();
    }
}
