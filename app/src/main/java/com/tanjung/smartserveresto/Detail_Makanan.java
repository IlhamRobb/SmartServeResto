package com.tanjung.smartserveresto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail_Makanan extends Activity {
    String NamaMakanan, Harga;
    int Gambar;
    int position;
    TextView tvNamaMakanan, tvHarga;
    ImageView imgGambar;
    Button btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__makanan);

        tvNamaMakanan = (TextView)findViewById(R.id.textView4);
        tvHarga = (TextView)findViewById(R.id.textView5);
        imgGambar = (ImageView)findViewById(R.id.imageView2);
        btnPesan = (Button)findViewById(R.id.btnPesan2);

        Intent i = getIntent();
        position = i.getExtras().getInt("position");
        NamaMakanan = i.getStringExtra("NamaMakanan");
        Harga = i.getStringExtra("Harga");
        Gambar = i.getIntExtra("Gambar", Gambar);

        tvNamaMakanan.setText(NamaMakanan);
        tvHarga.setText(Harga);
        imgGambar.setImageResource(Gambar);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://api.whatsapp.com/send?phone=+6282215548119&text=Saya memesan atas nama : \nNomor Meja : \nYang dipesan : "+NamaMakanan+" \nJumlah : \nCatatan :"));
                startActivity(i);
            }
        });
    }
}