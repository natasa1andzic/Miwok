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
package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Create a list of words
       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.family_father,"father", "әpә",R.raw.family_father));
        words.add(new Word(R.drawable.family_mother, "mother", "әṭa",R.raw.family_mother));
        words.add(new Word(R.drawable.family_son, "son", "angsi", R.raw.family_son));
        words.add(new Word(R.drawable.family_daughter, "daughter", "tune",R.raw.family_daughter));
        words.add(new Word(R.drawable.family_older_brother,"older brother", "taachi", R.raw.family_older_brother));
        words.add(new Word(R.drawable.family_younger_brother,"younger brother", "chalitti", R.raw.family_younger_brother));
        words.add(new Word(R.drawable.family_older_sister,"older sister", "teṭe",R.raw.family_older_sister));
        words.add(new Word(R.drawable.family_younger_sister,"younger sister", "kolliti",R.raw.family_younger_sister));
        words.add(new Word(R.drawable.family_grandmother,"grandmother ", "ama", R.raw.family_grandmother));
        words.add(new Word(R.drawable.family_grandfather,"grandfather", "paapa",R.raw.family_grandfather));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

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
                mp = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
                mp.start();
                Toast.makeText(FamilyActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
