package com.example.pet_care.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pet_care.R;
import com.example.pet_care.listeners.PetListener;
import com.example.pet_care.models.Pet;

import java.util.List;

import kotlin.jvm.internal.Lambda;

public class MyPetsAdapter extends RecyclerView.Adapter<MyPetsAdapter.ViewHolder> {

    private List<Pet> mypetList;
    private PetListener petListener;

    public MyPetsAdapter(List<Pet> mypetList, PetListener petListener) {
        this.mypetList = mypetList;
        this.petListener = petListener;
    }

    @NonNull
    @Override
    public MyPetsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly=LayoutInflater.from(parent.getContext());
        View v=ly.inflate(R.layout.mypets_recycle,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPetsAdapter.ViewHolder holder, int position) {
        Pet pet=mypetList.get(holder.getAdapterPosition());
        holder.setdata(pet);

        holder.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petListener.onClick(mypetList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mypetList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, id_pet;
        CardView profile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.tvDogoname);
            id_pet=itemView.findViewById(R.id.pet_id);
            profile=itemView.findViewById(R.id.pet_prof);
        }

        public void setdata(Pet pet) {
            Pet p=pet;
            nombre.setText(p.nombre);
            id_pet.setText(String.valueOf(p.id_mascota));
        }
    }
}
