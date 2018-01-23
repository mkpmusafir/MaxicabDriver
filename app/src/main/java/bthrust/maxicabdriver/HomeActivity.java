package bthrust.maxicabdriver;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import bthrust.maxicabdriver.Fragment.CancelBookingFragment;
import bthrust.maxicabdriver.Fragment.CompletedBookingFragment;
import bthrust.maxicabdriver.Fragment.NewBookingFragment;

public class HomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setUpViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        adapter.addFrag(new NewBookingFragment(),"New Booking");
        adapter.addFrag(new CompletedBookingFragment(),"Completed");
        adapter.addFrag(new CancelBookingFragment(),"Cancelled");
        viewPager.setAdapter(adapter);

    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> wFragmentList = new ArrayList<>();
        private final List<String> wFragmentTitleList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {

            return wFragmentList.get(position);
        }
        @Override
        public int getCount() {
            return wFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            wFragmentList.add(fragment);
            wFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return wFragmentTitleList.get(position);
        }
    }
}
