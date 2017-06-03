package pe.edu.ulima.restaurantapp.model;

/**
 * Created by sodm on 6/2/2017.
 */

public class Categoria {
    private int codigo;
    private String tipo;

    public Categoria(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
