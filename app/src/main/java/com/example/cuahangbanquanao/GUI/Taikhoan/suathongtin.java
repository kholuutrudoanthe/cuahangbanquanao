package com.example.cuahangbanquanao.GUI.Taikhoan;

import static com.example.cuahangbanquanao.DAO.Tai_khoanDAO.Sua_taikhoan;
import static com.example.cuahangbanquanao.DAO.Tai_khoanDAO.get_thongtin;
import static com.example.cuahangbanquanao.GUI.MainActivity.email_;
import static com.example.cuahangbanquanao.GUI.MainActivity.position_tk;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu._OnBack;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu.chipNavigationBar;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cuahangbanquanao.DTO.Taikhoan;
import com.example.cuahangbanquanao.GUI.MainActivity_trangchu;
import com.example.cuahangbanquanao.GUI.Sanpham.chitiet_sp;
import com.example.cuahangbanquanao.R;


public class suathongtin extends Fragment {

    EditText ten, email, sdt, diachi;
    ImageView image;
    Button btndn;

    public suathongtin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_suathongtin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chipNavigationBar.setVisibility(View.GONE);
        ten = view.findViewById(R.id.ten);
        image = view.findViewById(R.id.image);
        email = view.findViewById(R.id.email);
        sdt = view.findViewById(R.id.sdt);
        diachi = view.findViewById(R.id.diachi);
        btndn = view.findViewById(R.id.btndn);
        MainActivity_trangchu MainActivity_trangchu = (com.example.cuahangbanquanao.GUI.MainActivity_trangchu) getActivity();
         if (position_tk==0){
            _OnBack(MainActivity_trangchu, suathongtin.this, R.id.action_suathongtin_to_taikhoan);
        }else{
            _OnBack(MainActivity_trangchu, suathongtin.this, R.id.action_suathongtin_to_dat_hang);
        }
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position_tk==0){
                    Navigation.findNavController(view).navigate(R.id.action_suathongtin_to_taikhoan);
                }else{
                    Navigation.findNavController(view).navigate(R.id.action_suathongtin_to_dat_hang);
                }
            }
        });
        getdata();
        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Sua_taikhoan(ten.getText().toString().trim(), sdt.getText().toString().trim(), diachi.getText().toString().trim())) {
                    Toast.makeText(getActivity(), "Sửa thành công!", Toast.LENGTH_SHORT).show();
                    if (position_tk==0){
                        Navigation.findNavController(view).navigate(R.id.action_suathongtin_to_taikhoan);
                    }else{
                        Navigation.findNavController(view).navigate(R.id.action_suathongtin_to_dat_hang);
                    }
                } else {
                    Toast.makeText(getActivity(), "Sửa thất bại!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void getdata() {
        Taikhoan taikhoan = get_thongtin(email_);
        ten.setText(taikhoan.getHoten());
        email.setText(taikhoan.getEmail());
        sdt.setText(taikhoan.getSdt());
        diachi.setText(taikhoan.getDiachi());
    }
}