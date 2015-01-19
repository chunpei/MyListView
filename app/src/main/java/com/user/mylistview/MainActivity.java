package com.user.mylistview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private ListView mListView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)this.findViewById(R.id.list) ;
        List<Integer> StateColor = new ArrayList<Integer>() ;
        List<String> VacationType = new ArrayList<String>() ;
        List<String> DueDay = new ArrayList<String>() ;
        List<String> Remain = new ArrayList<String>() ;
        List<String> Reason = new ArrayList<String>() ;


        for(int i = 0 ; i < 10 ; i++){
            StateColor.add(Color.GREEN) ;
            VacationType.add("[補休]") ;
            DueDay.add("到期日期 : 2015/01/12") ;
            Remain.add("4") ;
            Reason.add("原因XXXXXXXXXXXXXXXXXXXXXXXXX" + i) ;
        }

        MyAdapter adapter = new MyAdapter(this ,  StateColor , VacationType , DueDay ,  Remain ,  Reason) ;
        mListView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
