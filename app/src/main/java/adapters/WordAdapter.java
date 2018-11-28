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
package adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.activities.R;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word>  {

    private int colorId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        colorId=colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        ImageView imgId = (ImageView) listItemView.findViewById(R.id.img);
        if(currentWord.hasImage()) {
            imgId.setImageResource(currentWord.getImgId());
            imgId.setVisibility(View.VISIBLE);
        }
        else imgId.setVisibility(View.GONE);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefTranslation());

        View textContainer = listItemView.findViewById(R.id.textContainer);
        int color = ContextCompat.getColor(getContext(), colorId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}