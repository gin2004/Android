package com.example.myapplication;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.model.Phong;


import java.util.List;


public class PhongAdapter extends RecyclerView.Adapter<PhongAdapter.PhongViewHolder> {


    private Context context;
    private List<Phong> phongList;
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(Phong phong, int position);
        void onDeleteClick(Phong phong, int position);
    }


    public PhongAdapter(Context context, List<Phong> phongList, OnItemClickListener listener) {
        this.context = context;
        this.phongList = phongList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public PhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new PhongViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PhongViewHolder holder, int position) {
        Phong phong = phongList.get(position);
        holder.tvTenPhong.setText("Phòng: " + phong.getTenPhong());
        holder.tvGiaThue.setText("Giá: " + phong.getGiaThue() + " VNĐ");
        holder.tvTinhTrang.setText(phong.getTinhTrang());


        if (phong.getTinhTrang().equals("Còn trống")) {
            holder.tvTinhTrang.setTextColor(Color.GREEN);
        } else {
            holder.tvTinhTrang.setTextColor(Color.RED);
        }


        holder.itemView.setOnClickListener(v -> listener.onItemClick(phong, position));
        holder.btnXoa.setOnClickListener(v -> listener.onDeleteClick(phong, position));
    }


    @Override
    public int getItemCount() {
        return phongList.size();
    }


    public static class PhongViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenPhong, tvGiaThue, tvTinhTrang;
        ImageButton btnXoa;


        public PhongViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenPhong = itemView.findViewById(R.id.tvTenPhong);
            tvGiaThue = itemView.findViewById(R.id.tvGiaThue);
            tvTinhTrang = itemView.findViewById(R.id.tvTinhTrang);
            btnXoa = itemView.findViewById(R.id.btnXoa);
        }
    }
}
