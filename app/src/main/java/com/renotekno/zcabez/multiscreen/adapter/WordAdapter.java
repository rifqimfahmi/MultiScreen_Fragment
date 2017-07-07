package com.renotekno.zcabez.multiscreen.adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.renotekno.zcabez.multiscreen.R;
import com.renotekno.zcabez.multiscreen.model.Word;

import java.util.List;

/**
 * Created by zcabez on 01/07/2017.
 */
public class WordAdapter extends ArrayAdapter<Word> implements AdapterView.OnItemClickListener {

    private int colorResourceId;
    private MediaPlayer mediaPlayer;
    private AudioManager mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMedia();
            }
        }
    };

    public WordAdapter(Context context, List<Word> data, int colorPrimaryColors) {
        super(context, 0, data);
        this.colorResourceId = colorPrimaryColors;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.number_list, parent, false);
        }
        Word currentWord = getItem(position);

        TextView englishTranslate = (TextView) view.findViewById(R.id.englishTranslate);
        TextView miwokTranslate = (TextView) view.findViewById(R.id.miwokTranslate);
        ImageView wordImage = (ImageView) view.findViewById(R.id.wordImage);
        LinearLayout textViewGroup = (LinearLayout) view.findViewById(R.id.textContainer);

        if (currentWord.hasImage()) {
            wordImage.setImageResource(currentWord.getImageRes());
        } else {
            wordImage.setVisibility(View.GONE);
        }

        int bgColor = ContextCompat.getColor(getContext(), colorResourceId);

        textViewGroup.setBackgroundColor(bgColor);
        englishTranslate.setText(currentWord.getEnglish());
        miwokTranslate.setText(currentWord.getMiwok());

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Word word = getItem(position);

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            releaseMedia();
        }

        int requestAudioFocus = mAudioManager.requestAudioFocus(
                audioFocusChangeListener,
                AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (requestAudioFocus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){


            mediaPlayer = MediaPlayer.create(getContext(), word.getPronunciationRes());

            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    releaseMedia();
                }
            });
        }


    }

    public void releaseMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
            mAudioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }

}
