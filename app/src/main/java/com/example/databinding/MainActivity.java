package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.databinding.databinding.ActivityMainBinding;
import com.example.databinding.models.Product;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    private static final String TAG = "MainActivity";

    //data binding
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        init();
    }

//    private void init(){
//        ViewProductFragment fragment = new ViewProductFragment();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.main_container, fragment, getString(R.string.fragment_main));
//        transaction.commit();
//    }


    private void init(){
        MainFragment fragment = new MainFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, fragment, getString(R.string.fragment_main));
        transaction.commit();
    }

    @Override
    public void inflateViewProductFragment(Product product) {
        Log.d(TAG, "inflateViewProductFragment: called.");

        ViewProductFragment fragment = new ViewProductFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(getString(R.string.intent_product), product);
        fragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, fragment, getString(R.string.fragment_view_product));
        transaction.addToBackStack(getString(R.string.fragment_view_product));
        transaction.commit();

    }


//    @Override
//    public void inflateViewProductFragment(Product product) {
//        Log.d(TAG, "inflateViewProductFragment: called.");
//
//        ViewProductFragment fragment = new ViewProductFragment();
//
//        Bundle bundle = new Bundle();
//        bundle.putParcelable(getString(R.string.intent_product), product);
//        fragment.setArguments(bundle);
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.main_container, fragment, getString(R.string.fragment_view_product));
//        transaction.addToBackStack(getString(R.string.fragment_view_product));
//        transaction.commit();
//    }
}
