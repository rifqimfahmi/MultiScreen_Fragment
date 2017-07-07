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

public class FamilyActivity extends Fragment {


    private ListView activityFamily;
    private WordAdapter wordAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_family, container, false);
        activityFamily = (ListView) view.findViewById(R.id.activity_family);

        ArrayList<Word> familyMembers = new ArrayList<Word>();
        familyMembers.add(new Word("Father", "әpә", R.drawable.family_grandfather, R.raw.family_father));
        familyMembers.add(new Word("Mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        familyMembers.add(new Word("Son", "angsi", R.drawable.family_son, R.raw.family_son));
        familyMembers.add(new Word("Daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        familyMembers.add(new Word("Older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyMembers.add(new Word("Younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyMembers.add(new Word("Older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyMembers.add(new Word("Younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyMembers.add(new Word("Grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyMembers.add(new Word("Grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        wordAdapter = new WordAdapter(getContext(), familyMembers, R.color.colorPrimaryFamily);

        activityFamily.setAdapter(wordAdapter);
        activityFamily.setOnItemClickListener(wordAdapter);

        return view;
    }

    @Override
    public void onStop() {
        if(wordAdapter != null) wordAdapter.releaseMedia();
        super.onStop();
    }
}
