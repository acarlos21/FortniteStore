package com.tony.android.fortnitestore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bundles(View view) {
        Intent i = new Intent(this, fortniteBundles.class);
        startActivity(i);
    }

    public void outfits(View view) {
        Intent i = new Intent(this, fortniteOutfits.class);
        startActivity(i);

    }
}
