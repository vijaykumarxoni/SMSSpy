package com.spy.vksoni.smsspy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.spy.vksoni.smsspy.Adapter.ListViewAdapterMsg;
import com.spy.vksoni.smsspy.DB.DBHandler;
import com.spy.vksoni.smsspy.DB.SMSModel;

import java.util.List;

public class MessageActivity extends AppCompatActivity {
ListView listViewMsg;
ListViewAdapterMsg listViewAdapterMsg;
List<SMSModel> msgList;
String phone_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        listViewMsg=(ListView)findViewById(R.id.listViewMsg);
        Intent i=getIntent();
        phone_no=i.getStringExtra("phone_no");
        msgList= DBHandler.getInstance().getSMS(phone_no);
        listViewAdapterMsg=new ListViewAdapterMsg(getApplicationContext(),msgList);

        listViewMsg.setAdapter(listViewAdapterMsg);

    }
}
