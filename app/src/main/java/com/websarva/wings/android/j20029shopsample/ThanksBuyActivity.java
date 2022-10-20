package com.websarva.wings.android.j20029shopsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThanksBuyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks_buy);

        Button BackToTopButton = findViewById(R.id.bk_top);
        BackToTopButton.setOnClickListener(new ThanksBuyActivity.BackToTopButtonClickListener());


    }
    private class BackToTopButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view){

            MainActivity.itemSum[0] = 0;
            MainActivity.itemSum[1] = 0;
            MainActivity.itemSum[2] = 0;
            MainActivity.itemSum[3] = 0;
            MainActivity.itemSum[4] = 0;



            //Intent intent = new Intent(ThanksBuyActivity.this,CartActivity.class);
            //finish();

            Intent intent2 = new Intent(ThanksBuyActivity.this, MainActivity.class);
            startActivity(intent2);


        }

    }
}