package com.example.cuahangbanquanao.GUI;

import static android.view.View.VISIBLE;
import static com.example.cuahangbanquanao.DAO.Danh_mucDAO.getall_danhmuc;
import static com.example.cuahangbanquanao.DAO.San_phamDAO.getall_sanpham;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu.chipNavigationBar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import static com.example.cuahangbanquanao.GUI.MainActivity.*;
import com.example.cuahangbanquanao.GUI.Sanpham.danhmuc_adapter;
import com.example.cuahangbanquanao.GUI.Sanpham.sanpham_adapter;
import com.example.cuahangbanquanao.R;


public class trangchu extends Fragment {

    RecyclerView recy_1, recy_2;
    danhmuc_adapter danhmuc_adapter;
    sanpham_adapter sanpham_adapter;
    EditText timkiem;

    public trangchu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trangchu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        anhxa(view);
        getdata();
        timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     position_=2;
                  Navigation.findNavController(view).navigate(R.id.action_trangchu_to_timkiem2);
            }
        });

    }

    private void getdata() {
        recy_1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        danhmuc_adapter = new danhmuc_adapter(getall_danhmuc(), trangchu.this);
        recy_1.setAdapter(danhmuc_adapter);
        Log.e("sss",getall_danhmuc().get(0).getIddm()+"");
        recy_2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        sanpham_adapter = new sanpham_adapter(getall_sanpham(), trangchu.this);
        recy_2.setAdapter(sanpham_adapter);
    }

    private void anhxa(View view) {
        recy_1 = view.findViewById(R.id.recy_1);
        recy_2 = view.findViewById(R.id.recy_2);
        timkiem = view.findViewById(R.id.timkiem);
    }
}