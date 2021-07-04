package com.tanjung.smartserveresto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class AdapterCall extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private List<AdapterMenu> viewadapterlist = null;
    private ArrayList<AdapterMenu> arraylist;

    public AdapterCall (Context context,List<AdapterMenu> viewadapterlist) {
        mContext = context;
        this.viewadapterlist = viewadapterlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<AdapterMenu>();
        this.arraylist.addAll(viewadapterlist);
    }

    public class ViewHolder {
        TextView NamaMakanan;
        ImageView Gambar;
    }

    @Override
    public int getCount() {
        return viewadapterlist.size();
    }

    @Override
    public AdapterMenu getItem(int position) {
        return viewadapterlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
     public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.menu_list, null);
            holder.NamaMakanan = (TextView) view.findViewById(R.id.textView6);
            holder.Gambar = (ImageView) view.findViewById(R.id.imageView3);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.NamaMakanan.setText(viewadapterlist.get(position).getNamaMakanan());
        holder.Gambar.setImageResource(viewadapterlist.get(position).getGambar());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Detail_Makanan.class);
                intent.putExtra("NamaMakanan", (viewadapterlist.get(position).getNamaMakanan()));
                intent.putExtra("Harga", (viewadapterlist.get(position).getHarga()));
                intent.putExtra("Gambar", (viewadapterlist).get(position).getGambar());

                mContext.startActivity(intent);
            }
        });
        return view;
     }

     public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        viewadapterlist.clear();
        if (charText.length() == 0) {
            viewadapterlist.addAll(arraylist);
        } else {
            for (AdapterMenu wp : arraylist) {
                if (wp.getNamaMakanan().toLowerCase(Locale.getDefault()).contains(charText)) {
                    viewadapterlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
     }
}
