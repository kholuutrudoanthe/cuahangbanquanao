package com.example.cuahangbanquanao.GUI.Taikhoan;

import static com.example.cuahangbanquanao.DAO.don_hangDAO.getall_donhang;
import static com.example.cuahangbanquanao.DAO.gio_hangDAO.getall_giohang;
import static com.example.cuahangbanquanao.GUI.MainActivity.currencyVN;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu._OnBack;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu.chipNavigationBar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cuahangbanquanao.DTO.giohang_;
import com.example.cuahangbanquanao.GUI.MainActivity_trangchu;
import com.example.cuahangbanquanao.GUI.Sanpham.don_hangadapter;
import com.example.cuahangbanquanao.GUI.Sanpham.giohangadapter;
import com.example.cuahangbanquanao.GUI.Sanpham.timkiem;
import com.example.cuahangbanquanao.GUI.giohang;
import com.example.cuahangbanquanao.R;


public class donhang_ extends Fragment {

    RecyclerView list_item;
    TextView sl;
    ImageView image;
    com.example.cuahangbanquanao.GUI.Sanpham.don_hangadapter don_hangadapter;
    public donhang_() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donhang_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list_item = view.findViewById(R.id.list_item);
        sl = view.findViewById(R.id.sl);
        image = view.findViewById(R.id.image);
        chipNavigationBar.setVisibility(View.GONE);
        getdata();
        getdata1();
        MainActivity_trangchu MainActivity_trangchu= (com.example.cuahangbanquanao.GUI.MainActivity_trangchu) getActivity();
        _OnBack(MainActivity_trangchu, donhang_.this,R.id.action_donhang__to_taikhoan);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chipNavigationBar.setVisibility(View.VISIBLE);
                Navigation.findNavController(view).navigate(R.id.action_donhang__to_taikhoan);
            }
        });
    }

    private void getdata1() {

        if (getall_giohang().size()!=0) {
            sl.setText(""+getall_giohang().size());

        }

    }

    private void getdata() {
        don_hangadapter = new don_hangadapter(getall_donhang(), donhang_.this);
        list_item.setLayoutManager(new LinearLayoutManager(getContext()));
        list_item.setAdapter(don_hangadapter);
        don_hangadapter.notifyDataSetChanged();

    }

}