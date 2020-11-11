package com.sevenlearn.materialdesigntutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class DetailFragment extends Fragment {

    @Override
    //for set action on back btn in toolbar (continue in line 60)
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    //xml to java and set view
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //set toolbar on detail fragment
        Toolbar toolbar=view.findViewById(R.id.toolbar_detail);
        AppCompatActivity activity= (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        //set home btn on toolbar
        activity.getSupportActionBar().setHomeButtonEnabled(true);
        //change home btn to back(up) btn
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //hide toolbar color when expanded
        CollapsingToolbarLayout collapsingToolbarLayout=view.findViewById(R.id.collapsingToolbarLayout_detail);
        //use ContentCompat for support older version
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(getContext(),android.R.color.transparent));
        //change title
        collapsingToolbarLayout.setTitle("Lorem Ipsum");


    }

    @Override
    //say go back to btn
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //icon's id in toolbar is home
        if (item.getItemId()==android.R.id.home){
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
