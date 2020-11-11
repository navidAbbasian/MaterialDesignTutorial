package com.sevenlearn.materialdesigntutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView=findViewById(R.id.bottonNavigation_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menuitem_home:

                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_main_fragmentContrainer, new MainFragment());
                        fragmentTransaction.commit();
                        break;
                    case R.id.menuitem_nearme:

                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.frame_main_fragmentContrainer, new NearByFragment());
                        fragmentTransaction2.commit();
                        break;
                    case R.id.menuitem_recents:

                        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.frame_main_fragmentContrainer, new RecentFragment());
                        fragmentTransaction3.commit();
                        break;

                }
                return true;
            }
        });

                        //put setSelectedItemId after etOnNavigationItemSelectedListener
                        bottomNavigationView.setSelectedItemId(R.id.menuitem_home);

                        //stop re-selecting fragments
                        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
                            @Override
                            public void onNavigationItemReselected(@NonNull MenuItem item) {

                            }
                        });
    }
}
