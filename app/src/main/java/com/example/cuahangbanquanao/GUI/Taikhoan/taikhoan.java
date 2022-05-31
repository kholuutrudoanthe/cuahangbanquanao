package com.example.cuahangbanquanao.GUI.Taikhoan;

import static android.view.View.VISIBLE;
import static com.example.cuahangbanquanao.DAO.Tai_khoanDAO.get_thongtin;
import static com.example.cuahangbanquanao.GUI.MainActivity.email_;
import static com.example.cuahangbanquanao.GUI.MainActivity.position_tk;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu.chipNavigationBar;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuahangbanquanao.DTO.Taikhoan;
import com.example.cuahangbanquanao.GUI.MainActivity;
import com.example.cuahangbanquanao.R;


public class taikhoan extends Fragment {

    TextView ten, email, sdt, diachi;
    LinearLayout layout1, layout2;
    ImageView dx;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_taikhoan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chipNavigationBar.setVisibility(VISIBLE);
        ten = view.findViewById(R.id.ten);
        email = view.findViewById(R.id.email);
        sdt = view.findViewById(R.id.sdt);
        diachi = view.findViewById(R.id.diachi);
        layout1 = view.findViewById(R.id.layout1);
        layout2 = view.findViewById(R.id.layout2);
        dx = view.findViewById(R.id.dx);
        dx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position_tk=0;
                Navigation.findNavController(view).navigate(R.id.action_taikhoan_to_suathongtin);
            }
        });
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_taikhoan_to_donhang_);
            }
        });

        getdata();
    }

    private void getdata() {
        Taikhoan taikhoan = get_thongtin(email_);
        ten.setText("Họ tên: " + taikhoan.getHoten());
        email.setText("Email: " + taikhoan.getEmail());
        if (taikhoan.getSdt().isEmpty()) {
            sdt.setHint("SĐT: Thêm số điện thoại");
        }else{
            sdt.setText("SĐT: " + taikhoan.getSdt());
        }
        if (taikhoan.getDiachi().isEmpty()) {
            diachi.setHint("Địa chỉ: Thêm địa chỉ");
        }else{
            diachi.setText("Địa chỉ: " + taikhoan.getDiachi());

        }


    }
}