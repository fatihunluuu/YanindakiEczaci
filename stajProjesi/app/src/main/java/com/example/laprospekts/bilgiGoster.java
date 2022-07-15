package com.example.laprospekts;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class bilgiGoster extends AppCompatActivity {

    private ImageView ilacResim;
    private TextView ilacAdi, ilacFiyat, ilacFirma, kAmaci, yanEtki, kullanimDurum, kullanimTalimat, etkenMadde;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgi_goster);

        TextView baslik = findViewById(R.id.baslik1);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/plicata.ttf");
        baslik.setTypeface(typeface);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        ilacResim = findViewById(R.id.ilac_resim);
        ilacAdi = findViewById(R.id.ilac_adi);
        ilacFiyat = findViewById(R.id.ilac_fiyat);
        ilacFirma = findViewById(R.id.ilac_firma);
        kAmaci = findViewById(R.id.kAmaci);
        yanEtki = findViewById(R.id.yanEtki);
        kullanimDurum = findViewById(R.id.kullanmaDurumlar);
        kullanimTalimat = findViewById(R.id.kullanmaTavsiyesi);
        etkenMadde = findViewById(R.id.etkenMadde);

        Intent intent = getIntent();
        Mydatabase db = new Mydatabase(bilgiGoster.this);
        HashMap<String, String> ilac = db.ilacDetay(intent.getExtras().getLong("barkod"));
        HashMap<String, String> firma = db.firmaDetay(intent.getExtras().getLong("barkod"));

        int src = getApplicationContext().getResources().getIdentifier("s" + intent.getExtras().getLong("barkod"), "mipmap", getApplicationContext().getPackageName());
        ilacResim.setImageResource(src);
        ilacAdi.setText(ilac.get("ilac_adi"));
        ilacFiyat.setText("Fiyat : " + ilac.get("ilac_fiyat"));
        ilacFirma.setText(firma.get("firma_adi"));
        kAmaci.setText(ilac.get("kullanimAmaci"));
        yanEtki.setText(ilac.get("yanEtki"));
        kullanimDurum.setText(ilac.get("kullanilmamasiGereken"));
        kullanimTalimat.setText(ilac.get("kTalimati"));
        etkenMadde.setText(ilac.get("etkenMadde"));

        ilacFirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle(ilac.get("ilac_adi"));
                builder.setMessage("Firma adi : " + firma.get("firma_adi") + "\n" + "Adres : " + firma.get("adres") + "\n" + "Telefon : " + firma.get("telefon") + "\n" + "Mail : " + firma.get("mail"));
                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog = builder.create();
                dialog.show();
            }
        });
    }

}