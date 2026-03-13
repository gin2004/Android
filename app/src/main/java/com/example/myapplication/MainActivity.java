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
        setupSpinner();
        setupRecyclerView();


        btnThem.setOnClickListener(v -> addPhong());
        btnSua.setOnClickListener(v -> updatePhong());
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


    private void setupSpinner() {
        String[] tinhTrangArray = {"Còn trống", "Đã thuê"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tinhTrangArray);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTinhTrang.setAdapter(spinnerAdapter);
    }


    private void setupRecyclerView() {
        phongList = new ArrayList<>();
        // Dữ liệu mẫu ban đầu
        phongList.add(new Phong("P101", "Phòng 101", "Nguyễn Văn A", "0987654321", "Đã thuê", 2500000));
        phongList.add(new Phong("P102", "Phòng 102", "", "", "Còn trống", 2200000));


        adapter = new PhongAdapter(this, phongList, new PhongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Phong phong, int position) {
                fillDataToInputs(phong, position);
            }


            @Override
            public void onDeleteClick(Phong phong, int position) {
                showDeleteConfirmDialog(position);
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    private void fillDataToInputs(Phong phong, int position) {
        txtMaPhong.setText(phong.getMaPhong());
        txtTenPhong.setText(phong.getTenPhong());
        txtGiaThue.setText(String.valueOf(phong.getGiaThue()));
        txtTenNguoi.setText(phong.getTenNguoi());
        txtSdt.setText(phong.getSdt());

        if (phong.getTinhTrang().equals("Còn trống")) {
            spinnerTinhTrang.setSelection(0);
        } else {
            spinnerTinhTrang.setSelection(1);
        }

        editingPosition = position;
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


    private void updatePhong() {
        if (editingPosition == -1) {
            Toast.makeText(this, "Vui lòng chọn một phòng để sửa!", Toast.LENGTH_SHORT).show();
            return;
        }


        if (validateInput()) {
            Phong p = getInputData();
            phongList.set(editingPosition, p);
            adapter.notifyItemChanged(editingPosition);
            clearInputs();
            editingPosition = -1;
            Toast.makeText(this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
        }
    }


    private void showDeleteConfirmDialog(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Xác nhận xóa")
                .setMessage("Bạn có chắc chắn muốn xóa phòng này không?")
                .setPositiveButton("Xóa", (dialog, which) -> {
                    phongList.remove(position);
                    adapter.notifyItemRemoved(position);
                    adapter.notifyItemRangeChanged(position, phongList.size());
                    if (editingPosition == position) {
                        clearInputs();
                        editingPosition = -1;
                    }
                    Toast.makeText(this, "Đã xóa phòng!", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Hủy", null)
                .show();
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

