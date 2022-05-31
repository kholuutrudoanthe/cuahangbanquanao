package com.example.cuahangbanquanao.GUI.Sanpham;

import static com.example.cuahangbanquanao.DAO.San_phamDAO.get_sp;
import static com.example.cuahangbanquanao.DAO.gio_hangDAO.Sua_giohang;
import static com.example.cuahangbanquanao.DAO.gio_hangDAO.xoa_giohang;
import static com.example.cuahangbanquanao.GUI.MainActivity.currencyVN;

import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.cuahangbanquanao.DTO.giohang_;
import com.example.cuahangbanquanao.DTO.sanpham;
import com.example.cuahangbanquanao.R;

import java.util.List;

public class giohangadapter extends RecyclerView.Adapter<giohangadapter.giohangviewhodler> {
    List<giohang_> list;
    Fragment fragment;
    int position_g;
    int sl;
    int tongtien;

    public giohangadapter(List<giohang_> list, Fragment fragment, int position_g) {
        this.list = list;
        this.fragment = fragment;
        this.position_g = position_g;
    }


    @NonNull
    @Override
    public giohangviewhodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(fragment.getContext()).inflate(R.layout.item_giohang, parent, false);
        return new giohangviewhodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull giohangviewhodler holder, int position) {
        giohang_ giohang_ = list.get(position);
        if (position_g==1){
            holder.delete.setVisibility(View.GONE);
            holder.layout.setVisibility(View.GONE);
        }
        sanpham sanpham = get_sp(giohang_.getIdsp());
        sl=giohang_.getSl();
        if (sanpham!=null){
            Glide.with(fragment).load(sanpham.getHinhanh()).apply(new RequestOptions().transform(new CenterCrop()).transform(new RoundedCorners(15))).error(R.drawable.ic_error).into(holder.img);
            holder.tensp.setText(sanpham.getTensp());
            holder.chitiet.setText(sanpham.getChitiet());
            holder.tienx1.setText(currencyVN.format(sanpham.getGiatien()));
        }
        holder.sl.setText(giohang_.getSl() + "");
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getContext());
                builder.setMessage("Bạn có muốn xóa sản phẩm này ko")
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
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
        holder.cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sl = sl + 1;
                holder.sl.setText(sl + "");
                tongtien = sanpham.getGiatien() * sl;
                Sua_giohang(giohang_.getIdgh(),sl,tongtien);
            }
        });
        holder.tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sl != 1) {
                    sl = sl - 1;
                    holder.sl.setText(sl + "");
                    tongtien = sanpham.getGiatien() * sl;
                    Sua_giohang(giohang_.getIdgh(),sl,tongtien);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class giohangviewhodler extends RecyclerView.ViewHolder {
        ImageView img, cong, tru, delete;
        TextView tensp, chitiet, tienx1, sl;
        LinearLayout layout;

        public giohangviewhodler(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ImageView_Product);
            cong = itemView.findViewById(R.id.cong);
            tru = itemView.findViewById(R.id.tru);
            tensp = itemView.findViewById(R.id.tensp);
            chitiet = itemView.findViewById(R.id.chitiet);
            tienx1 = itemView.findViewById(R.id.tienx1);
            sl = itemView.findViewById(R.id.sl);
            delete = itemView.findViewById(R.id.delete);
            layout = itemView.findViewById(R.id.layout);
        }
    }

}
