package com.example.cuahangbanquanao.GUI.Sanpham;

import static com.example.cuahangbanquanao.DAO.San_phamDAO.get_sp;
import static com.example.cuahangbanquanao.DAO.gio_hangDAO.them_giohang;
import static com.example.cuahangbanquanao.GUI.MainActivity.currencyVN;
import static com.example.cuahangbanquanao.GUI.MainActivity.idsp_;
import static com.example.cuahangbanquanao.GUI.MainActivity.position_;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu._OnBack;
import static com.example.cuahangbanquanao.GUI.MainActivity_trangchu.chipNavigationBar;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.cuahangbanquanao.DTO.giohang_;
import com.example.cuahangbanquanao.DTO.sanpham;
import com.example.cuahangbanquanao.GUI.MainActivity_trangchu;
import com.example.cuahangbanquanao.R;


public class chitiet_sp extends Fragment {
    ImageView image, img_back, tru, cong;
    TextView tensp, TextView_thuonghieu, TextView_Content, TextView_Promotionalprice, tongtien, sl;
    LinearLayout layout1;
    int tien;
    int tientong;
    int slsp = 1;

    public chitiet_sp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chitiet_sp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chipNavigationBar.setVisibility(View.GONE);
        anhxa(view);
        getdata();
        onclick();
    }

    private void onclick() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chipNavigationBar.setVisibility(View.VISIBLE);
                switch (position_) {
                    case 0:
                        Navigation.findNavController(view).navigate(R.id.action_chitiet_sp_to_trangchu);
                        break;
                    case 1:
                        Navigation.findNavController(view).navigate(R.id.action_chitiet_sp_to_danhmuc_sp);
                        break;
                    case 2:
                        Navigation.findNavController(view).navigate(R.id.action_chitiet_sp_to_timkiem2);
                        break;
                }
            }
        });
        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slsp = slsp + 1;
                tientong = tien * slsp;
                sl.setText(slsp + "");
                tongtien.setText("Tổng tiền: " + currencyVN.format(tientong));
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (slsp != 1) {
                    slsp = slsp - 1;
                    tientong = tien * slsp;
                    sl.setText(slsp + "");
                    tongtien.setText("Tổng tiền: " + currencyVN.format(tientong));
                }
            }
        });
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giohang_ giohang=new giohang_(0,idsp_,idsp_,slsp,tientong,0);
                Log.e("1",idsp_+"");
                Log.e("2",slsp+"");
                Log.e("3",tientong+"");
                if (them_giohang(giohang)){
                    Toast.makeText(getActivity(), "Đặt hàng thành công!", Toast.LENGTH_SHORT).show();
                    chipNavigationBar.setVisibility(View.VISIBLE);
                    switch (position_) {
                        case 0:
                            Navigation.findNavController(view).navigate(R.id.action_chitiet_sp_to_trangchu);
                            break;
                        case 1:
                            Navigation.findNavController(view).navigate(R.id.action_chitiet_sp_to_danhmuc_sp);
                            break;
                        case 2:
                            Navigation.findNavController(view).navigate(R.id.action_chitiet_sp_to_timkiem2);
                            break;
                    }
                }else {
                    Toast.makeText(getActivity(), "Đặt hàng thất bại!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    private void getdata() {
        sanpham sanpham = get_sp(idsp_);
        Glide.with(chitiet_sp.this).load(sanpham.getHinhanh()).apply(new RequestOptions().transform(new CenterCrop()).transform(new RoundedCorners(15))).error(R.drawable.ic_error).into(image);
        tensp.setText(sanpham.getTensp());
        TextView_Content.setText(sanpham.getChitiet());
        TextView_thuonghieu.setText("Thương hiệu: " + sanpham.getThuonghieu());
        TextView_Promotionalprice.setText(currencyVN.format(sanpham.getGiatien()));
        tien = sanpham.getGiatien();
        tientong=tien;
        tongtien.setText("Tổng tiền: " + currencyVN.format(tien));
    }

    private void anhxa(View view) {
        image = view.findViewById(R.id.image);
        img_back = view.findViewById(R.id.img_back);
        tensp = view.findViewById(R.id.tensp);
        TextView_thuonghieu = view.findViewById(R.id.TextView_thuonghieu);
        TextView_Content = view.findViewById(R.id.TextView_Content);
        TextView_Promotionalprice = view.findViewById(R.id.TextView_Promotionalprice);
        tongtien = view.findViewById(R.id.tongtien);
        layout1 = view.findViewById(R.id.layout1);
        cong = view.findViewById(R.id.cong);
        tru = view.findViewById(R.id.tru);
        sl = view.findViewById(R.id.sl);
        MainActivity_trangchu MainActivity_trangchu = (com.example.cuahangbanquanao.GUI.MainActivity_trangchu) getActivity();

        switch (position_) {
            case 0:
                _OnBack(MainActivity_trangchu, chitiet_sp.this, R.id.action_chitiet_sp_to_trangchu);
                break;
            case 1:
                _OnBack(MainActivity_trangchu, chitiet_sp.this, R.id.action_chitiet_sp_to_danhmuc_sp);
                break;
            case 2:
                _OnBack(MainActivity_trangchu, chitiet_sp.this, R.id.action_chitiet_sp_to_timkiem2);
                break;
        }

    }
}