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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.Word;
import adapters.WordAdapter;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // Create a list of words
       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.color_red,"red", "weṭeṭṭi",R.raw.color_red));
        words.add(new Word(R.drawable.color_mustard_yellow,"mustard yellow", "chiwiiṭә",R.raw.color_mustard_yellow));
        words.add(new Word(R.drawable.color_dusty_yellow,"dusty yellow", "ṭopiisә",R.raw.color_dusty_yellow));
        words.add(new Word(R.drawable.color_green, "green", "chokokki",R.raw.color_green));
        words.add(new Word(R.drawable.color_brown,"brown", "ṭakaakki", R.raw.color_brown));
        words.add(new Word(R.drawable.color_gray,"gray", "ṭopoppi",R.raw.color_gray));
        words.add(new Word(R.drawable.color_black,"black", "kululli",R.raw.color_black));
        words.add(new Word(R.drawable.color_white,"white", "kelelli",R.raw.color_white));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

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
                mp = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId());
                mp.start();
                Toast.makeText(ColorsActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
