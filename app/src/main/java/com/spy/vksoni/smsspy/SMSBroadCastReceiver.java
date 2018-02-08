package com.spy.vksoni.smsspy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.spy.vksoni.smsspy.DB.ConversationModel;
import com.spy.vksoni.smsspy.DB.DBHandler;
import com.spy.vksoni.smsspy.DB.SMSModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Vksoni on 1/30/2018.
 */

public class SMSBroadCastReceiver extends BroadcastReceiver {
    String name="";
     int  con_id;
    boolean con=false;
    List<ContactBean> contactList;
    @Override
    public void onReceive(Context context, Intent intent) {
        // pdus protcol data unit
        Bundle bundlePDUS = intent.getExtras();
        Object[] pdus = (Object[]) bundlePDUS.get("pdus");
        SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[0]);
        Toast.makeText(context, "SMS RECEIVED ", Toast.LENGTH_SHORT).show();

        Date d=new Date();
        String  date=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat format=new SimpleDateFormat("HH:mm a");
        String time=format.format(calendar.getTime());


        List<ConversationModel> conversationList=new Select().all().from(ConversationModel.class).execute();
        List<SMSModel>smsList=new Select().all().from(SMSModel.class).execute();

        for(ConversationModel conversationModel:conversationList){
            if(conversationModel.sender_name_number.equalsIgnoreCase(message.getDisplayOriginatingAddress())){
               con=true;
                con_id=conversationModel.conver_id;
                Toast.makeText(context,""+con_id,Toast.LENGTH_SHORT).show();
                 break;
            }

        }
        if(con==true){
            new Update(ConversationModel.class).set( "msg_rec_date = ?," +
                    "msg_rec_time = ?",date,time)
                    .where("conver_id = ?",con_id).execute();
            DBHandler.getInstance().addMessage(message.getMessageBody(),message.getDisplayOriginatingAddress(),"Received",con_id);

        }
        else{

               DBHandler.getInstance().addToConversation(message.getDisplayOriginatingAddress(),conversationList.size());
            DBHandler.getInstance().
                    addMessage(message.getMessageBody(),message.getDisplayOriginatingAddress(),"Received",con_id);


        }






    }
}
