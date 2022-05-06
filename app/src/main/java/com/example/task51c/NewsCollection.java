package com.example.task51c;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

//static class that's used to store all our articles
public final class NewsCollection {
    public static List<News> getNews() {
        List<News> _newsList = new ArrayList<>();

        //news 1
        String news1Title = "Students on Strike";
        String news1Desc = "100s of students at a local school went on strike this morning, an event allegedly years in planning. We spoke to the ring-leader, a 10-year-old Bart Simpson. claiming 'education is unnecessary and unethical'. Testimonies of Bart's co-workers allege that he is a known trouble-maker. His parents were unavailable to comment.";
        String news1Publish = "9 News";
        String news1Categories = "General";
        int news1Image = R.drawable.bart;
        int news1Thumb = R.drawable.bartthumb;
        _newsList.add(new News(news1Title, news1Desc, news1Publish, news1Categories, news1Image, news1Thumb));

        //news 2
        String news2Title = "Toilet-Tissue Thief Takes Them All!";
        String news2Desc = "In yet another bizarre attack, the infamous 'toilet-tissue thief' has struck a Burwood supermarket, stealing 100's of dollars worth of toilet paper. Eye-witness accounts report seeing a fire in the liquor store next-door, allowing the thief to sneak into the main store unnoticed. Nobody was harmed in the atack.";
        String news2Publish = "9 News";
        String news2Categories = "Crime";
        int news2Image = R.drawable.toilet;
        int news2Thumb = R.drawable.toiletthumb;
        _newsList.add(new News(news2Title, news2Desc, news2Publish, news2Categories, news2Image, news2Thumb));

        //news 3
        String news3Title = "Cat Stuck in Tree";
        String news3Desc = "For 5 hours Mr. Frisky, a beautiful ragdoll cat belonging to a local man was stuck up the 30 metre tree. Mr. Frisky refused to come down, and the fire brigade had to rescue him. The estimated cost of the callout was $5000 dollars, leaving today a very expensive field-trip for 'Mr. Frisky'.";
        String news3Publish = "Channel 10";
        String news3Categories = "General";
        int news3Image = R.drawable.cat;
        int news3Thumb = R.drawable.catthumb;
        _newsList.add(new News(news3Title, news3Desc, news3Publish, news3Categories, news3Image, news3Thumb));

        //news 4
        String news4Title = "Scott Morrison Embarrasses Himself and Nation Yet Again";
        String news4Desc = "Scott Morrison has disgraced himself yet again by this time attempting to play the ANZAC song with the harmonica. Veterans report feeling insulted and outraged at his performance.";
        String news4Publish = "The Sun";
        String news4Categories = "Politics";
        int news4Image = R.drawable.scomo;
        int news4Thumb = R.drawable.scomothumb;
        _newsList.add(new News(news4Title, news4Desc, news4Publish, news4Categories, news4Image, news4Thumb));

        //news 5
        String news5Title = "Elon Musk First Extra-Terrestrial Criminal";
        String news5Desc = "The world-famous CEO of Tesla and SpaceX today was charged with harassment and assault of an anonymous astronaut on the International Space Station. This occasion marks the historic event of the first crime being committed in outer-space. Elon Musk argues that while he did attack the astronaut, he insists that '[they] weren't listening to [his] radical idea on how to terraform Mars in just one year. And besides, we're not in any sovereign territory so the law doesn't exist out here.";
        String news5Publish = "The Sun";
        String news5Categories = "Crime";
        int news5Image = R.drawable.elonmusk;
        int news5Thumb = R.drawable.elonmusksquare;
        _newsList.add(new News(news5Title, news5Desc, news5Publish, news5Categories, news5Image, news5Thumb));

        //news 6
        String news6Title = "Who to Vote for in the Election";
        String news6Desc = "Our panel of political experts at Channel 10 have put worked together to determine which parties you, the reader, should vote for in the upcoming election, by area. After great discussion, the panel has concluded that all voters should aim to put the newly established 'Channel 10 Political Party Australia' as their number 1 vote. We believe that the C10PPA will lead Australia to a brighter future without the bias of other media outlets, just the truth that only Channel 10 can bring you.";
        String news6Publish = "Channel 10";
        String news6Categories = "Politics";
        int news6Image = R.drawable._0news;
        int news6Thumb = R.drawable._0thumb;
        _newsList.add(new News(news6Title, news6Desc, news6Publish, news6Categories, news6Image, news6Thumb));

        return _newsList;
    }
}
