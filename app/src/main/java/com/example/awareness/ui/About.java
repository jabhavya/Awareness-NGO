package com.example.awareness.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

import com.example.awareness.R;

public class About extends AppCompatActivity {

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simulateDayNight(/* DAY */ 0);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        View aboutPage = new AboutPage(this)
                .isRTL(false)


                .setDescription(Html.fromHtml("<b>" + "•Developers Team•" + "</b>" + "<br><br><p align=\"right\">•Bhoomik Bhamavat<br>•Monu Kumar<br><br><b></p>" + "•Content Team•<br><br>" + "</b>" + "•Divya Jain<br>•Aditi Jain<br>"))
                .setImage(R.drawable.girl_photo)
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("Always ready to help you")
                .addEmail("sattvikmess@gmail.com")
                .addWebsite("http://sattvikmess.com/")
                .addGitHub("medyo")
                .addPlayStore("com.jain.shreyash.myapplication")
                .addItem(getCopyRightsElement())
                .create();


        root.addView(aboutPage);

        setContentView(root);

    }
    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = "Sattvik App Team | 2019";
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.ic_baseline_copyright_24);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);

        return copyRightsElement;
    }

    void simulateDayNight(int currentSetting) {
        final int DAY = 0;
        final int NIGHT = 1;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else if (currentSetting == FOLLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }
}