package com.example.animationmenulibary;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ContentAdapter extends FragmentPagerAdapter {

    private String[] menuNames = new String[]{
            "One", "Two"
    };

    public ContentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return TabOneFragment.newInstance();
        } else {
            return TabTwoFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return menuNames.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return menuNames[position];
    }
}
