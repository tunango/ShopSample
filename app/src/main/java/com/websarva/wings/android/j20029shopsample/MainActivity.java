package com.websarva.wings.android.j20029shopsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatExtras;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;


public class MainActivity extends AppCompatActivity {


    static int CashText = 0;
    static int cashNum = 0;
    static int[] itemSum = {0,0,0,0,0,0,0,0,0};
    //-------------------------------------------


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(cashNum);

        //--------------------------------cashNum

        TextView textView = findViewById(R.id.cashNum);
        textView.setText("￥" + cashNum );


        //--------------------------------cartButtonClick

        Button CartButton = findViewById(R.id.cartButton);
        CartButton.setOnClickListener(new CartButtonClickListener());


        //--------------------------------chargingMoney
        Button ChargeButton = findViewById(R.id.bt_carge);


        TextView textView2 = findViewById(R.id.cashText);
        textView2.setText("合計金額　：　￥　"+ CashText);

        ChargeButton.setOnClickListener(new ChargeButtonClickListener());


        //--------------------------------Menu

        createMenuList();

        /*ListView lvMenu = findViewById(R.id.lvMenu);
        List<Map<String, Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();


        menu.put("name","JhonnieWalker <Bk> ");
        menu.put("price",1850);
        menu.put("itemsum",itemSum[0]);
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","JackDaniels ");
        menu.put("price",1850);
        menu.put("itemsum",itemSum[1]);
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","Bowmore 12th years ");
        menu.put("price",3550);
        menu.put("itemsum",itemSum[2]);
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","CanadianClub 12th  ");
        menu.put("price",3550);
        menu.put("itemsum",itemSum[3]);
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","Hakushu 18th years ");
        menu.put("price",18950);
        menu.put("itemsum",itemSum[4]);
        menuList.add(menu);



        String[] from = {"name", "price", "itemsum"};
        int[] to = {R.id.tvMenuNameRow, R.id.tvMenuPriceRow,R.id.tvItemSumrow};
        SimpleAdapter addapter = new SimpleAdapter(MainActivity.this, menuList,
                R.layout.row, from , to );

        lvMenu.setAdapter(addapter);




        //---------------------------------ListKoushin
        addapter.notifyDataSetChanged();


        //---------------------------------ListItemClick

        lvMenu.setOnItemClickListener(new ListItemClickListener());


         */

    }

    void createMenuList(){

        calcCashText();

       ListView lvMenu = findViewById(R.id.lvMenu);
       List<Map<String, Object>> menuList = new ArrayList<>();
       Map<String, Object> menu = new HashMap<>();


       menu.put("name","JhonnieWalker <Bk> ");
       menu.put("price",1850);
       menu.put("itemsum",itemSum[0]);
       menuList.add(menu);

       menu = new HashMap<>();
       menu.put("name","JackDaniels ");
       menu.put("price",1850);
       menu.put("itemsum",itemSum[1]);
       menuList.add(menu);

       menu = new HashMap<>();
       menu.put("name","Bowmore 12th years ");
       menu.put("price",3550);
       menu.put("itemsum",itemSum[2]);
       menuList.add(menu);

       menu = new HashMap<>();
       menu.put("name","CanadianClub 12th  ");
       menu.put("price",3550);
       menu.put("itemsum",itemSum[3]);
       menuList.add(menu);

       menu = new HashMap<>();
       menu.put("name","Hakushu 18th years ");
       menu.put("price",18950);
       menu.put("itemsum",itemSum[4]);
       menuList.add(menu);



       String[] from = {"name", "price", "itemsum"};
       int[] to = {R.id.tvMenuNameRow, R.id.tvMenuPriceRow,R.id.tvItemSumrow};
       SimpleAdapter addapter = new SimpleAdapter(MainActivity.this, menuList,
               R.layout.row, from , to );

       lvMenu.setAdapter(addapter);

       addapter.notifyDataSetChanged();


       //---------------------------------ListItemClick

       lvMenu.setOnItemClickListener(new ListItemClickListener());
   }

      //____________________________________calc Sum


   void calcCashText (){

        CashText =  0;
       CashText = CashText + 1850 * MainActivity.itemSum[0]
               + 1850 * MainActivity.itemSum[1]
               + 3550 * MainActivity.itemSum[2]
               + 3550 * MainActivity.itemSum[3]
               + 18950 * MainActivity.itemSum[4];

       TextView textView = findViewById(R.id.cashText);
       textView.setText("合計金額　：　￥　"+ CashText);

   }


    //----------------------------ListItemClickListener------------------------------

    public class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view,int position,long id){
            //Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);


            itemSum[position] = itemSum[position] + 1;
            System.out.println(itemSum[position]);
            createMenuList();





        }

    }



    //----------------------------cartButtonClickListener----------------------------
    private class CartButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view){


            Intent intent = new Intent(MainActivity.this,CartActivity.class);


            startActivity(intent);


        }

    }




    //-----------------------ChargebuttonClickListener-----------------------------


    public class ChargeButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){


            //String countCash = new String((cash.getText()).toString());
            //int mCount = Integer.parseInt(countCash);
            cashNum = cashNum + 2000;
            //mCount = mCount +1000;

            //cash.setText(String.valueOf(mCount));
            TextView textView = findViewById(R.id.cashNum);
            textView.setText("￥" + cashNum );


        }

    }


}