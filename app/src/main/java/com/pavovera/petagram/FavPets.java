package com.pavovera.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class FavPets extends AppCompatActivity {
    ArrayList<ListFavPets> favPets;
    private RecyclerView listFavPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_pets);

        Toolbar toolbar = findViewById(R.id.actionbarNavBar);
        setSupportActionBar(toolbar);

        listFavPets = findViewById(R.id.listFavPets);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager linearManager = new LinearLayoutManager(this);
        linearManager.setOrientation(LinearLayoutManager.VERTICAL);

        listFavPets.setLayoutManager(linearManager);
        initListFavPets();
        initAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public void initAdapter() {
        PetsFavoriteAdapter adapter = new PetsFavoriteAdapter(favPets, this);
        listFavPets.setAdapter(adapter);
    }

    public void initListFavPets() {
        favPets = new ArrayList<ListFavPets>();

        favPets.add(new ListFavPets(R.drawable.husky, "Mimo", 5));
        favPets.add(new ListFavPets(R.drawable.bulldog, "Rocko", 5));
        favPets.add(new ListFavPets(R.drawable.beagle, "Pirlo", 4));
        favPets.add(new ListFavPets(R.drawable.pitbull, "Zeus", 3));
        favPets.add(new ListFavPets(R.drawable.pug, "Cafe", 2));
    }
}
