package pe.edu.ulima.restaurantapp.model;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestaurantesService {
    @GET("api/v2/datastreams/TIPO-DE-RESTA/data.ajson/?auth_key=f6ee57987a1800e145bf886bf50ec8cc77bbad53&limit=50")
    public Call<CategoriaRespuesta> obtenerCategorias();
}
