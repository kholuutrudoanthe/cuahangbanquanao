package com.example.cuahangbanquanao.GUI;

import static com.example.cuahangbanquanao.DAO.gio_hangDAO.getall_giohang;
import static com.example.cuahangbanquanao.GUI.MainActivity.currencyVN;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu.chipNavigationBar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cuahangbanquanao.DTO.giohang_;
import com.example.cuahangbanquanao.GUI.Sanpham.giohangadapter;
import com.example.cuahangbanquanao.R;

import java.util.ArrayList;
import java.util.List;


public class giohang extends Fragment {

    RecyclerView list_item;
    TextView sl, tongtien;
    LinearLayout layout_giohang, layout1;
    com.example.cuahangbanquanao.GUI.Sanpham.giohangadapter giohangadapter;
    LinearLayout dathang;
    Button muasp;
    int tongtien_;
    public giohang() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_giohang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list_item = view.findViewById(R.id.list_item);
        layout1 = view.findViewById(R.id.layout1);
        sl = view.findViewById(R.id.sl);
        tongtien = view.findViewById(R.id.tongtien);
        dathang = view.findViewById(R.id.dathang);
        muasp = view.findViewById(R.id.muasp);
        layout_giohang = view.findViewById(R.id.layout_giohang);
        getdata();
        getdata1();
        dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_giohang_to_dat_hang);
            }
        });
        muasp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chipNavigationBar.setItemSelected(R.id.home, true);
            }
        });
    }

    private void getdata1() {

        if (getall_giohang().size()!=0) {
            sl.setText(""+getall_giohang().size());
            layout1.setVisibility(View.VISIBLE);
            layout_giohang.setVisibility(View.GONE);
            for (giohang_ giohang : getall_giohang()
            ) {
                tongtien_ = tongtien_ + giohang.getTongtien();
                tongtien.setText(currencyVN.format(tongtien_));
            }
        }else {
            layout1.setVisibility(View.GONE);
            layout_giohang.setVisibility(View.VISIBLE);
        }

    }

    private void getdata() {
        giohangadapter = new giohangadapter(getall_giohang(), giohang.this,0);
        list_item.setLayoutManager(new LinearLayoutManager(getContext()));
        list_item.setAdapter(giohangadapter);
        giohangadapter.notifyDataSetChanged();

    }

}