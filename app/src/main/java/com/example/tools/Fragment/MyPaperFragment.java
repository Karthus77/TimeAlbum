package com.example.tools.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.tools.Activity.WriteActivity;
import com.example.tools.Adapter.PaperAdapter;
import com.example.tools.MyData;
import com.example.tools.R;
import com.example.tools.tools.MyNews;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MyPaperFragment extends Fragment {
    private RelativeLayout go_edit;
    private PaperAdapter adapter;
    private String token;
    private RecyclerView recyclerView;
    private RelativeLayout backs;
    private TextView name;
    private ImageView img;
    private int id;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_paper, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        backs = getActivity().findViewById(R.id.backshow);
        name = getActivity().findViewById(R.id.myPaper_name);
        img = getActivity().findViewById(R.id.myPaper_userHead);
        go_edit = Objects.requireNonNull(getActivity()).findViewById(R.id.go_edit);
        go_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WriteActivity.class);
                startActivity(intent);
            }
        });
        MyData myData = new MyData(getContext());
        token = myData.load_token();
        name.setText(myData.load_name());
        Glide.with(getContext()).load(myData.load_pic_url()).error(R.drawable.user_icon).circleCrop().into(img);

        //加载新闻

        List<MyNews> list = new ArrayList<>();


    }
}


