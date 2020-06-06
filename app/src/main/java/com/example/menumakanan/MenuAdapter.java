package com.example.menumakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private Context context;
    private ArrayList<Menu> menus;

    public MenuAdapter(Context mcontext, ArrayList<Menu> menumakanan) {
        context = mcontext;
        menus = menumakanan;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);

        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menubaru = menus.get(position);
        final String gambarBaru = menubaru.getGambar();
        final String harga = menubaru.getHarga();
        final String nama = menubaru.getNama();
        final String detail = menubaru.getDetail();

        holder.tvNamaData.setText(nama);
        holder.tvHargaData.setText(harga);
        Glide
                .with(context)
                .load(gambarBaru)
                .centerCrop()
                .into(holder.imData);

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(context, DetailActivity.class);

                detailIntent.putExtra("img_menu", gambarBaru);
                detailIntent.putExtra("nama_menu", nama);
                detailIntent.putExtra("detail_menu", detail);

                context.startActivity(detailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        public ImageView imData;
        public TextView tvNamaData;
        public TextView tvHargaData;
        public Button btnDetail;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            imData = itemView.findViewById(R.id.img_menu);
            tvNamaData = itemView.findViewById(R.id.tv_nama);
            tvHargaData = itemView.findViewById(R.id.tv_harga);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }

}
