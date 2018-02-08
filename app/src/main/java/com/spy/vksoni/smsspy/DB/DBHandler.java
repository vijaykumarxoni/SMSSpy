package com.spy.vksoni.smsspy.DB;

import com.activeandroid.query.Select;
import com.spy.vksoni.smsspy.ContactBean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Vksoni on 1/31/2018.
 */

public class DBHandler {
    static final DBHandler instance = new DBHandler();

    public static DBHandler getInstance() {
        return instance;
    }

   private DBHandler() {
    }
    Date d=new Date();
    String  date=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
    Calendar calendar=Calendar.getInstance();
    SimpleDateFormat format=new SimpleDateFormat("H:mm a");
    String time=format.format(calendar.getTime());

    public void addMsg(String msg_body,String msg_type,String phone_no){


        List<SMSModel> msgTempList=new Select().all().from(SMSModel.class).execute();

        SMSModel smsModel = new SMSModel();
        smsModel.msg_id =msgTempList.size();
        smsModel.msg_body= msg_body;
        smsModel.msg_type =msg_type;
        smsModel.phone_no=phone_no;
        smsModel.msg_rec_date=date;
        smsModel.msg_rec_time=time;
        smsModel.save();

    }
public void addToConversation(String sender_name_num,int con_id){

         ConversationModel conversationModel=new ConversationModel();
         conversationModel.conver_id=con_id;
         conversationModel.sender_name_number=sender_name_num;
         conversationModel.msg_rec_date=date;
         conversationModel.msg_rec_time=time;

         conversationModel.save();

}
public void addMessage(String msgBody,String number,String msgType,int conv_id){
    SMSModel smsModel=new SMSModel();
    smsModel.msg_type=msgType;
    smsModel.msg_id=new Select().all().from(SMSModel.class).execute().size();
    smsModel.phone_no=number;
    smsModel.msg_body=msgBody;
    smsModel.msg_rec_date=date;
    smsModel.msg_rec_time=time;
    smsModel.conver_id=conv_id;
    smsModel.save();



}
public List<ConversationModel> getConversation(){

    return  new Select().all().from(ConversationModel.class).execute();}

    public List<SMSModel> getSMS(String phone_no){
    return new Select().all().from(SMSModel.class).where("phone_no=?",phone_no).execute();
    }

}

