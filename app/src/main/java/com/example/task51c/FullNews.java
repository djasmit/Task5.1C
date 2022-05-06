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

public class FullNews extends Fragment implements RelatedNRecyclerViewAdapter.OnRowClickListener {

    protected String _title = "Title";
    protected String _description = "Description";
    protected int _imageIndex = R.drawable.ic_launcher_background;

    protected List<News> _newsList = new ArrayList<>();
    protected List<News> _relatedNews = new ArrayList<>();

    protected int _newsIndex;
    protected News _currentNews;

    protected RecyclerView _relatedNRecyclerView;
    protected RelatedNRecyclerViewAdapter _relatedNRecyclerViewAdapter;

    public FullNews() {
        // Required empty public constructor
    }

    public static FullNews newInstance() {
        FullNews fragment = new FullNews();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    //first time initialization
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            _newsList = getArguments().getParcelableArrayList("NewsList");
            _newsIndex = getArguments().getInt("NewsIndex");
            _currentNews = _newsList.get(_newsIndex);

            _title = _currentNews.getTitle();
            _description = _currentNews.getDesc();
            _imageIndex = _currentNews.getImage();
        }
        catch (Exception e) {
            Log.e("Error", e.getMessage());
        }

        getRelatedNews();
    }

    //initializes and inflates the view
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_full_news, container, false);
        return itemView;
    }

    //actions to take after the view has been inflated
    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        TextView titleView = view.findViewById(R.id.FullNewsTitleView);
        TextView descView = view.findViewById(R.id.FullNewsDescView);
        ImageView imageView = view.findViewById(R.id.FullNewsImageView);

        try {
            titleView.setText(_title);
            descView.setText(_description);
            imageView.setImageResource(_imageIndex);
        }
        catch (Exception e) {
            Log.e("Error", e.getMessage());
        }

        //set up related news recycler view
        _relatedNRecyclerView = view.findViewById(R.id.RelatedNRecyclerView);
        _relatedNRecyclerViewAdapter = new RelatedNRecyclerViewAdapter(_relatedNews, getActivity(), this::onItemClick);
        _relatedNRecyclerView.setAdapter(_relatedNRecyclerViewAdapter);
        RecyclerView.LayoutManager topNLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        _relatedNRecyclerView.setLayoutManager(topNLayoutManager);
    }

    //get the position of the clicked news item and send it to the fragment selector
    @Override public void onItemClick(int RNposition) {

        //get our news list position from our seleted related news position, then select that fragment
        int NLposition = getNewsPosition(RNposition);
        displayNewsFragment(NLposition);
    }

    //gets the position of news on the news list from given position on the related news list
    protected int getNewsPosition(int position) {
        //we've got the index of related news, now need to find index in full list
        for (int i = 0; i <_newsList.size(); i++) {
            News selectedNews = _newsList.get(i);
            if (_relatedNews.get(position) == selectedNews) {
                position = i;
                break;
            }
        }

        //got our position, so return it
        return position;
    }

    //jumps to the full story fragment, with the selected story
    protected void displayNewsFragment(int newsIndex) {
        Fragment fragment;
        fragment = new FullNews();
        Bundle bundle = new Bundle();

        //select our current news item and pass it along
        bundle.putInt("NewsIndex", newsIndex);
        bundle.putParcelableArrayList("NewsList", (ArrayList<? extends Parcelable>) _newsList);
        fragment.setArguments(bundle);

        //we want to use the fragment from the home page, so get the activity and its support fragment manager
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.HomePageFragment, fragment).addToBackStack(null).commit();
    }

    //takes the selected news and creates a new news list of related news items
    protected void getRelatedNews() {
        for (int i = 0; i < _newsList.size(); i++) {
            News selectedNews = _newsList.get(i);

            //check if selected news isn't our current news
            boolean differentNews = (i != _newsIndex);

            //check if selected news is same category
            boolean sameCategory = (selectedNews.getCategory() == _currentNews.getCategory());

            //check if selected news is from same publisher
            boolean samePublisher = (selectedNews.getPublisher() == _currentNews.getPublisher());

            //news is considered related if it's in the same category or from the same publisher
            if (differentNews & (sameCategory | samePublisher)){ _relatedNews.add(selectedNews); }
        }
    }
}