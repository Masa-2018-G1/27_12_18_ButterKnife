package com.sheygam.masa_2018_g1_27_12_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity implements MyAdapter.Callback {
    @BindView(R.id.myRv)RecyclerView myRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        MyAdapter adapter = new MyAdapter();
        adapter.setCallback(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        DividerItemDecoration divider = new DividerItemDecoration(this,manager.getOrientation());
        myRv.setAdapter(adapter);
        myRv.setLayoutManager(manager);
        myRv.addItemDecoration(divider);
    }

    @Override
    public void onRowClick(int position) {
        //ToDo
        Toast.makeText(this, "Click " + position, Toast.LENGTH_SHORT).show();
    }
}
