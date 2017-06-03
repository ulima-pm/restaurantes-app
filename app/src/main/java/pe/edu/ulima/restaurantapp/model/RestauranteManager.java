package pe.edu.ulima.restaurantapp.model;


import java.util.ArrayList;
import java.util.List;

public class RestauranteManager {
    public List<Categoria> obtenerCategorias(){
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Carnes y Parrillas"));
        categorias.add(new Categoria(2, "Chifas"));
        return categorias;
    }
    public List<Restaurante> obtenerRestaurantes(int codigoCategoria){
        List<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(
                new Restaurante(
                        "RestX",
                        "Direc1",
                        "34343",
                        new Categoria(1, "Carnes y Parrillas")
                )
        );
        return restaurantes;
    }
}
