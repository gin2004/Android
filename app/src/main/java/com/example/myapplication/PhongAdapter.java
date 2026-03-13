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

public class PhongAdapter {

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


    public static class PhongViewHolder {

    }
}
