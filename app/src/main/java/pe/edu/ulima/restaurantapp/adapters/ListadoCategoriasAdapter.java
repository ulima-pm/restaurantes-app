package pe.edu.ulima.restaurantapp.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pe.edu.ulima.restaurantapp.R;
import pe.edu.ulima.restaurantapp.model.Categoria;

public class ListadoCategoriasAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private List<Categoria> mCategorias;

    public ListadoCategoriasAdapter(
            Context context, List<Categoria> categorias){
        mCategorias = categorias;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mCategorias.size();
    }

    @Override
    public Object getItem(int i) {
        return mCategorias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mCategorias.get(i).getCodigo();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = mInflater.inflate(R.layout.item_categoria, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.tviNombreCategoria =
                    (TextView) view.findViewById(R.id.tviNombreCategoria);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Categoria categoria = mCategorias.get(i);
        viewHolder.tviNombreCategoria.setText(categoria.getTipo());

        return view;
    }
    class ViewHolder{
        TextView tviNombreCategoria;
    }
}
