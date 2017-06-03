package pe.edu.ulima.restaurantapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pe.edu.ulima.restaurantapp.R;
import pe.edu.ulima.restaurantapp.model.Restaurante;

/**
 * Created by sodm on 6/2/2017.
 */

public class ListadoRestaurantesAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Restaurante> mRestaurantes;

    public ListadoRestaurantesAdapter(Context context, List<Restaurante> restaurantes){
        mInflater = LayoutInflater.from(context);
        mRestaurantes = restaurantes;
    }
    @Override
    public int getCount() {
        return mRestaurantes.size();
    }

    @Override
    public Object getItem(int i) {
        return mRestaurantes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null){
            view = mInflater.inflate(R.layout.item_restaurante, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.tviNombreRestaurante =
                    (TextView) view.findViewById(R.id.tviNombreRestaurante);
            viewHolder.tviDireccionRestaurante =
                    (TextView) view.findViewById(R.id.tviDireccionRestaurante);
            viewHolder.tviTelefonoRestaurante =
                    (TextView) view.findViewById(R.id.tviTelefonoRestaurante);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Restaurante restaurante = mRestaurantes.get(i);
        viewHolder.tviNombreRestaurante.setText(restaurante.getNombre());
        viewHolder.tviDireccionRestaurante.setText(restaurante.getDireccion());
        viewHolder.tviTelefonoRestaurante.setText(restaurante.getTelefono());


        return view;
    }
    class ViewHolder{
        TextView tviNombreRestaurante;
        TextView tviDireccionRestaurante;
        TextView tviTelefonoRestaurante;
    }
}
