package com.example.prubea;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView ofertaLaboral, empresa, cargo, correo, descripcion;
        ImageView Img;

        public ViewHolder( View itemView) {
            super(itemView);
            ofertaLaboral=(TextView)itemView.findViewById(R.id.txtOferta);
            empresa=(TextView)itemView.findViewById(R.id.txtEmpresa);
            cargo=(TextView)itemView.findViewById(R.id.txtCargo);
            correo=(TextView)itemView.findViewById(R.id.txtCorreo);
            descripcion=(TextView)itemView.findViewById(R.id.txtDescrip);
            Img = (ImageView) itemView.findViewById(R.id.img_anuncio);
        }
    }
    public List<Datum> Data;

    public AdapterRecycler(List<Datum> data) {
        Data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_anuncio,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.ofertaLaboral.setText(Data.get(position).getOfertaLaboral());
        holder.empresa.setText(Data.get(position).getEmpresa());
        holder.cargo.setText(Data.get(position).getCargo());
        holder.correo.setText(Data.get(position).getCorreo());
        holder.descripcion.setText(Data.get(position).getDescripcion());
        Glide.with(holder.Img.getContext())
                .load(Data.get(position).getImagen())
                .into(holder.Img);
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }
}
