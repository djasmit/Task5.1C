package com.example.task51c;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends Fragment implements TopNRecyclerViewAdapter.OnRowClickListener {

    private List<News> _newsList = new ArrayList<>();
    private RecyclerView _newsRecyclerView, _topNRecyclerView;
    private NewsRecyclerViewAdapter _newsRecyclerViewAdapter;
    private TopNRecyclerViewAdapter _topNRecyclerViewAdapter;

    public HomePage() {
        // Required empty public constructor
    }

    public static HomePage newInstance(String param1, String param2) {
        HomePage fragment = new HomePage();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //attempt to get our news list
        try { _newsList = getArguments().getParcelableArrayList("NewsList"); }
        catch (Exception e) { Log.e("Error", e.getMessage()); }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        //top stories recycler
        _topNRecyclerView = view.findViewById(R.id.TopNewsRecyclerView);
        _topNRecyclerViewAdapter = new TopNRecyclerViewAdapter(_newsList, getActivity(), this::onItemClick);
        _topNRecyclerView.setAdapter(_topNRecyclerViewAdapter);
        RecyclerView.LayoutManager topNLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        _topNRecyclerView.setLayoutManager(topNLayoutManager);

        //news recycler
        int numberOfColumns = 2;
        _newsRecyclerView = view.findViewById(R.id.NewsRecyclerView);
        _newsRecyclerViewAdapter = new NewsRecyclerViewAdapter(_newsList, getActivity(), this::onItemClick);
        _newsRecyclerView.setAdapter(_newsRecyclerViewAdapter);
        RecyclerView.LayoutManager NewsLayoutManager = new GridLayoutManager(getActivity(), numberOfColumns);
        _newsRecyclerView.setLayoutManager(NewsLayoutManager);
    }

    @Override public void onItemClick(int position) {
        selectFragment(position);
    }

    public void selectFragment(int newsIndex) {

        //select our fragment
        Fragment fragment;
        fragment = new FullNews();

        //create bundle and set it to pass along the news list
        Bundle bundle = new Bundle();
        bundle.putInt("NewsIndex", newsIndex);
        bundle.putParcelableArrayList("NewsList", (ArrayList<? extends Parcelable>) _newsList);
        fragment.setArguments(bundle);

        //set up and head to the next fragment
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.HomePageFragment, fragment) .addToBackStack(null).commit();
    }

}