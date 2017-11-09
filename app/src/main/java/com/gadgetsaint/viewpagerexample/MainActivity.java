package com.gadgetsaint.viewpagerexample;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.MainThread;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
                R.drawable.clipboard,
                R.drawable.globe,
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

    public void onClick1(View view) {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", "Poštovani , \n\nNajbolje je da se javite Nebojši na 069/110 10 45 u periodu između 08h i "
                + "23h svakog dana (i vikendom), i on će Vam " + "pružiti najdetaljnije moguće informacije " + "u vezi željene opreme za Vaš " +
                "automobil.  \n\nS poštovanjem, \nRollbar-Bullbar \nBeograd");
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this,"Your message has been copied to clipboard.",Toast.LENGTH_LONG).show();

        /*Handler handler = new Handler();

        *//*handler.postDelayed(new Runnable() {
            public void run() {






                finish();

            }
        }, 500);*/


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

        Toast.makeText(MainActivity.this,"Your message has been copied to clipboard.Starting KP inbox.",Toast.LENGTH_LONG).show();


        //WHATSAPP DIRECT MESSAGE
        /*String toNumber = "+381 69110 1045"; // contains spaces.
        toNumber = toNumber.replace("+", "").replace(" ", "");

        Intent sendIntent = new Intent("android.intent.action.MAIN");
        sendIntent.putExtra("jid", toNumber + "@s.whatsapp.net");
        sendIntent.putExtra(Intent.EXTRA_TEXT, " ");
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setPackage("com.whatsapp");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);*/


        finish();




    }

    public void onClick3(View view) {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", "Poštovani , \n\nNajbolje je da se javite Nebojši na 069/110 10 45 u periodu između 08h i "
                + "23h svakog dana (i vikendom), i on će Vam " + "pružiti najdetaljnije moguće informacije " + "u vezi željene opreme za Vaš " +
                "automobil.  \n\nS poštovanjem, \nRollbar-Bullbar \nBeograd");
        clipboard.setPrimaryClip(clip);
        PackageManager pm = getPackageManager();

        Toast.makeText(MainActivity.this,"Your message has been copied to clipboard.Starting Google Inbox.",Toast.LENGTH_LONG).show();
        Intent intent = pm.getLaunchIntentForPackage("com.google.android.apps.inbox");
        startActivity(intent);



        finish();




    }
}
