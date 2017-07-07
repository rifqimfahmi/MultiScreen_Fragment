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

public class NumbersActivity extends Fragment {

    private ListView numbersListView;
    private WordAdapter wordAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_numbers, container, false);
        numbersListView = (ListView) view.findViewById(R.id.numbersListView);

        ArrayList<Word> numbers = new ArrayList<Word>();
        numbers.add(new Word("One", "lutti", R.drawable.number_one, R.raw.number_one));
        numbers.add(new Word("Two", "otiiko", R.drawable.number_two, R.raw.number_two));
        numbers.add(new Word("Three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        numbers.add(new Word("Four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        numbers.add(new Word("Five", "massokka", R.drawable.number_five, R.raw.number_five));
        numbers.add(new Word("Six", "temmokka", R.drawable.number_six, R.raw.number_six));
        numbers.add(new Word("Seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new Word("Eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new Word("Nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new Word("Ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        wordAdapter = new WordAdapter(getContext(), numbers, R.color.colorPrimaryNumbers);

        numbersListView.setAdapter(wordAdapter);
        numbersListView.setOnItemClickListener(wordAdapter);

        return view;
    }



}
