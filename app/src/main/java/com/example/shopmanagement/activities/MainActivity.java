package com.example.shopmanagement.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shopmanagement.R;
import com.example.shopmanagement.fragments.HomeFragment;
import com.example.shopmanagement.fragments.LogsFragment;
import com.example.shopmanagement.fragments.StockFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private  BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().
                beginTransaction().replace(R.id.frame_container,new HomeFragment()).commit();


    }

    // Using navListeneter we are selecting fragment and changing Fragment to Fragment
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){

                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_logs:
                            selectedFragment = new LogsFragment();
                            break;
                        case R.id.nav_stock:
                            selectedFragment = new StockFragment();
                            break;

                        default:
                    }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_container,selectedFragment).commit();

                    return true;
                }
            };
}
