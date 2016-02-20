package com.konnectify.www.konnectify;

/**
 * Created by rushabh.a.sheth on 15-02-2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import swipecard.SwipeFlingAdapterView;


public class fragment_starred_friends extends Fragment {


    public static card_adapter mCardAdapter;
    private ArrayList<card_data> starred_friends_list;
    private SwipeFlingAdapterView flingContainer;


    public fragment_starred_friends() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String res1 = "advait_alai";
        String res2 = "akash_mehta";
        String res3 = "archana_das";
        String res4 = "mark_pakhuongte";
        String res5 = "rahul_kishore";
        String res6 = "rushabh_sheth";
        String res7 = "sanjana_basu";

        starred_friends_list = new ArrayList<>();
        starred_friends_list.add(new card_data(getResources().getIdentifier(res1, "drawable",getContext().getPackageName()),"Advait Alai"));
        starred_friends_list.add(new card_data(getResources().getIdentifier(res2, "drawable",getContext().getPackageName()),"Akash Mehta"));
        starred_friends_list.add(new card_data(getResources().getIdentifier(res3, "drawable",getContext().getPackageName()),"Archana Das"));
        starred_friends_list.add(new card_data(getResources().getIdentifier(res4, "drawable",getContext().getPackageName()),"Mark Pakhuongte"));
        starred_friends_list.add(new card_data(getResources().getIdentifier(res5, "drawable",getContext().getPackageName()),"Rahul Kishore"));
        starred_friends_list.add(new card_data(getResources().getIdentifier(res6, "drawable",getContext().getPackageName()),"Rushabh Sheth"));
        starred_friends_list.add(new card_data(getResources().getIdentifier(res7, "drawable",getContext().getPackageName()),"Sanjana Basu"));

        mCardAdapter = new card_adapter(starred_friends_list, getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_starred_friends, container, false);

        flingContainer = (SwipeFlingAdapterView) view.findViewById(R.id.frame);
        flingContainer.setAdapter(mCardAdapter);
        setListeners();

        return view;
    }

    public void setListeners(){
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {

            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                starred_friends_list.remove(0);
                mCardAdapter.notifyDataSetChanged();
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject

            }

            @Override
            public void onRightCardExit(Object dataObject) {

                starred_friends_list.remove(0);
                mCardAdapter.notifyDataSetChanged();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);

                mCardAdapter.notifyDataSetChanged();
            }
        });
    }

}


