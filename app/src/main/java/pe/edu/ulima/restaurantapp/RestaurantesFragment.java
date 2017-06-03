package pe.edu.ulima.restaurantapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import pe.edu.ulima.restaurantapp.adapters.ListadoRestaurantesAdapter;
import pe.edu.ulima.restaurantapp.model.Restaurante;
import pe.edu.ulima.restaurantapp.model.RestauranteManager;

public class RestaurantesFragment extends Fragment{
    ListView lviRestaurantes;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lviRestaurantes = (ListView) getView().findViewById(R.id.lviRestaurantes);

        int codigo = getArguments().getInt("CODIGO");

        List<Restaurante> restaurantes =
                new RestauranteManager().obtenerRestaurantes(codigo);
        ListadoRestaurantesAdapter adapterRestaurantes =
                new ListadoRestaurantesAdapter(getActivity(), restaurantes);
        lviRestaurantes.setAdapter(adapterRestaurantes);
    }

    @Nullable
    @Override    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_restaurantes, container, false);
    }
}

