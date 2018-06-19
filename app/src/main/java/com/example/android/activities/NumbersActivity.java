/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.Word;
import adapters.WordAdapter;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
       // getActionBar().setDisplayHomeAsUpEnabled(true);

        // Create a list of words
       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.number_one,"one", "lutti",R.raw.number_one));
        words.add(new Word(R.drawable.number_two,"two", "otiiko", R.raw.number_two));
        words.add(new Word(R.drawable.number_three,"three", "tolookosu", R.raw.number_three));
        words.add(new Word(R.drawable.number_four,"four", "oyyisa",R.raw.number_four));
        words.add(new Word(R.drawable.number_five,"five", "massokka", R.raw.number_five));
        words.add(new Word(R.drawable.number_six,"six", "temmokka", R.raw.number_six));
        words.add(new Word(R.drawable.number_seven,"seven", "kenekaku",R.raw.number_seven));
        words.add(new Word(R.drawable.number_eight,"eight", "kawinta",R.raw.number_eight));
        words.add(new Word(R.drawable.number_nine,"nine", "wo’e",R.raw.number_nine));
        words.add(new Word(R.drawable.number_ten,"ten", "na’aacha", R.raw.number_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                mp = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
                mp.start();
                Toast.makeText(NumbersActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
