package com.example.jy330.touchscrollupdemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
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
public class FragmentThree extends Fragment {

    private static FragmentThree instance=null;
    public static FragmentThree newInstance() {
        if(instance==null){
            instance= new FragmentThree();
        }
        return instance;
    }
    private FragmentThree(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(getActivity(), datas));
        return view;
    }


}
