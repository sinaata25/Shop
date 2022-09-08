package myapp.co.shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import myapp.co.shop.adapters.NavAdapter;
import myapp.co.shop.fragments.Categories;
import myapp.co.shop.fragments.Home;
import myapp.co.shop.fragments.Profile;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    NavAdapter navAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
        setTablayoutNavs();
    }

    private void setUpViews() {
        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tabLayout);

    }


    void setTablayoutNavs(){
        viewPager.setAdapter(navAdapter);
        navAdapter=new NavAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        navAdapter.addfragment(new Profile());
        navAdapter.addfragment(new Home());
        navAdapter.addfragment(new Categories());
        viewPager.setAdapter(navAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setTabLayoutIcons();
        viewPager.setCurrentItem(1);

    }


    void setTabLayoutIcons(){
       tabLayout.getTabAt(0).setIcon(R.drawable.user);
        tabLayout.getTabAt(1).setIcon(R.drawable.homeshop);
        tabLayout.getTabAt(2).setIcon(R.drawable.categories1);

    }





}