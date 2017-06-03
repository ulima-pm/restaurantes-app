package pe.edu.ulima.restaurantapp.model;

/**
 * Created by sodm on 6/2/2017.
 */

public class Restaurante {
    private String nombre;
    private String direccion;
    private String telefono;
    private Categoria categoria;

    public Restaurante(String nombre, String direccion, String telefono, Categoria categoria) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
