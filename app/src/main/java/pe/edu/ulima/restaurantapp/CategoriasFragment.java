package pe.edu.ulima.restaurantapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import pe.edu.ulima.restaurantapp.adapters.ListadoCategoriasAdapter;
import pe.edu.ulima.restaurantapp.model.Categoria;
import pe.edu.ulima.restaurantapp.model.OnCategoriasCargadasListener;
import pe.edu.ulima.restaurantapp.model.RestauranteManager;

public class CategoriasFragment extends Fragment
        implements AdapterView.OnItemClickListener, OnCategoriasCargadasListener{
    ListView lviCategorias;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lviCategorias = (ListView) getView().findViewById(R.id.lviCategorias);

        new RestauranteManager().obtenerCategorias(this);

        lviCategorias.setOnItemClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categorias, container, false);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Categoria categoria = (Categoria) adapterView.getItemAtPosition(i);
        ((OnCategoriaSelectedListener)getActivity())
                .onCategoriaSelected(categoria.getCodigo());
    }

    @Override
    public void onCategoriasCargadas(List<Categoria> categorias) {
        ListadoCategoriasAdapter adapterCategorias =
                new ListadoCategoriasAdapter(getActivity(), categorias);
        lviCategorias.setAdapter(adapterCategorias);
    }

    @Override
    public void onError(String error) {

    }

    interface OnCategoriaSelectedListener{
        public void  onCategoriaSelected(int codigo);
    }
}
