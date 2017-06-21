package pe.edu.ulima.restaurantapp.model;


import java.util.List;

public interface OnCategoriasCargadasListener {
    public void onCategoriasCargadas(List<Categoria> categorias);
    public void onError(String error);
}
