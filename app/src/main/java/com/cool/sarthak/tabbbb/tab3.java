package com.cool.sarthak.tabbbb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sarthak on 27/12/17.
 */

public class tab3 extends Fragment {
    private static final String TAG = "tab3";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout3,container,false);
        return view;
    }
}
