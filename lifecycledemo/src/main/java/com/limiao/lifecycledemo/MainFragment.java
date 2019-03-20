package com.limiao.lifecycledemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by miao on 2019/3/8.
 */
public class MainFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("MainFragment", "on attach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("MainFragment", "on create");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("MainFragment", "on create view");
        return inflater.inflate(R.layout.activity_main,null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("MainFragment", "on view create");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("MainFragment", "on activity create");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("MainFragment", "on resume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("MainFragment", "on pause");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("MainFragment", "on start");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("MainFragment", "on stop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MainFragment", "on destroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("MainFragment", "on destroy view ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("MainFragment", "on detach");
    }

}
