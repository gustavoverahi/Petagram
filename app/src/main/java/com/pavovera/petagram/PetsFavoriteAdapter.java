package com.pavovera.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PetsFavoriteAdapter extends RecyclerView.Adapter<PetsFavoriteAdapter.PetsFavoriteViewHolder> {
    private ArrayList<ListFavPets> listFavPets;
    Activity activity;

    public PetsFavoriteAdapter(ArrayList<ListFavPets> listFavPets, Activity activity) {
        this.listFavPets = listFavPets;
        this.activity = activity;
    }

    static class PetsFavoriteViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatarPet, imgBoneNickNameDog, imgBoneGoldRaiting;
        TextView nickNameDog, numRaitingPet;

        public PetsFavoriteViewHolder(@NonNull View itemView) {
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
    public PetsFavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_favorite_pets, parent, false);
        return new PetsFavoriteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetsFavoriteViewHolder holder, int position) {
        final ListFavPets FavPets = listFavPets.get(position);
        holder.imgAvatarPet.setImageResource(FavPets.getImgAvatarPet());
        holder.nickNameDog.setText(FavPets.getNickName());
        holder.numRaitingPet.setText(toString().valueOf(FavPets.getRaiting()));
    }

    @Override
    public int getItemCount() {
        return listFavPets.size();
    }
}
