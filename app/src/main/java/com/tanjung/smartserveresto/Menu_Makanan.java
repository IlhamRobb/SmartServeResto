package com.tanjung.smartserveresto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Menu_Makanan extends AppCompatActivity {
    ListView lvMakanan;
    EditText edtCari;
    AdapterCall adapter;
    ArrayList<AdapterMenu> arrayList = new ArrayList<AdapterMenu>();

    int[] Gambar;
    String[] NamaMakanan;
    String[] Harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__makanan);

        lvMakanan = (ListView)findViewById(R.id.listview1);
        edtCari = (EditText)findViewById(R.id.editText1);

        Gambar = new int[] {
                R.mipmap.miebiasa,
                R.mipmap.mietelur,
                R.mipmap.mieayam,
                R.mipmap.miecumi,
                R.mipmap.miecumiudang,
                R.mipmap.miedaging,
                R.mipmap.sopbetawikambing,
                R.mipmap.sopbetawisapi,
                R.mipmap.miespesial,
                R.mipmap.timunserut,
                R.mipmap.bandrekori,
                R.mipmap.bandreksusu,
                R.mipmap.kopisangerori,
                R.mipmap.kopisangeracehsusu
        };

        NamaMakanan = new String[] {
                "Mie Aceh Goreng Biasa",
                "Mie Aceh Goreng + Telur",
                "Mie Aceh Goreng + Ayam",
                "Mie Aceh Goreng + Cumi",
                "Mie Aceh Goreng + Udang",
                "Mie Aceh Goreng + Daging Sapi",
                "Mie Aceh Goreng Special",
                "Sop Betawi Daging Kambing",
                "Sop Betawi Daging Sapi",
                "Timun Serut",
                "Bandrek Original",
                "Bandrek + Susu",
                "Kopi Sanger Aceh Original",
                "Kopi Sanger Aceh + Susu"
        };
        Harga = new String[] {
                "Rp. 18.000",
                "Rp. 20.000",
                "Rp. 22.000",
                "Rp. 25.000",
                "Rp. 25.000",
                "Rp. 25.000",
                "Rp. 45.000",
                "Rp. 25.000",
                "Rp. 30.000",
                "Rp. 10.000",
                "Rp. 7.000",
                "Rp. 10.000",
                "Rp. 12.000",
                "Rp. 15.000",
        };

        for (int i = 0; i < NamaMakanan.length; i++) {
            AdapterMenu wp = new AdapterMenu(NamaMakanan[i], Harga[i], Gambar[i]);
            arrayList.add(wp);
        }

        adapter = new AdapterCall(this, arrayList);
        lvMakanan.setAdapter(adapter);

        edtCari.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                String text = edtCari.getText().toString().toUpperCase(Locale.getDefault());
                adapter.filter(text);
                showToastMessage("Pencarian Berhasil");
            }
        });
    }
    void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}