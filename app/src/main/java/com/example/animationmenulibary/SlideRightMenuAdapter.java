package com.example.animationmenulibary;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SlideRightMenuAdapter extends FragmentPagerAdapter {

    private String[] menuNames = new String[]{
            "chat", "contacts"
    };

    public SlideRightMenuAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return ChatFragment.newInstance();
        } else {
            return ContactsFragment.newInstance();
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
