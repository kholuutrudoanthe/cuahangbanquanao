package com.example.cuahangbanquanao.GUI.Sanpham;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import static com.example.cuahangbanquanao.GUI.MainActivity.*;
import com.bumptech.glide.Glide;
import com.example.cuahangbanquanao.DTO.danhmuc;
import com.example.cuahangbanquanao.R;

import java.util.List;

public class danhmuc_adapter extends RecyclerView.Adapter<danhmuc_adapter.danhmuc_Viewholder>{
    List<danhmuc>List;
    Fragment fragment;

    public danhmuc_adapter(List<danhmuc> list, Fragment fragment) {
        List = list;
        this.fragment = fragment;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public danhmuc_Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhmuc,parent,false);
        return new danhmuc_Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull danhmuc_Viewholder holder, int position) {
        danhmuc danhmuc=List.get(position);
        Glide.with(fragment.getContext()).load(danhmuc.getHinhanh()).error(R.drawable.tra_sua).into(holder.imageView);
        holder.txt_name.setText(danhmuc.getTendm());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iddm_=danhmuc.getIddm();
                tendm_=danhmuc.getTendm();
                position_=1;
                NavHostFragment.findNavController(fragment).navigate(R.id.action_trangchu_to_danhmuc_sp);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (List!=null){
            return  List.size();
        }
        return 0;
    }

    public class danhmuc_Viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txt_name;
        public danhmuc_Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.profile_image);
            txt_name=itemView.findViewById(R.id.txt_name);
        }
    }
}
