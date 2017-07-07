package com.renotekno.zcabez.multiscreen.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.renotekno.zcabez.multiscreen.ColorsActivity;
import com.renotekno.zcabez.multiscreen.FamilyActivity;
import com.renotekno.zcabez.multiscreen.NumbersActivity;
import com.renotekno.zcabez.multiscreen.PhrasesActivity;

/**
 * Created by zcabez on 03/07/2017.
 */
public class MiwokViewPagerAdapter extends FragmentPagerAdapter {

    public MiwokViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0 ){
            return new ColorsActivity();
        } else if (position == 1) {
            return new FamilyActivity();
        } else if (position == 2){
            return new NumbersActivity();
        } else {
            return new PhrasesActivity();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0 ){
            return "COLORS";
        } else if (position == 1) {
            return "FAMILY";
        } else if (position == 2){
            return "NUMBERS";
        } else {
            return "PHRASES";
        }
    }
}
