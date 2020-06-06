package com.example.menumakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView img_menu;
    TextView nama_menu;
    TextView detail_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        img_menu = findViewById(R.id.img_detail);
        nama_menu = findViewById(R.id.tv_nama_detail);
        detail_menu = findViewById(R.id.tv_detail);

        getIncomingExtra();
    }

    private void getIncomingExtra() {
        if (
                getIntent().hasExtra("img_menu") &&
                getIntent().hasExtra("nama_menu") &&
                getIntent().hasExtra("detail_menu")
        ) {
            String imgFramework = getIntent().getStringExtra("img_menu");
            String namaFramework = getIntent().getStringExtra("nama_menu");
            String detailFramework = getIntent().getStringExtra("detail_menu");

            setDataActivity(imgFramework, namaFramework, detailFramework);
        }
    }

    private void setDataActivity(String img, String nama, String detail) {
        Glide.with(this).asBitmap().load(img).into(img_menu);
        nama_menu.setText(nama);
        detail_menu.setText(detail);
    }
}
