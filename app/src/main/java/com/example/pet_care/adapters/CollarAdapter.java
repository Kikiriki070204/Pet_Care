package com.example.pet_care.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pet_care.R;
import com.example.pet_care.models.CollarModel;
import com.example.pet_care.models.DataModel;

import java.util.List;

public class CollarAdapter extends RecyclerView.Adapter<CollarAdapter.ViewHolder> {
    private List<DataModel> collarList;

    public CollarAdapter(List<DataModel> collarList) {
        this.collarList = collarList;
    }


    @NonNull
    @Override
    public CollarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly=LayoutInflater.from(parent.getContext());
        View v=ly.inflate(R.layout.items_pets_recycle,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CollarAdapter.ViewHolder holder, int position) {
        DataModel data= collarList.get(holder.getAdapterPosition());
        holder.setdata(data);
    }

    @Override
    public int getItemCount() {
        return collarList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView valor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre_sensor);
            valor=itemView.findViewById(R.id.data);
        }
        public void setdata(DataModel data) {
            DataModel dataModel=data;
            nombre.setText(data.feed_key);
            valor.setText(data.value);

        }
    }
}
