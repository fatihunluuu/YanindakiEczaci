package com.example.laprospekts;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class isim_arama extends AppCompatActivity {

    EditText aramaYap;
    Mydatabase db;
    ArrayList<Ilaclar> ilacList;
    CustomAdapter customAdapter;
    ArrayList<Ilaclar> yedekList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isim_arama);

        TextView girisText = findViewById(R.id.baslik1);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/plicata.ttf");
        girisText.setTypeface(typeface);

        aramaYap = findViewById(R.id.aramaYap);



        ArrayList<HashMap<String, String>> tumIlaclar = new ArrayList<>();
        ilacList = new ArrayList<>();
        yedekList = new ArrayList<>();


        db = new Mydatabase(this);
        tumIlaclar = db.ilaclar();
        tumIlaclar.sort(new Sirala());

        for(int i=0;i<tumIlaclar.size();i++){
            ilacList.add(new Ilaclar(Long.parseLong(tumIlaclar.get(i).get("barkod")), tumIlaclar.get(i).get("ilac_adi"), tumIlaclar.get(i).get("ilac_fiyat")));
            yedekList.add(new Ilaclar(Long.parseLong(tumIlaclar.get(i).get("barkod")), tumIlaclar.get(i).get("ilac_adi"), tumIlaclar.get(i).get("ilac_fiyat")));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerIlaclar);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);

        customAdapter = new CustomAdapter(ilacList, isim_arama.this);
        recyclerView.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();

       aramaYap.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){ }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count){ }
            @Override
            public void afterTextChanged(Editable edText) {
                if(edText.toString().length()==0){
                    ilacList.clear();
                    for(Ilaclar ilac : yedekList)
                        ilacList.add(ilac);
                    customAdapter.notifyDataSetChanged();
                }
                else
                    filter(edText.toString().toLowerCase());
            }
        });

        }

        private void filter(String text){
            ilacList.clear();
            for(Ilaclar ilac : yedekList){
                if(ilac.getIlacAdi().toLowerCase().contains(text))
                    ilacList.add(ilac);
            }
            customAdapter.notifyDataSetChanged();
        }

    }

