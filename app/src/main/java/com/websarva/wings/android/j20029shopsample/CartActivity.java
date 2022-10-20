package com.websarva.wings.android.j20029shopsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartActivity extends AppCompatActivity {

    int TotalCost = 0;

    int ItemPrice0 = 1850;
    int ItemPrice1 = 1850;
    int ItemPrice2 = 3550;
    int ItemPrice3 = 3550;
    int ItemPrice4 = 18950;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        TotalCost = TotalCost + ItemPrice0 * MainActivity.itemSum[0]
                + ItemPrice1 * MainActivity.itemSum[1]
                + ItemPrice2 * MainActivity.itemSum[2]
                + ItemPrice3 * MainActivity.itemSum[3]
                + ItemPrice4 * MainActivity.itemSum[4]
        ;

        //-----------------------------------------goukei KIngaku

        TextView textView = findViewById(R.id.totalCost);
        textView.setText("￥" + String.valueOf(TotalCost) );

        //-----------------------------------------shoji kingaku

        TextView textView2 = findViewById(R.id.cash2);
        textView2.setText("￥" + String.valueOf(MainActivity.cashNum) );

        System.out.println(MainActivity.cashNum);

        //-----------------------------------------BuyButton Crick
        Button CartButton = findViewById(R.id.buyButton);
        CartButton.setOnClickListener(new CartActivity.BuyButtonClickListener());



        //------------------------------------------------------menu


        ListView lvMenu = findViewById(R.id.lvMenu2);
        List<Map<String, Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();


        menu.put("name","JhonnieWalker <Bk> ");
        menu.put("price",1850);
        menu.put("itemsum",MainActivity.itemSum[0]);
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","JackDaniels ");
        menu.put("price",1850);
        menu.put("itemsum",MainActivity.itemSum[1]);
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","Bowmore 12th years ");
        menu.put("price",3550);
        menu.put("itemsum",MainActivity.itemSum[2]);
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","CanadianClub 12th  ");
        menu.put("price",3550);
        menu.put("itemsum",MainActivity.itemSum[3]);
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","Hakushu 18th years ");
        menu.put("price",18950);
        menu.put("itemsum",MainActivity.itemSum[4]);
        menuList.add(menu);



        String[] from = {"name", "price", "itemsum"};
        int[] to = {R.id.tvMenuNameRow, R.id.tvMenuPriceRow,R.id.tvItemSumrow};
        SimpleAdapter addapter = new SimpleAdapter(CartActivity.this, menuList,
                R.layout.row, from , to );

        lvMenu.setAdapter(addapter);



    }

    private class BuyButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view){

            Intent intent = new Intent(CartActivity.this,ThanksBuyActivity.class);

            //kokoni switch de start Activityireru

            if(TotalCost == 0){

                String show = "商品をカートに追加してください。";
                Toast.makeText(CartActivity.this, show, Toast.LENGTH_LONG).show();

            }else if(TotalCost > MainActivity.cashNum){

                String show = "チャージ金額が足りません。";
                Toast.makeText(CartActivity.this, show, Toast.LENGTH_LONG).show();

            }else {


                MainActivity.cashNum=MainActivity.cashNum -TotalCost;

                startActivity(intent);

            }



        }

    }

    public void onBackButtonClick(View view){
        finish();
    }
}