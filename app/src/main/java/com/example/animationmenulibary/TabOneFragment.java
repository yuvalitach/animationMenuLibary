package com.example.animationmenulibary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabOneFragment extends Fragment {

    public static TabOneFragment newInstance() {
        Bundle args = new Bundle();
        TabOneFragment fragment = new TabOneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frg_tab_one, container, false);
        return rootView;
    }
}
