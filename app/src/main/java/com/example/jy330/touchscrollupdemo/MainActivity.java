package com.example.jy330.touchscrollupdemo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.jy330.touchscrollupdemo.adapter.MyViewPagerAdapter;
import com.example.jy330.touchscrollupdemo.fragment.FragmentOne;
import com.example.jy330.touchscrollupdemo.fragment.FragmentThree;
import com.example.jy330.touchscrollupdemo.fragment.FragmentTwo;

/**
 * Created by sming on 2017/6/24 0024.
 */
public class MainActivity extends AppCompatActivity{
    AppBarLayout appbar;
    EditText et_view;
    Toolbar mToolbar;
    ImageView imageView;
    ImageView view;
    View view_hr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        et_view = (EditText) findViewById(R.id.et_view);
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        imageView = (ImageView) findViewById(R.id.ivRight);
        view = (ImageView) findViewById(R.id.ivLeft);
        view_hr = findViewById(R.id.view_hr);
//        mToolbar.inflateMenu(R.menu.tool_menu);
//        setSupportActionBar(mToolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
        MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(FragmentOne.newInstance(), "TabOne");//添加Fragment
        viewPagerAdapter.addFragment(FragmentTwo.newInstance(), "TabTwo");
        viewPagerAdapter.addFragment(FragmentThree.newInstance(), "TabThree");
        mViewPager.setAdapter(viewPagerAdapter);//设置适配器
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.addTab(mTabLayout.newTab().setText("TabOne"));//给TabLayout添加Tab
        mTabLayout.addTab(mTabLayout.newTab().setText("TabTwo"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TabThree"));
        mTabLayout.setupWithViewPager(mViewPager);//给TabLayout设置关联ViewPager，如果设置了ViewPager，那么ViewPagerAdapter中的getPageTitle()方法返回的就是Tab上的标题
        appbar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if( state == State.EXPANDED ) {
                    //展开状态
//                    mToolbar.setNavigationIcon(R.drawable.back);
                    Drawable drawable= getResources().getDrawable(R.drawable.search);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    et_view.setCompoundDrawables(drawable,null,null,null);
                    imageView.setImageResource(R.drawable.list_meun);
                    view.setImageResource(R.drawable.back);
                    view_hr.setBackgroundColor(getResources().getColor(R.color.color_w));
                }else if(state == State.COLLAPSED){
                    //折叠状态
//                    mToolbar.setNavigationIcon(R.drawable.back_black);
                    Drawable drawable= getResources().getDrawable(R.drawable.search_black);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    et_view.setCompoundDrawables(drawable,null,null,null);
                    imageView.setImageResource(R.drawable.list_meun2);
                    view.setImageResource(R.drawable.back_black);
                    view_hr.setBackgroundColor(getResources().getColor(R.color.color_black));
                }else {
                    //中间状态
                    Drawable drawable= getResources().getDrawable(R.drawable.search);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    et_view.setCompoundDrawables(drawable,null,null,null);
                    imageView.setImageResource(R.drawable.list_meun);
                    view.setImageResource(R.drawable.back);
                    view_hr.setBackgroundColor(getResources().getColor(R.color.color_w));
                }
            }
        });
    }


}