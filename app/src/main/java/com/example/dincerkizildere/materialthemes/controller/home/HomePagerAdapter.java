package com.example.dincerkizildere.materialthemes.controller.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dincerkizildere.materialthemes.R;
import com.example.dincerkizildere.materialthemes.controller.home.material.MaterialThemeInCodeFragment;
import com.example.dincerkizildere.materialthemes.controller.home.material.MaterialThemeInXmlFragment;

import java.lang.ref.WeakReference;

public class HomePagerAdapter extends FragmentPagerAdapter {
    private WeakReference<Context> mContextRef;

    public HomePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContextRef=new WeakReference<Context>(context);
    }

    @Override
    public Fragment getItem(int i) {
        HomePage homePage= getWhichHomePage(i);

        switch (homePage){
            case THEME_IN_XML:
                return MaterialThemeInXmlFragment.newInstance();
            case THEME_IN_CODE:
                return MaterialThemeInCodeFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return HomePage.values().length;
    }


    @Override
    public CharSequence getPageTitle(int position){
        HomePage homePage=getWhichHomePage(position);

        Context context=mContextRef.get();
        if (context!=null){
            switch (homePage){
                case THEME_IN_XML:
                    return context.getString(R.string.home_tab_xml);
                case THEME_IN_CODE:
                    return context.getString(R.string.home_tab_code);
            }
        }
        return null;
    }


    private HomePage getWhichHomePage(int position) {
        return HomePage.values()[position];
    }
    private enum HomePage {
        THEME_IN_XML,
        THEME_IN_CODE
    }

}
