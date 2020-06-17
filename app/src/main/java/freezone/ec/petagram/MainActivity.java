package freezone.ec.petagram;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.ScriptIntrinsicColorMatrix;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    // declaramos nuestro Recycle View
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //llamamos al metodo toolbar
        metodoToolbar();
        //metodo para cambiar el icono izquierda por defecto de toolbar y  cambiar el color
        cambiarIcono(R.drawable.icons8_huella_de_perro_64,R.color.colorTextoIconos);


        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        LinearLayoutManager llm  = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        //llamamos al metodo
        inicializarListaMacotas();
        //inicializamos el adaptador
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    //metodo para llenar la lista
    public void inicializarListaMacotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Chiripa", R.drawable.dalmata,5));
        mascotas.add(new Mascota("Dante", R.drawable.malo,4));
        mascotas.add(new Mascota("Max", R.drawable.husky,6));
        mascotas.add(new Mascota("Noe", R.drawable.noe,7));
        mascotas.add(new Mascota("Negro", R.drawable.criollo,3));
        mascotas.add(new Mascota("Veky", R.drawable.may,6));
        mascotas.add(new Mascota("Bolillo", R.drawable.salchicha,2));
        mascotas.add(new Mascota("Pedro", R.drawable.golden,5));

    }

    //metodo toolbar
    private void metodoToolbar(){
        //es necesario declarar el actionbar para que funcione en todas las pantallas
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);
        //creamos el icono Huella
        iconoHuella();
    }
    //creamos el icono izquierda por la huella
    private void  iconoHuella(){
        //acción distinto de null para evitar problemas icono por defecto de flecha editamos por la estrella
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    //metodo para cambiar el icono izquierda por la huella y color
private void cambiarIcono(int drawable,int color){
        if(getSupportActionBar()!=null){
            final Drawable icon = getResources().getDrawable(drawable);
            icon.setColorFilter(getResources().getColor(color),PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(icon);
        }

    }
    //manejamos el menu del toolbar
    //sobreescribimos el metodo

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.menu, menu);

       //cambiar el color del icono izquierda a blanco
       menuIconColor(menu, R.color.colorTextoIconos);

        return super.onCreateOptionsMenu(menu);
   }

   //metodo para cambiar de color al icono que proviene del menu
    public void  menuIconColor(Menu menu,int color){
        for(int i=0; i<menu.size(); i++){
            Drawable drawable = menu.getItem(i).getIcon();
            if(drawable != null){
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    //metodo para dar el evento de un icono de estrella
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.icon_estrella:
                Intent intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }

}