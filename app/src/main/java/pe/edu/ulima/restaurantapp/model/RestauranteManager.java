package pe.edu.ulima.restaurantapp.model;


import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestauranteManager {
    public void obtenerCategorias(final OnCategoriasCargadasListener listener){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://miraflores.cloudapi.junar.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestaurantesService service = retrofit.create(RestaurantesService.class);
        service.obtenerCategorias().enqueue(new Callback<CategoriaRespuesta>() {
            @Override
            public void onResponse(Call<CategoriaRespuesta> call,
                                   Response<CategoriaRespuesta> response) {
                //Log.i("RestauranteManager","" + response.body().getResult().size());
                List<Categoria> categorias = new ArrayList<Categoria>();
                for (int i=1; i< response.body().getResult().size(); i++){
                    List<String> categoria = response.body().getResult().get(i);
                    categorias.add(new Categoria(
                            Integer.parseInt(categoria.get(0)),
                            categoria.get(1))
                    );
                }
                listener.onCategoriasCargadas(categorias);
            }

            @Override
            public void onFailure(Call<CategoriaRespuesta> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });

        /*List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Carnes y Parrillas"));
        categorias.add(new Categoria(2, "Chifas"));
        return categorias;*/
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
