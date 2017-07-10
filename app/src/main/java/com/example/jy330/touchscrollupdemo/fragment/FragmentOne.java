package com.example.jy330.touchscrollupdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.jy330.touchscrollupdemo.adapter.MyRecyclerViewAdapter;
import com.example.jy330.touchscrollupdemo.R;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by sming on 2017/6/24 0024.
 */
public class FragmentOne extends Fragment {
    private static FragmentOne instance=null;
    public static FragmentOne newInstance() {
        if(instance==null){
            instance= new FragmentOne();
        }
        return instance;
    }
    private FragmentOne(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(getActivity(), datas));
        return view;
    }


}
