package com.example.cuahangbanquanao.GUI;

import static com.example.cuahangbanquanao.DAO.Tai_khoanDAO.kiem_tra_tk;
import static com.example.cuahangbanquanao.DAO.Tai_khoanDAO.them_taikhoan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuahangbanquanao.DTO.Taikhoan;
import com.example.cuahangbanquanao.R;

public class MainActivity_dangky extends AppCompatActivity {
    ImageView image;
    EditText hoten, email, mk;
    Button btndk;
    TextView dangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dangky);
        anhxa();
        onclick();
    }

    private void onclick() {
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_dangky.this, MainActivity.class));
                finish();
            }
        });
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = email.getText().toString().trim();
                String hoten1 = hoten.getText().toString().trim();
                String mk1 = mk.getText().toString().trim();
                if (email1.isEmpty() && hoten1.isEmpty() && mk1.isEmpty()) {
                    Toast.makeText(MainActivity_dangky.this, "Vui lòng ko để trống thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Taikhoan taikhoan=new Taikhoan(0,email1,hoten1,mk1,"","");
                    if (!kiem_tra_tk(email1)) {
                        if (them_taikhoan(taikhoan)) {
                            Toast.makeText(MainActivity_dangky.this, "Đã đăng ký thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(MainActivity_dangky.this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity_dangky.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_dangky.this, MainActivity.class));
                finish();
            }
        });
    }

    private void anhxa() {
        image = findViewById(R.id.image);
        hoten = findViewById(R.id.hoten);
        email = findViewById(R.id.email);
        mk = findViewById(R.id.mk);
        btndk = findViewById(R.id.btndk);
        dangnhap = findViewById(R.id.dangnhap);
    }
}