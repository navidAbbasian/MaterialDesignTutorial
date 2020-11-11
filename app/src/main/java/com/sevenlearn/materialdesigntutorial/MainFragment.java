package com.sevenlearn.materialdesigntutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class MainFragment extends Fragment {

    @Nullable
    @Override
    //xml to java and set view
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //set toolbar of main fragment
        Toolbar toolbar=view.findViewById(R.id.toolbar_main);
        toolbar.setNavigationIcon(R.drawable.ic_menu_24);

        AppCompatActivity appCompatActivity= (AppCompatActivity) getActivity();
        appCompatActivity.setSupportActionBar(toolbar);

        DrawerLayout drawerLayout=view.findViewById(R.id.drawer_main);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.menu_open,R.string.menu_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        final MaterialCardView materialCardView=view.findViewById(R.id.card_main_text);
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frame_main_fragmentContrainer,new DetailFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        FloatingActionButton floatingActionButton=view.findViewById(R.id.fab_main);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //use Snack bar instead of toast for have action
                Snackbar.make(getView(),"clicked(snackBar)",Snackbar.LENGTH_SHORT)
                        .setAction("Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                              Toast.makeText(getContext(),"retry clicked",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        NavigationView navigationView=view.findViewById(R.id.navigatioonView_main);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.menuitem_home:
                        //do somethings
                }
                return false;
            }
        });


//        View headerView=navigationView.getHeaderView(0);
//        TextView textView=headerView.findViewById(R.id.textView_header);
//        textView.setText(R.string.ynwa);

//
//
//
//
//        ( set check box for items )
//
//        MaterialCardView materialCardView = view.findViewById (R.id.card_main_text);
//        materialCardView.setChecked(true);
//        materialCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                materialCardView.setChecked(!materialCardView.isChecked());
//            }
//        });
    }
}
