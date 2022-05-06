package com.example.task51c;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<News> newsList = NewsCollection.getNews();

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //will hide the title
        getSupportActionBar().hide();                   // hide the title bar
        setContentView(R.layout.activity_main);


        //select our fragment
        Fragment fragment;
        fragment = new HomePage();

        //create bundle and set it to pass along the news list
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("NewsList", (ArrayList<? extends Parcelable>) newsList);
        fragment.setArguments(bundle);

        //set up and head to the next fragment
        FragmentManager fragmentManager = getSupportFragmentManager();

        //only initialize home page fragment the first time we come here
        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.HomePageFragment, fragment).commit();
        }
    }
}