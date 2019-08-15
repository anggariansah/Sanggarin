package com.aha.sanggarin;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.aha.sanggarin.fragment.HomeFragment;
import com.aha.sanggarin.fragment.ProfileFragment;
import com.aha.sanggarin.fragment.RiwayatFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar tb;

    private String username;
    String title = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(tb);


        HomeFragment beranda = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, beranda);
        transaction.commit();

//        title = "Halo " + username;
        title = "Halo Agung";
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setItemIconTintList(null);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:

                    HomeFragment beranda = new HomeFragment();
                    FragmentTransaction hometrans = getSupportFragmentManager().beginTransaction();
                    hometrans.replace(R.id.content, beranda);
                    hometrans.commit();
                    title = "Halo " + username;

                    if (getSupportActionBar() != null) {
                        getSupportActionBar().setTitle(title);
                    }

                    return true;

                case R.id.riwayat:

                    RiwayatFragment riwayat = new RiwayatFragment();
                    FragmentTransaction riwayattrans = getSupportFragmentManager().beginTransaction();
                    riwayattrans.replace(R.id.content, riwayat);
                    riwayattrans.commit();
                    title = "Riwayat Transaksi";
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().setTitle(title);
                    }

                    return true;

                case R.id.profile:

                    ProfileFragment profile = new ProfileFragment();
                    FragmentTransaction profiletrans = getSupportFragmentManager().beginTransaction();
                    profiletrans.replace(R.id.content, profile);
                    profiletrans.commit();
                    title = "Profile";
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().setTitle(title);
                    }

                    return true;
            }

            return false;
        }

    };
}
