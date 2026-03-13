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


    private void addPhong() {
        if (validateInput()) {
            Phong p = getInputData();
            phongList.add(p);
            adapter.notifyItemInserted(phongList.size() - 1);
            clearInputs();
            Toast.makeText(this, "Thêm phòng thành công!", Toast.LENGTH_SHORT).show();
        }
    }

    private Phong getInputData() {
        String ma = txtMaPhong.getText().toString().trim();
        String ten = txtTenPhong.getText().toString().trim();
        double gia = Double.parseDouble(txtGiaThue.getText().toString().trim());
        String tinhTrang = spinnerTinhTrang.getSelectedItem().toString();
        String nguoi = txtTenNguoi.getText().toString().trim();
        String sdt = txtSdt.getText().toString().trim();


        return new Phong(ma, ten, nguoi, sdt, tinhTrang, gia);
    }

    private boolean validateInput() {
        if (txtMaPhong.getText().toString().trim().isEmpty() ||
                txtTenPhong.getText().toString().trim().isEmpty() ||
                txtGiaThue.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Mã, tên và giá phòng không được để trống!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void clearInputs() {
        txtMaPhong.setText("");
        txtTenPhong.setText("");
        txtGiaThue.setText("");
        txtTenNguoi.setText("");
        txtSdt.setText("");
        spinnerTinhTrang.setSelection(0);
        txtMaPhong.requestFocus();
    }

}
