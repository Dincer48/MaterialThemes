package com.example.dincerkizildere.materialthemes.controller.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;

import com.example.dincerkizildere.materialthemes.R;
import com.example.dincerkizildere.materialthemes.controller.dialog.DialogUtils;
import com.example.dincerkizildere.materialthemes.controller.theme.MaterialTheme;
import com.example.dincerkizildere.materialthemes.log.LogUtils;

import timber.log.Timber;

public class HomeActivity  extends AppCompatActivity implements View.OnClickListener {


    private static final String KEY_ARG_CURRENT_THEME = "KEY_ARG_CURRENT_THEME";

    private MaterialTheme mCurrentTheme;

    public static Intent newInstanceIntent(Context context, MaterialTheme currentTheme){
        Timber.v(LogUtils.METHOD_ONLY);

        Intent intent=new Intent(context, HomeActivity.class);

        Bundle args=intent.getExtras();
        if (args==null){
            args=new Bundle();
        }

        args.putSerializable(KEY_ARG_CURRENT_THEME, currentTheme);
        intent.putExtras(args);

        return  intent;
    }

    @Override
    protected void  onCreate(Bundle savedInstanceState){

        Bundle args=getIntent().getExtras();

        if (args==null){
            mCurrentTheme=null;
        }
        else{
            mCurrentTheme=(MaterialTheme)args.getSerializable(KEY_ARG_CURRENT_THEME);
        }
        if (mCurrentTheme==null){
            mCurrentTheme=MaterialTheme.THEME_TEAL;
        }

        setTheme(mCurrentTheme.getThemeResId());

        super.onCreate(savedInstanceState);
        Timber.v(LogUtils.getSavedInstanceStateNullMessage(savedInstanceState));


        setContentView(R.layout.activity_home);
        Toolbar toolbar=(Toolbar) findViewById(R.id.activity_home_toolbar);
        ViewPager viewPager=(ViewPager) findViewById(R.id.activity_home_pager);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.activity_home_tab_layout);


        if (savedInstanceState==null){

        }
        else{

        }

        setSupportActionBar(toolbar);

        HomePagerAdapter viewPagerAdapter=new HomePagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.activity_home_fab);
        fab.setOnClickListener(this);
    }


    @Override
    public void onStart(){
        super.onStart();
        Timber.v(LogUtils.METHOD_ONLY);
    }
    @Override
    public void onResume(){
        super.onResume();
        Timber.v(LogUtils.METHOD_ONLY);
    }
    @Override
    public void onPause() {
        super.onPause();
        Timber.v(LogUtils.METHOD_ONLY);
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Timber.v(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onStop() {
        super.onStop();
        Timber.v(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.v(LogUtils.METHOD_ONLY);
    }

    @Override
    public void onClick(View v){
        Timber.d(LogUtils.METHOD_ONLY);

        switch (v.getId()){
            case R.id.activity_home_fab:
                DialogFragment dialogFragment=SetThemeDialogFragment.newInstance(mCurrentTheme);
                DialogUtils.showDialogFragment(getSupportFragmentManager(),dialogFragment);
                break;
                default:
                    Timber.w("Bilinmeyen Görünüm Tıklandı");
                    break;
        }
    }


}
