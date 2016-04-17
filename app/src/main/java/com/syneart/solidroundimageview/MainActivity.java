package com.syneart.solidroundimageview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.syneart.widget.SolidRoundImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SolidRoundImageView ivSolidRound = (SolidRoundImageView) findViewById(R.id.ivSolidRound);
        if (ivSolidRound != null)
        //ivSolidRound.setSolidColor(Color.BLUE);
        ivSolidRound.setSolidColor(0xFF123456);
    }
}
