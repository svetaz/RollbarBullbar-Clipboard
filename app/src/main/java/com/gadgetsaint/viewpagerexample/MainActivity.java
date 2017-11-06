package com.gadgetsaint.viewpagerexample;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gadgetsaint.viewpagerexample.fragments.FragmentOne;
import com.gadgetsaint.viewpagerexample.fragments.FragmentThree;
import com.gadgetsaint.viewpagerexample.fragments.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "CLIPBOARD");
        adapter.addFragment(new FragmentTwo(), "KP");
        adapter.addFragment(new FragmentThree(), "INBOX");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //An array containing your icons from the drawable directory
        final int[] ICONS = new int[]{
                R.drawable.icon_1,
                R.drawable.icon_2,
                R.drawable.icon_3
        };

        //Get reference to your Tablayout
        TabLayout tabLayout1 = (TabLayout) findViewById(R.id.tabs);
        tabLayout1.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(ICONS[0]);
        tabLayout.getTabAt(1).setIcon(ICONS[1]);
        tabLayout.getTabAt(2).setIcon(ICONS[2]);


    }



// Adapter for the viewpager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void onClick(View view) {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", "Poštovani , \n\nNajbolje je da se javite Nebojši na 069/110 10 45 u periodu između 08h i "
                + "23h svakog dana (i vikendom), i on će Vam " + "pružiti najdetaljnije moguće informacije " + "u vezi željene opreme za Vaš " +
                "automobil.  \n\nS poštovanjem, \nRollbar-Bullbar \nBeograd");
        clipboard.setPrimaryClip(clip);


        finish();




    }

    public void onClick2(View view) {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", "Poštovani , \n\nNajbolje je da se javite Nebojši na 069/110 10 45 u periodu između 08h i "
                + "23h svakog dana (i vikendom), i on će Vam " + "pružiti najdetaljnije moguće informacije " + "u vezi željene opreme za Vaš " +
                "automobil.  \n\nS poštovanjem, \nRollbar-Bullbar \nBeograd");
        clipboard.setPrimaryClip(clip);
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.kupujemprodajem.com/message.php?action=inbox"));
        startActivity(i);


        finish();




    }

    public void onClick3(View view) {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", "Poštovani , \n\nNajbolje je da se javite Nebojši na 069/110 10 45 u periodu između 08h i "
                + "23h svakog dana (i vikendom), i on će Vam " + "pružiti najdetaljnije moguće informacije " + "u vezi željene opreme za Vaš " +
                "automobil.  \n\nS poštovanjem, \nRollbar-Bullbar \nBeograd");
        clipboard.setPrimaryClip(clip);
        PackageManager pm = getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage("com.google.android.apps.inbox");
        startActivity(intent);


        finish();




    }
}
