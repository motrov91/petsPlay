package com.example.ingmanuel.petsplay.UI;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ingmanuel.petsplay.Adapters.ViewPagerAdapter;
import com.example.ingmanuel.petsplay.Fragments.CreateNewUser;
import com.example.ingmanuel.petsplay.Fragments.viewPagerFragments.page1;
import com.example.ingmanuel.petsplay.Fragments.viewPagerFragments.page2;
import com.example.ingmanuel.petsplay.Fragments.viewPagerFragments.page3;
import com.example.ingmanuel.petsplay.Fragments.viewPagerFragments.page4;
import com.example.ingmanuel.petsplay.Fragments.viewPagerFragments.page5;
import com.example.ingmanuel.petsplay.Interface.IComCreateUser;
import com.example.ingmanuel.petsplay.Interface.IComFragments;
import com.example.ingmanuel.petsplay.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainViewPager extends AppCompatActivity implements page5.OnFragmentInteractionListener, CreateNewUser.OnFragmentInteractionListener,
        IComCreateUser {

    ViewPager viewPager;
    ViewPagerAdapter pagerAdapter;
    SpringDotsIndicator springDotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_pager);

        springDotsIndicator = findViewById(R.id.dots_indicator);

        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        springDotsIndicator.setViewPager(viewPager);

    }

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment newInstance(int sectionNumber) {

            Fragment fragment = null;

            switch (sectionNumber){
                case 1: fragment = new page1();
                    break;
                case 2: fragment = new page2();
                    break;
                case 3: fragment = new page3();
                    break;
                case 4: fragment = new page4();
                    break;
                case 5: fragment = new page5();
                    break;

            }

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main_view_pager, container, false);

            return rootView;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void sendCreateUser() {
       CreateNewUser createNewUser = new CreateNewUser();
       getSupportFragmentManager().beginTransaction().replace(R.id.content_main, createNewUser).addToBackStack(null).commit();
    }
}
