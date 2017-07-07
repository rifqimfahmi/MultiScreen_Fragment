package com.renotekno.zcabez.multiscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.renotekno.zcabez.multiscreen.adapter.WordAdapter;
import com.renotekno.zcabez.multiscreen.model.Word;

import java.util.ArrayList;

public class PhrasesActivity extends Fragment {

    private ListView phrasesListView;
    private WordAdapter wordAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_phrases, container, false);
        phrasesListView = (ListView) view.findViewById(R.id.activity_phrases);

        ArrayList<Word> colors = new ArrayList<Word>();
        colors.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        colors.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        colors.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        colors.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        colors.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        colors.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        colors.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        colors.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        colors.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        colors.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        wordAdapter = new WordAdapter(getContext(), colors, R.color.colorPrimaryPhrases);

        phrasesListView.setAdapter(wordAdapter);
        phrasesListView.setOnItemClickListener(wordAdapter);

        return view;
    }

    @Override
    public void onStop() {
        if(wordAdapter != null) wordAdapter.releaseMedia();
        super.onStop();
    }

}
