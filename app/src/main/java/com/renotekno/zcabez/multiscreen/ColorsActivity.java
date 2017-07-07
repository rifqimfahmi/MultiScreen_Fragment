package com.renotekno.zcabez.multiscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.renotekno.zcabez.multiscreen.adapter.WordAdapter;
import com.renotekno.zcabez.multiscreen.model.Word;

import java.util.ArrayList;

public class ColorsActivity extends Fragment {

    private ListView activityColors;
    private WordAdapter wordAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_colors, container, false);
        activityColors = (ListView) view.findViewById(R.id.activity_colors);

        ArrayList<Word> colors = new ArrayList<Word>();
        colors.add(new Word("Red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        colors.add(new Word("Green", "chokokki", R.drawable.color_green, R.raw.color_green));
        colors.add(new Word("Brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        colors.add(new Word("Gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        colors.add(new Word("Black", "kululli", R.drawable.color_black, R.raw.color_black));
        colors.add(new Word("White", "kelelli", R.drawable.color_white, R.raw.color_white));
        colors.add(new Word("Dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colors.add(new Word("Mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        wordAdapter = new WordAdapter(getContext(), colors, R.color.colorPrimaryColors);

        activityColors.setAdapter(wordAdapter);
        activityColors.setOnItemClickListener(wordAdapter);

        return view;
    }

    @Override
    public void onStop() {
        if(wordAdapter != null) wordAdapter.releaseMedia();
        super.onStop();
    }

}
