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


public class Word {

    private int imgId=NO_IMAGE;

    private int audioId;

    private static final int NO_IMAGE=-1;

    /** Default translation for the word */
    private String defTranslation;

    /** Miwok translation for the word */
    private String miwokTranslation;

    public Word(String defaultTranslation, String mmiwokTranslation,int audioResourseId) {
        defTranslation = defaultTranslation;
        miwokTranslation = mmiwokTranslation;
        audioId = audioResourseId;
    }

    public Word(int img, String defaultTranslation, String mmiwokTranslation,int audioResourceId) {
        imgId= img;
        defTranslation = defaultTranslation;
        miwokTranslation = mmiwokTranslation;
        audioId=audioResourceId;
    }

    public int getImgId() {
        return imgId;
    }

    public int getAudioId() {
        return audioId;
    }

    public static int getNoImage() {
        return NO_IMAGE;
    }

    public String getDefTranslation() {
        return defTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public boolean hasImage() {
        return imgId!= NO_IMAGE;
    }


}