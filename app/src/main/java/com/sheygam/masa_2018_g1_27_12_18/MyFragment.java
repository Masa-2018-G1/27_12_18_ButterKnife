package com.sheygam.masa_2018_g1_27_12_18;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    @BindView(R.id.titleTxt)TextView titleTxt;
//    @BindView(R.id.clickBtn)Button clickBtn;
    private Unbinder unbinder;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_my, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.clickBtn)
    public void setText(){
        titleTxt.setText("My super title");
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
