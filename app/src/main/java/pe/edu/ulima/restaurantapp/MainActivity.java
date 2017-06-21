package pe.edu.ulima.restaurantapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
    implements CategoriasFragment.OnCategoriaSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);

        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT){
            // Se cargaran Fragment categorias

            CategoriasFragment fragment = new CategoriasFragment();
            FragmentManager fmanager = getFragmentManager();
            fmanager.popBackStack();
            FragmentTransaction ft = fmanager.beginTransaction();
            ft.add(R.id.flaContenido2, fragment);
            ft.commit();
        }else{
            // Se cargaran los dos fragments
            CategoriasFragment categoriasFragment = new CategoriasFragment();
            RestaurantesFragment restaurantesFragment = new RestaurantesFragment();

            Bundle bundle = new Bundle();
            bundle.putInt("CODIGO", 0);
            restaurantesFragment.setArguments(bundle);

            FragmentManager fMan = getFragmentManager();
            fMan.popBackStack();
            FragmentTransaction ft = fMan.beginTransaction();
            ft.add(R.id.flaCategorias, categoriasFragment);
            ft.add(R.id.flaContenido, restaurantesFragment);
            ft.commit();
        }
    }

    @Override
    public void onCategoriaSelected(int codigo) {
        // Este es el metodo que se va a ejecutar, cuando
        // se seleccione una categoria del fragment
        RestaurantesFragment fragmentRestaurantes =
                new RestaurantesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("CODIGO", codigo);
        fragmentRestaurantes.setArguments(bundle);

        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT) {

            FragmentManager fManager = getFragmentManager();
            FragmentTransaction ft = fManager.beginTransaction();
            ft.replace(R.id.flaContenido2, fragmentRestaurantes);
            ft.addToBackStack(null);
            ft.commit();
        }else{
            FragmentManager fManager = getFragmentManager();
            FragmentTransaction ft = fManager.beginTransaction();
            ft.replace(R.id.flaContenido, fragmentRestaurantes);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
