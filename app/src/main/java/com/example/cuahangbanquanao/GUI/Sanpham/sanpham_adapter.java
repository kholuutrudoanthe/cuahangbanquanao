package com.example.cuahangbanquanao.GUI.Sanpham;

import static com.example.cuahangbanquanao.DAO.San_phamDAO.get_sp;
import static com.example.cuahangbanquanao.GUI.MainActivity.currencyVN;
import static com.example.cuahangbanquanao.GUI.MainActivity.idsp_;
import static com.example.cuahangbanquanao.GUI.MainActivity.position_;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.cuahangbanquanao.DTO.sanpham;
import com.example.cuahangbanquanao.R;

import java.util.List;

public class sanpham_adapter extends RecyclerView.Adapter<sanpham_adapter.sp_viewholder>{
    List<sanpham>list;
    Fragment fragment;

    public sanpham_adapter(List<sanpham> list, Fragment fragment) {
        this.list = list;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public sp_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sp,parent,false);
        return new sp_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sp_viewholder holder, int position) {
        sanpham sanpham=list.get(position);
        Glide.with(fragment).load(sanpham.getHinhanh()).apply(new RequestOptions().transform(new CenterCrop()).transform(new RoundedCorners(15))).error(R.drawable.ic_error).into(holder.ImageView_Product);
        holder.TextView_NameProduct.setText(sanpham.getTensp());
        holder.TextView_Content.setText(sanpham.getChitiet());
        holder.TextView_thuonghieu.setText("Thương hiệu: "+sanpham.getThuonghieu());
        holder.TextView_Promotionalprice.setText(currencyVN.format(sanpham.getGiatien()));
        holder.LinearLayout_Product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idsp_=sanpham.getIdsp();
                switch (position_) {
                    case 0:
                        NavHostFragment.findNavController(fragment).navigate(R.id.action_trangchu_to_chitiet_sp);
                        break;
                    case 1:
                        NavHostFragment.findNavController(fragment).navigate(R.id.action_danhmuc_sp_to_chitiet_sp);

                        break;
                    case 2:
                        NavHostFragment.findNavController(fragment).navigate(R.id.action_timkiem2_to_chitiet_sp);

                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    public class sp_viewholder extends RecyclerView.ViewHolder{
        ImageView ImageView_Product;
        TextView TextView_NameProduct,TextView_Content,TextView_Promotionalprice,TextView_thuonghieu;
        LinearLayout LinearLayout_Product;
        public sp_viewholder(@NonNull View itemView) {
            super(itemView);
            ImageView_Product=itemView.findViewById(R.id.ImageView_Product);
            TextView_NameProduct=itemView.findViewById(R.id.TextView_NameProduct);
            TextView_Content=itemView.findViewById(R.id.TextView_Content);
            TextView_Promotionalprice=itemView.findViewById(R.id.TextView_Promotionalprice);
            TextView_thuonghieu=itemView.findViewById(R.id.TextView_thuonghieu);
            LinearLayout_Product=itemView.findViewById(R.id.LinearLayout_Product);
        }
    }
}
