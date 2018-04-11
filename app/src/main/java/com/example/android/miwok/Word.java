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


import android.media.Image;

public class Word {

    private int imgId=NO_IMAGE;

    private int mAudioResourceId;

    private static final int NO_IMAGE=-1;

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    public Word(String defaultTranslation, String miwokTranslation,int audioResourseId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourseId;
    }


    public Word(int img, String defaultTranslation, String miwokTranslation,int audioResourceId) {
        imgId= img;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId=audioResourceId;
    }

    public int getImgId() {
        return imgId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public boolean hasImage() {
        return imgId!= NO_IMAGE;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}