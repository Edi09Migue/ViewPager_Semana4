package freezone.ec.petagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MacotaViewHolder>{

    ArrayList<Mascota> mascotas;


    //metodo para contruir las mascotas
    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull

    //inflar el layout y lo pasara al view holder para que obtenga los views
    @Override
    public MacotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MacotaViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MacotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvNumeroCV.setText(mascota.getNumero());

    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MacotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvNumeroCV;



        public MacotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFotoCV   = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV  = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvNumeroCV  = (TextView) itemView.findViewById(R.id.tvNumeroCV);

        }
    }
}
