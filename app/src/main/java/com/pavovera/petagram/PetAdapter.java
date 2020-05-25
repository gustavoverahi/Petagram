package com.pavovera.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {
    private ArrayList<Pet> pets;
    private Activity activity;

    PetAdapter(ArrayList<Pet> pets, Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    static class PetViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatarPet, imgBoneNickNameDog, imgBoneGoldRaiting;
        TextView nickNameDog, numRaitingPet;

        PetViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatarPet = itemView.findViewById(R.id.imgAvatarPet);
            imgBoneNickNameDog = itemView.findViewById(R.id.imgBoneNickNameDog);
            imgBoneGoldRaiting = itemView.findViewById(R.id.imgBoneGoldRaiting);
            nickNameDog = itemView.findViewById(R.id.nickNameDog);
            numRaitingPet = itemView.findViewById(R.id.numRaitingPet);
        }
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pet, parent, false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PetViewHolder holder, int position) {
        final Pet pet = pets.get(position);
        holder.imgAvatarPet.setImageResource(pet.getImgAvatarPet());
        holder.nickNameDog.setText(pet.getNickName());
        holder.numRaitingPet.setText(toString().valueOf(pet.getRaiting()));

        holder.imgBoneNickNameDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Te gusta " + pet.getNickName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return (pets == null) ? 0 : pets.size();
    }
}
