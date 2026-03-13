package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.Phong;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtMaPhong, txtTenPhong, txtGiaThue, txtTenNguoi, txtSdt;
    private Spinner spinnerTinhTrang;
    private Button btnThem, btnSua;
    private RecyclerView recyclerView;
    private PhongAdapter adapter;
    private List<Phong> phongList;
    private int editingPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        txtMaPhong = findViewById(R.id.txtMaPhong);
        txtTenPhong = findViewById(R.id.txtTenPhong);
        txtGiaThue = findViewById(R.id.txtGiaThue);
        txtTenNguoi = findViewById(R.id.txtTenNguoi);
        txtSdt = findViewById(R.id.txtSdt);
        spinnerTinhTrang = findViewById(R.id.spinnerTinhTrang);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        recyclerView = findViewById(R.id.recyclerView);

        // Clear default text from layout if any
        txtMaPhong.setText("");
        txtTenPhong.setText("");
        txtGiaThue.setText("");
        txtTenNguoi.setText("");
        txtSdt.setText("");
    }


















}
