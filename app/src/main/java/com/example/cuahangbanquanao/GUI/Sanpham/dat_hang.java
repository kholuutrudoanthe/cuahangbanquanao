package com.example.cuahangbanquanao.GUI.Sanpham;

import static com.example.cuahangbanquanao.DAO.Tai_khoanDAO.get_thongtin;
import static com.example.cuahangbanquanao.DAO.don_hangDAO.them_donhang;
import static com.example.cuahangbanquanao.DAO.gio_hangDAO.Sua_trangthai;
import static com.example.cuahangbanquanao.DAO.gio_hangDAO.getall_giohang;
import static com.example.cuahangbanquanao.DAO.gio_hangDAO.xoa_giohang;
import static com.example.cuahangbanquanao.GUI.MainActivity.currencyVN;
import static com.example.cuahangbanquanao.GUI.MainActivity.email_;
import static com.example.cuahangbanquanao.GUI.MainActivity.position_tk;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu._OnBack;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu.chipNavigationBar;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuahangbanquanao.DTO.Taikhoan;
import com.example.cuahangbanquanao.DTO.donhang;
import com.example.cuahangbanquanao.DTO.giohang_;
import com.example.cuahangbanquanao.GUI.MainActivity_trangchu;
import com.example.cuahangbanquanao.GUI.giohang;
import com.example.cuahangbanquanao.R;

import java.util.ArrayList;
import java.util.List;


public class dat_hang extends Fragment {

    RecyclerView list_item;
    ImageView image;
    LinearLayout layout1;
    giohangadapter giohangadapter;
    TextView ttt, ten, sdt, diachi, sua, loinhan;
    int tongtien_;
    Taikhoan taikhoan;

    public dat_hang() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dat_hang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        taikhoan = get_thongtin(email_);
        chipNavigationBar.setVisibility(View.GONE);
        list_item = view.findViewById(R.id.list_item);
        ttt = view.findViewById(R.id.ttt);
        ten = view.findViewById(R.id.ten);
        sdt = view.findViewById(R.id.sdt);
        diachi = view.findViewById(R.id.diachi);
        sua = view.findViewById(R.id.sua);
        image = view.findViewById(R.id.image);
        layout1 = view.findViewById(R.id.layout1);
        loinhan = view.findViewById(R.id.loinhan);
        MainActivity_trangchu MainActivity_trangchu = (com.example.cuahangbanquanao.GUI.MainActivity_trangchu) getActivity();
        _OnBack(MainActivity_trangchu, dat_hang.this, R.id.action_dat_hang_to_giohang);
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position_tk=1;
                 Navigation.findNavController(view).navigate(R.id.action_dat_hang_to_suathongtin);
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chipNavigationBar.setVisibility(View.VISIBLE);
                Navigation.findNavController(view).navigate(R.id.action_dat_hang_to_giohang);
            }
        });
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (taikhoan.getDiachi().isEmpty()||taikhoan.getSdt().isEmpty()) {
                    Toast.makeText(getContext(), "Vui lòng thêm đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                } else {
                    if (getall_giohang().size() != 0) {
                        for (giohang_ giohang : getall_giohang()
                        ) {

                            donhang donhang=new donhang(0,giohang.getIdgh(),0,loinhan.getText().toString().trim());
                            them_donhang(donhang);
                            Sua_trangthai(giohang.getIdgh(),1);
                        }
                    }
                    chipNavigationBar.setItemSelected(R.id.home, true);
                    Toast.makeText(getContext(), "Đặt hàng thành công !", Toast.LENGTH_SHORT).show();
                    chipNavigationBar.setVisibility(View.VISIBLE);

                }


            }
        });
        getdata1();
        getdata();
    }

    private void getdata1() {

        ten.setText("Họ tên: " + taikhoan.getHoten());
        if (taikhoan.getSdt().isEmpty()) {
            sdt.setText("SĐT: Thêm số điện thoại");
        } else {
            sdt.setText("SĐT: " + taikhoan.getSdt());
        }
        if (taikhoan.getDiachi().isEmpty()) {
            diachi.setText("Địa chỉ: Thêm địa chỉ");
        } else {
            diachi.setText("Địa chỉ: " + taikhoan.getDiachi());

        }
        if (getall_giohang().size() != 0) {
            for (giohang_ giohang : getall_giohang()
            ) {
                tongtien_ = tongtien_ + giohang.getTongtien();
                ttt.setText(currencyVN.format(tongtien_));
            }
        }

    }

    private void getdata() {
        giohangadapter = new giohangadapter(getall_giohang(), dat_hang.this, 1);
        list_item.setLayoutManager(new LinearLayoutManager(getContext()));
        list_item.setAdapter(giohangadapter);
        giohangadapter.notifyDataSetChanged();
    }
}