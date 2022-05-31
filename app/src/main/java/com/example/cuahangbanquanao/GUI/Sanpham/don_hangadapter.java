package com.example.cuahangbanquanao.GUI.Sanpham;

import static com.example.cuahangbanquanao.DAO.San_phamDAO.get_sp;
import static com.example.cuahangbanquanao.DAO.don_hangDAO.xoa_donhang;
import static com.example.cuahangbanquanao.DAO.gio_hangDAO.get_giohang;
import static com.example.cuahangbanquanao.DAO.gio_hangDAO.xoa_giohang;
import static com.example.cuahangbanquanao.GUI.MainActivity.currencyVN;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.cuahangbanquanao.DTO.donhang;
import com.example.cuahangbanquanao.DTO.giohang_;
import com.example.cuahangbanquanao.DTO.sanpham;
import com.example.cuahangbanquanao.R;

import java.util.List;

public class don_hangadapter extends RecyclerView.Adapter<don_hangadapter.don_hangviewhodler>{
    List<donhang>lists;
    Fragment fragment;

    public don_hangadapter(List<donhang> lists, Fragment fragment) {
        this.lists = lists;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public don_hangviewhodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_donhang,parent,false);
        return new don_hangviewhodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull don_hangviewhodler holder, int position) {
        donhang donhang = lists.get(position);
        giohang_ giohang_=get_giohang(donhang.getIdgh());
        if (giohang_==null){
            return;
        }
        sanpham sanpham = get_sp(giohang_.getIdsp());
        if (sanpham!=null){
            Glide.with(fragment).load(sanpham.getHinhanh()).apply(new RequestOptions().transform(new CenterCrop()).transform(new RoundedCorners(15))).error(R.drawable.ic_error).into(holder.img);
            holder.tensp.setText(sanpham.getTensp());
            holder.chitiet.setText(sanpham.getChitiet());
            holder.tienx1.setText(currencyVN.format(sanpham.getGiatien()));
        }
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getContext());
                builder.setMessage("Bạn có muốn xóa sản phẩm này ko")
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                xoa_donhang(donhang.getIddh());
                                xoa_giohang(giohang_.getIdgh());
                            }
                        })
                        .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });

                builder.create();
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (lists!=null){
            return lists.size();
        }
        return 0;
    }

    public class don_hangviewhodler extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tensp, chitiet, tienx1;
        Button btn;

        public don_hangviewhodler(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ImageView_Product);

            tensp = itemView.findViewById(R.id.tensp);
            chitiet = itemView.findViewById(R.id.chitiet);
            tienx1 = itemView.findViewById(R.id.tienx1);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
