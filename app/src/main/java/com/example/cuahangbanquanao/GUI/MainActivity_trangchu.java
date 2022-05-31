package com.example.cuahangbanquanao.GUI;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.cuahangbanquanao.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity_trangchu extends AppCompatActivity {
    public static ChipNavigationBar chipNavigationBar;
    public static NumberFormat currencyVN = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_trangchu);
        chipNavigationBar = findViewById(R.id.menu);
        chipNavigationBar.setItemSelected(R.id.home, true);
        bottommenu();

    }
    public static void _OnBack(MainActivity_trangchu mainActivity, Fragment fragment, int id) {
        mainActivity.getOnBackPressedDispatcher().addCallback(fragment, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                chipNavigationBar.setVisibility(View.VISIBLE);
                NavHostFragment.findNavController(fragment).navigate(id);
            }
        });
    }

    private void bottommenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.home:
                        Navigation.findNavController(MainActivity_trangchu.this, R.id.nav_host_fragment_content_main).navigate(R.id.trangchu);
                        break;
                    case R.id.gio_hang:
                        Navigation.findNavController(MainActivity_trangchu.this, R.id.nav_host_fragment_content_main).navigate(R.id.giohang);
                        break;
                    case R.id.tai_khoan:
                        Navigation.findNavController(MainActivity_trangchu.this, R.id.nav_host_fragment_content_main).navigate(R.id.taikhoan);
                        break;

                }
            }
        });
    }
}