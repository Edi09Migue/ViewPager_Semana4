package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.MascotaAdaptador;
import freezone.ec.petagram.Mascota;
import freezone.ec.petagram.R;

public class RecyclerviewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    // declaramos nuestro Recycle View
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container,false);

        //Recycler View
        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm  = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        //llamamos al metodo
        inicializarListaMacotas();
        //inicializamos el adaptador
        inicializarAdaptador();


return v;

    }

    //metodo para llenar la lista
    public void inicializarListaMacotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Noe", R.drawable.noe,7,R.drawable.icons8_hueso_del_perro_100,R.drawable.icons8_hueso_del_perro_101));
        mascotas.add(new Mascota("Chiripa", R.drawable.dalmata,5,R.drawable.icons8_hueso_del_perro_100,R.drawable.icons8_hueso_del_perro_101));
        mascotas.add(new Mascota("Dante", R.drawable.malo,4,R.drawable.icons8_hueso_del_perro_100,R.drawable.icons8_hueso_del_perro_101));
        mascotas.add(new Mascota("Max", R.drawable.husky,6,R.drawable.icons8_hueso_del_perro_100,R.drawable.icons8_hueso_del_perro_101));
        mascotas.add(new Mascota("Negro", R.drawable.criollo,3,R.drawable.icons8_hueso_del_perro_100,R.drawable.icons8_hueso_del_perro_101));
        mascotas.add(new Mascota("Veky", R.drawable.may,6,R.drawable.icons8_hueso_del_perro_100,R.drawable.icons8_hueso_del_perro_101));
        mascotas.add(new Mascota("Bolillo", R.drawable.salchicha,2,R.drawable.icons8_hueso_del_perro_100,R.drawable.icons8_hueso_del_perro_101));
        mascotas.add(new Mascota("Pedro", R.drawable.golden,5,R.drawable.icons8_hueso_del_perro_100,R.drawable.icons8_hueso_del_perro_101));

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
}
