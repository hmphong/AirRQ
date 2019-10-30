package com.example.airrq.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.airrq.R;
import com.example.airrq.databinding.ActivityMainBinding;
import com.example.airrq.model.AirModel;
import com.example.airrq.view.adapter.RecyclerAdapter;
import com.example.airrq.viewmodel.AirViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    AirViewModel airViewModel;
    AirModel airModel;
    RecyclerAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        airModel = new AirModel();

        airViewModel = ViewModelProviders.of(MainActivity.this).get(AirViewModel.class);
        airViewModel.getLiveModel().observe(MainActivity.this, new Observer<AirModel>() {
            @Override
            public void onChanged(AirModel airModel) {
                if (airModel!=null){
                    airViewModel.setViewModel(airModel);
                    activityMainBinding.reCycler.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL,false));
                    myAdapter = new RecyclerAdapter(airViewModel.getListToRecycler());
                    activityMainBinding.reCycler.setAdapter(myAdapter);
                    activityMainBinding.setViewmodel(airViewModel);
                }
            }
        });


    }
}
