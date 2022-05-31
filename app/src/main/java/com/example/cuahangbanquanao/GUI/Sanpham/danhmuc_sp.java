package com.example.cuahangbanquanao.GUI.Sanpham;

import static com.example.cuahangbanquanao.DAO.San_phamDAO.danhmuc_sp_;
import static com.example.cuahangbanquanao.DAO.San_phamDAO.timkiem_sp;
import static com.example.cuahangbanquanao.GUI.MainActivity.iddm_;
import static com.example.cuahangbanquanao.GUI.MainActivity.tendm_;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu._OnBack;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu.chipNavigationBar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuahangbanquanao.DTO.sanpham;
import com.example.cuahangbanquanao.GUI.MainActivity_trangchu;
import com.example.cuahangbanquanao.R;

import java.util.ArrayList;
import java.util.List;


public class danhmuc_sp extends Fragment {

    RecyclerView recy_2;
    TextView ten_danhmuc;
    sanpham_adapter sanpham_adapter;
    ImageView image;

    public danhmuc_sp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_danhmuc_sp, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recy_2=view.findViewById(R.id.recy_2);
        ten_danhmuc=view.findViewById(R.id.ten_danhmuc);
        image=view.findViewById(R.id.img_back);
        chipNavigationBar.setVisibility(View.GONE);
        ten_danhmuc.setText(tendm_);
        MainActivity_trangchu MainActivity_trangchu= (com.example.cuahangbanquanao.GUI.MainActivity_trangchu) getActivity();
        _OnBack(MainActivity_trangchu,danhmuc_sp.this,R.id.action_danhmuc_sp_to_trangchu);
        getData();
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chipNavigationBar.setVisibility(View.VISIBLE);
                Navigation.findNavController(view).navigate(R.id.action_danhmuc_sp_to_trangchu);
            }
        });
    }
    private void getData() {
        recy_2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        sanpham_adapter = new sanpham_adapter(danhmuc_sp_(iddm_), danhmuc_sp.this);
        recy_2.setAdapter(sanpham_adapter);
    }
}