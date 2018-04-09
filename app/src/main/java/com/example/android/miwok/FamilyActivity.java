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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.family_father,"father", "әpә"));
        words.add(new Word(R.drawable.family_mother, "mother", "әṭa"));
        words.add(new Word(R.drawable.family_son, "son", "angsi"));
        words.add(new Word(R.drawable.family_daughter, "daughter", "tune"));
        words.add(new Word(R.drawable.family_older_brother,"older brother", "taachi"));
        words.add(new Word(R.drawable.family_younger_brother,"younger brother", "chalitti"));
        words.add(new Word(R.drawable.family_older_sister,"older sister", "teṭe"));
        words.add(new Word(R.drawable.family_younger_sister,"younger sister", "kolliti"));
        words.add(new Word(R.drawable.family_grandmother,"grandmother ", "ama"));
        words.add(new Word(R.drawable.family_grandfather,"grandfather", "paapa"));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}