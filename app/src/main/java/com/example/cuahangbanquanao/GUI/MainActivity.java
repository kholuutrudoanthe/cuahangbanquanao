package com.example.cuahangbanquanao.GUI;

import static com.example.cuahangbanquanao.DAO.Danh_mucDAO.getall_danhmuc;
import static com.example.cuahangbanquanao.DAO.Danh_mucDAO.them_danhmuc;
import static com.example.cuahangbanquanao.DAO.San_phamDAO.getall_sanpham;
import static com.example.cuahangbanquanao.DAO.San_phamDAO.them_sanpham;
import static com.example.cuahangbanquanao.DAO.Tai_khoanDAO.kiem_tra_dn;
import static com.example.cuahangbanquanao.DAO.data.adddm;
import static com.example.cuahangbanquanao.DAO.data.addsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuahangbanquanao.DAO.SQLite_DAO;
import com.example.cuahangbanquanao.DTO.danhmuc;
import com.example.cuahangbanquanao.DTO.sanpham;
import com.example.cuahangbanquanao.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static SQLite_DAO sqLite_dao;
    public static String email_;
    public static String tendm_;
    public static int idsp_;
    public static int iddm_;
    public static int position_=0;
    public static int position_tk=0;
    Button btndn;
    EditText mk, email;
    TextView dk;
    public static NumberFormat currencyVN = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLite_dao = new SQLite_DAO(this);
        sqLite_dao.getdatatk();
        sqLite_dao.getdatadm();
        sqLite_dao.getdatasanpham();
        sqLite_dao.getdatagiohang();
        sqLite_dao.getdatadonhang();
        Log.e("size", getall_danhmuc().size() + "");
        if (getall_danhmuc().size() == 0) {
            adddm();
        }
        if (getall_sanpham().size() == 0) {
            addsp();
        }

        anhxa();
        onclick();
    }


    private void onclick() {
        dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity_dangky.class));
            }
        });
        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = email.getText().toString().trim();
                String mk1 = mk.getText().toString().trim();
                email_ = email1;
                if (email1.isEmpty() || mk1.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng điền đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if (kiem_tra_dn(email1, mk1)) {
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity_trangchu.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Tài khoản chưa được đăng ký", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private void anhxa() {
        btndn = findViewById(R.id.btndn);
        email = findViewById(R.id.email);
        mk = findViewById(R.id.mk);
        dk = findViewById(R.id.dk);
    }
}