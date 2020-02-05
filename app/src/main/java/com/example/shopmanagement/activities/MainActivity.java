package com.example.shopmanagement.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shopmanagement.R;
import com.example.shopmanagement.fragments.HomeFragment;
import com.example.shopmanagement.fragments.LogsFragment;
import com.example.shopmanagement.fragments.StockFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private  BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // the following two line is for customize toolbar
        Toolbar toolbar = findViewById(R.id.customize_toolbar);
        setSupportActionBar(toolbar);

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().
                beginTransaction().replace(R.id.frame_container,new HomeFragment()).commit();


    }
    // the following is for customize toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.title1) {
            Toast.makeText(getApplicationContext(), "Item 1 has been selected",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.title2) {
            Toast.makeText(getApplicationContext(), "Item 2 has been selected",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.title3) {
            Toast.makeText(getApplicationContext(), "Item 3 has been selected",
                    Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Item 5 has been selected",
                    Toast.LENGTH_SHORT).show();
        }
        return  true;
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
