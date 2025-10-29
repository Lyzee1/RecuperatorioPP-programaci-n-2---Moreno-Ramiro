package Entidades;

public class Pizza extends Producto implements IVendible {

    public TipoPizza sabor;
    public TamanoPizza tamano;

    public Pizza(String nombre, double precio, Fabricante fabricante, TipoPizza sabor, TamanoPizza tamano) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.tamano = tamano;
    }

    @Override
    public double getPrecioTotal() {
        double precioTotal = this.precio;
        switch (this.tamano) {
            case CHICA:
                precioTotal *= 1.05;
                break;
            case MEDIANA:
                precioTotal *= 1.10;
                break;
            case GRANDE:
                precioTotal *= 1.20;
                break;
        }
        return precioTotal;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Sabor: " + this.sabor + "\n" + "Tamaño: " + this.tamano + "\n" + "Precio Total: $" + this.getPrecioTotal();
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (!(o instanceof Pizza)) {
            return false;
        }
        Pizza otra = (Pizza) o;
        return this.sabor == otra.sabor && this.tamano == otra.tamano;
    }
}
