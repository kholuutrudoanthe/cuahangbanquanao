package com.example.cuahangbanquanao.GUI.Sanpham;

import static com.example.cuahangbanquanao.DAO.San_phamDAO.getall_sanpham;
import static com.example.cuahangbanquanao.DAO.San_phamDAO.timkiem_sp;
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

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuahangbanquanao.DTO.sanpham;
import com.example.cuahangbanquanao.GUI.MainActivity_trangchu;
import com.example.cuahangbanquanao.GUI.trangchu;
import com.example.cuahangbanquanao.R;

import java.util.ArrayList;
import java.util.List;


public class timkiem extends Fragment {

    EditText timkiem;
    TextView tb;
    RecyclerView recy_1;
    ImageView image;
    sanpham_adapter sanpham_adapter;
    ArrayList<sanpham> arrayList=new ArrayList<>();
    public timkiem() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timkiem, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chipNavigationBar.setVisibility(View.GONE);
        timkiem=view.findViewById(R.id.timkiem);
        tb=view.findViewById(R.id.tb);
        recy_1=view.findViewById(R.id.recy_1);
        image=view.findViewById(R.id.image);
        MainActivity_trangchu MainActivity_trangchu= (com.example.cuahangbanquanao.GUI.MainActivity_trangchu) getActivity();
        _OnBack(MainActivity_trangchu,timkiem.this,R.id.action_timkiem2_to_trangchu);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chipNavigationBar.setVisibility(View.VISIBLE);
                Navigation.findNavController(view).navigate(R.id.action_timkiem2_to_trangchu);
            }
        });

        timkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                getdata(timkiem.getText().toString().trim());
            }
        });

    }

    private void getdata(String tikiem) {

        if (timkiem_sp(tikiem).size()!=0){
            tb.setVisibility(View.GONE);
            arrayList.clear();
            arrayList= (ArrayList<sanpham>) timkiem_sp(tikiem);
            recy_1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
            sanpham_adapter = new sanpham_adapter(arrayList, timkiem.this);
            recy_1.setAdapter(sanpham_adapter);
            recy_1.post(new Runnable() {
                @Override
                public void run() {
                    sanpham_adapter.notifyDataSetChanged();
                }
            });
        }else {
            arrayList.clear();
            recy_1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
            sanpham_adapter = new sanpham_adapter(arrayList, timkiem.this);
            recy_1.setAdapter(sanpham_adapter);
            recy_1.post(new Runnable() {
                @Override
                public void run() {
                    sanpham_adapter.notifyDataSetChanged();
                }
            });
            tb.setVisibility(View.VISIBLE);
        }
    }
}