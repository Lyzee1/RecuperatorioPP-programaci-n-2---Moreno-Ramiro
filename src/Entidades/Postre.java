package Entidades;

public class Postre extends Producto implements IVendible {

    public TipoPostre tipoPostre;

    public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }

    @Override
    public double getPrecioTotal() {
        double precioTotal = this.precio;
        switch (this.tipoPostre) {
            case TIRAMISU:
                precioTotal *= 1.20;
                break;
            case HELADO:
                precioTotal *= 1.15;
                break;
            case FLAN:
                precioTotal *= 1.10;
                break;
        }
        return precioTotal;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Tipo de Postre: " + this.tipoPostre + "\n" + "Precio Total: $" + this.getPrecioTotal();
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (!(o instanceof Postre)) {
            return false;
        }
        Postre otro = (Postre) o;
        return this.tipoPostre == otro.tipoPostre;
    }
}
