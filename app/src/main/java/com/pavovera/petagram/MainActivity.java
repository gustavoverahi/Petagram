package com.pavovera.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pet> pet;
    private RecyclerView listPets;
    ImageView imgStarIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.actionbarNavBar);
        setSupportActionBar(toolbar);

        listPets = findViewById(R.id.listPetsId);
        imgStarIcon = findViewById(R.id.imgStar);

        LinearLayoutManager linearManager = new LinearLayoutManager(this);
        linearManager.setOrientation(LinearLayoutManager.VERTICAL);

        listPets.setLayoutManager(linearManager);
        initListPets();
        initAdapter();

        onClick(imgStarIcon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public void initAdapter() {
        PetAdapter adapter = new PetAdapter(pet, this);
        listPets.setAdapter(adapter);
    }

    public void initListPets() {
        pet = new ArrayList<Pet>();

        pet.add(new Pet(R.drawable.bulldog, "Rocko", 5));
        pet.add(new Pet(R.drawable.beagle, "Pirlo", 4));
        pet.add(new Pet(R.drawable.chihuahua, "Tomas", 1));
        pet.add(new Pet(R.drawable.husky, "Mimo", 5));
        pet.add(new Pet(R.drawable.pitbull, "Zeus", 3));
        pet.add(new Pet(R.drawable.pug, "Cafe", 2));
    }

    public void onClick(View v) {
        imgStarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavPets.class);
                startActivity(intent);
            }
        });
    }
}
