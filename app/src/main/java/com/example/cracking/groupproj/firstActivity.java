package com.example.cracking.groupproj;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * This Is project's first Activity's Java File
 */
public class firstActivity extends Activity {

    ListView recentList;
    recentListAdapter listAdapter;
    ArrayList<listData> listDatas;

    protected void onCreate(Bundle savedInstanceState){

        long now = System.currentTimeMillis();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_view);

        Date date = new Date(now);

        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

        String strCurDate = CurDateFormat.format(date);

        setData();

        listAdapter = new recentListAdapter(this,listDatas);

        recentList = (ListView)findViewById(R.id.recentListView);
        recentList.setAdapter(listAdapter);

        TextView recentDate = (TextView)findViewById(R.id.recentDate);
        recentDate.setText("최근 추가 날짜 : "+strCurDate);

    }


    private void setData(){
        listDatas = new ArrayList<listData>();
        listDatas.add(new listData(R.drawable.user_profile, "소녀시대", "010-1111-2222"));
    }
}

