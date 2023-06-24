package com.example.animationmenulibary;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.example.animatedmenulibrary.OnSlideChangedListener;
import com.example.animatedmenulibrary.SlideMenuLayout;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private String TAG = this.getClass().getSimpleName();
  //ui
  private SlideMenuLayout slideMenuLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    actionBar.hide();
    setContentView(R.layout.activity_main);
    //initStatusBar();
    initView();
  }

  private void initView() {
    slideMenuLayout = (SlideMenuLayout) findViewById(R.id.mainSlideMenu);

    //right
    TabLayout slideTabLayout = (TabLayout) findViewById(R.id.fmr_tab);
    ViewPager slideViewPager = (ViewPager) findViewById(R.id.fmr_vp);
    slideTabLayout.addTab(slideTabLayout.newTab());
    slideTabLayout.addTab(slideTabLayout.newTab());
    slideViewPager.setAdapter(new SlideRightMenuAdapter(getSupportFragmentManager()));
    slideTabLayout.setupWithViewPager(slideViewPager);
    //left
    RecyclerView leftRecyclerView = (RecyclerView) findViewById(R.id.cml_rv);
    leftRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    SlideLeftAdapter slideLeftAdapter = new SlideLeftAdapter(this);
    leftRecyclerView.setAdapter(slideLeftAdapter);
    //content
    TabLayout contentTabLayout = (TabLayout) findViewById(R.id.am_tab);
    ViewPager contentViewPager = (ViewPager) findViewById(R.id.am_vp);
    contentTabLayout.addTab(contentTabLayout.newTab());
    contentTabLayout.addTab(contentTabLayout.newTab());
    contentViewPager.setAdapter(new ContentAdapter(getSupportFragmentManager()));
    contentTabLayout.setupWithViewPager(contentViewPager);

    findViewById(R.id.fm_leftMenu).setOnClickListener(this);
    findViewById(R.id.fm_rightMenu).setOnClickListener(this);
    slideMenuLayout.addOnSlideChangedListener(new OnSlideChangedListener() {
      @Override
      public void onSlideChanged(SlideMenuLayout slideMenu, boolean isLeftSlideOpen, boolean isRightSlideOpen) {
        Log.d(TAG, "onSlideChanged:isLeftSlideOpen=" + isLeftSlideOpen + ":isRightSlideOpen=" + isRightSlideOpen);
      }
    });
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.fm_leftMenu:
        slideMenuLayout.toggleLeftSlide();
        break;
      case R.id.fm_rightMenu:
        slideMenuLayout.toggleRightSlide();
        break;
    }
  }

  @Override
  public void onBackPressed() {
    if (slideMenuLayout.isLeftSlideOpen() || slideMenuLayout.isRightSlideOpen()) {
      slideMenuLayout.closeLeftSlide();
      slideMenuLayout.closeRightSlide();
    } else {
      super.onBackPressed();
    }
  }
}
