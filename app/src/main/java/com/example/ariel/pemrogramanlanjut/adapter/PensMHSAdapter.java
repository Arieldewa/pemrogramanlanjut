package com.example.ariel.pemrogramanlanjut.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ariel.pemrogramanlanjut.FormDetailMhs;
import com.example.ariel.pemrogramanlanjut.R;
import com.example.ariel.pemrogramanlanjut.object.PensMHS;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ariel on 5/12/2017.
 */

public class PensMHSAdapter extends RecyclerView.Adapter<PensMHSAdapter.ViewHolder> {
    private ArrayList<PensMHS> data;
    private Context context;

    public PensMHSAdapter() {
    }

    public PensMHSAdapter(ArrayList<PensMHS> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mhs_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nrp.setText(String.valueOf(data.get(position).getNrp()));
        holder.nama.setText(data.get(position).getName());
        holder.jurusan.setText(data.get(position).getJurusan());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nrp;
        private TextView nama;
        private TextView jurusan;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nrp = (TextView) itemView.findViewById(R.id.nrp);
            nama = (TextView) itemView.findViewById(R.id.nama);
            jurusan = (TextView) itemView.findViewById(R.id.jurusan);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(view.getContext(), FormDetailMhs.class);
            i.putExtra("id",data.get(getAdapterPosition()).getNrp());
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
    public void swap(ArrayList<PensMHS> datas){
        data.clear();
        data.addAll(datas);
        notifyDataSetChanged();
    }
}
