package com.example.cracking.groupproj;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Cracking on 2016-05-11.
 */
public class ListViewActivity extends Activity implements AdapterView.OnItemClickListener{

    public static final String[] userNames= new String[] {"한석규","조형기","이민기","황정민","소지섭","차승원"};

    public static final String[] userTel = new String[] {"010-9012-1249","010-2949-2915","010-2591-0050","010-0393-9298","010-1234-0293","010-9283-9174"};

    public static final Integer[] images={R.drawable.user_profile,R.drawable.user_profile,R.drawable.user_profile,R.drawable.user_profile,R.drawable.search,R.drawable.plus_button};

    ListView listView;
    List<listData> listItems;
    EditText search_users;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_view);

        listItems = new ArrayList<listData>();
        for(int i=0; i<userNames.length; i++){
            listData item = new listData(images[i],userNames[i],userTel[i]);
            listItems.add(item);
            Log.i("camera test",""+images[i]+userNames[i]+userTel[i]);

        }

        listView = (ListView)findViewById(R.id.user_list);
        final CustomListViewAdapter adapter = new CustomListViewAdapter(this,listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        search_users = (EditText)findViewById(R.id.search_users);
        search_users.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = search_users.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }
        });
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Toast toast = Toast.makeText(getApplicationContext(),"Item"+(position+1)+": "+listItems.get(position),Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
        toast.show();
    }


}
